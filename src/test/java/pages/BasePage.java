package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait20;
    private WebDriverWait webDriverWait60;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    protected void LoaderWait() {
        getWait60().until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[@class ='owm-loader-container']/div[@class='owm-loader']")));
    }
    protected String getText(WebElement element, String text) {
        if (!element.getText().isEmpty()) {
            getWait20().until(ExpectedConditions.visibilityOf(element));
        }
        getWait20().until(ExpectedConditions.textToBePresentInElement(element, text));

        return element.getText();
    }

    protected void wait20ElementToBeVisible(WebElement element) {
        getWait20().until(ExpectedConditions.visibilityOf(element));
    }

    protected void click20(WebElement element) {
        wait20ElementToBeVisible(element);
        element.click();
    }

    protected void input(String text, WebElement element) {

        element.sendKeys(text);
    }
}
