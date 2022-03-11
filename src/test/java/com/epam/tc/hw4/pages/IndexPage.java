package com.epam.tc.hw4.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

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

    // header elements
    @FindBy(xpath = "//a[@href='index.html']")
    private WebElement headerHome;
    @FindBy(xpath = "//a[@href='contacts.html']")
    private WebElement headerContact;
    @FindBy(xpath = "//a[@class='dropdown-toggle' and contains(.,'Service')]")
    private WebElement headerService;
    @FindBy(xpath = "//a[@href='metals-colors.html']")
    private WebElement headerMetalsColors;

    // images
    @FindBy(xpath = "//span[contains(@class,'icons-benefit')]")
    private List<WebElement> imagesList;

    // texts
    @FindBy(xpath = "//span[contains(.,'include')]")
    private WebElement benefitText1;
    @FindBy(xpath = "//span[contains(.,'flexible')]")
    private WebElement benefitText2;
    @FindBy(xpath = "//span[contains(.,'multi')]")
    private WebElement benefitText3;
    @FindBy(xpath = "//span[contains(.,'base')]")
    private WebElement benefitText4;

    // frame
    @FindBy(xpath = "//iframe[@id='frame']")
    private WebElement iframe;
    @FindBy(xpath = "//input[@id='frame-button']")
    private WebElement iframeButton;

    // left elements
    @FindBy(xpath = "//li[@ui='label' and contains(.,'Home')]")
    private WebElement leftHome;
    @FindBy(xpath = "//li[@ui='label' and contains(.,'Contact')]")
    private WebElement leftContact;
    @FindBy(xpath = "//li[@class='menu-title' and contains(.,'Service')]")
    private WebElement leftService;
    @FindBy(xpath = "//li[@ui='label' and contains(.,'Metals')]")
    private WebElement leftMetalsColors;
    @FindBy(xpath = "//li[@class='menu-title' and contains(.,'Elements')]")
    private WebElement leftElementsPacks;

    @FindBy(xpath = "//a[contains(@class, 'dropdown-toggle')]")
    private WebElement dropdownService;
    @FindBy(xpath = "//a[@href = 'different-elements.html']")
    private WebElement differentElementPageButton;

    public IndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String name, String password) {
        loginDropdown.click();
        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        loginEnter.click();
    }

    public String getLoginName() {
        return userName.getText();
    }

    public boolean headerHomeDisplay() {
        return headerHome.isDisplayed();
    }

    public boolean headerContactDisplay() {
        return headerContact.isDisplayed();
    }

    public boolean headerServiceDisplay() {
        return headerService.isDisplayed();
    }

    public boolean headerMetalsColorsDisplay() {
        return headerMetalsColors.isDisplayed();
    }

    public String headerHomeText() {
        return headerHome.getText();
    }

    public String headerContactText() {
        return headerContact.getText();
    }

    public String headerServiceText() {
        return headerService.getText();
    }

    public String headerMetalsColorsText() {
        return headerMetalsColors.getText();
    }

    public boolean imagesDisplay() {
        return imagesList.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean text1Display() {
        return benefitText1.isDisplayed();
    }

    public boolean text2Display() {
        return benefitText2.isDisplayed();
    }

    public boolean text3Display() {
        return benefitText3.isDisplayed();
    }

    public boolean text4Display() {
        return benefitText4.isDisplayed();
    }

    public String text1() {
        return benefitText1.getText();
    }

    public String text2() {
        return benefitText2.getText();
    }

    public String text3() {
        return benefitText3.getText();
    }

    public String text4() {
        return benefitText4.getText();
    }

    public boolean iframeEnable() {
        return iframe.isEnabled();
    }

    public boolean frameButtonEnable() {
        return iframeButton.isEnabled();
    }

    public boolean leftHomeDisplay() {
        return leftHome.isDisplayed();
    }

    public boolean leftContactDisplay() {
        return leftContact.isDisplayed();
    }

    public boolean leftServiceDisplay() {
        return leftService.isDisplayed();
    }

    public boolean leftMetalsColorsDisplay() {
        return leftMetalsColors.isDisplayed();
    }

    public boolean leftElementsPacksDisplay() {
        return leftElementsPacks.isDisplayed();
    }

    public String leftHomeText() {
        return leftHome.getText();
    }

    public String leftContactText() {
        return leftContact.getText();
    }

    public String leftServiceText() {
        return leftService.getText();
    }

    public String leftMetalsColorsText() {
        return leftMetalsColors.getText();
    }

    public String leftElementsPacksText() {
        return leftElementsPacks.getText();
    }

    public void openDifferentElementsPage() {
        dropdownService.click();
        differentElementPageButton.click();
    }
}
