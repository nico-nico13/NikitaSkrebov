package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class AddTest {


    @Test(
            dataProviderClass = DataProviderAdd.class,
            dataProvider = "testing add numbers"
    )
    public void testAdd(int a, int b, int expected) {
        int actual = a + b;
        assertThat(actual).isEqualTo(expected);
    }
}
