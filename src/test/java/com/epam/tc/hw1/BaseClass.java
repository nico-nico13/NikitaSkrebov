package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    public Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }
}
