package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.BaseClass;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.IndexPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SecondExercise extends BaseClass {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void secondTest() {
        IndexPage indexPage = new IndexPage(driver);
        // 2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        // 3. Perform login
        indexPage.login("Roman", "Jdi1234");
        // 4. Assert Username is loggined
        softAssert.assertEquals(indexPage.getLoginName(), "ROMAN IOVLEV");
        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        indexPage.openDifferentElementsPage();
        // 6. Select checkboxes
        differentElementsPage.selectCheckboxex();
        // 7. Select radio
        differentElementsPage.selectRadio();
        // 8. Select in dropdown
        differentElementsPage.selectDropdown();
        // 9. Assert that
        softAssert.assertTrue(differentElementsPage.waterLogTest().endsWith("Water: condition changed to true"));
        softAssert.assertTrue(differentElementsPage.windLogTest().endsWith("Wind: condition changed to true"));
        softAssert.assertTrue(differentElementsPage.metalLogTest().endsWith("metal: value changed to Selen"));
        softAssert.assertTrue(differentElementsPage.colorsLogTest().endsWith("Colors: value changed to Yellow"));
    }
}
