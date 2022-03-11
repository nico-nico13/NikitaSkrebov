package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class AddTest extends BaseClass {

    @Test(
            dataProviderClass = DataProviderAdd.class,
            dataProvider = "testing add numbers"
    )
    public void testAdd(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
