package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Main thCls = new Main();

        // 1st method

        thCls.firstMethod(new File("data.txt"));

        // 2nd method

//        thCls.secondMethod(args);
    }

    public void secondMethod(String[] args) {
        String str = String.join(" ", args);
        Main.timerMethod(str);
    }

    public void firstMethod(File file) {
        byte[] byteArray = new byte[(int) file.length()];
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file));) {
                try {
                    byteArray = dis.readAllBytes();
                } catch (EOFException e) {
                    throw new EOFException();
                }
            String str = new String(byteArray, StandardCharsets.UTF_8);
            Main.timerMethod(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void timerMethod(String str) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                File wav = new File(PlayWAV.class.getClassLoader().getResource("rocket.wav").getPath());
                PlayWAV.playWavFromFile(wav);
                timer.cancel();
            }
        };

        try {
            Date date = new SimpleDateFormat("dd.MM.yy HH:mm:ss")
                    .parse(str);

            timer.schedule(task, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}