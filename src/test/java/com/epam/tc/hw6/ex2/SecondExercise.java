package com.epam.tc.hw6.ex2;

import static io.qameta.allure.Allure.step;

import com.epam.tc.hw6.BaseTest;
import com.epam.tc.hw6.pages.DifferentElementsPage;
import com.epam.tc.hw6.pages.IndexPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("Selects")
public class SecondExercise extends BaseTest {

    @Test
    @Story("Different Elements Page")
    public void testDifferentElementsPage() {

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
        softAssert.assertEquals(indexPage.getLoginName(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        step("Open Different Element Page");
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        indexPage.openDifferentElementsPage();

        // 6. Select checkboxes
        step("Select Wind and Water checkboxes");
        differentElementsPage.selectCheckboxes("Wind");
        differentElementsPage.selectCheckboxes("Water");

        // 7. Select radio
        step("Select Selen radio-checkbox");
        differentElementsPage.selectRadio("Selen");

        // 8. Select in dropdown
        step("Select yellow in dropdown");
        differentElementsPage.selectYellowDropdown();

        // 9. Assert that
        step("Assert logs are displayed and corresponded");
        softAssert.assertTrue(differentElementsPage.waterLogText().endsWith("Water: condition changed to true"));
        softAssert.assertTrue(differentElementsPage.windLogText().endsWith("Wind: condition changed to true"));
        softAssert.assertTrue(differentElementsPage.metalLogText().endsWith("metal: value changed to Selen"));
        softAssert.assertTrue(differentElementsPage.colorsLogText().endsWith("Colors: value changed to Yellow"));

        softAssert.assertAll();
    }
}
