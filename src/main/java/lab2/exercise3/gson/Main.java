package lab2.exercise3.gson;

import java.lang.reflect.Type;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lab2.exercise3.entity.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("src/main/java/lab2/exercise3/data.json"));
        Gson gson = new Gson();
        ListState listState = new ListState();
        Type collectionType = new TypeToken<List<State>>() {}.getType();
        listState.adds(gson.fromJson(reader, collectionType));
        reader.close();

        listState.showStates();

        try {
            String abb = "AL";
            System.out.println("\ntim state co Abbreviation = " + abb);
            State state = listState.findByAb(abb);
            System.out.println(state.toString());
            
            abb = "ARR";
            System.out.println("\ntim state co Abbreviation = " + abb);
            state = listState.findByAb(abb);
            if (state == null) {
                System.out.println("Khong tim thấy State nao hop le");
            } else
                System.out.println(state.toString());

            int year = 1820;
            System.out.println("\ntim nhung state co StateHoodYear truoc nam " + year);
            ArrayList<State> states = listState.findByYear(year);
            if (states.size() <= 0) {
                System.out.println("Khong tim thay state nao hop le");
            } else {
                for (State item : states) {
                    System.out.println(item.toString());
                }
            }

            year = 1000;
            System.out.println("\ntim nhung state co StateHoodYear truoc nam " + year);
            states = listState.findByYear(year);
            if (states.size() <= 0) {
                System.out.println("Khong tim thay state nao hop le");
            } else {
                for (State item : states) {
                    System.out.println(item.toString());
                }
            }
        } catch (Exception e) {
        }
    }
}
