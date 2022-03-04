package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // 1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        // 12.Close Browser
        driver.quit();
    }
}
