package com.epam.tc.hw7;

import static com.epam.tc.hw7.entities.User.ROMAN;
import static com.epam.tc.hw7.site.JdiSite.*;
import static com.epam.tc.hw7.site.pages.HomePage.*;
import com.epam.tc.hw7.entities.TestData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.epam.jdi.light.driver.WebDriverUtils;

public class TestRunner implements TestsInit {

    @BeforeSuite
    public void testSetUp() {
        homePage.open();
        userIcon.click();
        loginForm.loginAs(ROMAN);
    }

    @Test(dataProviderClass = DataProviderJDI.class,
    dataProvider = "dataForMetalColorTest")
    public void JdiTest(TestData testData) {
        metalsColorsPage.open();
        metalsColorsForm.submitForm(testData);
        metalsColorsPage.assertResults(testData);
    }

    @AfterTest
    public void testTearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
