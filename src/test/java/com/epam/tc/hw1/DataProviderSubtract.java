package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderSubtract {

    @DataProvider(name = "testing subtract numbers")
    public static Object[][] getTestSubtractData() {
        return new Object[][]{
                {6, 5, 1},
                {-5, 3, -8},
                {0, 0, 0},
                {4, -3, 7},
                {-1000, -500, -500}
        };
    }
}
