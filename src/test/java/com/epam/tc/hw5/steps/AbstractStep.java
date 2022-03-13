package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.IndexPage;
import com.epam.tc.hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected UserTablePage userTablePage;
    protected DifferentElementsPage differentElementsPage;
    protected IndexPage indexPage;

    protected AbstractStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);
        userTablePage = new UserTablePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        indexPage = new IndexPage(driver);
    }
}
