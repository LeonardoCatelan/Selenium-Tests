package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.id("flash");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setUsername(String user)
    {
        driver.findElement(usernameField).sendKeys(user);
    }

    public void setPassword(String pass)
    {
        driver.findElement(passwordField).sendKeys(pass);
    }

    public void clickLogin() 
    {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage()
    {
        return driver.findElement(errorMessage).getText();
    }

    public SecureAreaPage loginAs(String user, String pass)
    {
        setUsername(user);
        setPassword(pass);
        clickLogin();
        return new SecureAreaPage(driver);
    }
}
