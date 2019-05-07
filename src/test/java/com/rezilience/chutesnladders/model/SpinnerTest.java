package com.rezilience.chutesnladders.model;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SpinnerTest {

    private static Spinner spinner;

    @BeforeClass
    public static void init() {
        spinner = new Spinner();
    }

    @Test
    public void testValueWithinRange() {
        for (int i = 0; i < 10000; i++) {
            int spin = spinner.spin();
            assertTrue(spin >= 1);
            assertTrue(spin <= 6);
        }
    }
}
