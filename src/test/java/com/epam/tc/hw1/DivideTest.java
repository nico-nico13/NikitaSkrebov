package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;


public class DivideTest {

    @Test(
            dataProviderClass = DataProviderDivide.class,
            dataProvider = "testing divide numbers"
    )
    public void testDivide(int a, int b, int expected) {
      int actual;
        try {
            actual = a / b;
            assertThat(actual).isEqualTo(expected);
        } catch (ArithmeticException e) {
            System.out.println("Can not divide by 0");
        }
    }
}
