package com.epam.tc.hw7;

import com.epam.tc.hw7.site.JdiSite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        initElements(JdiSite.class);
    }
}