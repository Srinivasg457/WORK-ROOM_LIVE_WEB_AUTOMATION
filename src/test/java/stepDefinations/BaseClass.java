package stepDefinations;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class BaseClass {
    public WebDriver driver;

    public static String randomString(){
        String generatedString1= RandomStringUtils.randomAlphanumeric(8);
      return(generatedString1);
    }

}
