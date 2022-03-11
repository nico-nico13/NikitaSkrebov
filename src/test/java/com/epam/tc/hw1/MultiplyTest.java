package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class MultiplyTest extends BaseClass {

    @Test(
            dataProviderClass = DataProviderMultiply.class,
            dataProvider = "testing multiply numbers"
    )
    public void testMultiply(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
