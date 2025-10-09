package test.java.tests;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.java.pages.EntryAdPage;
import test.java.utils.DriverFactory;

public class EntryAdTest {
    private WebDriver driver;


    @Before
    public void setUp()
    {
        driver = DriverFactory.createDriver();
        driver.get("https://the-internet.herokuapp.com/entry_ad");
    }

    @Test
    public void testEntryAdAndRestartAd() 
    {
        //test to close ad
        EntryAdPage entryAd = new EntryAdPage(driver);
        entryAd.waitForModalToAppear();
        // fecha modal
        entryAd.clickClose();
        Assert.assertFalse("Modal still visible after closing it", entryAd.isModalVisible());

        //test to re-enable the ad
        entryAd.restartAdAndWait();
        Assert.assertTrue("Modal did not came back after restart", entryAd.isModalVisible());
    }


    @After
    public void tearDown()
    {
        driver.quit();
    }

}
