package com.example.demo1.Query;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringToStringStrategyTest {
    @Test
    public void testResolve_Hallo() {
        // Arrange
        StringToStringStrategy strategy = new StringToStringStrategy();
        QueryResolutionForm<String> form = new QueryResolutionForm<>("hallo");

        // Act
        QueryResolutionResult<String> result = strategy.resolve(form);

        // Assert
        assertEquals("Bot: Hey", result.getData());
    }

    @Test
    public void testResolve_AnderWoord() {
        // Arrange
        StringToStringStrategy strategy = new StringToStringStrategy();
        QueryResolutionForm<String> form = new QueryResolutionForm<>("goedemorgen");

        // Act
        QueryResolutionResult<String> result = strategy.resolve(form);

        // Assert
        assertEquals("Bot: Wat bedoel je met goedemorgen?", result.getData());
    }
}
