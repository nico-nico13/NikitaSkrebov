package com.epam.tc.hw5.hook;

import com.epam.tc.hw5.PropertiesUtil;
import com.epam.tc.hw5.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CucumberHook {

    private WebDriver driver;

    public static Properties properties;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
        properties = PropertiesUtil.loadProperties();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        TestContext.getInstance().setObject("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.getInstance().cleanContext();
    }
}
