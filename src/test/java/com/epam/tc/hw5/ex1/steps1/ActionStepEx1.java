package com.epam.tc.hw5.ex1.steps1;

import static com.epam.tc.hw5.hook.CucumberHook.properties;

import com.epam.tc.hw5.steps.AbstractStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ActionStepEx1 extends AbstractStep {
    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        indexPage.open("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void login() {
        indexPage.login(properties.getProperty("login"), properties.getProperty("password"));
    }

    @Given("I click on \"Service\" button in Header")
    public void clickOnService() {
        indexPage.serviceDropdownClick();
    }

    @Given("I click on \"Different Elements\" button in Service dropdown")
    public void openUserTablePage() {
        indexPage.openDifferentElementsPage();
    }

    @When("I select 'Wind' and 'Water' checkboxes")
    public void selectCheckboxes() {
        differentElementsPage.selectCheckboxes("Wind");
        differentElementsPage.selectCheckboxes("Water");
    }

    @When("I select 'Selen' radio-checkbox")
    public void selectRadio() {
        differentElementsPage.selectRadio("Selen");
    }

    @When("I select 'Yellow' in dropdown")
    public void selectDropdown() {
        differentElementsPage.selectYellowDropdown();
    }
}
