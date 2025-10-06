package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private WebDriver driver;

    private By dropdownMenu = By.id("dropdown");

    public DropdownPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void selectDropdownOption()
    {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText("Option 1");
    }

    public WebElement returnSelectedDropdownOption()
    {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption();
    }

}
