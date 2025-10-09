package test.java.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import test.java.pages.DynamicControlsPage;
import test.java.utils.DriverFactory;

public class DynamicControlsTest {
    
    private WebDriver driver;

    @Before
    public void setUp()
    {
        driver = DriverFactory.createDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void testRemoveAndAddCheckbox()
    {
        DynamicControlsPage dynamicControls = new DynamicControlsPage(driver);
        Assert.assertTrue(dynamicControls.isCheckboxDisplayed());

        dynamicControls.removeCheckbox();
        Assert.assertEquals("It's gone!", dynamicControls.getStatusMessage());
        Assert.assertFalse(dynamicControls.isCheckboxDisplayed());

        dynamicControls.addCheckbox();
        Assert.assertEquals("It's back!", dynamicControls.getStatusMessage());
        Assert.assertTrue(dynamicControls.isCheckboxDisplayed());
    }

    @Test
    public void testEnableAndDisableTextfield()
    {
        DynamicControlsPage dynamicControls = new DynamicControlsPage(driver);

        Assert.assertFalse(dynamicControls.isTextfieldEnabled());

        dynamicControls.enableTextfield();
        Assert.assertEquals("It's enabled!", dynamicControls.getStatusMessage());
        Assert.assertTrue(dynamicControls.isTextfieldEnabled());

        dynamicControls.disableTextfield();
        Assert.assertEquals("It's disabled!", dynamicControls.getStatusMessage());
        Assert.assertFalse(dynamicControls.isTextfieldEnabled());
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
