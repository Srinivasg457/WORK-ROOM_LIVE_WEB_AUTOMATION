package stepDefinations;


import io.cucumber.java.en.*;
import pageobjects.*;
import java.io.IOException;

public class Chataaksteps extends BaseClass {


    @Given("the user launches the Chrome browser")
    public void the_user_launches_the_chrome_browser() throws IOException {
        lp = new ChataakLoginPage(driver);
        sp = new ChataakStoresPage(driver);
        signUppage = new ChataakSignUpPage(driver);
        catalog = new ChataakCatalogModulePage(driver);
        AddProducts = new ChataakAddCatalogProducts(driver);
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
    }


//    //Adding new store
//
//    @When("user will perform the actions to add the store")
//    public void user_will_perform_the_actions_to_add_the_store() throws InterruptedException {
//        logger.info("************* Adding The Store information *****************");
//        sp.Addstore();
//        logger.info("************* Checking The Added Store Confirmation Message *****************");
//        sp.status();
//    }


//    //user Sign Up Page
//    @Given("the user navigates to the SignUp page with the URL {string}")
//    public void the_user_navigates_to_the_sign_up_page_with_the_url(String SignUpPageUrl) {
//        driver.get(SignUpPageUrl);
//    }
//
//    @Given("User Fills the Sign Up form")
//    public void user_fills_the_sign_up_form() {
//        logger.info("************* Enter Organization Name*****************");
//        signUppage.organizationName();
//        logger.info("************* Enter Your Name *****************");
//        signUppage.YourName();
//        logger.info("************* Enter Your Email *****************");
//        signUppage.YourEmail();
//        logger.info("************* Enter Contact Number *****************");
//        signUppage.ContactNumber();
//        logger.info("************* Enter Your Designation *****************");
//        signUppage.YourDesignation();
//        logger.info("************* Select Organization Type *****************");
//        signUppage.OrganizationType();
//        logger.info("************* Select Country from Dropdown *****************");
//        signUppage.CountryDropDown();
//        logger.info("************* Accept Terms and Conditions *****************");
//        signUppage.termsandConditions();
//    }
//
//    @Given("Click on the Submit Your Interest Form")
//    public void click_on_the_submit_your_interest_form() {
//        logger.info("************* click on submit Your Interest Button *****************");
//        signUppage.SubmitYourInterest();
//
//    }
//
//    @Then("the SignUp Page Status message will be seen")
//    public void the_sign_up_page_status_message_will_be_seen() {
//        // signUppage.status();
//        logger.info("************* Sign up Page Status *****************");
//        signUppage.SignUpPageStatus();
//        logger.info("************* Click Back To Login Button *****************");
//        signUppage.backtoLogin();
//    }
//
//    //here user Doest Click the Terms and Conditions Check Box
//    @Given("User fill the Sign Up form But Doest Click the privacy policy check box")
//    public void user_fill_the_sign_up_form_but_doest_click_the_privacy_policy_check_box() {
//        logger.info("************* Enter Organization Name*****************");
//        signUppage.organizationName();
//        logger.info("************* Enter Your Name *****************");
//        signUppage.YourName();
//        logger.info("************* Enter Your Email *****************");
//        signUppage.YourEmail();
//        logger.info("************* Enter Contact Number *****************");
//        signUppage.ContactNumber();
//        logger.info("************* Enter Your Designation *****************");
//        signUppage.YourDesignation();
//        logger.info("************* Select Organization Type *****************");
//        signUppage.OrganizationType();
//        logger.info("************* Select Country DropDown *****************");
//        signUppage.CountryDropDown();
//    }
//
//    @Then("the SignUp Page Status message will be seen as Please agree to the privacy policy and terms.")
//    public void the_sign_up_page_status_message_will_be_seen_as_please_agree_to_the_privacy_policy_and_terms() {
//        logger.info("************* Sign up Page Status 'the SignUp Page Status message will be seen as Please agree to the privacy policy and terms.' *****************");
//        signUppage.SignUpPageStatus();
//    }
//
//    @Then("the SignUp Page Status message will be seen as Organization already exists with email")
//    public void the_sign_up_page_status_message_will_be_seen_as_organization_already_exists_with_email() {
//        logger.info("************* Sign up Page Status 'the SignUp Page Status message will be seen as Organization already exists with email' *****************");
//        signUppage.SignUpPageStatus();
//    }


//    //Catalog Module --> Where we are Performing to add the Products and its related Submodule
//
//    @When("user will perform the actions to add the Category Manager")
//    public void user_will_perform_the_actions_to_add_the_category_manager() throws InterruptedException {
//        logger.info("*** Performing to add the category  ***");
//        catalog.catalogModule();
//    }
//
//    //Here Filling up all the fields of the category module
//    @When("user will fill all the fields of the category form")
//    public void user_will_fill_all_the_fields_of_the_category_form() throws InterruptedException {
//        logger.info("*** Filling up All the Fields in the Category Module  ***");
//        catalog.fillAllCategoryModule();
//    }
//
//    @When("user will try to create the lable")
//    public void user_will_try_to_create_the_lable() throws InterruptedException {
//        logger.info("*** creating the new label  ***");
//        catalog.CreateNewLabel();
//    }
//
//    @When("user will see the list of datas")
//    public void user_will_see_the_list_of_datas() throws InterruptedException {
//        logger.info("*** getting the list of Data  ***");
//        catalog.CategoryList();
//    }
//
//    @When("user will try to delete the category")
//    public void user_will_try_to_delete_the_category() throws InterruptedException {
//        logger.info("*** Deleting the one of the list  ***");
//
//        try {
//            catalog.categoryDelete();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//    @When("user will perform the enable or Disable Action")
//    public void user_will_perform_the_enable_or_disable_action() throws InterruptedException {
//        logger.info("*** Enable or Disable the Category ***");
//        catalog.categoryEnableOrDisable();
//    }


//    From Here we are working on the Products Module

//    @When("user will see the Pop up message saying to create the category First")
//    public void user_will_see_the_pop_up_message_saying_to_create_the_category_first() throws InterruptedException {
//        logger.info("*** Creating the Products Without Presents of the Category ***");
//        AddProducts.AddProductsPage();
//        AddProducts.AddProductsWithoutCategory();
//    }
//
//
//    @When("user will go to the Products and try to print the list of products")
//    public void user_will_go_to_the_products_and_try_to_print_the_list_of_products() throws InterruptedException {
//        logger.info("*** Print the List of Products ***");
//        AddProducts.ProductList();
//    }
//
//
//    @When("User will fill the Product Data  for Adding the New Product")
//    public void user_will_fill_the_product_data_for_adding_the_new_product() throws InterruptedException {
//        logger.info("*** Adding The New products ***");
//        AddProducts.AddProductsPage();
//        AddProducts.AddNewProducts();
//    }
//
//
//    @When("User will Add The New Product")
//    public void user_will_add_the_new_product() throws InterruptedException {
//        logger.info("*** If the category is Present in the Category Only Then User will create the Products ***");
//        AddProducts.AddProductsPage();
//        AddProducts.CategoryExistAddNewProduct();
//    }
//
//    @When("user will print the product Active , All and Inactive products in the Console")
//    public void user_will_print_the_product_active_all_and_inactive_products_in_the_console() throws InterruptedException {
//        logger.info("*** Print the All Products , Active Products , And In-Active Products Count ***");
//        AddProducts.PrintProductCardDetails();
//    }
//
//    @When("user will Test Action Active or Inactive")
//    public void user_will_test_action_active_or_inactive() throws InterruptedException {
//        AddProducts.productEnableOrDisable();
//    }

//    @When("The user will perform the action to edit the product")
//    public void the_user_will_perform_the_action_to_edit_the_product() throws InterruptedException {
//     AddProducts.productActionProductEdit();
//    }



}
