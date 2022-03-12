package com.epam.tc.hw2.ex1;

import static org.testng.Assert.assertEquals;

import com.epam.tc.hw2.BaseClass;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



public class FirstExercise extends BaseClass {

    SoftAssertions softAssert = new SoftAssertions();

    @Test
    public void testWebElementsDisplayWithProperText() {
        // 2. Assert Browser title
        softAssert.assertThat(driver.getTitle()).isEqualTo("Home Page");

        // 3. Perform login
        WebElement caret = driver.findElement(By.xpath("//li[contains(@class, 'uui-profile-menu')]"));
        caret.click();
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='name']"));
        loginInput.sendKeys("Roman");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("Jdi1234");
        WebElement enterButton = driver.findElement(By.xpath("//button[contains(@class, 'btn-login')]"));
        enterButton.click();

        // 4. Assert Username is loggined
        WebElement username = driver.findElement(By.id("user-name"));
        softAssert.assertThat(username.getText()).isEqualTo("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        WebElement home = driver.findElement(By.xpath("//a[@href='index.html']"));
        softAssert.assertThat(home.isDisplayed()).isTrue();
        softAssert.assertThat(home.getText()).isEqualTo("HOME");
        WebElement contacts = driver.findElement(By.xpath("//a[@href='contacts.html']"));
        softAssert.assertThat(contacts.isDisplayed()).isTrue();
        softAssert.assertThat(contacts.getText()).isEqualTo("CONTACT FORM");
        WebElement service = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(.,'Service')]"));
        softAssert.assertThat(service.isDisplayed()).isTrue();
        softAssert.assertThat(service.getText()).isEqualTo("SERVICE");
        WebElement metalcolors = driver.findElement(By.xpath("//a[@href='metals-colors.html']"));
        softAssert.assertThat(metalcolors.isDisplayed()).isTrue();
        softAssert.assertThat(metalcolors.getText()).isEqualTo("METALS & COLORS");

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> images = driver.findElements(By.xpath("//span[contains(@class, 'icons-benefit')]"));
        for (WebElement i : images) {
            softAssert.assertThat(i.isDisplayed()).isTrue();
        }

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        WebElement benefitText1 = driver.findElement(By.xpath("//span[contains(., 'include')]"));
        softAssert.assertThat(benefitText1.isDisplayed()).isTrue();
        softAssert.assertThat(benefitText1.getText()).isEqualTo("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        WebElement bennifitText2 = driver.findElement(By.xpath("//span[contains(.,'flexible')]"));
        softAssert.assertThat(bennifitText2.isDisplayed()).isTrue();
        softAssert.assertThat(bennifitText2.getText()).isEqualTo("To be flexible and\n"
                + "customizable");
        WebElement bennifitText3 = driver.findElement(By.xpath("//span[contains(., 'multi')]"));
        softAssert.assertThat(bennifitText3.isDisplayed()).isTrue();
        softAssert.assertThat(bennifitText3.getText()).isEqualTo("To be multiplatform");
        WebElement bennifitText4 = driver.findElement(By.xpath("//span[contains(., 'base')]"));
        softAssert.assertThat(bennifitText4.isDisplayed()).isTrue();
        softAssert.assertThat(bennifitText4.getText()).isEqualTo("Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");

        // 8. Assert that there is the iframe with “Frame Button” exist
        Boolean iframe = driver.findElement(By.xpath("//iframe[@id='frame']")).isEnabled();
        softAssert.assertThat(iframe).isTrue();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        Boolean iframeButton = driver.findElement(By.xpath("//input[@id='frame-button']")).isEnabled();
        softAssert.assertThat(iframeButton).isTrue();

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        WebElement homeLeft = driver.findElement(By.xpath("//li[@ui='label' and contains(.,'Home')]"));
        softAssert.assertThat(homeLeft.isDisplayed()).isTrue();
        softAssert.assertThat(homeLeft.getText()).isEqualTo("Home");
        WebElement contactLeft = driver.findElement(By.xpath("//li[@ui='label' and contains(.,'Contact')]"));
        softAssert.assertThat(contacts.isDisplayed()).isTrue();
        softAssert.assertThat(contactLeft.getText()).isEqualTo("Contact form");
        WebElement serviceLeft = driver.findElement(By.xpath("//li[@class='menu-title' and contains(.,'Service')]"));
        softAssert.assertThat(serviceLeft.isDisplayed()).isTrue();
        softAssert.assertThat(serviceLeft.getText()).isEqualTo("Service");
        WebElement metalsColorsLeft = driver.findElement(By.xpath("//li[@ui='label' and contains(.,'Metals')]"));
        softAssert.assertThat(metalsColorsLeft.isDisplayed()).isTrue();
        softAssert.assertThat(metalsColorsLeft.getText()).isEqualTo("Metals & Colors");
        WebElement elPacksLeft = driver.findElement(By.xpath("//li[@class='menu-title' and contains(.,'Elements')]"));
        softAssert.assertThat(elPacksLeft.isDisplayed()).isTrue();
        softAssert.assertThat(elPacksLeft.getText()).isEqualTo("Elements packs");
        softAssert.assertAll();
    }
}
