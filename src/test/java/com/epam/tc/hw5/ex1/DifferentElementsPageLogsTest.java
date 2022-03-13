package com.epam.tc.hw5.ex1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(features = {"classpath:/features/differentElements.feature"})
public class DifferentElementsPageLogsTest extends AbstractTestNGCucumberTests {
}
