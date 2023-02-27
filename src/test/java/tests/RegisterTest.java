package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class RegisterTest {

    WebDriver driver;

    public void register(){

        LandingPage landingPage = new LandingPage(driver);
        landingPage.myAccountDropDown().click();
        landingPage.registerOption().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.firstNameReg().sendKeys("");




    }
}
