package com.piggybank.dbloader;

import com.piggybank.model.Category;

import java.util.Random;

public class RandomCategoryLimits {

    static Random random = new Random();
    static Integer INCOME_PREFIX = 5000, ENTERTAINMENT_PREFIX = 5000, GROCERY_PREFIX = 500, HOUSING_PREFIX = 1000, UTILITIES_PREFIX = 200, HEALTH_PREFIX = 300, SAVINGS_PREFIX = 600, DEBT_PREFIX = 400;
    static Integer INCOME_BOUND = 1000, ENTERTAINMENT_BOUND = 1000, GROCERY_BOUND = 100, HOUSING_BOUND = 700, UTILITIES_BOUND = 400, HEALTH_BOUND = 200, SAVINGS_BOUND = 400, DEBT_BOUND = 50;


    public static Integer getRandomForCategory(Category category) {
        if (category.equals(Category.INCOME)) {
            return INCOME_PREFIX + random.nextInt(INCOME_BOUND);
        }
        if (category.equals(Category.ENTERTAINMENT)) {
            return ENTERTAINMENT_PREFIX + random.nextInt(ENTERTAINMENT_BOUND);
        }
        if (category.equals(Category.GROCERY)) {
            return GROCERY_PREFIX + random.nextInt(GROCERY_BOUND);
        }
        if (category.equals(Category.HOUSING)) {
            return HOUSING_PREFIX + random.nextInt(HOUSING_BOUND);
        }
        if (category.equals(Category.UTILITIES)) {
            return UTILITIES_PREFIX + random.nextInt(UTILITIES_BOUND);
        }
        if (category.equals(Category.HEALTH)) {
            return HEALTH_PREFIX + random.nextInt(HEALTH_BOUND);
        }
        if (category.equals(Category.SAVINGS)) {
            return SAVINGS_PREFIX + random.nextInt(SAVINGS_BOUND);
        }
        if (category.equals(Category.DEBT)) {
            return DEBT_PREFIX + random.nextInt(DEBT_BOUND);
        }
        return random.nextInt(100);

    }
}
