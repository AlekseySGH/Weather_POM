package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends TopMenuPage {

    @FindBy(xpath = "//div[@id='weather-widget']//input[@placeholder='Search city']")
    private WebElement searchCityField;

    @FindBy(xpath = "//div[@id='weather-widget']//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@class='search-dropdown-menu']//span[text()='Paris, FR ']")
    private WebElement searchItem;

    @FindBy(xpath = "//div[@id='weather-widget']//h2")
    private WebElement actualCityNameHeader;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickSearchCityField() {
        click20(searchCityField);

        return this;
    }

    public MainPage inputText(String text) {
        input(text, searchCityField);

        return this;
    }

    public MainPage clickSearchButton() {
        click20(searchButton);

        return this;
    }

    public MainPage clickSearchItem() {
        click20(searchItem);

        return this;
    }

    public String readActualItemText(String expectedText) {

        return getText(actualCityNameHeader, expectedText);
    }

    public String readTitle() {

        return getDriver().getTitle();
    }
}
