import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Pair[] quickSort(Pair[] arr){
        //TODO
        return null;
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