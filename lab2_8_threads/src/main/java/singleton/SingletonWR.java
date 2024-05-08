package singleton;

import java.io.*;

public class SingletonWR {
    public static void main(String[] args) {
        SingletonWR sngWR = new SingletonWR();

        sngWR.writeToFile(new File("kittens.txt"));
        sngWR.readFromFile(new File("kittens.txt"));

        SingletonWR sngWR2 = new SingletonWR();
    }
    private static SingletonWR instance;

    private SingletonWR () {

    }

    public static SingletonWR getInstance() {
        if (instance == null) {
            synchronized (SingletonWR.class) {
                if (instance == null) {
                    instance = new SingletonWR();
                }
            }
        }
        return instance;
    }

    public void readFromFile(File file) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            int chr = 0;
            while ((chr = dis.readByte()) > 0) {
                System.out.println((char) chr);
            }
        } catch (EOFException e) {
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToFile(File file) {
        String message = "Kittens!";

        try (DataOutputStream dot = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < message.length(); i++) {
                dot.writeByte(message.charAt(i));
            }
            dot.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
