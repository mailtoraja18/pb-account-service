package com.piggybank.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum TrasactionType {
    DEBIT , CREDIT;

    private static final List<TrasactionType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static TrasactionType randomType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
