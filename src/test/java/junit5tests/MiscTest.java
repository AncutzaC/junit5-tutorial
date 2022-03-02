package junit5tests;

import org.junit.jupiter.api.*;

public class MiscTest {
    @Test
    @Timeout(5)
    void timeout() throws InterruptedException {
        System.out.println("This is the test with the timeout");
        Thread.sleep(6000);
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest {

        @BeforeAll
        void beforeAll() {
            System.out.println("Before All in nested test");
        }

        @Test
        void nestedTestMethod() {
            System.out.println("Nested test method");
        }
    }

    @MyAnnotation
    void annotatedMethod1() {
        System.out.println("This is the annotated method");
    }
}
