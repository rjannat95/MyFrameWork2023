package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

import java.io.IOException;

public class Login extends Base {
    WebDriver driver = null;
    LandingPage landingPage;
    LoginPage loginPage;
    AccountPage accountPage;

    @Given("Open any Browser")
    public void open_any_browser() throws IOException {
        driver = initializeDriver();
    }

    @And("^Navigate to Login page$")
    public void navigate_to_login_page() throws InterruptedException {

        driver.get(prop.getProperty("url"));
        landingPage = new LandingPage(driver);
        landingPage.myAccountDropDown();
        landingPage.loginOption();

        Thread.sleep(3000);

    }

    @When("User enters username as {string} and password as {string} into the fields")
    public void user_enters_username_as_and_password_as_into_the_fields(String string, String string2) {

        loginPage = new LoginPage(driver);
        loginPage.emailAddressField().sendKeys(string);
        loginPage.passwordField().sendKeys(string2);
    }

    @And("^User clicks on Login buttons$")
    public void user_clicks_on_login_buttons(){
        loginPage.loginButton().click();
    }

    @Then("^Verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login(){

        accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.editAccountInformationOption().isDisplayed());
    }

    /*@After
    public void closeBrowser(){
        driver.close();
    }*/


}
