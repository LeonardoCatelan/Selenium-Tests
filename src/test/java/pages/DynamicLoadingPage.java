package test.java.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {
    private WebDriver driver;

    private By startButton = By.xpath("//*[@id=\"start\"]/button");
    private By invisibleText = By.xpath("//*[@id=\"finish\"]/h4");


    public DynamicLoadingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickStartButton()
    {
        driver.findElement(startButton).click();
    }

    public void waitForTextToBeVisible()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(invisibleText));
    }

    public boolean isTextVisible()
    {
        for(WebElement element : driver.findElements(invisibleText))
        {
            if(element.isDisplayed()){
                return true;
            }
        }
        return false;
    }

}
