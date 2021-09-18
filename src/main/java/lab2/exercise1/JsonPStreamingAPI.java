package lab2.exercise1;

import java.io.StringReader;
import java.math.BigDecimal;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;;

public class JsonPStreamingAPI {
    public static void main(String[] args) {
        final String result = "{ \"name\": \"Falco\", \"age\": 1000000000000000000000000000, \"bitable\":false, \"test\": null, \"array\": [ 'a': 3, 'b': 1 ] }";
        final JsonParser parser = Json.createParser(new StringReader(result));
        String key = null;
        String value = null;
        while (parser.hasNext()) {
            final Event event = parser.next();
            switch (event) {
                case KEY_NAME:
                    key = parser.getString();
                    System.out.print(key + ": ");
                    break;
                case VALUE_STRING:
                    value = parser.getString();
                    System.out.println(value);
                    break;
                case START_OBJECT:
                    break;
                case END_OBJECT:
                    break;
                case START_ARRAY:
                    break;
                case END_ARRAY:
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    value = parser.getValue().toString();
                    System.out.println(Boolean.parseBoolean(value));
                    break;
                case VALUE_NULL:
                    value = null;
                    System.out.println(value);
                    break;
                case VALUE_NUMBER:
                    if (parser.isIntegralNumber()) {
                        int value1 = parser.getInt();
                        System.out.println(value1 + "(int)");
                    } else {
                        BigDecimal value1 = parser.getBigDecimal();
                        System.out.println(value1);
                    }
                    break;
                default:
                    break;
            }
        }
        parser.close();
    }
}
