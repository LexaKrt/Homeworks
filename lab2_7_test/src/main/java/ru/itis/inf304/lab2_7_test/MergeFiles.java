package ru.itis.inf304.lab2_7_test;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class MergeFiles {

    public static void main(String[] args) {
        merge(new File("file1.bin"), new File("file2.bin"));
    }
    public static byte[] merge(File file1, File file2) {
        try (FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);
        ) {
            byte[] array = new byte[(int) (file1.length() + file2.length())];
            byte[] arr1 = fis1.readAllBytes();
            byte[] arr2 = fis2.readAllBytes();


            System.arraycopy(arr1, 0, array, 0, arr1.length);
            System.arraycopy(arr2, 0, array, arr1.length, arr2.length);

            System.out.println(Arrays.toString(array));
            return array;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}