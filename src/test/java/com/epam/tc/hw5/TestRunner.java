package com.epam.tc.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(features = {"classpath:com/epam/tc/hw5/features/"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
