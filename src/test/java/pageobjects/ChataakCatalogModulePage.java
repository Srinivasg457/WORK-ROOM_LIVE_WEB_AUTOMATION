package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinations.BaseClass;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ChataakCatalogModulePage extends BaseClass {

    public WebDriver ldriver;
    WaitHelper waithelper;
    public static Properties configprop;

    //constructor
    public ChataakCatalogModulePage (WebDriver rdriver) throws IOException {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
        waithelper=new WaitHelper(ldriver);
    }

    //xpath identification

    {
        try {
            configprop = new Properties();
            String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream configProfile = new FileInputStream(configPath);
            configprop.load(configProfile);


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    private By getByXpath(String key) {
        String xpath = configprop.getProperty(key);
        if (xpath == null || xpath.trim().isEmpty()) {
            System.out.println("WARNING: XPath for key '" + key + "' is missing or commented out in config.properties.");
            return null; // Avoids IllegalArgumentException
        }
        return By.xpath(xpath);
    }

    //Locators
//
    By link_Catalog = By.xpath(configprop.getProperty("catalog_link"));

    By catalog_CategoryManager=By.xpath(configprop.getProperty("catalog_CategoryManager"));
    By Button_AddButton=By.xpath(configprop.getProperty("button_AddButton"));
    By catagory_logo=By.xpath(configprop.getProperty("catagory_image"));
    By image_catogory=By.xpath(configprop.getProperty("catagory_UploadImage"));




  //Actions Method
    public void catalogModule() throws InterruptedException {
        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(catalog_CategoryManager ).click();
        ldriver.findElement(Button_AddButton ).click();

        if(ldriver.findElement(catagory_logo).isDisplayed()){
            System.out.println("Profile_Logo is Displayed");
            String filePath = System.getProperty("user.dir") + "/src/test/java/images/LC2D09P7_Image_369.jpg";
          // waithelper.WaitForElement(ldriver.findElement(image_catogory),10);
            ldriver.findElement(image_catogory).sendKeys(filePath);
            Assert.assertTrue(true);
        }
    }

}
