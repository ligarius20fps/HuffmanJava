import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static java.lang.System.exit;

public class Main {
    private static LinkedList<Tree> quickSort(LinkedList<Tree> arr, int left, int right)
    {
        int i = left, j = right;
        int pivot = arr.get(((left + right) / 2)).node.getWeight();
        Tree temp;
        while(i < j)
        {
            while(arr.get(i).node.getWeight() < pivot)i++;
            while(arr.get(j).node.getWeight() > pivot)j--;
            if(i<=j)
            {
                temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
                i++;
                j--;
            }
        }
        if(left < j) arr = quickSort(arr, left, j);
        if(i < right) arr = quickSort(arr, i, right);
        return arr;
    }
    private static LinkedList<Tree> quickSort(LinkedList<Tree> arr){
        return quickSort(arr, 0, arr.size() - 1);
    }
    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            System.out.println("Please provide a file name");
            exit(1);
        }
        LinkedList<Tree> treeList = new LinkedList<>();
        {
            Map<Integer, Integer> map = new HashMap<>();
            {
                String strFile = args[0];
                //odczytać plik
                try (FileInputStream in = new FileInputStream(strFile)) {
                    int c;
                    //key: byte
                    //value: number of same bytes
                    while ((c = in.read()) != -1) {
                        //policzyć liczbę poszczególnych bajtów
                        if (map.containsKey(c)) {
                            int numberOfOccurences = map.get(c);
                            map.put(c, ++numberOfOccurences);
                        } else {
                            map.put(c, 1);
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Could not find file: " + strFile);
                    exit(1);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int key : map.keySet()) { // kluczem jest bajt
                int value = map.get(key); //wartością jest waga
                Node node = new Node(key, value);
                treeList.add(new Tree(node));
            }
        }
        treeList = quickSort(treeList);
        //zbudować drzewo
        while(treeList.size() > 1)
        {
            Tree first = treeList.pop();
            Tree second = treeList.pop();
            Node node = new Node(first.node, second.node);
            Tree newTree = new Tree(node, first, second);
            int i = 0;
            while(i < treeList.size() &&
                    treeList.get(i).node.getWeight() < newTree.node.getWeight()){
                i++;
            }
            treeList.add(i, newTree);
        }
        //z drzewa w ciąg bitów
        System.out.println("good");
        //zapisać w postaci skompresowanej
    }
}