package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderMultiply {

    @DataProvider(name = "testing multiply numbers")
    public static Object[][] getTestMultiplyData() {
        return new Object[][]{
                {2, 2, 4},
                {2, 1, 2},
                {2, 0, 0},
                {-3, 3, -9},
                {1, -5, -5}
        };
    }
}
