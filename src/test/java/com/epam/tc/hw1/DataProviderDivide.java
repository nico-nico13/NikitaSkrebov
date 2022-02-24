package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderDivide {

    @DataProvider(name = "testing divide numbers")
    public static Object[][] getTestDivideData() {
        return new Object[][]{
                {2, 2, 1},
                {5, 3, 1},
                {-5, 3, -1},
                {3, -3, -1},
                {1000, 500, 2},
        };
    }

    @DataProvider(name = "testing divide zero double numbers")
    public static Object[][] getTestDivideZeroDoubleData() {
        return new Object[][]{
                {0.0, 0.0, Double.NaN},
                {5.0, 0.0, Double.POSITIVE_INFINITY},
                {-5.0, 0.0, Double.NEGATIVE_INFINITY}
        };
    }

    @DataProvider(name = "testing divide zero long numbers")
    public static Object[][] getTestDivideZeroLongData() {
        return new Object[][]{
                {0, 0},
                {5, 0},
                {-5, 0}
        };
    }
}
