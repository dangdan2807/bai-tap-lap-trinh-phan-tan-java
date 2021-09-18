package lab2.exercise3.entity;

public class State {
    private int ID;
    private String StateName;
    private String Abbreviation;
    private String Capital;
    private int StateHoodYear;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getAbbreviation() {
        return Abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        Abbreviation = abbreviation;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public int getStateHoodYear() {
        return StateHoodYear;
    }

    public void setStateHoodYear(int StateHoodYear) {
        this.StateHoodYear = StateHoodYear;
    }

    public State(int ID, String stateName, String abbreviation, String capital, int StateHoodYear) {
        this.ID = ID;
        StateName = stateName;
        Abbreviation = abbreviation;
        Capital = capital;
        this.StateHoodYear = StateHoodYear;
    }

    @Override
    public String toString() {
        return "State { ID= " + ID + ", Capital= " + Capital + ", Abbreviation= " + Abbreviation + ", StateName= "
                + StateName + ", StateHoodYear= " + StateHoodYear + " }";
    }
}
