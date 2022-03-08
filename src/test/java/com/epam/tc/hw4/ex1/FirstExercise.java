package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.BaseTest;
import com.epam.tc.hw4.pages.IndexPage;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstExercise extends BaseTest {

    @Test
    @Story("WebElements Display")
    public void testWebElementsDisplayWithProperText() {

        SoftAssert softAssert = new SoftAssert();
        IndexPage indexPage = new IndexPage(driver);

        // 2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        indexPage.login(properties.getProperty("login"), properties.getProperty("password"));

        // 4. Assert Username is loggined
        softAssert.assertEquals(indexPage.getLoginName(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        softAssert.assertTrue(indexPage.headerHomeDisplay());
        softAssert.assertTrue(indexPage.headerContactDisplay());
        softAssert.assertTrue(indexPage.headerServiceDisplay());
        softAssert.assertTrue(indexPage.headerMetalsColorsDisplay());
        softAssert.assertEquals(indexPage.headerHomeText(), "HOME");
        softAssert.assertEquals(indexPage.headerContactText(), "CONTACT FORM");
        softAssert.assertEquals(indexPage.headerServiceText(), "SERVICE");
        softAssert.assertEquals(indexPage.headerMetalsColorsText(), "METALS & COLORS");

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        softAssert.assertTrue(indexPage.imagesDisplay());

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        softAssert.assertTrue(indexPage.text1Display());
        softAssert.assertTrue(indexPage.text2Display());
        softAssert.assertTrue(indexPage.text3Display());
        softAssert.assertTrue(indexPage.text4Display());
        softAssert.assertEquals(indexPage.text1(), "To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        softAssert.assertEquals(indexPage.text2(), "To be flexible and\n"
                + "customizable");
        softAssert.assertEquals(indexPage.text3(), "To be multiplatform");
        softAssert.assertEquals(indexPage.text4(), "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");

        // 8. Assert that there is the iframe with “Frame Button” exists
        softAssert.assertTrue(indexPage.iframeEnable());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssert.assertTrue(indexPage.frameButtonEnable());

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softAssert.assertTrue(indexPage.leftHomeDisplay());
        softAssert.assertTrue(indexPage.leftContactDisplay());
        softAssert.assertTrue(indexPage.leftServiceDisplay());
        softAssert.assertTrue(indexPage.leftMetalsColorsDisplay());
        softAssert.assertTrue(indexPage.leftElementsPacksDisplay());
        softAssert.assertEquals(indexPage.leftHomeText(), "Home");
        softAssert.assertEquals(indexPage.leftContactText(), "Contact form");
        softAssert.assertEquals(indexPage.leftServiceText(), "Service");
        softAssert.assertEquals(indexPage.leftMetalsColorsText(), "Metals & Colors");
        softAssert.assertEquals(indexPage.leftElementsPacksText(), "Elements packs");

        softAssert.assertAll();
    }
}
