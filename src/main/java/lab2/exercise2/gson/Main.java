package lab2.exercise2.gson;

import java.io.*;
import java.nio.file.*;
import com.google.gson.Gson;

import lab2.exercise2.entity.User;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("src/main/java/lab2/exercise2/jsonData/data.json"));
        Gson gson = new Gson();
        User user = gson.fromJson(reader, User.class);
        reader.close();
        System.out.println("Convert json to java object");
        System.out.println(user);

        user.setFirstName("Alice");

        String json = gson.toJson(user);
        System.out.println(json);
        PrintWriter out = new PrintWriter(new FileOutputStream("src/main/java/lab2/exercise2/jsonData/data2.json"));
        out.println(json);
        out.close();
    }
}
