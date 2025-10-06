package test.java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static WebDriver createDriver()
    {
        //Generating new ChromeDriver through a method/function
        return new ChromeDriver();
    }
}
