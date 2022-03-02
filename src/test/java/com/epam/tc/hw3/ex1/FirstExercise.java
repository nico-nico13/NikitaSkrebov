package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.BaseClass;
import com.epam.tc.hw3.pages.IndexPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class FirstExercise extends BaseClass {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void firstTest() {
        IndexPage indexPage = new IndexPage(driver);
        // 2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        // 3. Perform login
        indexPage.login("Roman", "Jdi1234");
        // 4. Assert Username is loggined
        softAssert.assertEquals(indexPage.getLoginName(), "ROMAN IOVLEV");
        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        softAssert.assertTrue(indexPage.headerHomeDisplay());
        softAssert.assertTrue(indexPage.headerContactDisplay());
        softAssert.assertTrue(indexPage.headerServiceDisplay());
        softAssert.assertTrue(indexPage.headerMetalsColorsDisplay());
        softAssert.assertTrue(indexPage.headerHomeTextTest());
        softAssert.assertTrue(indexPage.headerContactTextTest());
        softAssert.assertTrue(indexPage.headerServiceTextTest());
        softAssert.assertTrue(indexPage.headerMetalsColorsTextTest());
        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        softAssert.assertTrue(indexPage.imagesTest());
        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        softAssert.assertTrue(indexPage.text1Display());
        softAssert.assertTrue(indexPage.text2Display());
        softAssert.assertTrue(indexPage.text3Display());
        softAssert.assertTrue(indexPage.text4Display());
        softAssert.assertTrue(indexPage.text1Test());
        softAssert.assertTrue(indexPage.text2Test());
        softAssert.assertTrue(indexPage.text3Test());
        softAssert.assertTrue(indexPage.text4Test());
        // 8. Assert that there is the iframe with “Frame Button” exists
        softAssert.assertTrue(indexPage.iframeEnable());
        // 9.
        driver.switchTo().frame("frame");
        softAssert.assertTrue(indexPage.frameButtonEnable());
        // 10.
        driver.switchTo().defaultContent();;
        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softAssert.assertTrue(indexPage.leftHomeDisplay());
        softAssert.assertTrue(indexPage.leftContactDisplay());
        softAssert.assertTrue(indexPage.leftServiceDisplay());
        softAssert.assertTrue(indexPage.leftMetalsColorsDisplay());
        softAssert.assertTrue(indexPage.leftElementsPacksDisplay());
        softAssert.assertTrue(indexPage.leftHomeTextTest());
        softAssert.assertTrue(indexPage.leftContactTextTest());
        softAssert.assertTrue(indexPage.leftServiceTextTest());
        softAssert.assertTrue(indexPage.leftMetalsColorsTextTest());
        softAssert.assertTrue(indexPage.leftElementsPacksTextTest());
    }
}
