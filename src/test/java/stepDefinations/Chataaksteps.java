package stepDefinations;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.ChataakLoginPage;
import pageobjects.ChataakStoresPage;

public class Chataaksteps {

    WebDriver driver;
    ChataakLoginPage lp;
    ChataakStoresPage sp;
    @Given("the user launches the Chrome browser")
    public void the_user_launches_the_chrome_browser() {
      System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver-linux64/chromedriver");
        driver=new ChromeDriver(); //launches the Chrome Driver
        driver.manage().window().maximize();
        lp= new ChataakLoginPage(driver);
        sp=new ChataakStoresPage(driver);
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



}
