package com.epam.tc.hw6.service.webdriver;

import com.epam.tc.hw6.service.exception.IllegalBrowserNameException;
import com.epam.tc.hw6.service.exception.WebDriverLaunchTypeException;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@NoArgsConstructor(access = AccessLevel.NONE)
public final class WebDriverFactory {

    private static final String LOCAL_LAUNCH_TYPE = "local";
    private static final String REMOTE_LAUNCH_TYPE = "remote";

    public static WebDriver createDriver(final String launchType, final Browser browser) {
        WebDriver driver;

        if (LOCAL_LAUNCH_TYPE.equalsIgnoreCase(launchType)) {
            driver = createLocalDriver(browser);
        } else if (REMOTE_LAUNCH_TYPE.equalsIgnoreCase(launchType)) {
            driver = createRemoteDriver(browser);
        } else {
            throw new WebDriverLaunchTypeException();
        }

        return driver;
    }

    // LOCAL
    private static WebDriver createLocalDriver(final Browser browser) {
        WebDriver driver;

        switch (browser) {
            case CHROME:
                driver = createLocalChromeDriver();
                break;

            case FIREFOX:
                driver = createLocalFirefoxDriver();
                break;

            case MICROSOFTEDGE:
                driver = createLocalEdgeDriver();
                break;

            case OPERA:
                driver = createLocalOperaDriver();
                break;

            default:
                throw new IllegalBrowserNameException();
        }

        return driver;
    }

    private static WebDriver createLocalChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createLocalFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createLocalEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver createLocalOperaDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }

    // REMOTE
    private static WebDriver createRemoteDriver(final Browser browser) {
        Capabilities capabilities;
        switch (browser) {
            case CHROME:
                capabilities = createRemoteChromeCapabilities();
                break;

            case FIREFOX:
                capabilities = createRemoteFirefoxCapabilities();
                break;

            case MICROSOFTEDGE:
                capabilities = createRemoteEdgeCapabilities();
                break;

            case OPERA:
                capabilities = createRemoteOperaCapabilities();
                break;

            default:
                throw new IllegalBrowserNameException();
        }

        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.17:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }

        return driver;
    }

    private static Capabilities createRemoteChromeCapabilities() {
        return new ChromeOptions();
    }

    private static Capabilities createRemoteFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static Capabilities createRemoteEdgeCapabilities() {
        return new EdgeOptions();
    }

    private static Capabilities createRemoteOperaCapabilities() {
        return new OperaOptions();
    }
}
