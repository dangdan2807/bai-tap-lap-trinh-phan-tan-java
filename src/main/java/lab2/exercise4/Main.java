package lab2.exercise4;

import java.io.*;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Main {
    public static void convertObj2JSON(Employee emp) throws Exception {
        Gson gson = new Gson();
        gson.toJson(emp, new FileWriter("./src/main/java/lab2/exercise4/emp1.json"));

        String jsonInString = gson.toJson(emp);
        System.out.println(jsonInString);
    }

    public static void convertJSON2Object() throws Exception {
        Gson gson = new Gson();
        Employee emp1 = gson.fromJson(new FileReader("./src/main/java/lab2/exercise4/emp.json"), Employee.class);

        String jsonInString = "{\"id\":1001,\"name\":\"Than thi det\"}";
        Employee emp2 = gson.fromJson(jsonInString, Employee.class);

        JsonElement json = gson.fromJson(new FileReader("src/main/java/lab2/exercise4/emp.json"), JsonElement.class);
        String result = gson.toJson(json);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        convertJSON2Object();
        String jsonInString = "{\"id\":1001,\"name\":\"Than thi det\"}";
        Gson gson = new Gson();
        Employee emp2 = gson.fromJson(jsonInString, Employee.class);
        convertObj2JSON(emp2);
    }
}
