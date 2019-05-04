package com.rezilience.chutesnladders;

import java.util.concurrent.ThreadLocalRandom;

public class Spinner {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 6;

    public int spin() {
        return ThreadLocalRandom.current().nextInt(MINIMUM, MAXIMUM + 1);
    }
}
