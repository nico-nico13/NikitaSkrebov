package com.epam.tc.hw4.pages;

import io.qameta.allure.Feature;
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


    public void selectCheckboxes(String name) {
        for (WebElement option : allCheckboxes) {
            if (option.getText().equals(name)) {
                option.click();
            }
        }
    }

    public void selectRadio(String name) {
        for (WebElement option : allRadioCheckboxes) {
            if (option.getText().equals(name)) {
                option.click();
            }
        }
    }

    public void selectYellowDropdown() {
        Select select = new Select(dropdown);
        select.selectByVisibleText("Yellow");
    }

    public String waterLogText() {
        return waterLog.getText();
    }

    public String windLogText() {
        return windLog.getText();
    }

    public String metalLogText() {
        return metalLog.getText();
    }

    public String colorsLogText() {
        return colorsLog.getText();
    }

}
