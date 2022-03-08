package com.epam.tc.hw4.pages;

import io.qameta.allure.Step;
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

    @Step("Login")
    public void login(String name, String password) {
        loginDropdown.click();
        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        loginEnter.click();
    }

    @Step("Getting user name")
    public String getLoginName() {
        return userName.getText();
    }

    @Step("Display of header Home")
    public boolean headerHomeDisplay() {
        return headerHome.isDisplayed();
    }

    @Step("Display of header Contact form")
    public boolean headerContactDisplay() {
        return headerContact.isDisplayed();
    }

    @Step("Display of header Service")
    public boolean headerServiceDisplay() {
        return headerService.isDisplayed();
    }

    @Step("Display of header Metals & Colors")
    public boolean headerMetalsColorsDisplay() {
        return headerMetalsColors.isDisplayed();
    }

    @Step("Getting of header Home text")
    public String headerHomeText() {
        return headerHome.getText();
    }

    @Step("Getting of header Contact form text")
    public String headerContactText() {
        return headerContact.getText();
    }

    @Step("Getting of header Service text")
    public String headerServiceText() {
        return headerService.getText();
    }

    @Step("Getting of header Metals & Colors text")
    public String headerMetalsColorsText() {
        return headerMetalsColors.getText();
    }

    @Step("Display of images")
    public boolean imagesDisplay() {
        return imagesList.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Display of first benefit text")
    public boolean text1Display() {
        return benefitText1.isDisplayed();
    }

    @Step("Display of second benefit text")
    public boolean text2Display() {
        return benefitText2.isDisplayed();
    }

    @Step("Display of third benefit text")
    public boolean text3Display() {
        return benefitText3.isDisplayed();
    }

    @Step("Display of fourth benefit text")
    public boolean text4Display() {
        return benefitText4.isDisplayed();
    }

    @Step("Getting first text")
    public String text1() {
        return benefitText1.getText();
    }

    @Step("Getting second text")
    public String text2() {
        return benefitText2.getText();
    }

    @Step("Getting third text")
    public String text3() {
        return benefitText3.getText();
    }

    @Step("Getting fourth text")
    public String text4() {
        return benefitText4.getText();
    }

    @Step("Checking iframe exists")
    public boolean iframeEnable() {
        return iframe.isEnabled();
    }

    @Step("Checking iframe button exists")
    public boolean frameButtonEnable() {
        return iframeButton.isEnabled();
    }

    @Step("Display of left section Home")
    public boolean leftHomeDisplay() {
        return leftHome.isDisplayed();
    }

    @Step("Display of left section Contact form")
    public boolean leftContactDisplay() {
        return leftContact.isDisplayed();
    }

    @Step("Display of left section Servic")
    public boolean leftServiceDisplay() {
        return leftService.isDisplayed();
    }

    @Step("Display of left section Metals & Colors")
    public boolean leftMetalsColorsDisplay() {
        return leftMetalsColors.isDisplayed();
    }

    @Step("Display of left section Elements packs")
    public boolean leftElementsPacksDisplay() {
        return leftElementsPacks.isDisplayed();
    }

    @Step("Getting of left section Home text")
    public String leftHomeText() {
        return leftHome.getText();
    }

    @Step("Getting of left section Contact form text")
    public String leftContactText() {
        return leftContact.getText();
    }

    @Step("Getting of left section Service text")
    public String leftServiceText() {
        return leftService.getText();
    }

    @Step("Getting of left section Metals & Colors text")
    public String leftMetalsColorsText() {
        return leftMetalsColors.getText();
    }

    @Step("Getting of left section Elements packs text")
    public String leftElementsPacksText() {
        return leftElementsPacks.getText();
    }

    @Step("Opening Different Elements page")
    public void openDifferentElementsPage() {
        dropdownService.click();
        differentElementPageButton.click();
    }
}
