package com.epam.tc.hw5.steps;

import io.cucumber.java.en.Given;

public class ModuleSteps extends AbstractSteps {
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
    public void openDifferentElementsPage() {
        indexPage.openDifferentElementsPage();
    }

    @Given("I click on \"User Table\" button in Service dropdown")
    public void openUserTablePage() {
        indexPage.openUserTablePage();
    }
}
