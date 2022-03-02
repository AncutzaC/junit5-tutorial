package junit5tests;

import listeners.Listener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
@ExtendWith(Listener.class)

public class DisableEnableTest {

    @Test
    @Disabled(value = "disabled for demo")
    void firstTest() {
        System.out.println("This is the first test method");
    }

    @Test
    @DisabledOnOs(value= OS.WINDOWS, disabledReason = "disabled on Windows")
    void secondTest() {
        System.out.println("This is the second test method");
    }

    @Test
    void thirdTest() {
        System.out.println("This is the third test method");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "disabled for demo")
    void fourthTest() {
        System.out.println("This is the fourth test method");
    }
    boolean provider (){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    @Test
    void fifthTest() {
        System.out.println("This is the fifth test method");
    }
}
