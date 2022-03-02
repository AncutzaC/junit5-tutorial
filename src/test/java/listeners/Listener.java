package listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listener implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("                        ");
        System.out.println("________________________");
        System.out.println("This test was disabled ("+context+") because of "+ reason);
        System.out.println("________________________");
        System.out.println("                        ");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("                        ");
        System.out.println("________________________");
        System.out.println("This test was successfull! ("+context+")");
        System.out.println("________________________");
        System.out.println("                        ");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("                        ");
        System.out.println("________________________");
        System.out.println("This test has failed ("+ context + ") because of "+ cause);
        System.out.println("________________________");
        System.out.println("                        ");
    }
}
