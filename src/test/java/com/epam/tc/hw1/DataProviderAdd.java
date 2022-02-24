package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderAdd {

    @DataProvider(name = "testing add numbers")
    public static Object[][] getTestAddData() {
        return new Object[][]{
                {0, 5, 5},
                {5, 3, 8},
                {0, 0, 0},
                {-3, 3, 0},
                {1000, 500, 1500}
        };
    }
}
