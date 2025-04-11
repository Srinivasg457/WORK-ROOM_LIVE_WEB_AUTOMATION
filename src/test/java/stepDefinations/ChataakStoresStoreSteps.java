package stepDefinations;

import io.cucumber.java.en.When;
import pageobjects.ChataakSignUpPage;
import pageobjects.ChataakStoresPage;

import java.io.IOException;

public class ChataakStoresStoreSteps extends BaseClass{


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
}
