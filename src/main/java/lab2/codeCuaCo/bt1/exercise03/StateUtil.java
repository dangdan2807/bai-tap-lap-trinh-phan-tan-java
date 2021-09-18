package lab2.codeCuaCo.bt1.exercise03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import lab2.codeCuaCo.bt1.entity.State;

public class StateUtil {
	
	private JsonReader reader;

	public StateUtil() {
		try {
			reader = Json.createReader(new FileReader("data/usa-states.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public State findByAb(String abb) {
		
		JsonArray ja = reader.readArray();
		for(JsonValue jv : ja) {
			if(jv instanceof  JsonObject) {
				JsonObject jo = jv.asJsonObject();
				
				String abbreviation = jo.getString("Abbreviation");
				if(abbreviation.equalsIgnoreCase(abb)) {
					State state = new State(jo.getJsonNumber("ID").longValue(), 
							jo.getString("StateName"),
							jo.getString("Abbreviation"),
							jo.getString("Capital"),
							jo.getInt("Statehood"));
					
					return state;
				}
			}
		}
		
		return null;
	}
	
	public ArrayList<State>findByYear(int year){
		
		
		return null;
	}
	
	
	public void close() {
		reader.close();
	}
}
