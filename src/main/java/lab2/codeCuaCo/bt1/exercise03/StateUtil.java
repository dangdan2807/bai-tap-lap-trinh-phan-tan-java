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
			reader = Json.createReader(new FileReader("json/usa-states.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public State findByAb(String abb) {
		JsonArray jArray = reader.readArray();
		for (JsonValue JItem : jArray) {
			if (JItem instanceof JsonObject) {
				JsonObject jObj = JItem.asJsonObject();
				String abbreviation = jObj.getString("Abbreviation");
				if (abbreviation.equalsIgnoreCase(abb)) {
					State state = new State(jObj.getJsonNumber("ID").longValue(), jObj.getString("StateName"),
							jObj.getString("Abbreviation"), jObj.getString("Capital"), jObj.getInt("Statehood"));
					return state;
				}
			}
		}
		return null;
	}

	public ArrayList<State> findByYear(int year) {
		return null;
	}

	public void close() {
		reader.close();
	}
}
