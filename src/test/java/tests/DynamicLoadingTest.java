package test.java.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import test.java.pages.DynamicLoadingPage;
import test.java.utils.DriverFactory;

public class DynamicLoadingTests {
    private WebDriver driver;

    @Before
    public void setUp()
    {
        driver = DriverFactory.createDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
    }

    @Test
    public void testClickButtonAndVerifyIfTextAppears()
    {
        DynamicLoadingPage dynamicLoading = new DynamicLoadingPage(driver);

        dynamicLoading.clickStartButton();
        dynamicLoading.waitForTextToBeVisible();
        Assert.assertTrue(dynamicLoading.isTextVisible());
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
