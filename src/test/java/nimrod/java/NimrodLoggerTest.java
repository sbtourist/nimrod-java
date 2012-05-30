package nimrod.java;

import org.junit.Test;

/**
 * Silly test.
 */
public class NimrodLoggerTest {

    @Test
    public void testNormalization() {
        NimrodLogger.forAlert(NimrodLogger.normalize("TEST me/123")).error("error");
    }
}
