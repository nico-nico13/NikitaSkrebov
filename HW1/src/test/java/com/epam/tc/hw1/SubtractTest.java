package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class SubtractTest {

    @Test(
            dataProviderClass = DataProviderSubtract.class,
            dataProvider = "testing subtract numbers"
    )
    public void testSubtract(int a, int b, int expected) {
        int actual = a - b;
        assertThat(actual).isEqualTo(expected);
    }
}
