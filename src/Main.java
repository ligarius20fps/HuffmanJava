import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Pair[] quickSort(Pair[] arr, int left, int right)
    {
        int i = left, j = right;
        int pivot = arr[(left + right) / 2].v();
        Pair temp;
        while(i < j)
        {
            while(arr[i].v() > pivot)i++;
            while(arr[j].v() < pivot)j--;
            if(i<=j)
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if(left < j) arr = quickSort(arr, left, j);
        if(i < right) arr = quickSort(arr, i, right);
        return arr;
    }
    private static Pair[] quickSort(Pair[] arr){
        return quickSort(arr, 0, arr.length - 1);
    }
    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            System.out.println("Please provide a file name");
            System.exit(1);
        }
        String strFile = args[0];
        //odczytać plik
        try (FileInputStream in = new FileInputStream(strFile)) {
            int c;
            //key: byte
            //value: number of same bytes
            Map<Integer, Integer> map = new HashMap<>();
            while ((c = in.read()) != -1)
            {
                //policzyć liczbę poszczególnych bajtów
                if(map.containsKey(c)){
                    int numberOfOccurences = map.get(c);
                    map.put(c,++numberOfOccurences);
                }
                else{
                    map.put(c,1);
                }
            }
            Pair[] tempArr = new Pair[map.size()];
            int i = 0;
            for(int key:map.keySet()){
                int value = map.get(key);
                tempArr[i++] = new Pair(key,value);
            }
            tempArr = quickSort(tempArr);
            System.out.println("good");
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + strFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("hello");

        //zbudować drzewo
        //z drzewa w ciąg bitów
        //zapisać w postaci skompresowanej
    }
}