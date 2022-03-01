package com.epam.tc.hw3.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.epam.tc.hw3.BaseClass;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.IndexPage;
import org.testng.annotations.Test;

public class SecondExercise extends BaseClass {

    @Test
    public void secondTest() {
        IndexPage indexPage = new IndexPage(driver);
        // 2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");
        // 3. Perform login
        indexPage.login("Roman", "Jdi1234");
        // 4. Assert Username is loggined
        assertEquals(indexPage.getLoginName(), "ROMAN IOVLEV");
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
        assertTrue(differentElementsPage.waterLogTest().endsWith("Water: condition changed to true"));
        assertTrue(differentElementsPage.windLogTest().endsWith("Wind: condition changed to true"));
        assertTrue(differentElementsPage.metalLogTest().endsWith("metal: value changed to Selen"));
        assertTrue(differentElementsPage.colorsLogTest().endsWith("Colors: value changed to Yellow"));
    }
}
