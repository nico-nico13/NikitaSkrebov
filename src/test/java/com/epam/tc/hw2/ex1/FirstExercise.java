package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseClass;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FirstExercise extends BaseClass {

    SoftAssertions softAssert = new SoftAssertions();

    @Test
    public void mainFirstTest() {
        // 2. Assert Browser title
        softAssert.assertThat(driver.getTitle()).isEqualTo("Home Page");
        // 3. Perform login
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
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
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        Boolean home = driver.findElement(By.xpath("//a[@href='index.html']")).isDisplayed();
        softAssert.assertThat(home).isTrue();
        WebElement homeText = driver.findElement(By.xpath("//a[@href='index.html']"));
        softAssert.assertThat(homeText.getText()).isEqualTo("HOME");
        Boolean contacts = driver.findElement(By.xpath("//a[@href='contacts.html']")).isDisplayed();
        softAssert.assertThat(contacts).isTrue();
        WebElement contactsText = driver.findElement(By.xpath("//a[@href='contacts.html']"));
        softAssert.assertThat(contactsText.getText()).isEqualTo("CONTACT FORM");
        Boolean service;
        service = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(.,'Service')]")).isDisplayed();
        softAssert.assertThat(service).isTrue();
        WebElement serviceText;
        serviceText = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(., 'Service')]"));
        softAssert.assertThat(serviceText.getText()).isEqualTo("SERVICE");
        Boolean metalcolors = driver.findElement(By.xpath("//a[@href='metals-colors.html']")).isDisplayed();
        softAssert.assertThat(metalcolors).isTrue();
        WebElement metalcolorsText = driver.findElement(By.xpath("//a[@href='metals-colors.html']"));
        softAssert.assertThat(metalcolorsText.getText()).isEqualTo("METALS & COLORS");
        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> images = driver.findElements(By.xpath("//span[contains(@class, 'icons-benefit')]"));
        for (WebElement i : images) {
            softAssert.assertThat(i.isDisplayed()).isTrue();
        }
        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        Boolean bennifitText1Display = driver.findElement(By.xpath("//span[contains(., 'include')]")).isDisplayed();
        WebElement bennifitText1 = driver.findElement(By.xpath("//span[contains(., 'include')]"));
        softAssert.assertThat(bennifitText1Display).isTrue();
        softAssert.assertThat(bennifitText1.getText()).isEqualTo("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        Boolean bennifitText2Display = driver.findElement(By.xpath("//span[contains(.,'flexible')]")).isDisplayed();
        WebElement bennifitText2 = driver.findElement(By.xpath("//span[contains(., 'flexible')]"));
        softAssert.assertThat(bennifitText2Display).isTrue();
        softAssert.assertThat(bennifitText2.getText()).isEqualTo("To be flexible and\n"
                + "customizable");
        Boolean bennifitText3Display = driver.findElement(By.xpath("//span[contains(., 'multi')]")).isDisplayed();
        WebElement bennifitText3 = driver.findElement(By.xpath("//span[contains(., 'multi')]"));
        softAssert.assertThat(bennifitText3Display).isTrue();
        softAssert.assertThat(bennifitText3.getText()).isEqualTo("To be multiplatform");
        Boolean bennifitText4Display = driver.findElement(By.xpath("//span[contains(., 'base')]")).isDisplayed();
        WebElement bennifitText4 = driver.findElement(By.xpath("//span[contains(., 'base')]"));
        softAssert.assertThat(bennifitText4Display).isTrue();
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
        Boolean homeLeft = driver.findElement(By.xpath("//li[@ui='label' and contains(., 'Home')]")).isDisplayed();
        softAssert.assertThat(homeLeft).isTrue();
        WebElement homeLeftText = driver.findElement(By.xpath("//li[@ui='label' and contains(., 'Home')]"));
        softAssert.assertThat(homeLeftText.getText()).isEqualTo("Home");
        Boolean contact = driver.findElement(By.xpath("//li[@ui='label' and contains(., 'Contact')]")).isDisplayed();
        softAssert.assertThat(contact).isTrue();
        WebElement contactText = driver.findElement(By.xpath("//li[@ui='label' and contains(., ' Contact ')]"));
        softAssert.assertThat(contactText.getText()).isEqualTo("Contact form");
        Boolean serviceLeft;
        serviceLeft = driver.findElement(By.xpath("//li[@class='menu-title' and contains(.,'Service')]")).isDisplayed();
        softAssert.assertThat(serviceLeft).isTrue();
        WebElement serviceLeftText;
        serviceLeftText = driver.findElement(By.xpath("//li[@class='menu-title' and contains(., 'Service')]"));
        softAssert.assertThat(serviceLeftText.getText()).isEqualTo("Service");
        Boolean metalsLeft = driver.findElement(By.xpath("//li[@ui='label' and contains(., 'Metals')]")).isDisplayed();
        softAssert.assertThat(metalsLeft).isTrue();
        WebElement metalcolorsLeftText = driver.findElement(By.xpath("//li[@ui='label' and contains(., 'Metals')]"));
        softAssert.assertThat(metalcolorsLeftText.getText()).isEqualTo("Metals & Colors");
        Boolean elPacks;
        elPacks = driver.findElement(By.xpath("//li[@class='menu-title' and contains(., 'Elements')]")).isDisplayed();
        softAssert.assertThat(elPacks).isTrue();
        WebElement elPacksText = driver.findElement(By.xpath("//li[@class='menu-title' and contains(., 'Elements')]"));
        softAssert.assertThat(elPacksText.getText()).isEqualTo("Elements packs");
    }
}
