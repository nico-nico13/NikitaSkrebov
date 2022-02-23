package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DivideTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(
            dataProviderClass = DataProviderDivide.class,
            dataProvider = "testing divide numbers"
    )
    public void testDivide(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(
            expectedExceptions = ArithmeticException.class,
            dataProviderClass = DataProviderDivideZero.class,
            dataProvider = "testing divide zero numbers"
    )
    public void testDivideByZero(long a, long b, long expected) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        } else {
            long actual = calculator.div(a, b);
            assertThat(actual).isEqualTo(expected);
        }
    }
}
