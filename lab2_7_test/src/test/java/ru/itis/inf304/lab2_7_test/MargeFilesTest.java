package ru.itis.inf304.lab2_7_test;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class MargeFilesTest {

    @Test
    public void testMerge() throws IOException {
        byte[] expectedArray = Files.readAllBytes(Path.of("fileResult.txt"));
        Assert.assertArrayEquals(expectedArray, MergeFiles.merge(new File("file1.bin"), new File("file2.bin")));
    }
}
