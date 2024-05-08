import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainSumm {
    public static void main(String[] args) {
        double SP = Math.sqrt(Math.PI);
        SumPart s1 = new SumPart(0, SP);
        long startTime = System.nanoTime();
        s1.run();
        double summ1 = s1.getPartSum();
        long endTime = System.nanoTime();

        System.out.println(summ1 + " : " + (endTime - startTime) );


        int countOfThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("countOfThreads " + countOfThreads);
        double h = SP / countOfThreads;
        List<SumPart> thList = new ArrayList<>();
        for (int i = 0; i < countOfThreads; ++i) {
            thList.add(new SumPart(i * h, (i + 1) * h));
        }

        startTime = System.nanoTime();
        // запускаем потоки
        thList.forEach(t -> t.start());


        // родительский поток (main) ожидает завершения работы потоков
        thList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        double result = thList.stream()
                .mapToDouble(t -> t.getPartSum())
                .sum();
        endTime = System.nanoTime();

        System.out.println(result + " : " + (endTime - startTime) );


        // synchronized

//        List<Thread> threads = new ArrayList<>();
        SumPart sumPart = new SumPart(0, SP);
        thList = new ArrayList<>();

        startTime = System.nanoTime();

        /*for (int i = 0; i < countOfThreads; ++i) {
            double start = i * h;
            double end = (i + 1) * h;
            Thread thread = new Thread(() -> sumPart.addSum(SumPart.calculatePartSum(start, end)));
            threads.add(thread);
            thread.start();
        }

        threads.forEach(thread ->
                {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );*/

        for (int i = 0; i < countOfThreads; ++i) {
            thList.add(new SumPart(i * h, (i + 1) * h));
        }

        thList.forEach(t -> t.start());

        thList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        endTime = System.nanoTime();

        System.out.println(sumPart.getCountSum().result + " : " + (endTime - startTime) );
    }
}