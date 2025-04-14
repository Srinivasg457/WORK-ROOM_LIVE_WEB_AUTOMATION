package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.*;
import stepDefinations.BaseClass;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

public class ChataakWebApphooks extends BaseClass {

    @Before
    public void setup() throws IOException {
        // Reading the properties file
        configprop = new Properties();
        String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        FileInputStream configProfile = new FileInputStream(configPath);
        configprop.load(configProfile);


        // Logger setup
        logger = Logger.getLogger("ChataakWebApplication");
        String log4jPath = System.getProperty("user.dir") + "/src/test/resources/log4j.properties";
        PropertyConfigurator.configure(log4jPath);
        logger.setLevel(Level.DEBUG);


        String br = configprop.getProperty("browser"); //getting the browser name from config.properties file

        //Launching browser
        if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxdriverpath"));
            driver = new FirefoxDriver();
        } else if (br.equals("chrome")) {

            logger.info("************* Launching CHROME Browser *****************");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");
            String userDataDir = "/tmp/chrome-user-data-" + UUID.randomUUID();
            options.addArguments("--user-data-dir=" + userDataDir);



            System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
            driver = new ChromeDriver(options);
        } else if (br.equals("msedge")) {
            logger.info("************* Launching EDGE Browser *****************");
            System.setProperty("webdriver.edge.driver", configprop.getProperty("microsoftedgepath"));
            // Create EdgeOptions to start a fresh session
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--no-sandbox"); // Ensures Edge runs safely
            options.addArguments("--disable-dev-shm-usage"); // Fixes resource issues on Linux
            options.addArguments("--disable-gpu"); // Disables GPU rendering
            options.addArguments("--remote-allow-origins=*"); // Resolves security policy issues
            options.addArguments("--guest"); // Launches without user profile
            driver = new EdgeDriver(options); // Launch Edge
        }
        // Maximize the browser window
        logger.info("************* Browser Launched and Maximized *****************");
        driver.manage().window().maximize();


    }


//    @Before
//    public void setUp() throws IOException {
//        lp = new ChataakLoginPage(driver);
//        sp = new ChataakStoresPage(driver);
//        signUppage = new ChataakSignUpPage(driver);
//        catalog = new ChataakCatalogModulePage(driver);
//        AddProducts = new ChataakAddCatalogProducts(driver);
//    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                // Take a screenshot if scenario fails
                if (driver != null) {
                    TakesScreenshot ts = (TakesScreenshot) driver;
                    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

                    scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
                    // Also attach to Allure report
                    //  Allure.addAttachment("Allure Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");


                }
            }
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
//        finally {
//            if (driver != null) {
//                logger.info("************* Quitting Browser *****************");
//                driver.quit(); // This closes all windows and ends the WebDriver session
//                logger.info("************* Browser Closed Successfully *****************");
//            }
//        }
    }


}
