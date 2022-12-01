package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test
    public void testH2TagText_WhenSearchingCityCountry() {

        String cityName = "Paris";
        String expectedCityCountryNames = "Paris, FR";

        String actualCityCountryNames = openBaseUrl()
                .clickSearchCityField()
                .inputText(cityName)
                .clickSearchButton()
                .clickSearchItem()
                .readActualItemText(expectedCityCountryNames);

        Assert.assertEquals(actualCityCountryNames, expectedCityCountryNames);
    }

    @Test
    public void testDashboardLinkFromMainPage_WhenClick() {

        String expectedResult = "Dashboard";

        String actualResult = openBaseUrl()
                .dashboardButtonClick()
                .readActualItemText(expectedResult);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLinkFromMainPageToDashboardAndBackToMainPage_WhenClick() {

        String expectedResult = "Сurrent weather and forecast - OpenWeatherMap";

        String actualResult = openBaseUrl()
                .dashboardButtonClick()
                .HomeButtonClick()
                .readTitle();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
