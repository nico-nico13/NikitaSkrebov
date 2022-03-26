package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.TestData;

public class MetalsColorsForm extends Form<TestData> {

    @UI("//input[@name='custom_radio_odd']")
    RadioButtons odds;

    @UI("//input[@name='custom_radio_even']")
    RadioButtons even;

    @Css("#elements-checklist")
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

    @UI("//button[@id='submit-button']")
    Button submit;
}
