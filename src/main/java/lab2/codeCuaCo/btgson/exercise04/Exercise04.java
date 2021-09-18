package lab2.codeCuaCo.btgson.exercise04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import lab2.codeCuaCo.btgson.entity.State;

public class Exercise04 {
	public static void main(String[] args) throws JsonIOException, IOException {
		
//		Gson gson = new Gson();
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		
		List<State> states = Arrays.asList(new State(5, "Arkansas", "AR", "Little Rock", 1836),
				new State(1, "Alabama", "AL", "Montgomery", 1819));
		
		FileWriter out2;
		gson.toJson(states, out2 = new FileWriter("data/states.json"));
		out2.close();
		
//		State state = new State(5, "Arkansas", "AR", "Little Rock", 1836);
//		
//		String json = gson.toJson(state);
//		System.out.println(json);
//		
//		FileWriter out;
//		
//		gson.toJson(state, out = new FileWriter("data/state.json"));
//		
//		out.close();
	}
}
