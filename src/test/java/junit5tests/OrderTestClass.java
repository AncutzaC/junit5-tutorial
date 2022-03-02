package junit5tests;

import org.junit.jupiter.api.*;
@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class OrderTestClass {
    @BeforeAll
    void beforeAll(){
        System.out.println("-- This is the beforeAll method.");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("----This is the beforeEach method.");
    }

    @AfterAll
    void afterAll(){
        System.out.println("--This is the afterAll method.");
    }

    @AfterEach
            void afterEach(){
        System.out.println("----This is the afterEach method.");
    }
    @Test
    void firstMethod(){
        System.out.println("This is the first method.");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethod(){
        System.out.println("This is the second method.");
    }

    @Test
    @DisplayName("A display name")
    void thirdTest(){
        System.out.println("This is the third method.");
    }
}
