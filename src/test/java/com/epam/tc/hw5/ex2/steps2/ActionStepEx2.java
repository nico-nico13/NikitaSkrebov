package com.epam.tc.hw5.ex2.steps2;

import static com.epam.tc.hw5.hook.CucumberHook.properties;

import com.epam.tc.hw5.steps.AbstractStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ActionStepEx2 extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        indexPage.open("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void login() {
        indexPage.login(properties.getProperty("login"), properties.getProperty("password"));
    }

    @When("I click on \"Service\" button in Header")
    public void clickOnService() {
        indexPage.serviceDropdownClick();
    }

    @When("I click on \"User Table\" button in Service dropdown")
    public void openUserTablePage() {
        indexPage.openUserTablePage();
    }
}
