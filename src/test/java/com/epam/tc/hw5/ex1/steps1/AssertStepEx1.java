package com.epam.tc.hw5.ex1.steps1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.steps.AbstractStep;
import io.cucumber.java.en.Then;

public class AssertStepEx1 extends AbstractStep {

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
}
