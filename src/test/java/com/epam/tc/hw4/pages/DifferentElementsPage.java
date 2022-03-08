package com.epam.tc.hw4.pages;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class DifferentElementsPage {

    //checkboxes
    @FindBy(xpath = "//div[@class='checkbox-row']/label[@class='label-checkbox']")
    private List<WebElement> allCheckboxes;
    //radio
    @FindBy(xpath = "//div[@class='checkbox-row']/label[@class='label-radio']")
    private List<WebElement> allRadioCheckboxes;
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

    @Step("Selecting checkboxes")
    public void selectCheckboxes(String name) {
        for (WebElement option : allCheckboxes) {
            if (option.getText().equals(name)) {
                option.click();
            }
        }
    }

    @Step("Selecting radio checkbox")
    public void selectRadio(String name) {
        for (WebElement option : allRadioCheckboxes) {
            if (option.getText().equals(name)) {
                option.click();
            }
        }
    }

    @Step("Selecting Yellow option in dropdown")
    public void selectYellowDropdown() {
        Select select = new Select(dropdown);
        select.selectByVisibleText("Yellow");
    }

    @Step("Getting water log text")
    public String waterLogText() {
        return waterLog.getText();
    }

    @Step("Getting wind log text")
    public String windLogText() {
        return windLog.getText();
    }

    @Step("Getting metal log text")
    public String metalLogText() {
        return metalLog.getText();
    }

    @Step("Getting color log text")
    public String colorsLogText() {
        return colorsLog.getText();
    }

}
