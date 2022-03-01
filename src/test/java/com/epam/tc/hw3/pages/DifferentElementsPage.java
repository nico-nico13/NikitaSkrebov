package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage {

    //checkboxes
    @FindBy(xpath = "//label[contains(., 'Water')]/input")
    private WebElement water;
    @FindBy(xpath = "//label[contains(., 'Wind')]/input")
    private WebElement wind;
    //radio
    @FindBy(xpath = "//label[contains(.,'Selen')]/input")
    private WebElement selen;
    //select
    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropdown;

    //logs
    @FindBy(xpath = "//li[contains(.,'Water') and contains(.,'true')]")
    private WebElement waterLog;
    @FindBy(xpath = "//li[contains(.,'Wind') and contains(.,'true')]")
    private WebElement windLog;
    @FindBy(xpath = "//li[contains(.,'metal') and contains(.,'Selen')]")
    private WebElement metalLog;
    @FindBy(xpath = "//li[contains(.,'Colors') and contains(.,'Yellow')]")
    private WebElement colorsLog;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectCheckboxex() {
        water.click();
        wind.click();
    }

    public void selectRadio() {
        selen.click();
    }

    public void selectDropdown() {
        Select select = new Select(dropdown);
        select.selectByIndex(3);
    }

    public String waterLogTest() {
        String waterLogText = waterLog.getText();
        return waterLogText;
    }

    public String windLogTest() {
        String windLogText = windLog.getText();
        return windLogText;
    }

    public String metalLogTest() {
        String metalLogText = metalLog.getText();
        return metalLogText;
    }

    public String colorsLogTest() {
        String colorsLogText = colorsLog.getText();
        return colorsLogText;
    }
}
