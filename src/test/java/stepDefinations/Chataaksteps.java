package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.ChataakCatalogModulePage;
import pageobjects.ChataakLoginPage;
import pageobjects.ChataakSignUpPage;
import pageobjects.ChataakStoresPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
public class Chataaksteps extends BaseClass {

@Before
public void setup() throws IOException {

    // Reading the properties file
    configprop = new Properties();
    String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
    FileInputStream configProfile = new FileInputStream(configPath);
    configprop.load(configProfile);


    // Logger setup
    logger = Logger.getLogger("ChataakWebApplication");
    String log4jPath = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
    PropertyConfigurator.configure(log4jPath);
    logger.setLevel(Level.DEBUG);


    String br=configprop.getProperty("browser"); //getting the browser name from config.properties file

    //Launching browser
    if (br.equals("firefox")) {
        System.setProperty("webdriver.gecko.driver",configprop.getProperty("firefoxdriverpath"));
        driver = new FirefoxDriver();
    }

    else if (br.equals("chrome")) {

        logger.info("************* Launching CHROME Browser *****************");
        // Chrome options setup
     //   ChromeOptions options = new ChromeOptions();

        // Disable "Save Password" popup
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.password_manager_enabled", false);
//        options.setExperimentalOption("prefs", prefs);
//
//        options.addArguments("--remote-allow-origins=*");
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.setExperimentalOption("useAutomationExtension", false);

        System.setProperty("webdriver.chrome.driver",configprop.getProperty("chromepath"));
        driver = new ChromeDriver();
    }

    else if (br.equals("msedge")) {

        logger.info("************* Launching EDGE Browser *****************");
        // Create Edge Options
        EdgeOptions options = new EdgeOptions();
        options.addArguments("useAutomationExtension=false");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments("--remote-allow-origins=*");

        // Disable password save popup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.edge.driver",configprop.getProperty("microsoftedgepath"));
        driver = new EdgeDriver(options); // Launch Edge
    }
    // Maximize the browser window
    logger.info("************* Browser Launched and Maximized *****************");
    driver.manage().window().maximize();


}


    @After
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                // Ensure WebDriver is initialized
                if (driver == null) {
                    System.out.println("WebDriver is null! Screenshot cannot be taken.");
                    return;
                }

                // Capture Screenshot as Bytes
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

                // Attach screenshot to Cucumber Report
                scenario.attach(screenshot, "image/png", "Failed Step Screenshot");

            } catch (Exception e) {
                System.out.println("⚠️ Failed to capture screenshot: " + e.getMessage());
            }
        }
    }









    @Given("the user launches the Chrome browser")
    public void the_user_launches_the_chrome_browser() throws IOException {

        lp= new ChataakLoginPage(driver);
        sp=new ChataakStoresPage(driver);
        signUppage=new ChataakSignUpPage(driver);
        catalog=new ChataakCatalogModulePage(driver);
    }

    @Given("the user navigates to the login page with the URL {string}")
    public void the_user_navigates_to_the_login_page_with_the_url(String url) {
        logger.info("************* Get The Application URL  *****************");
        driver.get(url);
    }

    @When("the user enters their email {string} and password {string}")
    public void the_user_enters_their_email_and_password(String email, String password) {
        logger.info("************* Enter the Email *****************");
        lp.Email(email);
        logger.info("************* Enter the Password *****************");
        lp.password(password);
    }

    @When("the user clicks the Login button")
    public void the_user_clicks_the_login_button() throws InterruptedException {
      Thread.sleep(4000);
        logger.info("************* Click on the Login Button *****************");
        lp.Login();
    }

    @Then("the user should see the status message")
    public void the_user_should_see_the_status_message() {
        logger.info("************* Check The Application Status Message *****************");
      lp.statusmessage();
        logger.info("************* Close The Browser *****************");
        driver.close();
    }




    //Adding new store

    @When("user will perform the actions to add the store")
    public void user_will_perform_the_actions_to_add_the_store() throws InterruptedException {
        logger.info("************* Adding The Store information *****************");
        sp.Addstore();
        logger.info("************* Checking The Added Store Confirmation Message *****************");
        sp.status();
    }





    //user Sign Up Page
    @Given("the user navigates to the SignUp page with the URL {string}")
    public void the_user_navigates_to_the_sign_up_page_with_the_url(String SignUpPageUrl) {
      driver.get(SignUpPageUrl);
    }
    @Given("User Fills the Sign Up form")
    public void user_fills_the_sign_up_form() {
        logger.info("************* Enter Organization Name*****************");
        signUppage.organizationName();
        logger.info("************* Enter Your Name *****************");
        signUppage.YourName();
        logger.info("************* Enter Your Email *****************");
        signUppage.YourEmail();
        logger.info("************* Enter Contact Number *****************");
        signUppage.ContactNumber();
        logger.info("************* Enter Your Designation *****************");
        signUppage.YourDesignation();
        logger.info("************* Select Organization Type *****************");
        signUppage.OrganizationType();
        logger.info("************* Select Country from Dropdown *****************");
        signUppage.CountryDropDown();
        logger.info("************* Accept Terms and Conditions *****************");
        signUppage.termsandConditions();
    }
    @Given("Click on the Submit Your Interest Form")
    public void click_on_the_submit_your_interest_form() {
        logger.info("************* click on submit Your Interest Button *****************");
        signUppage.SubmitYourInterest();

    }
    @Then("the SignUp Page Status message will be seen")
    public void the_sign_up_page_status_message_will_be_seen() {
       // signUppage.status();
        logger.info("************* Sign up Page Status *****************");
        signUppage.SignUpPageStatus();
        logger.info("************* Click Back To Login Button *****************");
        signUppage.backtoLogin();
    }

    //here user Doest Click the Terms and Conditions Check Box
    @Given("User fill the Sign Up form But Doest Click the privacy policy check box")
    public void user_fill_the_sign_up_form_but_doest_click_the_privacy_policy_check_box() {
        logger.info("************* Enter Organization Name*****************");
        signUppage.organizationName();
        logger.info("************* Enter Your Name *****************");
        signUppage.YourName();
        logger.info("************* Enter Your Email *****************");
        signUppage.YourEmail();
        logger.info("************* Enter Contact Number *****************");
        signUppage.ContactNumber();
        logger.info("************* Enter Your Designation *****************");
        signUppage.YourDesignation();
        logger.info("************* Select Organization Type *****************");
        signUppage.OrganizationType();
        logger.info("************* Select Country DropDown *****************");
        signUppage.CountryDropDown();
    }

    @Then("the SignUp Page Status message will be seen as Please agree to the privacy policy and terms.")
    public void the_sign_up_page_status_message_will_be_seen_as_please_agree_to_the_privacy_policy_and_terms() {
        logger.info("************* Sign up Page Status 'the SignUp Page Status message will be seen as Please agree to the privacy policy and terms.' *****************");
        signUppage.SignUpPageStatus();
    }

    @Then("the SignUp Page Status message will be seen as Organization already exists with email")
    public void the_sign_up_page_status_message_will_be_seen_as_organization_already_exists_with_email() {
        logger.info("************* Sign up Page Status 'the SignUp Page Status message will be seen as Organization already exists with email' *****************");
        signUppage.SignUpPageStatus();
    }





    //Catalog Module --> Where we are Performing to add the Products and its related Submodule

    @When("user will perform the actions to add the Category Manager")
    public void user_will_perform_the_actions_to_add_the_category_manager() throws InterruptedException {
        catalog.catalogModule();
    }








}
