package com.epam.tc.hw7.entities;

import com.jdiai.tools.DataClass;

public class TestData extends DataClass<TestData> {
    private int odds;
    private int even;
    private String elements;
    private String metals;
    private String colors;
    private String vegetables;

    public static TestData DEFAULT_DATA = new TestData().set(testData -> {
        testData.odds = 3;
        testData.even = 4;
//        testData.elements = "Wind";
        testData.colors = "Red";
        testData.metals = "Bronze";
        //testData.vegetables
    });
}
