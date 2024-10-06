package prepare;

import org.junit.jupiter.api.*;

public class JunitTests {
    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before Each");
    }

    @Test
    void test1(){
        System.out.println("Тест 1");
    }

    @Test
    void test2(){
        System.out.println("Тест 2");
    }

    @Test
    void test3(){
        System.out.println("Тест 3");
    }

    @AfterEach
    void afterfEach(){
        System.out.println("After Each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After All");
    }

}
