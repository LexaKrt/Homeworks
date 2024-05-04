package ru.itis.inf304.lab2_7_test;

import org.junit.Assert;
import org.junit.Test;

public class JSONBracketsTest {

    @Test
    public void testCheckBrackets() {
        Assert.assertEquals(1, JSONBrackets.checkBrackets("testFile.json"));
    }
}
