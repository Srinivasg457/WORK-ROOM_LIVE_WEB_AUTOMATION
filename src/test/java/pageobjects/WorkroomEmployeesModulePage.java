package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinations.BaseClass;
import utilities.EmailReading;
import utilities.WaitHelper;

import javax.mail.AuthenticationFailedException;
import javax.mail.Session;
import javax.mail.Store;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static stepDefinations.BaseClass.randomString;


public class WorkroomEmployeesModulePage {

  public EmailReading emailu;
    public WebDriver ldriver;
    WaitHelper waithelper;

    public static Properties configprop;

    //constructor
    public WorkroomEmployeesModulePage(WebDriver rdriver) throws IOException {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        waithelper = new WaitHelper(ldriver);

    }

    //xpath identification

    {
//        try {
//            configprop = new Properties();
//            // Use the classpath to load the properties file
//            InputStream configProfile = getClass().getClassLoader().getResourceAsStream("config.properties");
//
//            if (configProfile == null) {
//                throw new RuntimeException("config.properties file not found in the classpath!");
//            }
//
//            configprop.load(configProfile);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to load properties file!");
//        }


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
    By EmploeesModuleSideMenu = By.xpath(configprop.getProperty("EmploeesModuleSideMenu"));
    By AddNewEmployeeButton = By.xpath(configprop.getProperty("AddNewEmployee_Button"));
    By DepartmentDropDown = By.xpath(configprop.getProperty("EmploeeDepartmentDropDown"));
    By dropdownoptions = By.cssSelector(configprop.getProperty("dropdownoptions"));
    By EmployeeNameTxtBox = By.xpath(configprop.getProperty("EmployeeNameTxtBox"));
    By EmployeeEmailTxtBox = By.xpath(configprop.getProperty("EmployeeEmailTxtBox"));
    By EmployeePhoneNumberTxtBox = By.xpath(configprop.getProperty("EmployeePhoneNumberTxtBox"));
    By EmployeeAddressTxtBox = By.xpath(configprop.getProperty("EmployeeAddressTxtBox"));
    By EmployeeCityTxtBox = By.xpath(configprop.getProperty("EmployeeCityTxtBox"));
    By EmployeeCountryDropDown = By.xpath(configprop.getProperty("EmployeeCountryDropDown"));
    By CountryOptions = By.xpath(configprop.getProperty("CountryOptions"));
    By CountryList = By.xpath(configprop.getProperty("CountryList"));
    By EmployeeShowRadioButton = By.xpath(configprop.getProperty("EmployeeShowRadioButton"));
    By EmployeeHideRadioButton = By.xpath(configprop.getProperty("EmployeeHideRadioButton"));
    By EmployeeImage=By.xpath(configprop.getProperty("EmployeeImage"));
    By SaveButton=By.xpath(configprop.getProperty("SaveButton"));
    By SuccessMessage=By.xpath(configprop.getProperty("SuccessMessage"));
    By ExistedEmail=By.xpath(configprop.getProperty("ExistedEmail"));
    By Toastmessagerightcorner=By.xpath(configprop.getProperty("Toastmessagerightcorner"));
    By ToastMessages=By.xpath(configprop.getProperty("ToastMessages"));
    By EmployeePasswordUpdate=By.xpath(configprop.getProperty("EmployeePasswordUpdate"));


    //  This Method helps to click the employeeModule
    public void EmployeesPage() throws InterruptedException {
        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);

        WebElement employeeModule = waithelper.WaitForElement1(EmploeesModuleSideMenu, 10);
        employeeModule.click();

    }


    //Add Employee Button Click
    public void addEmployeeButton() {
        WebElement addEmployeeButton = waithelper.WaitForElement1(AddNewEmployeeButton, 10);
        addEmployeeButton.click();
    }

    //DropDown Selecting for the Department
    public void departmentDropDown() {
        WebElement depDropdown = waithelper.WaitForElement1(DepartmentDropDown, 10);
        depDropdown.click();

        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownoptions));

        List<WebElement> options = ldriver.findElements(dropdownoptions);

        if (options.size() == 0) {
            System.out.println("No options available in dropdown.");
            ldriver.findElement(By.tagName("body")).click();
        } else {
            // If first option is "Select", skip it
            int startIndex = options.get(0).getText().trim().equalsIgnoreCase("Select") ? 1 : 0;

            if (options.size() <= startIndex) {
                System.out.println("No valid options available in dropdown.");
                ldriver.findElement(By.tagName("body")).click();
            } else {
                Random rand = new Random();
                int randomIndex = startIndex + rand.nextInt(options.size() - startIndex);

                options = ldriver.findElements(dropdownoptions); // re-fetch to avoid stale elements

                WebElement selectedOption = options.get(randomIndex);
                String selectedText = selectedOption.getText();
                selectedOption.click();

                System.out.println("Randomly selected: " + selectedText);

                // Print all dropdown options
                for (WebElement printingOption : options) {
                    System.out.println("The DropDown Option: " + printingOption.getText());
                }
            }


        }


    }

    //Sending Employee Name
    public void employeename() {
        WebElement EmployeeName = waithelper.WaitForElement1(EmployeeNameTxtBox, 10);
        EmployeeName.click();
        EmployeeName.clear();
        EmployeeName.sendKeys(configprop.getProperty("Employeename"));
    }

    //Sending EmployeeEmail
    public void EmployeeEmail() {
        WebElement EmployeeEmail = waithelper.WaitForElement1(EmployeeEmailTxtBox, 10);
        EmployeeEmail.click();
        EmployeeEmail.clear();
        EmployeeEmail.sendKeys(configprop.getProperty("EmployeeEmail"));
        //EmployeeEmail.sendKeys(randomString()+"@gmail.com");
    }

    //Sending Employee Phone Number
    public void employeePhoneNumber() {
        WebElement EmployeePhoneNumber = waithelper.WaitForElement1(EmployeePhoneNumberTxtBox, 10);
        EmployeePhoneNumber.click();
        EmployeePhoneNumber.clear();
        EmployeePhoneNumber.sendKeys(configprop.getProperty("EmployeePhoneNumber"));
    }

    //Sending Employee Address
    public void employeeAddress() {
        WebElement EmployeeAddress = waithelper.WaitForElement1(EmployeeAddressTxtBox, 10);
        EmployeeAddress.click();
        EmployeeAddress.clear();
        EmployeeAddress.sendKeys(configprop.getProperty("EmployeeAddress"));
    }

    //Sending Employee city
    public void EmployeeCity() {
        WebElement EmployeeCity = waithelper.WaitForElement1(EmployeeCityTxtBox, 10);
        EmployeeCity.click();
        EmployeeCity.clear();
        EmployeeCity.sendKeys(configprop.getProperty("EmployeeCity"));
    }

    //Select Country of the Employee
    public void employeeCountry() {

        WebElement EmployeeCountry = waithelper.WaitForElement1(EmployeeCountryDropDown, 10);
        EmployeeCountry.click();

        // Find and click the India option

        waithelper.WaitForElement1(CountryOptions, 10);

        List<WebElement> contries = ldriver.findElements(CountryList);


        // Print all countries
        System.out.println("Country List:");
        for (WebElement co : contries) {
            String countryName = co.getText().trim();
            System.out.println("- " + countryName);

            // Select 'India' if found
            if (countryName.equalsIgnoreCase("India")) {
                co.click();
                System.out.println("Selected country: India");
                break;
            }


        }

    }

    //Select Show Radio button Show
    public void showRadiobutton() {
        WebElement ShowRadioButton = waithelper.WaitForElement1(EmployeeShowRadioButton, 10);
        ShowRadioButton.click();
    }


    //Select Hide Radio button Show
    public void hideRadioButton() {
        WebElement HideRadioButton = waithelper.WaitForElement1(EmployeeHideRadioButton, 10);
        HideRadioButton.click();
    }

    public void uploadEmployeeImage(){
        WebElement image= waithelper.WaitForElement1(EmployeeImage,10);
        String filePath = System.getProperty("user.dir") + "/src/test/java/images/pexels-justin-shaifer-501272-1222271.jpg";
        image.sendKeys(filePath);

    }

    public void saveButton(){
        WebElement Save= waithelper.WaitForElement1(SaveButton,10);
        Save.click();
    }

//    public void statusMessage(){
//
//        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.or(
//                ExpectedConditions.visibilityOfElementLocated(SuccessMessage),
//                ExpectedConditions.visibilityOfElementLocated(ExistedEmail)
//        ));
//
//
//        if(success.isDisplayed()  ){
//            Assert.assertTrue(true);
//        }
//        else if (emailexisted.isDisplayed()) {
//            Assert.assertTrue(true);
//            System.out.println(emailexisted.getText());
//
//        } else{
//            Assert.fail("Unexpected message");
//        }
//    }



    public void statusMessage() {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));

        try {
            // Wait until at least one toast message is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(Toastmessagerightcorner));

            // Now collect all visible toast messages
            List<WebElement> toastMessages = ldriver.findElements(ToastMessages);

            if (toastMessages.isEmpty()) {
                System.out.println("❌ No toast messages found.");
                Assert.fail("No toast messages appeared.");
            }
            boolean toastFound = false;
            // Print and assert each toast message
            for (WebElement toast : toastMessages) {
                if (toast.isDisplayed()) {
                    String message = toast.getText();
                    System.out.println("🔔 Toast Message: " + message);
                    Assert.assertTrue(message,true);

                    // Optionally assert specific expected messages
                    Assert.assertFalse("Toast message is empty", message.trim().isEmpty());
                    // Set flag to mark that at least one toast was found
                    toastFound = true;
                }
            }

            if(toastFound==true){
                System.out.println("The Toast found");
                Assert.assertTrue(true);
            }
            else{
                System.out.println("Toast didnt found");
                Assert.fail();
            }

        } catch (TimeoutException e) {
            Assert.fail("❌ Toast messages did not appear in expected time.");
        }
    }



    public void verifyInvitationEmail() {
        try {
            String host = configprop.getProperty("email.host");
            String user = configprop.getProperty("email.username");
            String password = configprop.getProperty("email.password");
            String subject = configprop.getProperty("email.subject.keyword");

            System.out.println("Attempting to retrieve invitation email...");
            String invitationLink = EmailReading.getInvitationLink(host, user, password, subject, 60);




            if (invitationLink != null) {
                // Open in new tab using Selenium
                ((JavascriptExecutor)ldriver).executeScript("window.open('" + invitationLink + "','_blank');");

                // Switch to new tab
                ArrayList<String> tabs = new ArrayList<>(ldriver.getWindowHandles());
                ldriver.switchTo().window(tabs.get(1));

                // Verify page loaded
                WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.urlContains("work-room.io"));
            } else {
                Assert.fail("No invitation link found");
            }

        } catch (Exception e) {
            System.err.println("Error verifying invitation email: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Failed to verify invitation email: " + e.getMessage());
        }
    }


    public void switchToNewTab() {
        String originalHandle = ldriver.getWindowHandle();

        // Wait for a new tab to open
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        // Switch to the new tab
        for (String handle : ldriver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                ldriver.switchTo().window(handle);
                System.out.println("🔁 Switched to new tab: " + ldriver.getTitle());

                try {
                    // Wait and click the Show Radio Button
                    WebElement PasswordUpdate = waithelper.WaitForElement1(EmployeePasswordUpdate, 10);
                    PasswordUpdate.click();
                    PasswordUpdate.clear();
                    PasswordUpdate.sendKeys(configprop.getProperty("updatepassword"));
                    System.out.println("✅ Clicked Show Radio Button in new tab.");
                } catch (TimeoutException e) {
                    throw new RuntimeException("❌ Show Radio Button not found in the new tab.", e);
                }

                return;
            }
        }

        throw new RuntimeException("❌ New tab not found after waiting.");
    }
















}
