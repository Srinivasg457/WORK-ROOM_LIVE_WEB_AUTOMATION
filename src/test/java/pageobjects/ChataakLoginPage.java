package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ChataakLoginPage {
    public WebDriver ldriver;
    WaitHelper waitHelper;
    public Properties configprop;

    public ChataakLoginPage(WebDriver rdriver) throws IOException {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
        waitHelper=new WaitHelper(ldriver);

        configprop = new Properties();
        FileInputStream configProfile = new FileInputStream("/home/limitscale/Documents/ChataakProjectWebAutomation/src/test/resources/config.properties");
        configprop.load(configProfile);
    }

    //xpath identification
    @FindBy(xpath="//a[normalize-space()='Create here a free trial']")
    @CacheLookup
    WebElement ClickLink_SignUpLink;

    //Locators
    @FindBy(xpath="//input[@placeholder='johndoe@example.com']")
    @CacheLookup
    WebElement txtEmail;


    @FindBy(xpath="//input[@placeholder='Password']")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="//button[normalize-space()='Login']")
    @CacheLookup
    WebElement btnLogin;


    @FindBy(xpath="//li[normalize-space()='Sign Out']")
    @CacheLookup
    WebElement Logout;

    @FindBy(xpath="//p[@aria-label='Organization Type : Merchant']")
    @CacheLookup
    WebElement owner;



    @FindBy(xpath="//div[@role='status']")
    @CacheLookup
    WebElement status;


    //Action Method
    public void clickLink() {
        ClickLink_SignUpLink.click();
    }


    public void Email(String email) {
        // waithelper.WaitForElement(txtEmail,10);
        txtEmail.click();
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void password(String password) {

        txtPassword.click();
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void Login() {
        btnLogin.click();
    }

    public void Logout() {
        Logout.click();
    }

    public void  OwnerType() {
        owner.getText();
        System.out.println(owner.getText());
    }


    public void statusmessage() {
        waitHelper.WaitForElement(status, 10);
        String message = status.getText();
        System.out.println("Status message = " + message);

        if (message.equalsIgnoreCase("Login successful")) {
            System.out.println("Status : " + message);
            Assert.assertTrue(true);
        } else if (message.equalsIgnoreCase("Incorrect password. Please try again or reset your password if you've forgotten it.")) {
            System.out.println("Status : "+ message);
            //Assert.fail("Login failed due to incorrect password. Stopping scenario.");
            Assert.assertTrue(true);
        } else if (message.equalsIgnoreCase("This email is not registered in Chataak")) {
            System.out.println("Status : "+ message);
//            Assert.fail("Login failed due to unregistered email. Stopping scenario.");
            Assert.assertTrue(true);
        } else {
           // logger.error();
            System.out.println("Unexpected login status message: " + message);
            Assert.fail("Unexpected login status. Stopping scenario.");
        }
    }







}
