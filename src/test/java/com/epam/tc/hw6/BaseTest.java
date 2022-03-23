package com.epam.tc.hw6;

import com.epam.tc.hw6.service.webdriver.WebDriverProvider;
import com.epam.tc.hw6.utils.PropertiesUtil;
import io.qameta.allure.Step;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;

    protected Properties properties;

    @BeforeClass
    public void setUpProperties() {
        properties = PropertiesUtil.loadProperties();
    }

    @BeforeMethod
    @Step("Setting driver and opening URL")
    public void setUp() {
        driver = WebDriverProvider.getDriver();
        // 1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Step("Environment blanking")
    @AfterMethod
        public void tearDown() {
        // 12.Close Browser
        WebDriverProvider.closeDriver();
    }
}
