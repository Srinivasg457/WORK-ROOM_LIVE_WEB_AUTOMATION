package stepDefinations;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageobjects.ChataakCatalogModulePage;
import pageobjects.ChataakLoginPage;
import pageobjects.ChataakSignUpPage;
import pageobjects.ChataakStoresPage;

import java.util.Properties;


public class BaseClass {
    public WebDriver driver;
    public ChataakLoginPage lp;
    public ChataakStoresPage sp;
    public ChataakSignUpPage signUppage;
    public static Logger logger;
    public Properties configprop;
    public ChataakCatalogModulePage catalog;









    public static String randomString(){
        String generatedString1= RandomStringUtils.randomAlphanumeric(8);
      return(generatedString1);
    }
    //random numbers

    public static String randomNumber() {
        return RandomStringUtils.randomNumeric(10); // Generates an 8-digit random number
    }

}
