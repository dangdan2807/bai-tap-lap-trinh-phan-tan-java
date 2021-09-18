package lab2.codeCuaCo.bt1.exercise05;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import lab2.codeCuaCo.bt1.entity.State;

public class Exercise05 {
	public static void main(String[] args) throws IOException {
		Map<String, State> map = new HashMap<>();
		
		State st1 = new State(5, "Arkansas", "AR", "Little Rock", 1836);
		State st2 = new State(1, "Alabama", "AL", "Montgomery", 1819);
		
		map.put("state5", st1);
		map.put("state1", st2);
		
		Set<Entry<String, State>> entrys = map.entrySet();
		
		Iterator<Entry<String, State>> it = entrys.iterator();
		
		Map<String, Boolean> config = new HashMap<>();
		config.put(JsonGenerator.PRETTY_PRINTING, Boolean.TRUE);
		
		JsonGenerator generator = Json.createGeneratorFactory(config)
				.createGenerator(new FileWriter("data/map.json"));
		
		generator.writeStartObject();
		
		while(it.hasNext()) {
			Entry<String, State> entry = it.next();
			State st = entry.getValue();
			generator.writeStartObject(entry.getKey())
			.write("id", st.getId())
			.write("stateName", st.getStateName())
			.write("abbreviation", st.getAbbreviation())
			.write("capital", st.getCapital())
			.write("statehood", st.getStatehood())
			
			.writeEnd();
		}
		
		generator.writeEnd();
		generator.close();
	}
}
//{
//	  "state5": {
//	    "id": 5,
//	    "stateName": "Arkansas",
//	    "abbreviation": "AR",
//	    "capital": "Little Rock",
//	    "statehood": 1836
//	  },
//	  "state1": {
//	    "id": 1,
//	    "stateName": "Alabama",
//	    "abbreviation": "AL",
//	    "capital": "Montgomery",
//	    "statehood": 1819
//	  }
//	}

