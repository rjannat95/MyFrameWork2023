package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "input-email")
    private WebElement emailAddressField;

    public WebElement emailAddressField(){

        return emailAddressField;
    }

    @FindBy(id = "input-password")
    private WebElement passwordField;

    public WebElement passwordField(){

        return passwordField;
    }

    @FindBy(css = "input[value=Login]")
    private WebElement loginButton;

    public WebElement loginButton(){

        return loginButton;
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameReg;

    public WebElement firstNameReg(){

        return firstNameReg;
    }

    @FindBy(id = "input-lastname")
    private WebElement lastNameReg;

    public WebElement lastNameReg(){

        return lastNameReg;
    }

    @FindBy(id = "input-email")
    private WebElement emailReg;

    public WebElement emailReg(){

        return emailReg;
    }

    @FindBy(id = "input-telephone")
    private WebElement telephoneReg;

    public WebElement telephoneReg(){

        return telephoneReg;
    }

    @FindBy(id = "input-password")
    private WebElement passwordReg;

    public WebElement passwordReg(){

        return passwordReg;
    }

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmReg;

    public WebElement passwordConfirmReg(){

        return passwordConfirmReg;
    }

    @FindBy(css = "input[name=agree]")
    private WebElement agreeButton;

    public WebElement agreeButton(){

        return agreeButton;
    }

    @FindBy(css = "input[value=Continue]")
    private WebElement continueClickButton;

    public WebElement continueClickButton(){

        return continueClickButton;
    }










}
