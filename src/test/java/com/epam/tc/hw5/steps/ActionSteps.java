package com.epam.tc.hw5.steps;

import io.cucumber.java.en.When;

public class ActionSteps extends AbstractSteps {
    @When("I select {string} and {string} checkboxes")
    public void selectCheckboxes(final String checkboxName, final String checkboxName2) {
        differentElementsPage.selectCheckboxes(checkboxName);
        differentElementsPage.selectCheckboxes(checkboxName2);
    }

    @When("I select {string} radio-checkbox")
    public void selectRadio(final String radio) {
        differentElementsPage.selectRadio(radio);
    }

    @When("I select 'Yellow' in dropdown")
    public void selectDropdown() {
        differentElementsPage.selectYellowDropdown();
    }

    @When("I select \'vip\' checkbox for \"Sergey Ivan\"")
    public void selectVipCheckbox() {
        userTablePage.makeIvanVip();
    }
}
