import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.*;

public class Task1 {
    private static boolean isValid(String number){
        // (xxx) xxx-xxxx
        // [(]\d{3}[)]\s\d{3}-\d{4}
        // xxx-xxx-xxxx
        // \d{3}-\d{3}-\d{4}
        return Pattern.matches("[(]\\d{3}[)]\\s\\d{3}-\\d{4}", number) || Pattern.matches("\\d{3}-\\d{3}-\\d{4}", number);
    }
    public static void numberValidator(File file){
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            String text = new String(buffer);
            String[] numbers = text.split("\n");
            for(String number : numbers){
                if (isValid(number.trim())){
                    System.out.println(number);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        File file = new File("D:\\goit\\file.txt");
        numberValidator(file);
    }
}
