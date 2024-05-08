package org.example.brigades;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Brigades {
    private List<Integer> listOfWorks;
    private long dominoTime;
    private String name;
    public Brigades(String name, List<Integer> listOfWork) {
        this.name = name;
        this.listOfWorks = listOfWork;
    }
    Brigades() {}

    @Override
    public String toString() {
        return "Brigade " + name + " played domino for " + dominoTime;
    }
}
