package test.java.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage 
{
    private WebDriver driver;

    private By checkboxes = By.xpath("//input[@type='checkbox']");

    public CheckboxesPage(WebDriver driver)
    {
        this.driver = driver;
    }
    
    public void toggleCheckbox(int index)
    {
        List<WebElement> allBoxes = findCheckboxes();
        allBoxes.get(index).click();
    }

    public boolean isCheckboxSelected(int index)
    {
        List<WebElement> allBoxes = findCheckboxes();
        return allBoxes.get(index).isSelected();
    }

    public List<WebElement> findCheckboxes()
    {
        return driver.findElements(checkboxes);
    }

    public int getTotalCheckboxes()
    {
        return findCheckboxes().size();
    }
}
