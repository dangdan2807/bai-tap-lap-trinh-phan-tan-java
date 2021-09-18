package lab2.exercise3.entity;

import java.util.*;

public class ListState {
    private List<State> listState;

    public ListState() {
        listState = new ArrayList<State>();
    }

    public boolean add(State state) {
        if (state != null) {
            for (State item : listState) {
                if (item.getID() == state.getID()) {
                    return false;
                }
            }
            listState.add(state);
            return true;
        }
        return false;
    }

    public void adds(ArrayList<State> state) {
        for (State item : state) {
            if (item != null) {
                listState.add(item);
            }
        }
    }

    public State findByAb(String abb) {
        for (State state : listState) {
            if (state.getAbbreviation().equals(abb)) {
                return state;
            }
        }
        return null;
    }

    public ArrayList<State> findByYear(int year) {
        ArrayList<State> result = new ArrayList<State>();
        for (State state : listState) {
            if (state.getStateHoodYear() == year - 1) {
                result.add(state);
            }
        }
        return result;
    }

    public void showStates() {
        for (State item : listState) {
            System.out.println(item.toString());
        }
    }

    public ArrayList<State> getListState() {
        return (ArrayList<State>) listState;
    }
}
