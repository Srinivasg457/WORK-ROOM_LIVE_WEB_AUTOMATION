package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ChataakSignUpPage;
import pageobjects.ChataakStoresPage;

import java.io.IOException;

public class ChataakStoresStoreSteps extends BaseClass {


    public ChataakStoresStoreSteps() throws IOException {
        sp = new ChataakStoresPage(driver);
    }
    //Adding new store

    @When("user will perform the actions to add the store")
    public void user_will_perform_the_actions_to_add_the_store() throws InterruptedException {
        logger.info("************* Adding The Store information *****************");
        sp.Addstore();
        logger.info("************* Checking The Added Store Confirmation Message *****************");
        sp.status();
    }


    @Then("the user will get the count of Total , Active  and Inactive stores count")
    public void the_user_will_get_the_count_of_total_active_and_inactive_stores_count() throws InterruptedException {
        logger.info("****** Getting Total , Active and Inactive Stores Count");
        sp.StoreCardCount();
    }


    @Then("the user will see the list of Stores")
    public void the_user_will_see_the_list_of_stores() throws InterruptedException {
        logger.info("*** User will try to see the List of Store ****");
        sp.StoreList();
    }


}
