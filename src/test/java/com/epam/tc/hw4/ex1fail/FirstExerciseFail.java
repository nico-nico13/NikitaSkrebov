package com.epam.tc.hw4.ex1fail;

import static io.qameta.allure.Allure.step;

import com.epam.tc.hw4.BaseTest;
import com.epam.tc.hw4.pages.IndexPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("WebElements Fail")
public class FirstExerciseFail extends BaseTest {

    @Test
    @Story("WebElements display with proper text")
    public void testWebElementsDisplayWithProperText() {

        SoftAssert softAssert = new SoftAssert();

        // 2. Assert Browser title
        step("Assert Browser title");
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        IndexPage indexPage = new IndexPage(driver);

        // 3. Perform login
        step("Login");
        indexPage.login(properties.getProperty("login"), properties.getProperty("password"));

        // 4. Assert Username is loggined
        step("Assert User is loggined");
        softAssert.assertEquals(indexPage.getLoginName(), "ROM");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        step("Assert 4 header items are displayed with proper text");
        softAssert.assertTrue(indexPage.headerHomeDisplay());
        softAssert.assertTrue(indexPage.headerContactDisplay());
        softAssert.assertTrue(indexPage.headerServiceDisplay());
        softAssert.assertTrue(indexPage.headerMetalsColorsDisplay());
        softAssert.assertEquals(indexPage.headerHomeText(), "HOME");
        softAssert.assertEquals(indexPage.headerContactText(), "CONTACT FORM");
        softAssert.assertEquals(indexPage.headerServiceText(), "SERVICE");
        softAssert.assertEquals(indexPage.headerMetalsColorsText(), "METALS & COLORS");

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        step("Assert 4 images are displayed");
        softAssert.assertTrue(indexPage.imagesDisplay());

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        step("Assert 4 proper texts are displayed");
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
                + "wish to get more!!!");

        // 8. Assert that there is the iframe with “Frame Button” exists
        step("Assert iframe exists");
        softAssert.assertTrue(indexPage.iframeEnable());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        step("Switch to iframe");
        driver.switchTo().frame("frame");
        softAssert.assertTrue(indexPage.frameButtonEnable());

        // 10. Switch to original window back
        step("Switch to original window back");
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        step("Assert 5 Left Section items are displayed with proper text");
        softAssert.assertTrue(indexPage.leftHomeDisplay());
        softAssert.assertTrue(indexPage.leftContactDisplay());
        softAssert.assertTrue(indexPage.leftServiceDisplay());
        softAssert.assertTrue(indexPage.leftMetalsColorsDisplay());
        softAssert.assertTrue(indexPage.leftElementsPacksDisplay());
        softAssert.assertEquals(indexPage.leftHomeText(), "Home");
        softAssert.assertEquals(indexPage.leftContactText(), "Contact");
        softAssert.assertEquals(indexPage.leftServiceText(), "Service");
        softAssert.assertEquals(indexPage.leftMetalsColorsText(), "Metals & Colors");
        softAssert.assertEquals(indexPage.leftElementsPacksText(), "Elements packs");

        softAssert.assertAll();
    }
}
