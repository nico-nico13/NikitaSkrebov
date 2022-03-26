package com.epam.tc.hw7.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.sections.LoginForm;
import com.epam.tc.hw7.sections.MetalsColorsForm;
import com.epam.tc.hw7.site.pages.HomePage;
import com.epam.tc.hw7.site.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/index.html")
    public static HomePage homePage;

    public static LoginForm loginForm;

    @Url("/metals-colors.html")
    public static MetalsColorsPage metalsColorsPage;

    public static MetalsColorsForm metalsColorsForm;
}
