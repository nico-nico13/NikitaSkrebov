package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.context.TestContext;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserTablePage {

    @FindBy(xpath = "//input[@type='checkbox' and @id='ivan']")
    private WebElement ivanVipCheckbox;
    @FindBy(xpath = "//li[contains(text(), 'Vip: condition changed to true')]")
    private WebElement vipLog;

    @FindBy(xpath = "//select")
    private List<WebElement> dropdowns;
    @FindBy(xpath = "//td/a")
    private List<WebElement> usernames;
    @FindBy(xpath = "//div[@class='user-descr']/span")
    private List<WebElement> descriptions;
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);

    public UserTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void makeIvanVip() {
        ivanVipCheckbox.click();
    }

    public String getVipLogText() {
        return vipLog.getText();
    }

    public boolean dropdownsDisplay() {
        return dropdowns.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean usernamesDisplay() {
        return usernames.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean descriptionsDisplay() {
        return descriptions.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean checkboxesDisplay() {
        return checkboxes.stream().allMatch(WebElement::isDisplayed);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

