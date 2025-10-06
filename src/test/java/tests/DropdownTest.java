package test.java.tests;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.pages.DropdownPage;
import test.java.utils.DriverFactory;

public class DropdownTest {

    private WebDriver driver;

    @Before
    public void setUp()
    {
        driver = DriverFactory.createDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void testDropdown()
    {
        DropdownPage dropPage = new DropdownPage(driver);

        dropPage.selectDropdownOption();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement selectedOption = dropPage.returnSelectedDropdownOption();

        Assert.assertEquals
        (
            "Option 1",
            selectedOption.getText()
        );

    }
    
    @After
    public void tearDown()
    {
        driver.quit();
    }

}
