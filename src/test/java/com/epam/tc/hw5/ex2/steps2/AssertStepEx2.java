package com.epam.tc.hw5.ex2.steps2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.epam.tc.hw5.steps.AbstractStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.List;

public class AssertStepEx2 extends AbstractStep {

    @Then("\"User Table\" page should be opened")
    public void assertTitle() {
        assertEquals(userTablePage.getPageTitle(), "User Table");
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertDropdowns() {
        assertTrue(userTablePage.dropdownsDisplay());
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void assertUsernames() {
        assertTrue(userTablePage.usernamesDisplay());
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void assertDescriptions() {
        assertTrue(userTablePage.descriptionsDisplay());
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxes() {
        assertTrue(userTablePage.checkboxesDisplay());
    }

    @Then("User table should contain following values:")
    public void assertUserTable(DataTable dataTable) {
        List<List<String>> usersList = dataTable.asLists(String.class);
    }
}
