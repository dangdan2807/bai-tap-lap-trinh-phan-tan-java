package lab2.exercise1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class EncodeJson {
    public static void main(String[] args) throws FileNotFoundException {
        EncodeJson ej = new EncodeJson();
        Employee e = new Employee(10001, "Nguyen Van A", 10000d);
        String js = ej.getJson(e);
        ej.export("./json/emp.json", js);
    }

    private void export(String filePath, String json) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream(filePath));
        out.println(json);
        out.close();
    }

    private String getJson(Employee e) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id", e.getId());
        builder.add("name", e.getName());
        builder.add("salary", e.getSalary());

        JsonObject jo = builder.build();
        return jo.toString();
    }
}
