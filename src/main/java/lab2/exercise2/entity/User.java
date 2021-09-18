package lab2.exercise2.entity;

import java.util.*;

import javax.json.*;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private Address address;
    private List<PhoneNumber> phones = new ArrayList<PhoneNumber>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneNumber> phones) {
        this.phones = phones;
    }

    public User(String firstName, String lastName, int age, Address address, List<PhoneNumber> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phones = phones;
    }

    public User(JsonObject jo) {
        this.firstName = jo.getString("firstName");
        this.lastName = jo.getString("lastName");
        this.age = jo.getInt("age");
        this.address = new Address(jo.getJsonObject("address"));
        for (JsonValue i : jo.getJsonArray("phoneNumbers")) {
            PhoneNumber p = new PhoneNumber(i.asJsonObject());
            phones.add(p);
        }
    }

    @Override
    public String toString() {
        return "User { firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", \n\taddress=" + address
                + ", \n\tphones=" + phones + " \n}";
    }

}
