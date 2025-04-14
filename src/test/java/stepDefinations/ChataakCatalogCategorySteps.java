package stepDefinations;

import io.cucumber.java.en.When;
import io.qameta.allure.*;
import pageobjects.ChataakAddCatalogProducts;
import pageobjects.ChataakCatalogModulePage;

import java.io.IOException;
@Epic("Chataak Platform")
@Feature("Category Feature")
@Story("User will be on the Category Page")
@Severity(SeverityLevel.CRITICAL)
public class ChataakCatalogCategorySteps extends BaseClass {


    public ChataakCatalogCategorySteps() throws IOException {
        catalog = new ChataakCatalogModulePage(driver);
    }




    //Catalog Module --> Where we are Performing to add the Products and its related Submodule

    @When("user will perform the actions to add the Category Manager")
    public void user_will_perform_the_actions_to_add_the_category_manager() throws InterruptedException {
        logger.info("*** Performing to add the category  ***");
        catalog.catalogModule();
    }

    //Here Filling up all the fields of the category module
    @When("user will fill all the fields of the category form")
    public void user_will_fill_all_the_fields_of_the_category_form() throws InterruptedException {
        logger.info("*** Filling up All the Fields in the Category Module  ***");
        catalog.fillAllCategoryModule();
    }

    @When("user will try to create the lable")
    public void user_will_try_to_create_the_lable() throws InterruptedException {
        logger.info("*** creating the new label  ***");
        catalog.CreateNewLabel();
    }

    @When("user will see the list of datas")
    public void user_will_see_the_list_of_datas() throws InterruptedException {
        logger.info("*** getting the list of Data  ***");
        catalog.CategoryList();
    }

    @When("user will try to delete the category")
    public void user_will_try_to_delete_the_category() throws InterruptedException {
        logger.info("*** Deleting the one of the list  ***");

        try {
            catalog.categoryDelete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @When("user will perform the enable or Disable Action")
    public void user_will_perform_the_enable_or_disable_action() throws InterruptedException {
        logger.info("*** Enable or Disable the Category ***");
        catalog.categoryEnableOrDisable();
    }


    @When("user will perform the edit operation")
    public void user_will_perform_the_edit_operation() throws InterruptedException {
        logger.info("*** user will perform the edit operation For the Category ***");
        catalog.CategoryActionProductEdit();
    }


}
