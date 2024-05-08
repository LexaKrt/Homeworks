
public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        String data = "Переход от базовых приложений к более сложным требует использования Spring Security для обеспечения безопасности. Новая версия, Spring Security 6, изменяет некоторые базовые реализации, а русскоязычных материалов на эту тему очень мало.";

        // Создать два параллельных потока, в которых выведем фразу на консоль

/*
        Thread thread1 = new Thread(new PrintDataTask(data));
        Thread thread2 = new Thread(new PrintDataTask(data));
*/

/*
        Thread thread1 = new Thread(()->{
            for(int i = 0; i < data.length(); ++i)
                System.out.print(data.charAt(i));
            System.out.println();
        });
        Thread thread2 = new Thread(()->{
            for(int i = 0; i < data.length(); ++i)
                System.out.print(data.charAt(i));
            System.out.println();
        });
*/
/*
        Thread thread1 = new PrintDataThread(data);
        Thread thread2 = new PrintDataThread(data);

        thread1.start();
        thread2.start();
*/
        int procCount = Runtime.getRuntime().availableProcessors();
        System.out.println(procCount);

        for (int i = 0; i < procCount; i++) {
            Thread thread = new PrintDataThread(data);
            thread.start();
            thread.join();
        }
/*
        new PrintDataThread(data).start();
        new PrintDataThread(data).start();
*/

    }

}