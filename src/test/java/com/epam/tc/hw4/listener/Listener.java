package com.epam.tc.hw4.listener;

import com.epam.tc.hw4.other.AttachmentUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(result.getName());
        Object driver = result.getTestContext().getAttribute("driver");
        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            AttachmentUtil.attachPngImage("Screenshot on failure", screenshot);
        } else {
            log.warn("No driver is found");
        }
    }
}
