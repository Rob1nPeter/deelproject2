package com.example.demo1.LoginEnRegistreer;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAccountsLezenTest {
    @Test // bestaande File
    public void testLaadAccountsUitBestand_ValidFile_ReturnsCorrectAccounts() {
        // Arrange
        String fileName = "accounts.txt";
        String content = "user1:password1\nuser2:password2";
        createTestFile(fileName, content);

        // Act
        Map<String, String> accounts = LoginAccountsLezen.laadAccountsUitBestand();

        // Assert
        assertEquals(2, accounts.size());
        assertEquals("password1", accounts.get("user1"));
        assertEquals("password2", accounts.get("user2"));

        // Clean up
        deleteTestFile(fileName);
    }
    @Test // niet bestaande file
    public void testLaadAccountsUitBestand_InvalidFile_ReturnsEmptyAccounts() {
        // Arrange
        String fileName = "nonexistent.txt";
        String content = "user1:password1\nuser2:password2";
        createTestFile(fileName, content);

        // Act
        Map<String, String> accounts = LoginAccountsLezen.laadAccountsUitBestand();

        // Assert
        assertEquals(0, accounts.size());

        // geen clean up
    }

    // maak testfile met naam en content
    private void createTestFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // delete testfile
    private void deleteTestFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}