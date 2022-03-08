package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.BaseTest;
import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.IndexPage;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SecondExercise extends BaseTest {

    @Test
    @Story("Different Elements Page")
    public void testDifferentElementsPage() {

        SoftAssert softAssert = new SoftAssert();
        IndexPage indexPage = new IndexPage(driver);

        // 2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        indexPage.login(properties.getProperty("login"), properties.getProperty("password"));

        // 4. Assert Username is loggined
        softAssert.assertEquals(indexPage.getLoginName(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        indexPage.openDifferentElementsPage();

        // 6. Select checkboxes
        differentElementsPage.selectCheckboxes("Wind");
        differentElementsPage.selectCheckboxes("Water");

        // 7. Select radio
        differentElementsPage.selectRadio("Selen");

        // 8. Select in dropdown
        differentElementsPage.selectYellowDropdown();

        // 9. Assert that
        softAssert.assertTrue(differentElementsPage.waterLogText().endsWith("Water: condition changed to true"));
        softAssert.assertTrue(differentElementsPage.windLogText().endsWith("Wind: condition changed to true"));
        softAssert.assertTrue(differentElementsPage.metalLogText().endsWith("metal: value changed to Selen"));
        softAssert.assertTrue(differentElementsPage.colorsLogText().endsWith("Colors: value changed to Yellow"));

        softAssert.assertAll();
    }
}
