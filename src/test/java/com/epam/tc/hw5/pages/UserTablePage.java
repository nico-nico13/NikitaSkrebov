package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTablePage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@type='checkbox' and @id='ivan']")
    private WebElement ivanVipCheckbox;
    @FindBy(xpath = "//li[contains(text(), 'Vip: condition changed to true')]")
    private WebElement vipLog;

    @FindBy(xpath = "//select")
    private List<WebElement> dropdowns;
    @FindBy(xpath = "//tr/td[1]")
    private List<WebElement> numbers;
    @FindBy(xpath = "//td/a")
    private List<WebElement> users;
    @FindBy(xpath = "//div[@class='user-descr']/span")
    private List<WebElement> descriptions;
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//tr[1]/td/select/option")
    private List<WebElement> dropdownRoman;

    public UserTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
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
        return users.stream().allMatch(WebElement::isDisplayed);
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

    public List<String> getNumber() {
        List<String> strings = new ArrayList<>();
        for (WebElement str : numbers) {
            strings.add(str.getText());
        }
        return strings;
    }

    public List<String> getUser() {
        List<String> strings = new ArrayList<>();
        for (WebElement str : users) {
            strings.add(str.getText());
        }
        return strings;
    }

    public List<String> getDescription() {
        List<String> strings = new ArrayList<>();
        for (WebElement str : descriptions) {
            strings.add(str.getText());
        }
        return strings;
    }

    public List<String> getDropdownValues() {
        List<String> strings = new ArrayList<>();
        for (WebElement str : dropdownRoman) {
            strings.add(str.getText().to);
        }
        return strings;
    }
}

