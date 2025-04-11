package stepDefinations;

import io.cucumber.java.en.When;
import io.qameta.allure.*;
import pageobjects.ChataakAddCatalogProducts;

import java.io.IOException;

//@Epic("Chataak Platform")
//@Feature("SignUp Feature")
//@Story("User will be on the product page")

/// /@Step("User  will perform on the product page")
//@Severity(SeverityLevel.CRITICAL)
@Epic("Chataak Platform")
@Feature("SignUp Feature")
@Story("User will be on the product page")
@Severity(SeverityLevel.CRITICAL)
public class ChataakCatalogProductSteps extends BaseClass {


    public ChataakCatalogProductSteps() throws IOException {
         AddProducts = new ChataakAddCatalogProducts(driver);
    }


    @Step("user will see the Pop up message saying to create the category First")
    @When("user will see the Pop up message saying to create the category First")
    public void user_will_see_the_pop_up_message_saying_to_create_the_category_first() throws InterruptedException {
        logger.info("*** Creating the Products Without Presents of the Category ***");
        AddProducts.AddProductsPage();
        AddProducts.AddProductsWithoutCategory();
    }


    @Step("user will go to the Products and try to print the list of products")
    @When("user will go to the Products and try to print the list of products")
    public void user_will_go_to_the_products_and_try_to_print_the_list_of_products() throws InterruptedException {
        logger.info("*** Print the List of Products ***");
        AddProducts.ProductList();
    }


    @Step("User will fill the Product Data  for Adding the New Product")
    @When("User will fill the Product Data  for Adding the New Product")
    public void user_will_fill_the_product_data_for_adding_the_new_product() throws InterruptedException {
        logger.info("*** Adding The New products ***");
        AddProducts.AddProductsPage();
        AddProducts.AddNewProducts();
    }


    @Step("User will Add The New Product")
    @When("User will Add The New Product")
    public void user_will_add_the_new_product() throws InterruptedException {
        logger.info("*** If the category is Present in the Category Only Then User will create the Products ***");
        AddProducts.AddProductsPage();
        AddProducts.CategoryExistAddNewProduct();
    }

    @Step("user will print the product Active , All and Inactive products in the Console")
    @When("user will print the product Active , All and Inactive products in the Console")
    public void user_will_print_the_product_active_all_and_inactive_products_in_the_console() throws InterruptedException {
        logger.info("*** Print the All Products , Active Products , And In-Active Products Count ***");
        AddProducts.PrintProductCardDetails();
    }

    @Step("user will Test Action Active or Inactive")
    @When("user will Test Action Active or Inactive")
    public void user_will_test_action_active_or_inactive() throws InterruptedException {
        logger.info("*** user will Test Action Active or Inactive ***");
        AddProducts.productEnableOrDisable();
    }

    @Step("The user will perform the action to edit the product")
    @When("The user will perform the action to edit the product")
    public void the_user_will_perform_the_action_to_edit_the_product() throws InterruptedException {
        logger.info("*** The user will perform the action to edit the product ***");
        AddProducts.productActionProductEdit();
    }


}
