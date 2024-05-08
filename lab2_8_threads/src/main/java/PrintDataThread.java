public class PrintDataThread extends Thread {

    private String data;

    public PrintDataThread(String data) {
        this.data = data;
    }

    @Override
    public synchronized void run() {

        for(int i = 0; i < data.length(); ++i)
            System.out.print(data.charAt(i));

        System.out.println();
    }
}