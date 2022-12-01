package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void testDashboardLinkFromMainPage_WhenClick() {

        String expectedResult = "Dashboard";

        String actualResult = openBaseUrl()
                .dashboardButtonClick()
                .readActualItemText(expectedResult);

        Assert.assertEquals(actualResult, expectedResult);
    }
}
