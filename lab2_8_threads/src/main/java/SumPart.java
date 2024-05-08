import java.util.Timer;

public class SumPart extends Thread {
    private static CountSum countSum;
    private double a;
    private double b;
    private double sum = 0;
    public static final int N = 100;

    public SumPart(double a, double b) {
        this.a = a;
        this.b = b;
        countSum = new CountSum();
    }

    public CountSum getCountSum() {
        return countSum;
    }

    public double getPartSum() {
        return sum;
    }

    public void addSum(double addition) {
        sum += addition;
    }

    private Double func(Double x) {
        return Math.sin(x * x);
    }

    @Override
    public void run() {
        double h = (b - a) / N;
        for (int i = 0; i < N; ++ i) {
            sum += h * func(a + i * h + h/2);

        }
        synchronized (countSum) {
            countSum.result += sum;
        }
    }
}