package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class SubtractTest extends BaseClass {

    @Test(
            dataProviderClass = DataProviderSubtract.class,
            dataProvider = "testing subtract numbers"
    )
    public void testSubtract(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
