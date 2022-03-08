package com.epam.tc.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {

    public WebDriver driver;

    @BeforeMethod
    @Step("Setting driver and opening URL")
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        context.setAttribute("driver", driver);
        // 1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Step("Environment blanking")
    @AfterMethod
        public void tearDown() {
        // 12.Close Browser
        driver.quit();
    }
}
