package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class FourTest extends Base {
    public WebDriver driver;
    @Test
    public void fourTest() throws IOException, InterruptedException {

        System.out.println("This is test four");
        driver = initializeDriver();

        driver.get("http://www.tutorialsninja.com/demo/");

        Thread.sleep(2000);

        Assert.assertTrue(false);

    }

    @AfterMethod
    public void closingBrowser(){
        driver.close();
    }
}
