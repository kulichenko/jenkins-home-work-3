package guru.qa.hw9.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class Skipped {

    @Test
    @Disabled
    void test00() {
        assertTrue(true);
    }

    @Test
    @Disabled("No need")
    void test01() {
        assertTrue(true);
    }

    @Test
    @Disabled("Broken")
    void test02() {
        assertTrue(true);
    }
}
