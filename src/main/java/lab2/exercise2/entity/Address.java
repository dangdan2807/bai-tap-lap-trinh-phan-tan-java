package lab2.exercise2.entity;

import javax.json.JsonObject;

public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private int postalCode;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public Address(String streetAddress, String city, String state, int postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public Address(JsonObject jo) {
        this(jo.getString("streetAddress"), jo.getString("city"), jo.getString("state"), jo.getInt("postalCode"));
    }

    @Override
    public String toString() {
        return "Address {city=" + city + ", postalCode=" + postalCode + ", state=" + state + ", streetAddress="
                + streetAddress + "}";
    }
}
