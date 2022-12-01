package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends TopMenuPage {

    @FindBy(xpath = "//div/h1/b")
    private WebElement headerName;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String readActualItemText(String expectedText) {

        return getText(headerName, expectedText);
    }
}
