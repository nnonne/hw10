import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Task3 {
    public static void comparator(HashMap<String, Integer>map){
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
    public static String readText(File file){
        String text;
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            text = new String(buffer);
            return text;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static ArrayList<String> splitWords(String text){
        ArrayList<String> words = new ArrayList<String>();
        for (String word: text.split(" ")){
            if (word.contains("\n")){
                for(String w: word.split("\n")){
                    if (!w.isBlank()) words.add(w.trim());
                }
            }
            else if (!word.isBlank()) words.add(word.trim());

        }
        return words;
    }
    public static void countWords(String text){
        ArrayList<String> words = splitWords(text);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word: words){
            if (map.containsKey(word)){
                map.replace(word, map.get(word),map.get(word)+1 );
            }
            else{
                map.put(word, 1);
            }

        }
        comparator(map);

    }
    public static void main(String[] args) {
        File file = new File("D:\\goit\\words.txt");
        String text = readText(file);
        countWords(text);
    }
}
