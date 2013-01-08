package org.sibyg.hibernate.tutorial.util;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();

    public static int integer() {
        return random.nextInt();
    }

    public static String string() {
        return RandomStringUtils.random(10);
    }
}
