package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class DivideByZeroTest {

    @Test(
            expectedExceptions = ArithmeticException.class,
            dataProviderClass = DataProviderDivideZero.class,
            dataProvider = "testing divide zero numbers"
    )
    public void divideByZero(int a, int b, int expected) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        } else {
            int actual = a / b;
            assertThat(actual).isEqualTo(expected);
        }
    }
}
