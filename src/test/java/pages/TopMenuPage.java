package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class TopMenuPage extends BasePage {

    @FindBy(xpath = "//div/ol/li/a[@href = '/']")
    private WebElement homeButton;

    @FindBy(xpath = "//div[@id='desktop-menu']//li/a[text() = 'Dashboard']")
    private WebElement dashboardButton;

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage dashboardButtonClick() {
        click20(dashboardButton);

        return new DashboardPage(getDriver());
    }

    public MainPage HomeButtonClick() {
        click20(homeButton);
        LoaderWait();

        return new MainPage(getDriver());
    }

}
