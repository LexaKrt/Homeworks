package ru.itis.inf304.lab2_7_test;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class JSONBrackets {
    public static void main(String[] args) throws NotTextFileException, IOException {
        System.out.println(checkBrackets("testFile.json"));
    }
    public static int checkBrackets(String filename) throws NotTextFileException, IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            int content;
            Deque<Character> deque = new LinkedList<>() {
            };
            while ((content = dis.read()) != -1) {
                char chr = (char) content;
                if (!isTextSymbol(chr)) {
                    System.out.println(chr);
                    throw new NotTextFileException("Character is not in the text format!");
                } else if (chr == '[' || chr == '{') {
                    deque.push(chr);
                } else if (chr == '}' || chr == ']') {
                    char tmp = deque.pop();
                    if (!(chr == '}' & tmp == '{' || chr == ']' & tmp == '[')) {
                        return 0;
                    }
                }
            }
            if (!deque.isEmpty()) {
                return 0;
            }
        } catch (NullPointerException e) {
            throw new NullPointerException();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e);
        } catch (NotTextFileException e) {
            throw new NotTextFileException();
        }
        return 1;
    }

    private static boolean isTextSymbol(char symbol) {
        return String.valueOf(symbol).matches("^[A-Za-zА-Яа-яЁёЙй0-9\\{\\}\\[\\].,:;\"\\r\\n ]|-|_");
    }
}
