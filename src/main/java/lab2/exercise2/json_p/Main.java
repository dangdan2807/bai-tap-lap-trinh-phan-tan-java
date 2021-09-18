package lab2.exercise2.json_p;

import java.io.*;
import java.util.*;

import javax.json.*;

import lab2.exercise2.entity.*;

public class Main {
    public static JsonArrayBuilder builderPhoneNumber(List<PhoneNumber> phoneNumber) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (PhoneNumber item : phoneNumber) {
            JsonObjectBuilder builder = Json.createObjectBuilder();
            builder.add("type", item.getType());
            builder.add("number", item.getNumber());
            arrayBuilder.add(builder);
        }
        return arrayBuilder;
    }

    public static JsonObjectBuilder builderAddress(Address address) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("streetAddress", address.getStreetAddress());
        builder.add("city", address.getCity());
        builder.add("state", address.getState());
        builder.add("postalCode", address.getPostalCode());
        return builder;
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream("src/main/java/lab2/exercise2/jsonData/data.json");
        JsonReader reader = Json.createReader(in);
        JsonObject jo = reader.readObject();

        User user = new User(jo);
        System.out.println("Convert json to java object");
        System.out.println(user);
        
        user.setFirstName("Bod");
        
        System.out.println("Convert java object to json");
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("firstName", user.getFirstName());
        builder.add("lastName", user.getLastName());
        builder.add("age", user.getAge());
        builder.add("address", builderAddress(user.getAddress()));
        builder.add("phoneNumbers", builderPhoneNumber(user.getPhones()));

        JsonObject jo2 = builder.build();
        String json = jo2.toString();
        PrintWriter out = new PrintWriter(new FileOutputStream("src/main/java/lab2/exercise2/jsonData/data2.json"));
        out.println(json);
        out.close();
    }
}
