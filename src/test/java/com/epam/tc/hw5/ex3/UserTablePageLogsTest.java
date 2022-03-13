package com.epam.tc.hw5.ex3;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(features = {"classpath:/resources/com/epam/tc/hw5/features/vipCheckbox.feature"})
public class UserTablePageLogsTest extends AbstractTestNGCucumberTests {
}
