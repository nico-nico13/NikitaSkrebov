package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class MetalsColorsPage extends WebPage {

    @UI("//input[@name='custom_radio_odd']")
    public static RadioButtons oddsSelect;

    @UI("//input[@name='custom_radio_even']")
    public static RadioButtons evenSelect;

    @UI("//p/input[@type='checkbox']")
    public static Checklist elementsSelect;

    @JDropdown(root = "//div[@id='colors']",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colorsSelect;

    @JDropdown(root = "//div[@id='metals']",
    value = ".filter-option",
    list = "li",
    expand = ".caret")
    public static Dropdown metalsSelect;

    @UI("//div/ul[@class='dropdown-menu']")
    public static MultiSelector vegetablesSelect;


}
