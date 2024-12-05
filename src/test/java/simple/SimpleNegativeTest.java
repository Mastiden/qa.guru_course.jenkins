package simple;

import static org.junit.jupiter.api.Assertions.assertTrue;
import helpers.TestBaseWithListener;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("simple")
public class SimpleNegativeTest extends TestBaseWithListener {

    @Test
    void test0() {
        assertTrue(false);
    }

    @Test
    void test1() {
        assertTrue(false);
    }

    @Test
    void test2() {
        assertTrue(false);
    }
}
