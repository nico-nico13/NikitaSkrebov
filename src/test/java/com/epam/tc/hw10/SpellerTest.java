package com.epam.tc.hw10;

import com.epam.tc.hw10.DTO.ResponseDTO;
import com.epam.tc.hw10.DTO.TextDTO;
import com.epam.tc.hw10.DTO.TextsDTO;
import com.epam.tc.hw10.services.ActionService;
import com.epam.tc.hw10.services.AssertionService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpellerTest {

    private AssertionService assertionService;
    private ActionService actionService;

    @BeforeClass
    public void SetUp() {
        assertionService = new AssertionService();
        actionService = new ActionService();
    }

    @Test(dataProvider = "parsingCheckText", dataProviderClass = DataProviderSpeller.class)
    public void checkTextEndpointCodeAndLength(TextDTO testData) {

        Response response = actionService.requestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService
                .checkErrorCode(actualResult, testData)
                .checkLength(actualResult, testData);
    }

    @Test(dataProvider = "parsingCheckText", dataProviderClass = DataProviderSpeller.class)
    public void checkTextEndpointIncorrectAndFixedWordResponse(TextDTO testData) {

        Response response = actionService.requestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService
                .checkIncorrectWord(actualResult, testData)
                .checkResponseFixedWord(actualResult, testData);
    }

    @Test(dataProvider = "parsingCheckText", dataProviderClass = DataProviderSpeller.class)
    public void checkTextEndpointCode(TextDTO testData) {

        Response response = actionService.requestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService.
                checkErrorCode(actualResult, testData);
    }

    @Test(dataProvider = "parsingCheckText", dataProviderClass = DataProviderSpeller.class)
    public void checkTextEndpointFixedWordResponse(TextDTO testData) {

        Response response = actionService.requestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService.
                checkResponseFixedWord(actualResult, testData);

    }

    @Test(dataProvider = "parsingCheckTexts", dataProviderClass = DataProviderSpeller.class)
    public void checkTextsEndpoint(TextsDTO testData) {

        Response response = actionService.requestForCheckTexts(testData);
        ResponseDTO[][] actualResult = actionService.parseResponseForTexts(response);
        assertionService.
                checkAllIncorrectWords(actualResult, testData);
    }
}
