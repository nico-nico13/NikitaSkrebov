package com.epam.tc.hw3.ex1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.epam.tc.hw3.BaseClass;
import com.epam.tc.hw3.pages.IndexPage;
import org.testng.annotations.Test;



public class FirstExercise extends BaseClass {

    @Test
    public void firstTest() {
        IndexPage indexPage = new IndexPage(driver);
        // 2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");
        // 3. Perform login
        indexPage.login("Roman", "Jdi1234");
        // 4. Assert Username is loggined
        assertEquals(indexPage.getLoginName(), "ROMAN IOVLEV");
        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        assertTrue(indexPage.headerHomeDisplay());
        assertTrue(indexPage.headerContactDisplay());
        assertTrue(indexPage.headerServiceDisplay());
        assertTrue(indexPage.headerMetalsColorsDisplay());
        assertTrue(indexPage.headerHomeTextTest());
        assertTrue(indexPage.headerContactTextTest());
        assertTrue(indexPage.headerServiceTextTest());
        assertTrue(indexPage.headerMetalsColorsTextTest());
        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        assertTrue(indexPage.imagesTest());
        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        assertTrue(indexPage.text1Display());
        assertTrue(indexPage.text2Display());
        assertTrue(indexPage.text3Display());
        assertTrue(indexPage.text4Display());
        assertTrue(indexPage.text1Test());
        assertTrue(indexPage.text2Test());
        assertTrue(indexPage.text3Test());
        assertTrue(indexPage.text4Test());
        // 8. Assert that there is the iframe with “Frame Button” exists
        assertTrue(indexPage.iframeEnable());
        // 9.
        driver.switchTo().frame("frame");
        assertTrue(indexPage.frameButtonEnable());
        // 10.
        driver.switchTo().defaultContent();;
        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        assertTrue(indexPage.leftHomeDisplay());
        assertTrue(indexPage.leftContactDisplay());
        assertTrue(indexPage.leftServiceDisplay());
        assertTrue(indexPage.leftMetalsColorsDisplay());
        assertTrue(indexPage.leftElementsPacksDisplay());
        assertTrue(indexPage.leftHomeTextTest());
        assertTrue(indexPage.leftContactTextTest());
        assertTrue(indexPage.leftServiceTextTest());
        assertTrue(indexPage.leftMetalsColorsTextTest());
        assertTrue(indexPage.leftElementsPacksTextTest());
    }
}
