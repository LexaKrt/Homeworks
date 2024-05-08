package org.example;


import org.example.brigades.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        List<Work> workList = new LinkedList<>();
        MainClass.addAllWorks(workList);
        int daysCount = 0;


        List<Brigades> brigadesList = new LinkedList<>();
        MainClass.addAllBrigades(brigadesList);

        Set<Integer> doneWorksIds = new HashSet<>(List.of(0));
        List<Brigades> brigadesDone = new LinkedList<>();

        while (doneWorksIds.size() < 17) {
            List<Thread> threads = new ArrayList<>();
            Set<Work> doneWorks = new HashSet<>();
            for (Work work : workList) {
                if (doneWorksIds.containsAll(work.getDependencies())) {
                    Thread thread = new Thread(work);
                    threads.add(thread);
                    thread.start();
                    doneWorks.add(work);
                }
             }


            threads.forEach(
                    thread -> {
                        try {
                            thread.join();
                            doneWorks.forEach(w -> {
                                doneWorksIds.add(w.getWorkId());
                            });
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            int daysOfTheStage = doneWorks.stream().map(Work::getDuration).max(Integer::compare).get();
            daysCount += daysOfTheStage;


            for (Brigades brigade : brigadesList) {
                if (doneWorksIds.containsAll(brigade.getListOfWorks())) {
                    brigadesDone.add(brigade);
                } else if (doneWorks.stream().anyMatch(
                        work ->
                            brigade.getListOfWorks().contains(work.getWorkId())
                )) {
                   continue;
                } else if (doneWorksIds.size() > 1) {
                    brigade.setDominoTime(brigade.getDominoTime() + daysOfTheStage);
                }
            }

            System.out.println();
            workList.removeIf(doneWorks::contains);
            brigadesList.removeIf(brigadesDone::contains);
        }
        System.out.println("Building ends in " + daysCount);
        brigadesDone.forEach(brigades -> System.out.println(brigades.toString()));

        /*
        for (int i = 0; i < countOfThreads; i++) {
            if (new HashSet<>(doneWorksIds).containsAll(workList.get(i).getDependencies())) {
                Thread thread = new Thread(workList.get(i));
                thread.start();
                doneWorksIds.add(workList.get(i).getWorkId());
                thread.join();
            }
        }*/

        /*while (doneWorksIds.size() < 16) {
            List<Thread> threads = new ArrayList<>();
            Iterator<Work> iterator = workList.iterator();
            while (iterator.hasNext()) {
                Work work = iterator.next();
                if (new HashSet<>(doneWorksIds).containsAll(work.getDependencies())) {
                    Thread thread = new Thread(work);
                    threads.add(thread);
                    thread.start();
                    iterator.remove();
                }
            }
            threads.forEach(t -> {
                try {
                    t.join();
                    doneWorksIds.add();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                });
        }*/
    }

/*
    public void executingBuilding() {

    }*/


    public static void addAllWorks(List<Work> list) {
        list.add(new Work(1, "Projecting", 7, new LinkedList<>(List.of(0))));
        list.add(new Work(2, "Window Manufacturing", 7, new LinkedList<>(List.of(1))));
        list.add(new Work(3, "Door Manufacturing", 7, new LinkedList<>(List.of(1))));
        list.add(new Work(4, "Foundation Construction", 14, new LinkedList<>(List.of(1))));
        list.add(new Work(5, "Laying Communication", 4, new LinkedList<>(List.of(4))));
        list.add(new Work(6, "Walling", 14, new LinkedList<>(List.of(4))));
        list.add(new Work(7, "Roof Construction", 3, new LinkedList<>(List.of(6))));
        list.add(new Work(8, "Windows Installation", 1, new LinkedList<>(List.of(2, 7))));
        list.add(new Work(9, "Doors Installation", 1, new LinkedList<>(List.of(3, 7))));
        list.add(new Work(10, "Installation Of Heating Devices", 3, new LinkedList<>(List.of(5, 8, 9))));
        list.add(new Work(11, "Electrical Wiring", 3, new LinkedList<>(List.of(5, 7))));
        list.add(new Work(12, "Finishing Of Walls And Ceiling", 7, new LinkedList<>(List.of(8, 9, 11))));
        list.add(new Work(13, "Floor Finishing", 7, new LinkedList<>(List.of(12))));
        list.add(new Work(14, "Installation Of Lighting Devices", 1, new LinkedList<>(List.of(12))));
        list.add(new Work(15, "Plumbing Installation", 2, new LinkedList<>(List.of(5, 11, 12))));

        list.add(new Work(16, "Ending Of Building", 0, IntStream.rangeClosed(1, 15)
                .boxed()
                .collect(Collectors.toList()
                )));
    }

    public static void addAllBrigades(List<Brigades> list) {
        list.add(new Carpenters("carpenters", new LinkedList<>(List.of(2, 3, 7, 8, 9))));
        list.add(new Electricians("electricians", new LinkedList<>(List.of(11, 14))));
        list.add(new Masons("masons", new LinkedList<>(List.of(4, 6))));
        list.add(new Plasterers("plasters", new LinkedList<>(List.of(12, 13))));
        list.add(new Plumbers("plumbers", new LinkedList<>(List.of(5, 10, 15))));
    }
}
