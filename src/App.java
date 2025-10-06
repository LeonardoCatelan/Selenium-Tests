import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        
        /*
        Exemplo basicasso de como o selenium funciona
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        WebElement campo = driver.findElement(By.id("user"));
        campo.sendKeys("meuUsuario");
        driver.findElement(By.id("login")).click();
        driver.quit();
         */

         WebDriver driver = new ChromeDriver();
         driver.get("https://example.com");
         WebElement campo = driver.findElement(By.linkText("More information..."));
         campo.click();
         driver.wait(10);

    }
}
