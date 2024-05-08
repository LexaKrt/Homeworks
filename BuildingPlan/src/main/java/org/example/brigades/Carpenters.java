package org.example.brigades;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Carpenters extends Brigades{
    public Carpenters() {
    }
    public Carpenters(String name, List<Integer> listOfWork) {
        super(name, listOfWork);
    }
}
