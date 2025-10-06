package test.java.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntryAdPage {
    private WebDriver driver;

    private By modal = By.id("modal");
    private By closeField = By.xpath("//div[@class='modal-footer']/p[text()='Close']");
    private By restartAd = By.id("restart-ad");
    private final Duration TIMEOUT = Duration.ofSeconds(10);

    public EntryAdPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickClose() 
    {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        //waiting the modal to be visible
        waitForModalToAppear();
        

        WebElement close = wait.until(ExpectedConditions.elementToBeClickable(closeField));
        try
        {
            close.click();
        } catch(ElementClickInterceptedException e)
        {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", close);
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
    }

    public void restartAdAndWait()
    {
        driver.findElement(restartAd).click();
        waitForModalToAppear();
    }

    public void waitForModalToAppear()
    {
        new WebDriverWait(driver, TIMEOUT)
        .until(ExpectedConditions.visibilityOfElementLocated((modal)));
    }

    public boolean isModalVisible() 
    {
        List<WebElement> elems = driver.findElements(modal);
        if(elems.isEmpty()) return false;
        for(WebElement e: elems)
        {
            try
            {
                if (e.isDisplayed()) return true;
            } catch (StaleElementReferenceException se)
            {
                
            }
        }
        return false;
    }
}

