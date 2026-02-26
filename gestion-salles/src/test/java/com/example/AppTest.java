package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testAppNotNull() {
        App app = new App();
        assertNotNull(app);
    }

    @Test
    void testTrueExample() {
        assertTrue(1 + 1 == 2);
    }
}