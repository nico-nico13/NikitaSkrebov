package com.epam.tc.hw7;

import static com.epam.tc.hw7.entities.TestData.DEFAULT_DATA;
import static com.epam.tc.hw7.entities.User.ROMAN;
import static com.epam.tc.hw7.site.JdiSite.*;
import static com.epam.tc.hw7.site.pages.HomePage.*;
import static com.epam.tc.hw7.site.pages.MetalsColorsPage.*;

import org.testng.annotations.Test;

@Test
public class TestRunner implements TestsInit {

    public void JdiTest() {
        homePage.open();
        userIcon.click();
        loginForm.loginAs(ROMAN);
        userName.is().displayed();
        metalsColorsPage.open();
//        elementsSelect.select(4);
        metalsColorsForm.fill(DEFAULT_DATA);
//        metalsColorsForm.submit(DEFAULT_DATA);
//        oddsSelect.select(3);
//        evenSelect.select(2);

//        metalsSelect.select("Bronze");
//        colorsSelect.select("Red");
//        vegetablesSelect.check("Tomato", "Cucumber");
    }
}
