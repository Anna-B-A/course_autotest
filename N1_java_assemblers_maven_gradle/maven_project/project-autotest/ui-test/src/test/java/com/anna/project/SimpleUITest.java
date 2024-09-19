package com.anna.project;

import org.junit.Test;
import org.junit.jupiter.api.Tag;

public class SimpleUITest {
    @Test
    public void test1() {
        int res = 5 + 6;
        System.out.println(res);
        System.out.println("HELLO, im test1 in ui!");
    }
    
    @Tag("smoke")
    @Test
    public void test2() {
        int res = 5 + 6;
        System.out.println(res);
        System.out.println("HELLO, im test2 in ui!");
    }
}
