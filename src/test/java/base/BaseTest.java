package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.MainPage;

import java.time.Duration;

public abstract class BaseTest {

    public static final String BASE_URL = BaseUtils.getBaseUrl();
    private WebDriver driver;
    private WebDriverWait webDriverWait20;
    private WebDriverWait webDriverWait60;

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();
        webDriverWait20 = null;
        webDriverWait60 = null;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait20() {
        if (webDriverWait20 == null) {
            webDriverWait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait20;
    }

    protected WebDriverWait getWait60() {
        if (webDriverWait60 == null) {
            webDriverWait60 = new WebDriverWait(driver, Duration.ofSeconds(60));
        }

        return webDriverWait60;
    }

    public MainPage openBaseUrl() {
        getDriver().get(BASE_URL);
        LoaderWait();

        return new MainPage(getDriver());
    }

    protected void LoaderWait() {
        getWait60().until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[@class ='owm-loader-container']/div[@class='owm-loader']")));
    }

}
