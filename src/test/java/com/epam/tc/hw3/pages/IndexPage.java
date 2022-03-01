package com.epam.tc.hw3.pages;

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
    private WebElement benifitText1;
    @FindBy(xpath = "//span[contains(.,'flexible')]")
    private WebElement benifitText2;
    @FindBy(xpath = "//span[contains(.,'multi')]")
    private WebElement benifitText3;
    @FindBy(xpath = "//span[contains(.,'base')]")
    private WebElement benifitText4;

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
    private WebElement diffentElementPageButton;


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
        String name = userName.getText();
        return name;
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

    public boolean headerHomeTextTest() {
        String headerHomeText = headerHome.getText();
        return headerHomeText.equals("HOME");
    }

    public boolean headerContactTextTest() {
        String headerContactText = headerContact.getText();
        return headerContactText.equals("CONTACT FORM");
    }

    public boolean headerServiceTextTest() {
        String headerServiceText = headerService.getText();
        return headerServiceText.equals("SERVICE");
    }

    public boolean headerMetalsColorsTextTest() {
        String headerMetalsColorsText = headerMetalsColors.getText();
        return headerMetalsColorsText.equals("METALS & COLORS");
    }

    public boolean imagesTest() {
        return imagesList.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean text1Display() {
        return benifitText1.isDisplayed();
    }

    public boolean text2Display() {
        return benifitText2.isDisplayed();
    }

    public boolean text3Display() {
        return benifitText3.isDisplayed();
    }

    public boolean text4Display() {
        return benifitText4.isDisplayed();
    }

    public boolean text1Test() {
        String benefitText1 = benifitText1.getText();
        return benefitText1.equals("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
    }

    public boolean text2Test() {
        String benefitText2 = benifitText2.getText();
        return benefitText2.equals("To be flexible and\n"
                + "customizable");
    }

    public boolean text3Test() {
        String benefitText3 = benifitText3.getText();
        return benefitText3.equals("To be multiplatform");
    }

    public boolean text4Test() {
        String benefitText4 = benifitText4.getText();
        return benefitText4.equals("Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");
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

    public boolean leftHomeTextTest() {
        String leftHomeText = leftHome.getText();
        return leftHomeText.equals("Home");
    }

    public boolean leftContactTextTest() {
        String leftContactText = leftContact.getText();
        return leftContactText.equals("Contact form");
    }

    public boolean leftServiceTextTest() {
        String leftServiceText = leftService.getText();
        return leftServiceText.equals("Service");
    }

    public boolean leftMetalsColorsTextTest() {
        String leftMetalsColorsText = leftMetalsColors.getText();
        return leftMetalsColorsText.equals("Metals & Colors");
    }

    public boolean leftElementsPacksTextTest() {
        String leftElementsPacksText = leftElementsPacks.getText();
        return leftElementsPacksText.equals("Elements packs");
    }

    public void openDifferentElementsPage() {
        dropdownService.click();
        diffentElementPageButton.click();
    }
}
