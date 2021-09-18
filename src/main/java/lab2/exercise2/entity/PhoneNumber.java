package lab2.exercise2.entity;

import javax.json.JsonObject;

public class PhoneNumber {
    private String type;
    private String number;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumber(String type, String phone) {
        this.type = type;
        this.number = phone;
    }

    public PhoneNumber(JsonObject jo) {
        this(jo.getString("type"), jo.getString("number"));
    }

    @Override
    public String toString() {
        return "phoneNumber {number=" + number + ", type=" + type + "}";
    }
}
