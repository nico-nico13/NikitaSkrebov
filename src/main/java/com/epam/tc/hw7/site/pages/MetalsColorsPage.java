package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.entities.TestData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

@Url("/metals-colors.html")
@Title("Metals&Colors Page")
public class MetalsColorsPage extends WebPage {

    @Css(".results li")
    public WebList results;

    public List<String> getActualResult() {
        List<String> actualResults = new ArrayList<>();
        for (WebElement element : results) {
            actualResults.add(element.getText());
        }
        return actualResults;
    }

    public void assertResults(TestData testData) {
        List<String> expectedResults = testData.resultLogRows();
        Assert.assertEquals(getActualResult(), expectedResults);
    }


}
