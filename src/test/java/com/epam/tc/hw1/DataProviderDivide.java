package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderDivide {

    @DataProvider(name = "testing divide numbers")
    public static Object[][] getTestData() {
        return new Object[][]{
                {2, 2, 1},
                {5, 3, 1},
                {-5, 3, -1},
                {3, -3, -1},
                {1000, 500, 2}
                {5, 0, 0}
        };
    }
}

