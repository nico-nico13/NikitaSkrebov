package com.epam.tc.hw5.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.testng.Assert;

public class AssertionSteps extends AbstractSteps {
    //exercise1
    @Then("1 log row has \"Wind: condition changed to true\" text in log section")
    public void assertWindLog() {
        assertThat(differentElementsPage.windLogText().endsWith("Wind: condition changed to true"));
    }

    @Then("1 log row has \"Water: condition changed to true\" text in log section")
    public void assertWaterLog() {
        assertThat(differentElementsPage.waterLogText().endsWith("Water: condition changed to true"));
    }

    @Then("1 log row has \"metal: value changed to Selen\" text in log section")
    public void assertMetalLog() {
        assertThat(differentElementsPage.metalLogText().endsWith("metal: value changed to Selen"));
    }

    @Then("1 log row has \"Colors: value changed to Yellow\" text in log section")
    public void assertColorsLog() {
        assertThat(differentElementsPage.colorsLogText().endsWith("Colors: value changed to Yellow"));
    }

    //exercise2
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
    
    //@Then("User table should contain following values:")


   //    public void assertUserTable(DataTable dataTable) {
   //        List<List<String, String>> usersList = dataTable.;
   //        List<String> values = usersList.stream().map(o -> o.get("Number")).collect(Collectors.toList());
   //        for (int i = 0; i < values.size(); i++) {
   //            Assert.assertEquals(values.get(i), list.get(i).getText);
   //        }
   //    }

    //exercise3
    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void assertVipLog() {
        assertThat(userTablePage.getVipLogText().endsWith("Vip: condition changed to true"));
    }
}
