package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class DivideTest extends BaseClass {

    @Test(
            dataProviderClass = DataProviderDivide.class,
            dataProvider = "testing divide numbers"
    )
    public void testDivide(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(
            expectedExceptions = NumberFormatException.class,
            dataProviderClass = DataProviderDivide.class,
            dataProvider = "testing divide zero long numbers"
    )
    public void testDivideLongByZero(long a, long b) {
        calculator.div(a, b);
    }

    @Test(
            dataProviderClass = DataProviderDivide.class,
            dataProvider = "testing divide zero double numbers"
    )
    public void testDivideDoubleByZero(double a, double b, Double expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
