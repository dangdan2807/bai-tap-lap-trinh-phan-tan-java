package lab2.exercise1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class DecodeJson {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream("./json/emp.json");
        JsonReader reader = Json.createReader(in);

        JsonObject jo = reader.readObject();
        JsonNumber id = jo.getJsonNumber("id");
        String name = jo.getString("name");
        JsonNumber salary = jo.getJsonNumber("salary");
        Employee emp = new Employee(id.longValue(), name, salary.doubleValue());
        System.out.println(emp.toString());
    }
}
