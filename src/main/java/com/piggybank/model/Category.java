package com.piggybank.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Category {
    ENTERTAINMENT, GROCERY, HOUSING, UTILITIES, INCOME, HEALTH, SAVINGS, DEBT;

    private static final List<Category> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static Category randomCategory() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public TrasactionType getTransactiontype(Category category) {
        if (category.equals(INCOME)) {
            return TrasactionType.CREDIT;
        } else return TrasactionType.DEBIT;
    }
}
