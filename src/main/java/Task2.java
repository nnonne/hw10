import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.*;
import java.util.ArrayList;

public class Task2 {
    public static String userToJson(ArrayList<User> users){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(users);
    }
    public static void main(String[] args) {
        File file = new File("D:\\goit\\file.txt");
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            String text = new String(buffer);
            String[] textUsers = text.split("\n");
            ArrayList<User> users = new ArrayList<>();
            for (int i = 1; i < textUsers.length-1;i++){
                String name = textUsers[i].split(" ")[0];
                String stringAge = (textUsers[i].split(" ")[1]).trim();
                int age = Integer.parseInt(stringAge);
                users.add(new User(name, age));
            }
            String toJson = userToJson(users);
            OutputStream fos = new FileOutputStream("users.json");
            fos.write(toJson.getBytes());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
