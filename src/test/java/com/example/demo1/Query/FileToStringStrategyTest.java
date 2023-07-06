package com.example.demo1.Query;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileToStringStrategyTest {

    @Test
    public void testResolve() {
        // Create a test file
        File testFile = new File("LOL.PNG");

        // Create a query resolution form with the test file
        QueryResolutionForm<File> form = new QueryResolutionForm<>(testFile);

        // Create an instance of the FileToStringStrategy
        FileToStringStrategy strategy = new FileToStringStrategy();

        // Resolve the query
        QueryResolutionResult<String> result = strategy.resolve(form);

        // Verify the result
        String resolvedData = result.getData();
        Assertions.assertEquals("Mooie png", resolvedData);
    }

    @Test
    public void testResolveElse() {
        //  test file
        File testFile = new File("LOL.jpeg");

        // Create a query resolution form with the test file
        QueryResolutionForm<File> form = new QueryResolutionForm<>(testFile);

        // Create an instance of the FileToStringStrategy
        FileToStringStrategy strategy = new FileToStringStrategy();

        // Resolve the query
        QueryResolutionResult<String> result = strategy.resolve(form);

        // Verify the result
        String resolvedData = result.getData();
        Assertions.assertEquals("LOL.jpegLOL.jpeg", resolvedData);
    }
}