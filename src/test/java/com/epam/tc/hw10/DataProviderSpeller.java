package com.epam.tc.hw10;

import org.testng.annotations.DataProvider;

public class DataProviderSpeller extends ParserJsonToDP {

    @DataProvider
    public Object[][] parsingCheckText() {

        resultArray = parseFromJsonToDataProvider(CheckTextDataJson);
        return resultArray;
    }

    @DataProvider
    public Object[][] parsingCheckTexts() {

        resultArray = parseFromJsonToDataProvider(CheckTextsDataJson);
        return resultArray;
    }
}
