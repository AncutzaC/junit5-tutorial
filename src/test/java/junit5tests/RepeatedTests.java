package junit5tests;

import org.junit.jupiter.api.*;

public class RepeatedTests {

    @RepeatedTest(5)
    @Disabled
        void firstRepeatedMethod() {
            System.out.println("We are repeating this test");
        }

    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}." +
            " Total is: {totalRepetitions}")
    @Disabled
    void secondRepeatedMethod() {
        System.out.println("We are repeating a new test");
    }

    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}." +
            " Total is: {totalRepetitions}")
    @DisplayName("This is a repeated test method")
    @Disabled
    void secondRepeatedMethodAndDisplayName() {
        System.out.println("We are repeating a new test");
    }

    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}." +
            " Total is: {totalRepetitions}")
    @DisplayName("This is a repeated test method")
    void thirdRepeatedMethod(RepetitionInfo repetitionInfo) {
        System.out.println("This code will run at each repetition");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 3,
                () -> System.out.println("This code only runs for repetition " +
                        "3"));
    }
}
