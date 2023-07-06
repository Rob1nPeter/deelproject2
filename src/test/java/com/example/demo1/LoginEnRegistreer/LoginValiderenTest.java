package com.example.demo1.LoginEnRegistreer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginValiderenTest {

    @Test
    void loginValideren() {
        assertTrue(LoginValideren.testLogin("aaa", "aaa"));

    }
    @Test
    void loginValideren2(){
        assertTrue(LoginValideren.testLogin("bbb","bbb"));
    }
}