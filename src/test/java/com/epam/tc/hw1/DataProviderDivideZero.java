package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderDivideZero {

    @DataProvider(name = "testing divide zero numbers")
    public static Object[][] getTestData() {
        return new Object[][]{
                {0, 0, 0},
                {5, 0, 0},
                {-5, 0, 0}
        };
    }
}
