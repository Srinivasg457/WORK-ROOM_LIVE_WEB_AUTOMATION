package stepDefinations;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.ChataakLoginPage;
import pageobjects.ChataakSignUpPage;
import pageobjects.ChataakStoresPage;

import java.util.HashMap;
import java.util.Map;

public class Chataaksteps {

    WebDriver driver;
    ChataakLoginPage lp;
    ChataakStoresPage sp;
    ChataakSignUpPage signUppage;
    @Given("the user launches the Chrome browser")
    public void the_user_launches_the_chrome_browser() {
      System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver-linux64/chromedriver");
      ChromeOptions options=new ChromeOptions();
        // Disable "Save Password" popup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
      options.addArguments("--remote-allow-origins=*");
      options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
      options.setExperimentalOption("useAutomationExtension",false);
        driver=new ChromeDriver(options); //launches the Chrome Driver
        driver.manage().window().maximize();
        lp= new ChataakLoginPage(driver);
        sp=new ChataakStoresPage(driver);
        signUppage=new ChataakSignUpPage(driver);
    }

    @Given("the user navigates to the login page with the URL {string}")
    public void the_user_navigates_to_the_login_page_with_the_url(String url) {
     driver.get(url);
    }

    @When("the user enters their email {string} and password {string}")
    public void the_user_enters_their_email_and_password(String email, String password) {
      lp.Email(email);
      lp.password(password);
    }

    @When("the user clicks the Login button")
    public void the_user_clicks_the_login_button() throws InterruptedException {
      Thread.sleep(4000);
        lp.Login();
    }

    @Then("the user should see the status message")
    public void the_user_should_see_the_status_message() {
      lp.statusmessage();

        driver.close();
    }




    //Adding new store

    @When("user will perform the actions to add the store")
    public void user_will_perform_the_actions_to_add_the_store() throws InterruptedException {
        sp.Addstore();
        sp.status();
    }





    //user Sign Up Page
    @Given("the user navigates to the SignUp page with the URL {string}")
    public void the_user_navigates_to_the_sign_up_page_with_the_url(String SignUpPageUrl) {
      driver.get(SignUpPageUrl);
    }
    @Given("User Fills the Sign Up form")
    public void user_fills_the_sign_up_form() {
        signUppage.organizationName();
        signUppage.YourName();
        signUppage.YourEmail();
        signUppage.ContactNumber();
        signUppage.YourDesignation();
        signUppage.OrganizationType();
        signUppage.CountryDropDown();
        signUppage.termsandConditions();
    }
    @Given("Click on the Submit Your Interest Form")
    public void click_on_the_submit_your_interest_form() {
        signUppage.SubmitYourInterest();

    }
    @Then("the SignUp Page Status message will be seen")
    public void the_sign_up_page_status_message_will_be_seen() {
       // signUppage.status();
        signUppage.SignUpPageStatus();
        signUppage.backtoLogin();
    }

    //here user Doest Click the Terms and Conditions Check Box
    @Given("User fill the Sign Up form But Doest Click the privacy policy check box")
    public void user_fill_the_sign_up_form_but_doest_click_the_privacy_policy_check_box() {
        signUppage.organizationName();
        signUppage.YourName();
        signUppage.YourEmail();
        signUppage.ContactNumber();
        signUppage.YourDesignation();
        signUppage.OrganizationType();
        signUppage.CountryDropDown();
    }

    @Then("the SignUp Page Status message will be seen as Please agree to the privacy policy and terms.")
    public void the_sign_up_page_status_message_will_be_seen_as_please_agree_to_the_privacy_policy_and_terms() {
        signUppage.SignUpPageStatus();
    }

    @Then("the SignUp Page Status message will be seen as Organization already exists with email")
    public void the_sign_up_page_status_message_will_be_seen_as_organization_already_exists_with_email() {
        signUppage.SignUpPageStatus();
    }




}
