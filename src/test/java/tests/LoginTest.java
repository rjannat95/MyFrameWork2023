package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

import java.io.IOException;

public class LoginTest extends Base {

    public WebDriver driver;
    Logger log;

    @Test(dataProvider = "getLoginData")
    public void login(String email, String password, String expectedResult) throws IOException, InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.myAccountDropDown().click();
        log.debug("Clicked on My Account dropdown");
        landingPage.loginOption().click();
        log.debug("Clicked on login option");

        Thread.sleep(5);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.emailAddressField().sendKeys(email);
        log.debug("Email address got entered");
        loginPage.passwordField().sendKeys(password);
        log.debug("Password got entered");
        loginPage.loginButton().click();
        log.debug("Clicked on Login Button");

        AccountPage accountPage = new AccountPage(driver);
        String actualResult = null;

        try {
            if(accountPage.editAccountInformationOption().isDisplayed()) {
                log.debug("User got logged in");
                actualResult = "Successful";
            }
        }catch (Exception e){
            log.debug("User didn't log in");
            actualResult = "Failure";
        }

        Assert.assertEquals(actualResult,expectedResult);
        log.info("Login Test got passed");

    }
    @AfterMethod
    public void closeBrowser(){

        driver.close();
        log.debug("Browser got closed");
    }

    @BeforeMethod
    public void openApplication() throws IOException {

        log = LogManager.getLogger(LoginTest.class.getName());
        driver = initializeDriver();
        log.debug("Browser got launched");
        driver.get(prop.getProperty("url"));
        log.debug("Navigated to application URL");
    }

    @DataProvider
    public Object[][] getLoginData(){

        Object [][] data = {{"jann@gmail.com","jann","Successful"},{"dummy@test.com","dummy","Failure"}};
        return data;
    }
}
