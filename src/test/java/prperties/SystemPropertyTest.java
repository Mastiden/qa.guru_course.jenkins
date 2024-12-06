package prperties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("SystemPropertyTest")
public class SystemPropertyTest {

    @Test
    @Tag("one_property")
    void simplePropertyTest() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }

    @Test
    @Tag("one_property")
    void simplePropertyTest1() {
        System.setProperty("browser", "opera");
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);

    // ./gradlew one_property_test -Dbrowser=safari - передать что-то из вне
    }

    @Test
    @Tag("hello_test")
    void simplePropertyTest2() {
        System.out.println("Hello, " + System.getProperty("user_name", "unknown student"));

        /*
        *
        * */
    }
}
