package lab2.codeCuaCo.btgson.exercise04;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import lab2.codeCuaCo.btgson.entity.State;

public class Exercise4_2 {
	public static void main(String[] args) throws JsonIOException, IOException {
		
//		Gson gson = new Gson();
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		
		State st1 = gson.fromJson(new FileReader("data/state.json"), State.class);
		System.out.println(st1);
		
		 Type typeOfT = new TypeToken<List<State>>(){}.getType();

		
		List<State> list = gson.fromJson(new FileReader("data/states.json"), typeOfT);
		list.forEach(st -> System.out.println(st));
	}
}
