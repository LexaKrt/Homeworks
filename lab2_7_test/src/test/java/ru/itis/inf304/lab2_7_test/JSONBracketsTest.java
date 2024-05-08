package ru.itis.inf304.lab2_7_test;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class JSONBracketsTest {

    @Test
    public void testCheckBrackets() throws NotTextFileException, IOException {
        Assert.assertEquals(1, JSONBrackets.checkBrackets("testFile.json"));

        Assert.assertThrows(NullPointerException.class, () ->
        {
            JSONBrackets.checkBrackets(null);
        });

        Assert.assertThrows(FileNotFoundException.class, () ->
        {
            JSONBrackets.checkBrackets("notExistentFile.txt");
        });

        Assert.assertThrows(NotTextFileException.class, () ->
        {
            JSONBrackets.checkBrackets("incorrectBrackets.json");
        });
    }
}
