public class MainDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for(int i = 0; i < 100; ++i) {
                try {
                    System.out.print(".");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // прерываем выполнение потока при завершении родительского
        thread.setDaemon(true);
        thread.start();
    }
}