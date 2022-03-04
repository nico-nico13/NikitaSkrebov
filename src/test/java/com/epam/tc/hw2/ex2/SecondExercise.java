package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw2.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SecondExercise extends BaseClass {

    @Test
    public void testDifferentElementsPage() {
        // 2. Assert Browser title
        assertThat(driver.getTitle()).isEqualTo("Home Page");

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
        assertThat(username.getText()).isEqualTo("ROMAN IOVLEV");

        // .5 Open through the header menu Service -> Different Elements Page
        WebElement dropdown = driver.findElement(By.xpath("//a[contains(@class, 'dropdown-toggle')]"));
        dropdown.click();
        WebElement pageButton = driver.findElement(By.xpath("//a[@href = 'different-elements.html']"));
        pageButton.click();

        // 6. Select checkboxes
        WebElement water = driver.findElement(By.xpath("//label[contains(., 'Water')]/input"));
        water.click();
        WebElement wind = driver.findElement(By.xpath("//label[contains(., 'Wind')]/input"));
        wind.click();

        // 7. Select radio
        WebElement selen = driver.findElement(By.xpath("//label[contains(.,'Selen')]/input"));
        selen.click();

        // 8. Select in dropdown
        WebElement selectElement = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("Yellow");

        // 9. Assert that
        WebElement waterLog = driver.findElement(By.xpath("//li[contains(.,'Water') and contains(.,'true')]"));
        assertThat(waterLog.isDisplayed()).isTrue();
        WebElement windLog = driver.findElement(By.xpath("//li[contains(.,'Wind') and contains(.,'true')]"));
        assertThat(windLog.isDisplayed()).isTrue();
        WebElement metalLog = driver.findElement(By.xpath("//li[contains(.,'metal') and contains(.,'Selen')]"));
        assertThat(metalLog.isDisplayed()).isTrue();
        WebElement colorLog = driver.findElement(By.xpath("//li[contains(.,'Colors') and contains(.,'Yellow')]"));
        assertThat(colorLog.isDisplayed()).isTrue();
    }
}
