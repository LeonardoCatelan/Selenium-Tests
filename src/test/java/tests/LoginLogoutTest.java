package test.java.tests;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.java.pages.LoginPage;
import test.java.pages.SecureAreaPage;
import test.java.utils.DriverFactory;

public class LoginLogoutTest {
    private WebDriver driver;
    

    @Before
    public void setUp()
    {
        driver = DriverFactory.createDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void testLoginLogout()
    {
        LoginPage loginPage = new LoginPage(driver);
        SecureAreaPage secureArea = loginPage.loginAs("tomsmith", "SuperSecretPassword!");

        By successMessage = By.cssSelector("div.example h4");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement message = wait.until
        (
          ExpectedConditions.visibilityOfElementLocated(successMessage)  
        );

        Assert.assertEquals
        (
            "Welcome to the Secure Area. When you are done click logout below.",
            message.getText()
        );
        //Aqui chegou na página de secure

        secureArea.logout();
        
        By finalMessage = By.cssSelector("div.example h2");
        WebElement jorge = wait.until
        (
            ExpectedConditions.visibilityOfElementLocated(finalMessage)
        );

        Assert.assertEquals
        (
        "Login Page",
         jorge.getText()
         );
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
