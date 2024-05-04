package ru.itis.inf304.lab2_7_test;

public class MathUtil {
    public static Double exp(Double x){
        double eps = 0.0000001;
        double x_ = x;
        Double sum = 1.d;
        int n = 1;
        while (Math.abs(x_) > eps){
            x_ = x_*x/n;
            sum += x_;
            n++;
        }
        return sum;
    }
}

