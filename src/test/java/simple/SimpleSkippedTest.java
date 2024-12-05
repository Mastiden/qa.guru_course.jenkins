package simple;

import static org.junit.jupiter.api.Assertions.assertTrue;
import helpers.TestBaseWithListener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("simple")
public class SimpleSkippedTest extends TestBaseWithListener {

    @Test
    @Disabled("Some reason")
    void test0() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    void test1() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    void test2() {
        assertTrue(false);
    }
}
