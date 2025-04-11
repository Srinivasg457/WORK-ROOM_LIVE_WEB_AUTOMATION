package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.ChataakCatalogModulePage;
import pageobjects.ChataakSignUpPage;
import pageobjects.ChataakStoresPage;

import java.io.IOException;

public class ChataakSignUpSteps extends BaseClass {



    public ChataakSignUpSteps() throws IOException {
        signUppage = new ChataakSignUpPage(driver);
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


}
