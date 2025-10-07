package test.java.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage {
    private WebDriver driver;

    private By checkbox = By.xpath("//input[@type='checkbox']");
    private By toggleCheckboxVisible = By.xpath("//button[@onClick='swapCheckbox()']");
    private By toggleTextFieldAvailability = By.xpath("//button[@onClick='swapInput()']");
    private By textField = By.xpath("//input[@type='text']");
    private By statusMessage = By.id("message");


    public DynamicControlsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private void waitForStatusMessage() 
    {
    new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(statusMessage));
    }   

    //Checkboxes section
    
    //just for making the test more legible
    public void addCheckbox()
    {
        toggleCheckbox();
    }

    //just for making the test more legible
    public void removeCheckbox()
    {
        toggleCheckbox();
    }

    private void toggleCheckbox()
    {
        WebElement button = driver.findElement(toggleCheckboxVisible);
        button.click();
        waitForStatusMessage();
    }

    public boolean isCheckboxDisplayed()
    {
        return !driver.findElements(checkbox).isEmpty();
    }

    public String getStatusMessage()
    {
        return driver.findElement(statusMessage).getText();
    }

    public void toggleSelectCheckbox()
    {
        driver.findElement(checkbox).click();
    }

    public boolean isCheckboxSelected()
    {
        return driver.findElement(checkbox).isSelected();
    }

    //Text field section

    //just for making the test more legible
    public void enableTextfield()
    {
        toggleTextfield();
    }

    //just for making the test more legible
    public void disableTextfield()
    {
        toggleTextfield();
    }

    public void toggleTextfield()
    {
        WebElement button = driver.findElement(toggleTextFieldAvailability);
        button.click();
        waitForStatusMessage();
    }

    public boolean isTextfieldEnabled()
    {
        return driver.findElement(textField).isEnabled();
    }

}
