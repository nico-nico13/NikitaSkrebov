package com.epam.tc.hw5.ex2;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(features = {"classpath:/features/userTable.feature"})
public class UserTablePageTest extends AbstractTestNGCucumberTests {
}
