package lab2.exercise5;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Employee> map = new HashMap<>();
        Employee emp1 = new Employee(10001, "Nguyen Van A");
        Employee emp2 = new Employee(10002, "Bui Van B");
        map.put(1, emp1);
        map.put(2, emp2);
        JSONObject json = new JSONObject(map);
        System.out.println(json);
    }
}
