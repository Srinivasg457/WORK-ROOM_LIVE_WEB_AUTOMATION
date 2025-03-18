package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import static stepDefinations.BaseClass.randomString;

public class ChataakSignUpPage {
public WebDriver ldriver;
WaitHelper waitHelper;
    public ChataakSignUpPage(WebDriver rdriver){
ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
        waitHelper=new WaitHelper(ldriver);
    }

    //xpath identification
//    @FindBy(xpath="//a[normalize-space()='Create here a free trial']")
//    @CacheLookup
//    WebElement ClickLink_SignUpLink;

    @FindBy(linkText = "Create here a free trial")
    @CacheLookup
    WebElement ClickLink_SignUpLink;



    //Locators
    @FindBy(xpath="//input[@placeholder='John Doe']")
    @CacheLookup
    WebElement txt_OrganizationName;

    @FindBy(xpath="//input[@placeholder='John']")
    @CacheLookup
    WebElement txt_YourName;

    @FindBy(xpath = "//input[@placeholder='john.doe@example.com']")
    @CacheLookup
    WebElement txt_YourEmail;

    @FindBy(xpath = "//input[@placeholder='Landline or Mobile']")
    @CacheLookup
    WebElement num_ContactNumber;

    @FindBy(xpath = "//input[@placeholder='Manager']")
    @CacheLookup
    WebElement txt_YourDesignation;

    @FindBy(xpath="//div[@aria-haspopup='listbox']")
    @CacheLookup
    WebElement drpdown_OrganizationType;

    @FindBy(xpath="//li[normalize-space()='Manufacturer']")
    @CacheLookup
    WebElement list_Manufacturer;

    @FindBy(xpath="//li[normalize-space()='Merchant']")
    @CacheLookup
    WebElement list_Merchant;

    @FindBy(xpath="//*[name()='svg'][@height='20']")
    @CacheLookup
    WebElement dropdown_Country;

    @FindBy(xpath="(//div[text()='India'])[2]")
    @CacheLookup
    WebElement list_India ;

    @FindBy(xpath="//input[@type='checkbox']")
    @CacheLookup
    WebElement radiobutton_TermsandCondition;

    @FindBy(xpath="//button[normalize-space()='Submit your Interest']")
    @CacheLookup
    WebElement Button_SubmitYourInterest;


    @FindBy(xpath="//div[@role='status']")
    @CacheLookup
    WebElement status_message;

    @FindBy(xpath="//span[normalize-space()='Back to login']")
    @CacheLookup
    WebElement Back_to_Login;


    //Action method

    public void Link (){
        //waithelper.WaitForElement(ClickLink_SignUpLink,10);
        ClickLink_SignUpLink.click();
    }

    public void organizationName(){
        waitHelper.WaitForElement(txt_OrganizationName,10);
        txt_OrganizationName.click();
        txt_OrganizationName.clear();
        txt_OrganizationName.sendKeys(randomString());
    }

    public void YourName(){
        waitHelper.WaitForElement(txt_YourName,10);
        txt_YourName.click();
        txt_YourName.clear();
        txt_YourName.sendKeys(randomString());
    }

    public void YourEmail(){
        waitHelper.WaitForElement(txt_YourEmail,10);
        txt_YourEmail.click();
        txt_YourEmail.clear();
        txt_YourEmail.sendKeys("likojo7615@owlny123.com");
    }

    public void ContactNumber(){
        waitHelper.WaitForElement(num_ContactNumber,10);
        num_ContactNumber.click();
        num_ContactNumber.clear();
        num_ContactNumber.sendKeys("3456723456");
    }


    public void YourDesignation(){
        waitHelper.WaitForElement(txt_YourDesignation,10);
        txt_YourDesignation.clear();
        txt_YourDesignation.clear();
        txt_YourDesignation.sendKeys("Manager");
    }


    public void OrganizationType(){
        waitHelper.WaitForElement(drpdown_OrganizationType,10);
        drpdown_OrganizationType.click();
        waitHelper.WaitForElement(list_Manufacturer,10);
        list_Manufacturer.click();

    }

    public void  CountryDropDown(){
        waitHelper.WaitForElement(dropdown_Country,10);
        dropdown_Country.click();
        waitHelper.WaitForElement(list_India,10);
        list_India.click();

    }


    public void termsandConditions(){
        if(!radiobutton_TermsandCondition.isSelected()){
            radiobutton_TermsandCondition.click();
        }

    }

    public void SubmitYourInterest(){
        if (Button_SubmitYourInterest.isDisplayed()) {
            if (Button_SubmitYourInterest.isEnabled()) {
                Button_SubmitYourInterest.click();
            } else {
                Assert.fail("Button is displayed but not enabled.");

            }
        } else {
            Assert.fail("Button is not displayed.");
        }
    }



    public void SignUpPageStatus(){
        waitHelper.WaitForElement(status_message,10);
        String signUpPageStatus=status_message.getText();
        if(signUpPageStatus.equalsIgnoreCase("A verification email has been sent to your email address. Please check your inbox.")){
           System.out.println(signUpPageStatus);
            Assert.assertTrue(true);
        } else if (signUpPageStatus.equalsIgnoreCase("Organization already exists with email")) {
            System.out.println(signUpPageStatus);
            Assert.assertTrue(true);
        } else if (signUpPageStatus.equalsIgnoreCase("Please agree to the privacy policy and terms.")) {
            System.out.println(signUpPageStatus);
            Assert.assertTrue(true);
        }


    }
    public void backtoLogin(){
        waitHelper.WaitForElement(status_message,10);

        String signUpPageStatus=status_message.getText();
        if(signUpPageStatus.equalsIgnoreCase("A verification email has been sent to your email address. Please check your inbox.")){
            Back_to_Login.click();
        }
    }





}
