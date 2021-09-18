package lab2.codeCuaCo.bt1.exercise03.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import lab2.codeCuaCo.bt1.entity.State;

public class StateUtil_2 {


	private JsonParser parser;


	public StateUtil_2() {
		try {
			parser = Json.createParser(new FileReader("data/usa-states.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public State findByAb(String abb) {

		return null;
	}

	public ArrayList<State>findByYear(int year){

		ArrayList<State> list = new ArrayList<State>();

		if(parser.hasNext()) {
			Event event = parser.next();
			if(event == Event.START_ARRAY) {
				JsonArray ja = parser.getArray();
				for(JsonValue jv : ja) {
					if(jv instanceof  JsonObject) {
						JsonObject jo = jv.asJsonObject();

						int y = jo.getInt("Statehood");
						if(y != -1 && y < year) {
							State state = new State(jo.getJsonNumber("ID").longValue(), 
									jo.getString("StateName"),
									jo.getString("Abbreviation"),
									jo.getString("Capital"),
									jo.getInt("Statehood"));

							list.add(state);
						}
					}
				}
			}
		}
		return list;
	}


	public void close() {
		parser.close();
	}
}
