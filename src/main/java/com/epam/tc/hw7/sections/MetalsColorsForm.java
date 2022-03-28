package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.TestData;

public class MetalsColorsForm extends Form<TestData> {

    @FindBy(name = "custom_radio_odd")
    RadioButtons odds;

    @FindBy(name = "custom_radio_even")
    RadioButtons even;

    @Css("section[id=elements-checklist] input[type=checkbox]")
    Checklist elements;

    @JDropdown(root = "//div[@id='colors']",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    Dropdown colors;

    @JDropdown(root = "//div[@id='metals']",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    Dropdown metals;

    @Css("#salad-dropdown")
    Button vegeDropdown;

    @FindBy(css = "#salad-dropdown  input")
    Checklist vegetables;

    @UI("//button[@id='submit-button']")
    Button submit;

    public void submitForm(TestData testData) {
        odds.select(testData.getSummary().get(0));
        even.select(testData.getSummary().get(1));
        for (int i = 0; i < testData.getElements().size(); i++) {
            elements.select(testData.getElements().get(i));
        }
        colors.select(testData.getColor());
        metals.select(testData.getMetals());
        vegeDropdown.click();
        vegetables.select("Vegetables");
        for (int i = 0; i < testData.getVegetables().size(); i++) {
            vegetables.select(testData.getVegetables().get(i));
        }
        submit.click();
    }
}
