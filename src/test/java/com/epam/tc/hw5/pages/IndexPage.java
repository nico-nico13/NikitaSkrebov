package com.epam.tc.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    private final WebDriver driver;

    // login elements
    @FindBy(xpath = "//li[contains(@class,'uui-profile-menu')]")
    private WebElement loginDropdown;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement loginInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginEnter;
    @FindBy(id = "user-name")
    private WebElement userName;

    //Service dropdown
    @FindBy(xpath = "//a[contains(@class, 'dropdown-toggle')]")
    private WebElement dropdownService;
    @FindBy(xpath = "//a[@href = 'different-elements.html']")
    private WebElement differentElementPageButton;
    @FindBy(xpath = "//a[@href='user-table.html']")
    private WebElement userTablePageButton;

    public IndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void login(String name, String password) {
        loginDropdown.click();
        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        loginEnter.click();
    }

    public void open(String url) {
        driver.navigate().to(url);
    }

    public void serviceDropdownClick() {
        dropdownService.click();
    }

    public void openUserTablePage() {
        userTablePageButton.click();
    }

    public void openDifferentElementsPage() {
        differentElementPageButton.click();
    }
}
