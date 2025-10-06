package test.java.pages;

import org.openqa.selenium.*;

public class SecureAreaPage {
    private WebDriver driver;

    private By logoutButton = By.cssSelector("a.button");

    public SecureAreaPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void logout()
    {
        driver.findElement(logoutButton).click();
    }
}
