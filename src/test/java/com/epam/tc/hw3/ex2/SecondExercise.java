package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.BaseClass;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.IndexPage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SecondExercise extends BaseClass {

    @Test
    public void testDifferentElementsPage() {

        SoftAssert softAssert = new SoftAssert();
        IndexPage indexPage = new IndexPage(driver);

        // 2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        FileInputStream fis;
        Properties properties = new Properties();

        try {
            fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);

            indexPage.login(properties.getProperty("login"), properties.getProperty("password"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        //softAssert.assertTrue(differentElementsPage.metalLogText().endsWith("metal: value changed to Selen"));
        softAssert.assertTrue(differentElementsPage.colorsLogText().endsWith("Colors: value changed to Yellow"));
    }
}
