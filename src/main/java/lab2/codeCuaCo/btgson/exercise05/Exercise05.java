package lab2.codeCuaCo.btgson.exercise05;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lab2.codeCuaCo.btgson.entity.State;

public class Exercise05 {
	public static void main(String[] args) {
		Map<String, State> map = new HashMap<>();

		State st1 = new State(5, "Arkansas", "AR", "Little Rock", 1836);
		State st2 = new State(1, "Alabama", "AL", "Montgomery", 1819);

		map.put("state5", st1);
		map.put("state1", st2);

		System.out.println(map);
		
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		
		String json = gson.toJson(map);
		System.out.println(json);
		
	}
}
