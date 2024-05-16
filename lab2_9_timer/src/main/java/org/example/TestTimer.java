package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Время подошло!");
                cancel();
            }
        };

        Timer timer = new Timer();
        //Запуск задачи через 2 секунды
        //timer.schedule(task, 2000);

        try {
            Date date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
                    .parse("08.05.2024 16:16:00");
            // Запускаем задачу на определенное время
            timer.schedule(task, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
