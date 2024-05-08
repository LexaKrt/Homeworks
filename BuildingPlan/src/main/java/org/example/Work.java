package org.example;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Getter
@Setter
public class Work implements Runnable{

    Work() {

    }

    Work(int workId, String name, int duration, List<Integer> dependencies) {
        this.dependencies = dependencies;
        this.name = name;
        this.duration = duration;
        this.workId = workId;
    }

    private int workId;
    private String name;
    private int duration;
    private List<Integer> dependencies;

    @Override
    public void run() {
        System.out.println("Start " + name);
        try {
            Thread.sleep(100L * duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\u001B[31m" + "End " + name + "\u001B[0m");
    }
}
