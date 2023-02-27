package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class ThreeTest extends Base {
    public WebDriver driver;
    @Test
    public void threeTest() throws IOException, InterruptedException {

        System.out.println("This is test three");
        driver = initializeDriver();

        driver.get("http://www.tutorialsninja.com/demo/");
        Thread.sleep(2000);

    }

    @AfterMethod
    public void closingBrowser(){
        driver.close();
    }
}
