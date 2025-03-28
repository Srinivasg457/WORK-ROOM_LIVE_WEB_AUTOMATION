package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinations.BaseClass;
import utilities.WaitHelper;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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
    By  category_name=By.xpath(configprop.getProperty("category_name"));
    By category_Description=By.xpath(configprop.getProperty("category_Description"));
    By category_label_DrpDown=By.xpath(configprop.getProperty("category_label_DrpDown"));
    By category_SubmitButton=By.xpath(configprop.getProperty("category_SubmitButton"));
    By category_Status=By.xpath(configprop.getProperty("category_Status"));
    By category_label_Options=By.xpath(configprop.getProperty("category_label_Options"));
    By category_label_textBox=By.xpath(configprop.getProperty("category_label_textBox"));
    By category_List=By.xpath(configprop.getProperty("category_List"));

    By cat_list_name=By.xpath(configprop.getProperty("cat_list_name"));
    By cat_list_desc=By.xpath(configprop.getProperty("cat_list_desc"));
    By cat_list_status=By.xpath(configprop.getProperty("cat_list_status"));
    By cat_list_imageURL=By.xpath(configprop.getProperty("cat_list_imageURL"));
    By cat_Action_Button=By.xpath(configprop.getProperty("cat_Action_Button"));
    By cat_Delete_Action=By.xpath(configprop.getProperty("cat_Delete_Action"));

    By cat_Delete_PopUp=By.xpath(configprop.getProperty("cat_Delete_PopUp"));
   By cat_Delete_Confirmtion=By.xpath(configprop.getProperty("cat_Delete_Confirmtion"));


    //Actions Method
    public void catalogModule() throws InterruptedException {
        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(catalog_CategoryManager).click();
        ldriver.findElement(Button_AddButton).click();
        Thread.sleep(2000);
        WebElement logo = ldriver.findElement(catagory_logo);
        waithelper.WaitForElement(logo, 10);
        if (logo.isDisplayed()) {
            System.out.println("Profile_Logo is Displayed");
            String filePath = System.getProperty("user.dir") + "/src/test/java/images/LC2D09P7_Image_369.jpg";
            ldriver.findElement(image_catogory).sendKeys(filePath);
            // upload_image.sendKeys(filePath);
            Assert.assertTrue(true);
        } else {
            System.out.println("profile logo is not Displyed");
            Assert.fail();
        }

        //category_name
        ldriver.findElement(category_name).click();
        ldriver.findElement(category_name).sendKeys(configprop.getProperty("catname"));
        WebElement text = ldriver.findElement(category_name);
        String catname = text.getAttribute("value");
        System.out.println(catname);
        //category description
        ldriver.findElement(category_Description).click();
        ldriver.findElement(category_Description).sendKeys(configprop.getProperty("catDesc"));

        //category label
//        ldriver.findElement(category_label).click();
//        ldriver.findElement(category_label).sendKeys(configprop.getProperty("catlabel"));
//        Thread.sleep(2000);
//         ldriver.findElement(category_label).click();


        //checking whether the submit button is Displayed and  enabled
        if (ldriver.findElement(category_SubmitButton).isDisplayed()) {
            if (ldriver.findElement(category_SubmitButton).isEnabled()) {
                ldriver.findElement(category_SubmitButton).click();
            } else {
                System.out.println("submit Button is Not Enabled");
            }
        } else {
            System.out.println("SubmitButton is Not Displayed");
        }

// Wait for the status element to be visible
        WebElement status = ldriver.findElement(category_Status);
        waithelper.WaitForElement(status, 10);

// Get the category status text and trim spaces
        String catstatus = status.getText().trim();
        System.out.println("Retrieved Category Status: " + catstatus);

// Expected status values
        String expectedStatus = (configprop.getProperty("catexiststatus") + catname).trim();
        String newCategoryStatus = configprop.getProperty("catnewstatus").trim();

// Log actual vs expected
        System.out.println("Actual Status: " + catstatus);
        System.out.println("Expected New Category Status: " + newCategoryStatus);
        System.out.println("Expected Existing Category Status: " + expectedStatus);

// Check conditions and assert accordingly
        if (catstatus.equalsIgnoreCase(newCategoryStatus)) {
            System.out.println("Category successfully added: " + catstatus);
            Assert.assertTrue(true);
        } else if (catstatus.equalsIgnoreCase(expectedStatus)) {
            System.out.println("Category already exists: " + catstatus);
            Assert.assertTrue(true);
        } else {
            System.out.println("Unexpected category status! Actual: " + catstatus +
                    ", Expected: " + newCategoryStatus + " or " + expectedStatus);
            Assert.fail("Unexpected category status: " + catstatus);
        }



    }


    //Here we will fill ll the fileds of the category module
    public void fillAllCategoryModule() throws InterruptedException {

        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(catalog_CategoryManager).click();
        ldriver.findElement(Button_AddButton).click();
        Thread.sleep(2000);
        WebElement logo = ldriver.findElement(catagory_logo);
        waithelper.WaitForElement(logo, 10);
        if (logo.isDisplayed()) {
            System.out.println("Profile_Logo is Displayed");
            String filePath = System.getProperty("user.dir") + "/src/test/java/images/LC2D09P7_Image_369.jpg";
            ldriver.findElement(image_catogory).sendKeys(filePath);
            // upload_image.sendKeys(filePath);
            Assert.assertTrue(true);
        } else {
            System.out.println("profile logo is not Displyed");
            Assert.fail();
        }

        //category_name
        ldriver.findElement(category_name).click();
        ldriver.findElement(category_name).sendKeys(configprop.getProperty("catname"));
        WebElement text = ldriver.findElement(category_name);
        String catname = text.getAttribute("value");
        System.out.println(catname);
        //category description
        ldriver.findElement(category_Description).click();
        ldriver.findElement(category_Description).sendKeys(configprop.getProperty("catDesc"));

        //category label Select Available Options
        ldriver.findElement(category_label_DrpDown).click();
        Thread.sleep(2000);
        ldriver.findElement(category_label_Options).click();



        //checking whether the submit button is Displayed and  enabled
        if (ldriver.findElement(category_SubmitButton).isDisplayed()) {
            if (ldriver.findElement(category_SubmitButton).isEnabled()) {
                ldriver.findElement(category_SubmitButton).click();
            } else {
                System.out.println("submit Button is Not Enabled");
            }
        } else {
            System.out.println("SubmitButton is Not Displayed");
        }

// Wait for the status element to be visible
        WebElement status = ldriver.findElement(category_Status);
        waithelper.WaitForElement(status, 10);

// Get the category status text and trim spaces
        String catstatus = status.getText().trim();
        System.out.println("Retrieved Category Status: " + catstatus);

// Expected status values
        String expectedStatus = (configprop.getProperty("catexiststatus") + catname).trim();
        String newCategoryStatus = configprop.getProperty("catnewstatus").trim();

// Log actual vs expected
        System.out.println("Actual Status: " + catstatus);
        System.out.println("Expected New Category Status: " + newCategoryStatus);
        System.out.println("Expected Existing Category Status: " + expectedStatus);

// Check conditions and assert accordingly
        if (catstatus.equalsIgnoreCase(newCategoryStatus)) {
            System.out.println("Category successfully added: " + catstatus);
            Assert.assertTrue(true);
        } else if (catstatus.equalsIgnoreCase(expectedStatus)) {
            System.out.println("Category already exists: " + catstatus);
            Assert.assertTrue(true);
        } else {
            System.out.println("Unexpected category status! Actual: " + catstatus +
                    ", Expected: " + newCategoryStatus + " or " + expectedStatus);
            Assert.fail("Unexpected category status: " + catstatus);
        }



    }



    //Here User will try to create a new label
    //Here we will fill ll the fileds of the category module
    public void CreateNewLabel() throws InterruptedException {

        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(catalog_CategoryManager).click();
        ldriver.findElement(Button_AddButton).click();
        Thread.sleep(2000);
        WebElement logo = ldriver.findElement(catagory_logo);
        waithelper.WaitForElement(logo, 10);
        if (logo.isDisplayed()) {
            System.out.println("Profile_Logo is Displayed");
            String filePath = System.getProperty("user.dir") + "/src/test/java/images/LC2D09P7_Image_369.jpg";
            ldriver.findElement(image_catogory).sendKeys(filePath);
            // upload_image.sendKeys(filePath);
            Assert.assertTrue(true);
        } else {
            System.out.println("profile logo is not Displyed");
            Assert.fail();
        }

        //category_name
        ldriver.findElement(category_name).click();
        ldriver.findElement(category_name).sendKeys(configprop.getProperty("catname"));
        WebElement text = ldriver.findElement(category_name);
        String catname = text.getAttribute("value");
        System.out.println(catname);
        //category description
        ldriver.findElement(category_Description).click();
        ldriver.findElement(category_Description).sendKeys(configprop.getProperty("catDesc"));

        //Create new label under category form

        WebElement label_Box=ldriver.findElement(category_label_textBox);
        Actions actions = new Actions(ldriver);

// Step 1: Click the dropdown
        actions.moveToElement(label_Box).click().perform();

// Step 2: Send Keys using Actions (sometimes bypasses React restrictions)
        actions.sendKeys(configprop.getProperty("labelname")).perform();
        actions.sendKeys(Keys.ENTER).perform();





        //checking whether the submit button is Displayed and  enabled
        if (ldriver.findElement(category_SubmitButton).isDisplayed()) {
            if (ldriver.findElement(category_SubmitButton).isEnabled()) {
                ldriver.findElement(category_SubmitButton).click();
            } else {
                System.out.println("submit Button is Not Enabled");
            }
        } else {
            System.out.println("SubmitButton is Not Displayed");
        }

// Wait for the status element to be visible
        WebElement status = ldriver.findElement(category_Status);
        waithelper.WaitForElement(status, 10);

// Get the category status text and trim spaces
        String catstatus = status.getText().trim();
        System.out.println("Retrieved Category Status: " + catstatus);

// Expected status values
        String expectedStatus = (configprop.getProperty("catexiststatus") + catname).trim();
        String newCategoryStatus = configprop.getProperty("catnewstatus").trim();

// Log actual vs expected
        System.out.println("Actual Status: " + catstatus);
        System.out.println("Expected New Category Status: " + newCategoryStatus);
        System.out.println("Expected Existing Category Status: " + expectedStatus);

// Check conditions and assert accordingly
        if (catstatus.equalsIgnoreCase(newCategoryStatus)) {
            System.out.println("Category successfully added: " + catstatus);
            Assert.assertTrue(true);
        } else if (catstatus.equalsIgnoreCase(expectedStatus)) {
            System.out.println("Category already exists: " + catstatus);
            Assert.assertTrue(true);
        } else {
            System.out.println("Unexpected category status! Actual: " + catstatus +
                    ", Expected: " + newCategoryStatus + " or " + expectedStatus);
            Assert.fail("Unexpected category status: " + catstatus);
        }

    }



    //Here User try to get the list of category list

    public void CategoryList() throws InterruptedException {

        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(catalog_CategoryManager).click();


        try {

            List<WebElement> list = ldriver.findElements(category_List);

            if (!list.isEmpty()) {  // Check if the list is not empty
                waithelper.WaitForElement(list.get(0), 20); // Wait for the first element
            } else {
                System.out.println("No elements found for category_List");
            }
            // Locate all rows in the MuiDataGrid table
            List<WebElement> rows = ldriver.findElements(category_List);

            for (WebElement row : rows) {
                // Extract the Name
                WebElement nameElement = row.findElement(cat_list_name);
                String name = nameElement.getText();

                // Extract the Description
                WebElement descElement = row.findElement(cat_list_desc);
                String description = descElement.getText();

                // Extract the Status
                WebElement statusElement = row.findElement(cat_list_status);
                String status = statusElement.getText();

                // Extract the Image URL
                WebElement imgElement = row.findElement(cat_list_imageURL);
                String imageUrl = imgElement.getAttribute("src");

                // Print the extracted data
                System.out.println("Name: " + name);
                System.out.println("Description: " + description);
                System.out.println("Status: " + status);
                System.out.println("Image URL: " + imageUrl);
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }



    public void categoryDelete() throws InterruptedException {
        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(catalog_CategoryManager).click();



        try {

            List<WebElement> list = ldriver.findElements(category_List);

            if (!list.isEmpty()) {  // Check if the list is not empty
                waithelper.WaitForElement(list.get(0), 20); // Wait for the first element
            } else {
                Assert.assertTrue(true);
                System.out.println("No elements found for category_List");
            }
            // Iterate through each row
            // Locate all rows in the MuiDataGrid table
            List<WebElement> rows = ldriver.findElements(category_List);
            for (WebElement row : rows) {
                try {
                    // Find the action button inside the current row
                    WebElement actionButton = row.findElement(cat_Action_Button);

                    // Click the action button
                    actionButton.click();

                    // Add a small delay to observe the click action (optional)
                    Thread.sleep(1000);

                    //click on the delete option
                    //ldriver.findElement(cat_Delete_Action).click();

                    List<WebElement> deleteButtons = ldriver.findElements(cat_Delete_Action);
                    for (WebElement button : deleteButtons) {
                        try {

                            waithelper.WaitForElement(button, 10);
                            button.click();

                            WebElement deletebutton = ldriver.findElement(cat_Delete_PopUp);
                            deletebutton.click();
                            WebElement OkayButton = ldriver.findElement(cat_Delete_Confirmtion);
                            OkayButton.click();

                            break; // Stop after first successful click
                        } catch (Exception e) {
                            System.out.println("Retrying click...");
                        }
                    }


                    System.out.println("Clicked action button in row: " + row.getAttribute("data-id"));

                } catch (Exception e) {
                    System.out.println("Failed to click action button in row: " + row.getAttribute("data-id"));
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("No data found");
            System.out.println(e.getMessage());
        }
    }
}
