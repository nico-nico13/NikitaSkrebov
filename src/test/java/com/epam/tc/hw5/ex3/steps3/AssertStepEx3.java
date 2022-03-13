package com.epam.tc.hw5.ex3.steps3;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.steps.AbstractStep;
import io.cucumber.java.en.Then;

public class AssertStepEx3 extends AbstractStep {

    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void assertVipLog() {
        assertThat(userTablePage.getVipLogText().endsWith("Vip: condition changed to true"));
    }

}
