package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinations.BaseClass;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChataakCatalogModulePage extends BaseClass {

    public WebDriver ldriver;
    WaitHelper waithelper;

    public static Properties configprop;

    //constructor
    public ChataakCatalogModulePage(WebDriver rdriver) throws IOException {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        waithelper = new WaitHelper(ldriver);

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

    By catalog_CategoryManager = By.xpath(configprop.getProperty("catalog_CategoryManager"));
    By Button_AddButton = By.xpath(configprop.getProperty("button_AddButton"));
    By catagory_logo = By.xpath(configprop.getProperty("catagory_image"));
    By image_catogory = By.xpath(configprop.getProperty("catagory_UploadImage"));
    By category_name = By.xpath(configprop.getProperty("category_name"));
    By category_Description = By.xpath(configprop.getProperty("category_Description"));
    By category_label_DrpDown = By.xpath(configprop.getProperty("category_label_DrpDown"));
    By category_SubmitButton = By.xpath(configprop.getProperty("category_SubmitButton"));
    By category_Status = By.xpath(configprop.getProperty("category_Status"));
    By category_label_Options = By.xpath(configprop.getProperty("category_label_Options"));
    By category_label_textBox = By.xpath(configprop.getProperty("category_label_textBox"));
    By category_List = By.xpath(configprop.getProperty("category_List"));

    By cat_list_name = By.xpath(configprop.getProperty("cat_list_name"));
    By cat_list_desc = By.xpath(configprop.getProperty("cat_list_desc"));
    By cat_list_status = By.xpath(configprop.getProperty("cat_list_status"));
    By cat_list_imageURL = By.xpath(configprop.getProperty("cat_list_imageURL"));
    By cat_Action_Button = By.xpath(configprop.getProperty("cat_Action_Button"));
    By cat_Delete_Action = By.xpath(configprop.getProperty("cat_Delete_Action"));
    By cat_edit_Action = By.xpath(configprop.getProperty("cat_edit_Action"));

    // Here we are finding thexpath for the Edit category Page
    By Edit_Category_Name = By.xpath(configprop.getProperty("Edit_Category_Name"));
    By Edit_Category_Description = By.xpath(configprop.getProperty("Edit_Category_Description"));
    By Edit_Category_label = By.xpath(configprop.getProperty("Edit_Category_label"));
    By Edit_category_Label_Option = By.xpath(configprop.getProperty("Edit_category_Label_Option"));
    By Edit_category_Parent_Category = By.xpath(configprop.getProperty("Edit_category_Parent_Category"));
    By Edit_Category_Parent_Label_Option = By.xpath(configprop.getProperty("Edit_Category_Parent_Label_Option"));
    By Edit_Category_Logo = By.xpath(configprop.getProperty("Edit_Category_Logo"));
    By Edit_Category_Upload_Image = By.xpath(configprop.getProperty("Edit_Category_Upload_Image"));
    By Edit_Category_UpdateButton = By.xpath(configprop.getProperty("Edit_Category_UpdateButton"));
    By Edit_Category_page_Status = By.xpath(configprop.getProperty("Edit_Category_page_Status"));

    By category_Action_List = By.xpath(configprop.getProperty("category_Action_List"));

    By cat_Delete_PopUp = By.xpath(configprop.getProperty("cat_Delete_PopUp"));
    By cat_Delete_Confirmtion = By.xpath(configprop.getProperty("cat_Delete_Confirmtion"));


    //to perform the enable or diable Actions
    By Category_Active_Status = By.xpath(configprop.getProperty("Category_Active_Status"));
    By Category_Inactive_Status = By.xpath(configprop.getProperty("Category_Inactive_Status"));

    By category_Enable = By.xpath(configprop.getProperty("category_Enable"));
    By category_Disable = By.xpath(configprop.getProperty("category_Disable"));


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
            String filePath = System.getProperty("user.dir") + "/src/test/java/images/Dell.jpg";
            //String filePath="/home/limitscale/WorkingProject/Live_ChataakProjectWebautomation/src/test/java/images/Dell.jpg";

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
            String filePath = System.getProperty("user.dir") + "/src/test/java/images/Picture-01.png";
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
            String filePath = System.getProperty("user.dir") + "/src/test/java/images/Dell.jpg";
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

        WebElement label_Box = ldriver.findElement(category_label_textBox);
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


    public void categoryEnableOrDisable() throws InterruptedException {
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


                    List<WebElement> Disable = ldriver.findElements(category_Disable);
                    for (WebElement button : Disable) {
                        try {

                            waithelper.WaitForElement(button, 10);
                            button.click();

//                            WebElement deletebutton = ldriver.findElement(cat_Delete_PopUp);
//                            deletebutton.click();
//                            WebElement OkayButton = ldriver.findElement(cat_Delete_Confirmtion);
//                            OkayButton.click();

                            break; // Stop after first successful click
                        } catch (Exception e) {
                            System.out.println("Retrying click...");
                        }
                    }


                    List<WebElement> enable = ldriver.findElements(category_Enable);
                    for (WebElement button : enable) {
                        try {

                            waithelper.WaitForElement(button, 10);
                            button.click();

//                            WebElement deletebutton = ldriver.findElement(cat_Delete_PopUp);
//                            deletebutton.click();
//                            WebElement OkayButton = ldriver.findElement(cat_Delete_Confirmtion);
//                            OkayButton.click();

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


//    public void CategoryEdit() throws InterruptedException {
//        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Thread.sleep(5000);
//        ldriver.findElement(link_Catalog).click();
//        ldriver.findElement(catalog_CategoryManager).click();
//
//
//        try {
//
//            List<WebElement> list = ldriver.findElements(category_List);
//
//            if (!list.isEmpty()) {  // Check if the list is not empty
//                waithelper.WaitForElement(list.get(0), 20); // Wait for the first element
//            } else {
//                Assert.assertTrue(true);
//                System.out.println("No elements found for category_List");
//            }
//            // Iterate through each row
//            // Locate all rows in the MuiDataGrid table
//            List<WebElement> rows = ldriver.findElements(category_List);
//            for (WebElement row : rows) {
//                try {
//                    // Find the action button inside the current row
//                    WebElement actionButton = row.findElement(cat_Action_Button);
//
//                    // Click the action button
//                    actionButton.click();
//
//                    // Add a small delay to observe the click action (optional)
//                    Thread.sleep(1000);
//
//                    //click on the delete option
//                    //ldriver.findElement(cat_Delete_Action).click();
//
//
//                    List<WebElement> Editbutton = ldriver.findElements(cat_edit_Action);
//                    for (WebElement Edit : Editbutton) {
//                        try {
//
//                            waithelper.WaitForElement(Edit, 10);
//                            Edit.click();
//
//
//                            WebElement EditCategoryName = waithelper.WaitForElement1(Edit_Category_Name, 10);
//                            Actions editactions = new Actions(ldriver);
//                            editactions.moveToElement(EditCategoryName).click().perform();
//                            return; // Exit after first successful edit
//
//                        } catch (Exception e) {
//                            System.out.println("Retrying click...");
//                        }
//                    }
//
//                    //                  List<WebElement> enable = ldriver.findElements(category_Enable);
////                for (WebElement button : enable) {
////                    try {
////
////                        waithelper.WaitForElement(button, 10);
////                        button.click();
////
//////                            WebElement deletebutton = ldriver.findElement(cat_Delete_PopUp);
//////                            deletebutton.click();
//////                            WebElement OkayButton = ldriver.findElement(cat_Delete_Confirmtion);
//////                            OkayButton.click();
////
////                        break; // Stop after first successful click
////                    } catch (Exception e) {
////                        System.out.println("Retrying click...");
////                    }
////                }
//
//
//                    System.out.println("Clicked action button in row: " + row.getAttribute("data-id"));
//                    break; // Stop after the first successful row action
//                } catch (Exception e) {
//                    System.out.println("Failed to click action button in row: " + row.getAttribute("data-id"));
//                    e.printStackTrace();
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("No data found");
//            System.out.println(e.getMessage());
//        }
//    }


    /// //////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void CategoryActionProductEdit() throws InterruptedException {


        ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);
        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(catalog_CategoryManager).click();


        try {
            WebElement categorylist = waithelper.WaitForElement1(category_List, 10);
            List<WebElement> rows = ldriver.findElements(category_List);

            if (rows.isEmpty()) {
                System.out.println("No products found.");
                return;
            }

            for (WebElement row : rows) {
                try {
                    WebElement actionButton = row.findElement(cat_Action_Button);
                    actionButton.click();
                    Thread.sleep(1000);

                    try {
                        List<WebElement> menuItems = ldriver.findElements(By.cssSelector("ul[role='menu'] li[role='menuitem']"));
                        int count = 0;
                        for (WebElement item : menuItems) {
                            System.out.println(item.getText().trim());
                            count++;
                            if (count == 3) break;
                        }
                    } catch (Exception e) {
                        System.out.println("Error reading action menu: " + e.getMessage());
                    }

                    List<WebElement> editButtons = ldriver.findElements(cat_edit_Action);
                    for (WebElement editButton : editButtons) {
                        try {
                            waithelper.WaitForElement(editButton, 10);
                            editButton.click();


                            //  Perform the actual edit right here
                            performCategorEdit();
                            System.out.println("Edited Catalog in row: " + row.getAttribute("data-id"));
                            return; // Exit after first successful edit
                        } catch (Exception e) {
                            System.out.println("Retrying edit click...");
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Failed to click action button in row: " + row.getAttribute("data-id"));
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println("No data found: ");
        }
    }


//Here we are Filling up or trying to edit the  Product
// And calling this Method  inside the PRODUCT_EDIT METHOD
//private void performCategorEdit() {
//    try {
//        // 1. Editing/Updating The  Product Code
//        WebElement EditcategoryName = waithelper.WaitForElement1(Edit_Category_Name, 10);
//
//        Actions actions = new Actions(ldriver);
//        actions.moveToElement(EditcategoryName).click().perform();
//        EditcategoryName.clear();
//        EditcategoryName.sendKeys(configprop.getProperty("EditcategoryName"));
//
//
//        // 2. Editing/Updating The Category Description
//        WebElement EditCategoryDescription=waithelper.WaitForElement1(Edit_Category_Description,10);
//        EditCategoryDescription.click();
//        EditCategoryDescription.clear();
//        EditCategoryDescription.sendKeys("EditCategoryDescription");
//
//
//       WebElement EditCategorylabel= waithelper.WaitForElement1(Edit_Category_label,10);
//        EditCategorylabel.click();
//
//        Thread.sleep(1000); // Optional wait for dropdown animation
//
//// Step 2: Locate dropdown options
//        List<WebElement> options = ldriver.findElements(Edit_category_Label_Option); // This should be: By.cssSelector("div[role='option']")
//
//        if (!options.isEmpty()) {
//            Random rand = new Random();
//            int randomIndex = rand.nextInt(options.size()); // Pick a random index
//
//            WebElement randomOption = options.get(randomIndex);
//
//            // Ensure it's visible and interactable
//            ((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", randomOption);
//            Thread.sleep(500); // Allow for scroll animation or overlay to finish
//
//            try {
//                randomOption.click(); // Try standard click first
//            } catch (ElementClickInterceptedException e) {
//                // Fallback to JS click if intercepted
//                ((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", randomOption);
//            }
//
//            System.out.println("Randomly selected option: " + randomOption.getText());
//            return; // Exit the method after successful selection
//        } else {
//            System.out.println("No dropdown options found!");
//        }
//
//
//
//
//        WebElement dropdownInput = waithelper.WaitForElement1(Edit_category_Parent_Category, 10);
//        dropdownInput.click();
////        Actions actions = new Actions(ldriver);
//    //    actions.moveToElement(dropdownInput).click().perform();

    /// /// Step 2: Fetch all dropdown options
    /// /        List<WebElement> options1 = ldriver.findElements(Edit_Category_Parent_Label_Option);
    /// /
    /// /        if (!options1.isEmpty()) {
    /// /            Random rand = new Random();
    /// /            int randomIndex1 = rand.nextInt(options1.size());
    /// /            WebElement randomOption1 = options.get(randomIndex1);
    /// /
    /// /            ((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", randomOption1);
    /// /            Thread.sleep(500);
    /// /
    /// /            try {
    /// /                randomOption1.click();
    /// /            } catch (ElementClickInterceptedException e) {
    /// /                ((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", randomOption1);
    /// /            }
    /// /
    /// /            System.out.println("Randomly selected option: " + randomOption1.getText());
    /// /            return; // Exit after one successful selection
    /// /        } else {
    /// /            System.out.println("No dropdown options found!");
    /// /        }
//
//
//
//
//    } catch (Exception e) {
//        System.out.println("Failed to update Category Data: " + e.getMessage());
//    }
//}
    private void performCategorEdit() {
        try {

            Thread.sleep(3000);
            WebElement logo = ldriver.findElement(Edit_Category_Logo);
            waithelper.WaitForElement(logo, 10);
            if (logo.isDisplayed()) {
                System.out.println("Profile_Logo is Displayed");
                String filePath = System.getProperty("user.dir") + "/src/test/java/images/Dell.jpg";
                ldriver.findElement(Edit_Category_Upload_Image).sendKeys(filePath);
                // upload_image.sendKeys(filePath);
                Assert.assertTrue(true);
            } else {
                System.out.println("profile logo is not Displyed");
                Assert.fail();
            }


            // Step 1: Edit Category Name
            WebElement editCategoryName = waithelper.WaitForElement1(Edit_Category_Name, 10);
            //new Actions(ldriver).moveToElement(editCategoryName).build().perform();
            Actions newactions = new Actions(ldriver);
            newactions.moveToElement(editCategoryName).click().perform();
            editCategoryName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            editCategoryName.sendKeys(Keys.DELETE);
            editCategoryName.sendKeys(configprop.getProperty("EditcategoryName"));
            String innertext_EditCategoryName = editCategoryName.getAttribute("value");
            System.out.println("inner text value of Category name of edit page : =" + innertext_EditCategoryName);


            // Step 2: Edit Category Description
            WebElement editCategoryDescription = waithelper.WaitForElement1(Edit_Category_Description, 10);

            newactions.moveToElement(editCategoryDescription).click().perform();
            editCategoryDescription.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            editCategoryDescription.sendKeys(Keys.DELETE);
            editCategoryDescription.sendKeys(configprop.getProperty("EditCategoryDescription"));


//        editCategoryDescription.click();
//        editCategoryDescription.clear();
//        editCategoryDescription.sendKeys("EditCategoryDescription");

            // Step 3: Click Category Label Dropdown
            WebElement editCategoryLabel = waithelper.WaitForElement1(Edit_Category_label, 10);
            editCategoryLabel.click();
            Thread.sleep(1000); // Let dropdown animate


            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
            By labelOptionLocator = Edit_category_Label_Option; // your XPath or By selector

// Step 1: Wait until the elements are present
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(labelOptionLocator));

            List<WebElement> labelOptions = ldriver.findElements(labelOptionLocator);

            if (!labelOptions.isEmpty()) {
                Random rand = new Random();
                int randomIndex = rand.nextInt(labelOptions.size());

                try {
                    // Step 2: Re-fetch the element just before use
                    labelOptions = ldriver.findElements(labelOptionLocator); // REFRESH THE LIST
                    WebElement randomOption = labelOptions.get(randomIndex);

                    // Scroll into view
                    ((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", randomOption);
                    Thread.sleep(500); // Optional, based on UI animation

                    try {
                        randomOption.click();
                    } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                        // Step 3: Retry once if needed
                        labelOptions = ldriver.findElements(labelOptionLocator);
                        randomOption = labelOptions.get(randomIndex);
                        ((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", randomOption);
                    }

                    System.out.println("Randomly selected label option: " + randomOption.getText());

                } catch (StaleElementReferenceException se) {
                    System.out.println("Stale element again — maybe DOM is shifting too fast. Consider a longer wait or stabilizing UI.");
                }

            } else {
                System.out.println("No label options found!");
            }


            WebElement EditCategoryUpdateButton = waithelper.WaitForElement1(Edit_Category_UpdateButton, 20);
            //Actions updateaction=new Actions(ldriver);
            // updateaction.moveToElement(EditCategoryUpdateButton).click().build().perform();
            if (EditCategoryUpdateButton.isDisplayed()) {
                System.out.println(" Category Update Button is Displayed");
                if (EditCategoryUpdateButton.isEnabled()) {
                    Actions updateaction = new Actions(ldriver);
                    updateaction.moveToElement(EditCategoryUpdateButton).click().build().perform();
                    System.out.println("Category Update Button is Enabled");
                } else {
                    System.out.println(" category Update Button is Not Enabled");
                }
            } else {
                System.out.println(" category update Button is Displayed");
            }
            String editpageStatusMessage = "Category already exists with name: " + innertext_EditCategoryName;
            System.out.println(editpageStatusMessage);

            WebElement EditCategorypageStatus = waithelper.WaitForElement1(Edit_Category_page_Status, 20);
            String CategoryStatus=EditCategorypageStatus.getText();
            System.out.println(EditCategorypageStatus.getText());

            if(CategoryStatus.equalsIgnoreCase(editpageStatusMessage)){

                Assert.assertTrue(true);
            }
            else if(CategoryStatus.equalsIgnoreCase("Updated Successfully")){
                Assert.assertTrue(true);
            }
            else{
                Assert.fail("The Status message is not Matching as expected");
            }

//        // IMPORTANT: Re-locate parent category input after label selection (DOM likely changed)
//        WebElement dropdownInput = waithelper.WaitForElement1(Edit_category_Parent_Category, 10);
//        dropdownInput.click();
//
//        List<WebElement> parentOptions = ldriver.findElements(Edit_Category_Parent_Label_Option);
//        if (!parentOptions.isEmpty()) {
//            Random rand = new Random();
//            WebElement randomParentOption = parentOptions.get(rand.nextInt(parentOptions.size()));
//
//            ((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", randomParentOption);
//            Thread.sleep(500);
//            try {
//                randomParentOption.click();
//            } catch (ElementClickInterceptedException e) {
//                ((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", randomParentOption);
//            }
//
//            System.out.println("Randomly selected parent option: " + randomParentOption.getText());
//        } else {
//            System.out.println("No parent category options found!");
//        }

        } catch (Exception e) {
            System.out.println("Failed to update Category Data: " + e.getMessage());
        }
    }


}
