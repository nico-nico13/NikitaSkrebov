package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class MultiplyTest {

    @Test(
            dataProviderClass = DataProviderMultiply.class,
            dataProvider = "testing multiply numbers"
    )
    public void testMultiply(int a, int b, int expected) {
        int actual = a * b;
        assertThat(actual).isEqualTo(expected);
    }
}
