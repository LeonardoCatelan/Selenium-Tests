package test.java.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import test.java.pages.CheckboxesPage;
import test.java.utils.DriverFactory;

public class CheckboxesTest {
    private WebDriver driver;

    @Before
    public void setUp()
    {
        driver = DriverFactory.createDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void testCheckboxesCorrectlyChangesState()
    {
        CheckboxesPage checkPage = new CheckboxesPage(driver);

        //verify is there is only two checkboxes as expected
        Assert.assertEquals(2, checkPage.getTotalCheckboxes());
        
        //unmark 2nd checkbox that was marked before
        if(checkPage.isCheckboxSelected(1))
        {
            checkPage.toggleCheckbox(1);
        }

        //Assert that the second checkbox is correctly off
        Assert.assertFalse(checkPage.isCheckboxSelected(1));

        //Similar to first if, but with a negative because the checkbox wasn't marked
        if(!checkPage.isCheckboxSelected(0))
        {
            checkPage.toggleCheckbox(0);
        }

        //Assert that the first checkbox is correctly on
        Assert.assertTrue(checkPage.isCheckboxSelected(0));

    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

}
