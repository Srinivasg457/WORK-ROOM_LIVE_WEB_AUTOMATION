package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static stepDefinations.BaseClass.randomNumber;


public class ChataakAddCatalogProducts {

    public WebDriver ldriver;
    WaitHelper waithelper;

    public static Properties configprop;

    //constructor
    public ChataakAddCatalogProducts(WebDriver rdriver) throws IOException {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        waithelper = new WaitHelper(ldriver);

    }

    //xpath identification

    {
        try {
            configprop = new Properties();
            // Use the classpath to load the properties file
            InputStream configProfile = getClass().getClassLoader().getResourceAsStream("config.properties");

            if (configProfile == null) {
                throw new RuntimeException("config.properties file not found in the classpath!");
            }

            configprop.load(configProfile);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }







//        try {
//            configprop = new Properties();
//            String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
//            FileInputStream configProfile = new FileInputStream(configPath);
//
//            configprop.load(configProfile);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to load properties file!");
//        }
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
    By Catalog_Products_Link = By.xpath(configprop.getProperty("Catalog_Products_Link"));
    By catalog_Products_AddProducts_Button = By.xpath(configprop.getProperty("catalog_Products_AddProducts_Button"));

    //Produc Page  Product_Card's Xpath
    By Total_Product_Text = By.xpath(configprop.getProperty("Total_Product_Text"));
    By Total_Products = By.xpath(configprop.getProperty("Total_Products"));

    By Active_Products_Text = By.xpath(configprop.getProperty("Active_Products_Text"));
    By Active_Products_Count = By.xpath(configprop.getProperty("Active_Products_Count"));

    By InActive_Products_Text = By.xpath(configprop.getProperty("InActive_Products_Text"));
    By InActive_Products_Count = By.xpath(configprop.getProperty("InActive_Products_Count"));

    // Product Page List xpath
    By Product_Page_Product_List = By.xpath(configprop.getProperty("Product_Page_Product_List"));
    By Product_Action_Button = By.xpath(configprop.getProperty("Product_Action_Button"));

    //Product page Actions
    // 1. Enable Or Disable Operation
    By Product_category_Disable = By.xpath(configprop.getProperty("Product_category_Disable"));
    By Product_category_Enable = By.xpath(configprop.getProperty("Product_category_Enable"));

    //2. Product Edit Operations
    By product_page_Edit = By.xpath(configprop.getProperty("product_page_Edit"));


    //Here we are identifying the xpath for the Adding Product Page
    By Product_Code = By.xpath(configprop.getProperty("Product_Code"));
    By Product_Bar_COde = By.xpath(configprop.getProperty("Product_Bar_COde"));
    By Product_Page_Product_Name = By.xpath(configprop.getProperty("Product_Page_Product_Name"));
    By Product_Description = By.xpath(configprop.getProperty("Product_Description"));
    By ProductSku = By.xpath(configprop.getProperty("ProductSku"));
    By Product_HSN_Code = By.xpath(configprop.getProperty("Product_HSN_Code"));
    By Product_Page_Product_Sku = By.xpath(configprop.getProperty("Product_Page_Product_Sku"));
    By Product_Page_Product_SellingPrice = By.xpath(configprop.getProperty("Product_Page_Product_SellingPrice"));
    By Product_Page_Product_HSN_Code = By.xpath(configprop.getProperty("Product_Page_Product_HSN_Code"));
    By Product_Page_Product_MinSellingPrice = By.xpath(configprop.getProperty("Product_Page_Product_MinSellingPrice"));
    By Product_Page_Product_UnitInBox = By.xpath(configprop.getProperty("Product_Page_Product_UnitInBox"));
    By Product_Page_Product_SellingPrice_PerUnit = By.xpath(configprop.getProperty("Product_Page_Product_SellingPrice_PerUnit"));

    //Here we are identifying the xpth for the Editing the Product
    By Edit_Product_Code_txtBox = By.xpath(configprop.getProperty("Edit_Product_Code_txtBox"));
    By Edit_Product_Bar_COde_txtBox = By.xpath(configprop.getProperty("Edit_Product_Bar_COde_txtBox"));
    By Edit_Product_Page_Product_Name_txtBox = By.xpath(configprop.getProperty("Edit_Product_Page_Product_Name_txtBox"));
    By Edit_Product_Description_txtBox = By.xpath(configprop.getProperty("Edit_Product_Description_txtBox"));
    By Edit_Product_Page_Product_Sku_txtBox = By.xpath(configprop.getProperty("Edit_Product_Page_Product_Sku_txtBox"));
    By Edit_Product_Page_Product_SellingPrice_txtBox = By.xpath(configprop.getProperty("Edit_Product_Page_Product_SellingPrice_txtBox"));
    By Edit_Product_Page_Product_HSN_Code_txtBox = By.xpath(configprop.getProperty("Edit_Product_Page_Product_HSN_Code_txtBox"));
    By Edit_Product_Page_Product_MinSellingPrice_txtBox = By.xpath(configprop.getProperty("Edit_Product_Page_Product_MinSellingPrice_txtBox"));
    By Edit_Product_Page_Product_UnitInBox_txtBox = By.xpath(configprop.getProperty("Edit_Product_Page_Product_UnitInBox_txtBox"));
    By Edit_Product_Page_Product_SellingPrice_PerUnit_txtBox = By.xpath(configprop.getProperty("Edit_Product_Page_Product_SellingPrice_PerUnit_txtBox"));
    By Edit_Product_Page_Product_Purchase_Price_txtBox = By.xpath(configprop.getProperty("Edit_Product_Page_Product_Purchase_Price_txtBox"));
    By Edit_Product_Page_Store_Price = By.xpath(configprop.getProperty("Edit_Product_Page_Store_Price"));
    By Product_Store_DropDown=By.xpath(configprop.getProperty("Product_Store_DropDown"));
    By product_Store_DropDown_List=By.xpath(configprop.getProperty("product_Store_DropDown_List"));
    By Product_Update_Button = By.xpath(configprop.getProperty("Product_Update_Button"));


    By Product_Page_Product_Category_List = By.xpath(configprop.getProperty("Product_Page_Product_Category_List"));


    By Product_page_Product_Submit_Button = By.xpath("Product_page_Product_Submit_Button");


    //DropDown List for the Category
    By Product_category_DropdownList = By.xpath(configprop.getProperty("Product_category_DropdownList"));
    By Product_Category_List = By.xpath(configprop.getProperty("Product_Category_List"));


    //Organization Type
    By Organization_Type = By.xpath(configprop.getProperty("Organization_Type"));

    //    pop-up message xpath
    By Category_First_Pop_Up = By.xpath(configprop.getProperty("Category_First_Pop_Up"));

    //Product List
    By Product_List = By.xpath(configprop.getProperty("Product_List"));

    //List Display names
    By Product_Name = By.xpath(configprop.getProperty("Product_Name"));
    By Product_Count = By.xpath(configprop.getProperty("Product_Count"));
    By Product_CodeOrSku = By.xpath(configprop.getProperty("Product_CodeOrSku"));
    By Product_Barcode = By.xpath(configprop.getProperty("Product_Barcode"));
    By product_Status = By.xpath(configprop.getProperty("product_Status"));


    //Xpath to find the list of category
    By Product_List_Category = By.xpath(configprop.getProperty("Product_List_Category"));
    By Product_CategoryOrBrand = By.xpath(configprop.getProperty("Product_CategoryOrBrand"));
    By Product_ImageOrVideo = By.xpath(configprop.getProperty("Product_ImageOrVideo"));
    By Product_CategoryOrBrand_DropDown = By.xpath(configprop.getProperty("Product_CategoryOrBrand_DropDown"));

    //Status message
    By Product_Page_Status = By.xpath(configprop.getProperty("Product_Page_Status"));


    // Using This Method we can move till the Add Product Page
    public void AddProductsPage() throws InterruptedException {
        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);

        //here if only the
        WebElement organizationType = waithelper.WaitForElement1(Organization_Type, 10);
        String Type = organizationType.getText();
        if (Type.equals(configprop.getProperty("ManName"))) {
            System.out.println(organizationType.getText());
            Assert.assertTrue(true);
        } else if (Type.equals(configprop.getProperty("MerName"))) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }


        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(Catalog_Products_Link).click();


        // Finding the Product Add Button
        WebElement AddButton = waithelper.WaitForElement1(catalog_Products_AddProducts_Button, 10);
        AddButton.click();
    }


    //    Using the Below Method we are trying to click the Pop up message if the product is not created
    public void AddProductsWithoutCategory() {
        WebElement productcode = waithelper.WaitForElement1(Product_Code, 10);


        //Finding The Product Code Text Box
        productcode.click();
        productcode.clear();
        productcode.sendKeys(configprop.getProperty("ProductCOde"));


//     Click on the Pop up message
        WebElement popup = waithelper.WaitForElement1(Category_First_Pop_Up, 10);
        popup.click();
    }


    //This method helps to get the list of data in the Product List

    public void ProductList() throws InterruptedException {
        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);

        //here if only the
        WebElement organizationType = waithelper.WaitForElement1(Organization_Type, 10);
        String Type = organizationType.getText();
        if (Type.equals(configprop.getProperty("ManName"))) {
            System.out.println(organizationType.getText());
            Assert.assertTrue(true);
        } else if (Type.equals(configprop.getProperty("MerName"))) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }


        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(Catalog_Products_Link).click();

        try {

            List<WebElement> list = ldriver.findElements(Product_List);

            if (!list.isEmpty()) {  // Check if the list is not empty
                waithelper.WaitForElement(list.get(0), 20); // Wait for the first element
            } else {
                System.out.println("No elements found for category_List");
            }
            // Locate all rows in the MuiDataGrid table
            List<WebElement> rows = ldriver.findElements(Product_List);

            for (WebElement row : rows) {
                // Extract the Name
                WebElement nameElement = row.findElement(Product_Name);
                String name = nameElement.getText();

                //Extract product Quantity
                WebElement ProductQuantity = row.findElement(Product_Count);
                String Quantity = ProductQuantity.getText();

                // Extract the Description
                WebElement ProductCode = row.findElement(Product_CodeOrSku);
                String pcode = ProductCode.getText();


                WebElement PSku = row.findElement(ProductSku);
                String PductSku = PSku.getText();

                // Extract the Status
                WebElement ProductBarcode = row.findElement(Product_Barcode);
                String PBarcode = ProductBarcode.getText();


                //Product_HSN_Code
                WebElement ProductHsnCode = row.findElement(Product_HSN_Code);
                String PductHsn = ProductHsnCode.getText();

                // Extract the Image URL
                WebElement productStatus = row.findElement(product_Status);
                String productStatusList = productStatus.getText();


                // Print the extracted data
                System.out.println("Product Name: " + name);
                System.out.println("Product Quantity : " + Quantity);
                System.out.println("Product  Code: " + pcode);
                System.out.println("Product Sku: " + PductSku);
                System.out.println("Product Barcode: " + PBarcode);
                System.out.println("Product Hsn Code: " + PductHsn);
                System.out.println("Product Status: " + productStatusList);
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void AddNewProducts() {


        try {
            ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Wait for the page category or brand Visibility of Dropdown
            WebElement CategoryOrBrand = waithelper.WaitForElement1(Product_CategoryOrBrand, 10);
            CategoryOrBrand.click();

            //click the dropdown box
            WebElement DropdownBox = waithelper.WaitForElement1(Product_CategoryOrBrand_DropDown, 10);
            DropdownBox.click();
            // Find elements matching the category XPath
            List<WebElement> categoryElements = ldriver.findElements(Product_List_Category);

            // Check if categories are found
            if (!categoryElements.isEmpty()) {
                System.out.println("Category list is present. Found categories:");
                for (WebElement category : categoryElements) {
                    System.out.println(category.getText());  // Print each category name
                }

                WebElement productcode = waithelper.WaitForElement1(Product_Code, 10);


                //Finding The Product Code Text Box
                productcode.click();
                productcode.clear();
                productcode.sendKeys(configprop.getProperty("ProductCOde"));


            } else {
                System.out.println("Category list is NOT present.");
                WebElement productcode = waithelper.WaitForElement1(Product_Code, 10);


                //Finding The Product Code Text Box
                productcode.click();
                productcode.clear();
                productcode.sendKeys(configprop.getProperty("ProductCOde"));


                //     Click on the Pop up message
                WebElement popup = waithelper.WaitForElement1(Category_First_Pop_Up, 10);
                popup.click();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    //    Here if only the category exist we need to create the Product
    public void CategoryExistAddNewProduct() {


        try {
            ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //Wait for the page category or brand Visibility of Dropdown
            WebElement CategoryOrBrand = waithelper.WaitForElement1(Product_CategoryOrBrand, 10);
            CategoryOrBrand.click();

            //click the dropdown box
            WebElement DropdownBox = waithelper.WaitForElement1(Product_CategoryOrBrand_DropDown, 10);
            DropdownBox.click();
            // Find elements matching the category XPath
            List<WebElement> categoryElements = ldriver.findElements(Product_List_Category);

            // Check if categories are found
            if (!categoryElements.isEmpty()) {
                System.out.println("Category list is present. Found categories:");
                for (WebElement category : categoryElements) {
                    System.out.println(category.getText());  // Print each category name
                }

                // 1. Here we are identifying the Product code tet box
                WebElement productcode = waithelper.WaitForElement1(Product_Code, 10);


                //Finding The Product Code Text Box
                productcode.click();
                productcode.clear();
                productcode.sendKeys(configprop.getProperty("ProductCOde"));

                // 2. Here we are identifying the barcode text box
                WebElement barcode = waithelper.WaitForElement1(Product_Bar_COde, 10);

                barcode.click();
                barcode.clear();
                barcode.sendKeys(randomNumber());  //here 10 didgit random number will be generated

                // 3. Here we are identifying the Prdoct name text box
                WebElement ProductName = waithelper.WaitForElement1(Product_Page_Product_Name, 10);

                ProductName.click();
                ProductName.clear();
                ProductName.sendKeys(configprop.getProperty("ProductName"));

                // 4. here we are identifying the product description text box
                WebElement ProductDescription = waithelper.WaitForElement1(Product_Description, 10);

                ProductDescription.click();
                ProductDescription.clear();
                ProductDescription.sendKeys(configprop.getProperty("ProductDescription"));

                // 5. here we are identifying the Product Sku text box
                WebElement Product_Sku = waithelper.WaitForElement1(Product_Page_Product_Sku, 10);

                Product_Sku.click();
                Product_Sku.clear();
                Product_Sku.sendKeys("Sku" + randomNumber());

                // 6. Here we are identifying the product Sellling price text box
                WebElement Product_SellingPriceMRP = waithelper.WaitForElement1(Product_Page_Product_SellingPrice, 10);

                Product_SellingPriceMRP.click();
                Product_SellingPriceMRP.clear();
                Product_SellingPriceMRP.sendKeys(configprop.getProperty("ProductSellingPrice"));


                // 7. we are identifying the product Hsn code text box
                WebElement Product_HSN_Code = waithelper.WaitForElement1(Product_Page_Product_HSN_Code, 10);


                Product_HSN_Code.click();
                Product_HSN_Code.clear();
                Product_HSN_Code.sendKeys(randomNumber());


                // 8. we are identifying the minimum selling price text box
                WebElement Product_MinSellingPrice = waithelper.WaitForElement1(Product_Page_Product_MinSellingPrice, 10);

                Product_MinSellingPrice.click();
                Product_MinSellingPrice.clear();
                Product_MinSellingPrice.sendKeys(configprop.getProperty("Product_MinimumSellingPrice"));

                // 9. We are identifying the no of units in the Box
                WebElement Product_UnitInBox = waithelper.WaitForElement1(Product_Page_Product_UnitInBox, 10);

                Product_UnitInBox.click();
                Product_UnitInBox.clear();
                Product_UnitInBox.sendKeys(configprop.getProperty("Product_UnitInBox"));

                // 10. we are identifying the  product Selling price per unit
                WebElement Product_SellingPrice_PerUnit = waithelper.WaitForElement1(Product_Page_Product_SellingPrice_PerUnit, 10);

                // 11. We are identifying the Product SellingPrice PerUnit text Box
                Product_SellingPrice_PerUnit.click();
                Product_SellingPrice_PerUnit.clear();
                Product_SellingPrice_PerUnit.sendKeys(configprop.getProperty("SellingPrice_PerUnit"));


                //click the dropdown Box
                DropdownBox.click();

                List<WebElement> ProductcategoryList = ldriver.findElements(Product_List_Category);

                // Check if categories are found
                if (!ProductcategoryList.isEmpty()) {
                    System.out.println("Category list is present. Found categories:");
                    for (WebElement category : ProductcategoryList) {
                        Thread.sleep(3000);
                        category.click();
                        break;
                        // Print each category name
                    }

                } else {
                    System.out.println("Category list is not Present");
                }


//                WebElement imageOrVideotab= ldriver.findElement(Product_ImageOrVideo);
//                imageOrVideotab.click();


                Wait<WebDriver> wait = new FluentWait<>(ldriver)
                        .withTimeout(Duration.ofSeconds(15))
                        .pollingEvery(Duration.ofSeconds(1))
                        .ignoring(NoSuchElementException.class);

                //  WebElement submitButton = wait.until(driver -> driver.findElement(Product_page_Product_Submit_Button));
                WebElement submitButton = wait.until(driver -> driver.findElement(By.xpath("(//button[@type='submit' ])[1]")));

                if (submitButton.isDisplayed()) {
                    System.out.println(" Submit Button is Displayed ");
                    submitButton.click();
                } else {
                    System.out.println(" Submit Button is Not  Displayed ");
                }


                WebElement status = waithelper.WaitForElement1(Product_Page_Status, 20);
                // String ExpectedStatus = "The store name already exists in your organization. Please choose unique name to continue";
                String ActualStatus = status.getText();
                if (ActualStatus.equals("This Product Code already exists your Organization.")) {
                    Assert.assertTrue(true);
                } else if (ActualStatus.equalsIgnoreCase("Added Successfully")) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }


            } else {
                System.out.println("Product list is NOT present.");
                WebElement productcode = waithelper.WaitForElement1(Product_Code, 10);


                // Finding The Product Code Text Box
                productcode.click();
                productcode.clear();
                productcode.sendKeys(configprop.getProperty("ProductCOde"));


                // Click on the Pop up message
                WebElement popup = waithelper.WaitForElement1(Category_First_Pop_Up, 10);
                popup.click();

            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }


    public void PrintProductCardDetails() throws InterruptedException {
        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);

        //here if only the organization type is manufacturer or merchant u need to move to add product
        WebElement organizationType = waithelper.WaitForElement1(Organization_Type, 10);
        String Type = organizationType.getText();
        if (Type.equals(configprop.getProperty("ManName"))) {
            System.out.println(organizationType.getText());
            Assert.assertTrue(true);
        } else if (Type.equals(configprop.getProperty("MerName"))) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }


        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(Catalog_Products_Link).click();

        //Here i'm Printing the Card count  on the console and comparing with the actual list count
        WebElement TotalProductText = waithelper.WaitForElement1(Total_Product_Text, 10);

        if (TotalProductText.isDisplayed()) {
            System.out.println("Total Products Text Message : " + TotalProductText.getText());
            Thread.sleep(3000);
            WebElement TotalProducts = waithelper.WaitForElement1(Total_Products, 10);
            System.out.println("Total Products : " + TotalProducts.getText());
            System.out.println("Total Products Card is Displayed");
        } else {
            System.out.println("Total Products Card is Not Displayed");
        }

        // Here im Printing the Active Products
        WebElement ActiveproductsText = waithelper.WaitForElement1(Active_Products_Text, 10);

        if (TotalProductText.isDisplayed()) {
            System.out.println("Active  Products Text Message : " + ActiveproductsText.getText());
            //Thread.sleep(3000);
            WebElement ActiveProducts = waithelper.WaitForElement1(Active_Products_Count, 10);
            System.out.println("Active  Products Count  : " + ActiveProducts.getText());
            System.out.println("Active Products Card is Displayed");
        } else {
            System.out.println("Active  Products Card is Not Displayed");
        }

        // Here im Printing the InActive Products
        WebElement InActiveProductsText = waithelper.WaitForElement1(InActive_Products_Text, 10);

        if (TotalProductText.isDisplayed()) {
            System.out.println("InActive  Products Text Message : " + InActiveProductsText.getText());
            //Thread.sleep(3000);
            WebElement InActiveProducts = waithelper.WaitForElement1(InActive_Products_Count, 10);
            System.out.println("InActive  Products Count : " + InActiveProducts.getText());
            System.out.println("inactive  Products Card is Displayed");
        } else {
            System.out.println("Inactive  Products Card is Not Displayed");
        }


        try {

            List<WebElement> list = ldriver.findElements(Product_List);

            if (!list.isEmpty()) {  // Check if the list is not empty
                waithelper.WaitForElement(list.get(0), 20); // Wait for the first element
            } else {
                System.out.println("No elements found for Product_List");
            }
            // Locate all rows in the MuiDataGrid table
            List<WebElement> rows = ldriver.findElements(Product_List);
            int count = 0;
            for (WebElement row : rows) {
                //Extract the Name
                WebElement nameElement = row.findElement(Product_Name);
                String name = nameElement.getText();
                count++;

            }
            // Print the total count of products
            System.out.println("Total number of products: " + count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    //Here i'M Performing the  Enable or Disable  Fuction is working in The List 1st Product ( C R U D ) Operation
    public void productEnableOrDisable() throws InterruptedException {
        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        //here if only the organization type is manufacturer or merchant u need to move to add product
        WebElement organizationType = waithelper.WaitForElement1(Organization_Type, 10);
        String Type = organizationType.getText();
        if (Type.equals(configprop.getProperty("ManName"))) {
            System.out.println(organizationType.getText());
            Assert.assertTrue(true);
        } else if (Type.equals(configprop.getProperty("MerName"))) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }


        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(Catalog_Products_Link).click();

        try {

            List<WebElement> list = ldriver.findElements(Product_Page_Product_List);

            if (!list.isEmpty()) {  // Check if the list is not empty
                waithelper.WaitForElement(list.get(0), 20); // Wait for the first element
            } else {
                Assert.assertTrue(true);
                System.out.println("No elements found for Product_List");
            }
            // Iterate through each row
            // Locate all rows in the MuiDataGrid table
            List<WebElement> rows = ldriver.findElements(Product_Page_Product_List);
            for (WebElement row : rows) {
                try {
                    // Find the action button inside the current row
                    WebElement actionButton = row.findElement(Product_Action_Button);
                    // Click the action button
                    actionButton.click();
                    // Add a small delay to observe the click action (optional)
                    Thread.sleep(1000);
                    List<WebElement> Disable = ldriver.findElements(Product_category_Disable);
                    for (WebElement button : Disable) {
                        try {
                            waithelper.WaitForElement(button, 10);
                            button.click();
                            break; // Stop after first successful click
                        } catch (Exception e) {
                            System.out.println("Retrying click...");
                        }
                    }


                    List<WebElement> enable = ldriver.findElements(Product_category_Enable);
                    for (WebElement button : enable) {
                        try {

                            waithelper.WaitForElement(button, 10);
                            button.click();
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


    public void productActionProductEdit() throws InterruptedException {
        ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);

        WebElement organizationType = waithelper.WaitForElement1(Organization_Type, 10);
        String Type = organizationType.getText();

        if (Type.equals(configprop.getProperty("ManName")) || Type.equals(configprop.getProperty("MerName"))) {
            System.out.println("Organization Type: " + organizationType.getText());
            Assert.assertTrue(true);
        } else {
            Assert.fail("Invalid Organization Type");
        }

        ldriver.findElement(link_Catalog).click();
        ldriver.findElement(Catalog_Products_Link).click();

        try {
            WebElement productList = waithelper.WaitForElement1(Product_Page_Product_List, 10);
            List<WebElement> rows = ldriver.findElements(Product_Page_Product_List);

            if (rows.isEmpty()) {
                System.out.println("No products found.");
                return;
            }

            for (WebElement row : rows) {
                try {
                    WebElement actionButton = row.findElement(Product_Action_Button);
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

                    List<WebElement> editButtons = ldriver.findElements(product_page_Edit);
                    for (WebElement editButton : editButtons) {
                        try {
                            waithelper.WaitForElement(editButton, 10);
                            editButton.click();

                            //  Perform the actual edit right here
                            performProductEdit();

                            System.out.println("Edited product in row: " + row.getAttribute("data-id"));
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
            System.out.println("No data found: " + e.getMessage());
        }
    }


    //Here we are Filling up or trying to edit the  Product
    // And calling this Method  inside the PRODUCT_EDIT METHOD
    private void performProductEdit() {
        try {
            // 1. Editing/Updating The  Product Code
            WebElement productCodeBox = waithelper.WaitForElement1(Edit_Product_Code_txtBox, 10);

            Actions actions = new Actions(ldriver);
            actions.moveToElement(productCodeBox).click().perform();
            productCodeBox.clear();
            productCodeBox.sendKeys(configprop.getProperty("ProductCOde"));

            //2. Editing/Updating the Product Bar code
            WebElement ProductBarCOdetxtBox = waithelper.WaitForElement1(Edit_Product_Bar_COde_txtBox, 10);

            ProductBarCOdetxtBox.click();
            ProductBarCOdetxtBox.clear();
            ProductBarCOdetxtBox.sendKeys(randomNumber());

            // 3. Editing/Updating The Product name
            WebElement ProductNametxtBox = waithelper.WaitForElement1(Edit_Product_Page_Product_Name_txtBox, 10);

            ProductNametxtBox.click();
            ProductNametxtBox.clear();
            ProductNametxtBox.sendKeys(configprop.getProperty("ProductName"));

            // 4. Editing/Updating The Product Description
            WebElement ProductDescriptiontxtBox = waithelper.WaitForElement1(Edit_Product_Description_txtBox, 10);

            ProductDescriptiontxtBox.click();
            ProductDescriptiontxtBox.clear();
            ProductDescriptiontxtBox.sendKeys(configprop.getProperty("ProductDescription"));

            //5. Editing/Updating the  product SKU
            WebElement Product_Sku_txtBox = waithelper.WaitForElement1(Edit_Product_Page_Product_Sku_txtBox, 10);

            Product_Sku_txtBox.click();
            Product_Sku_txtBox.clear();
            Product_Sku_txtBox.sendKeys("SKU" + randomNumber());

            //6. Editing/Updating  The product price
            WebElement Product_SellingPrice_txtBox = waithelper.WaitForElement1(Edit_Product_Page_Product_SellingPrice_txtBox, 10);

            Product_SellingPrice_txtBox.click();
            Product_SellingPrice_txtBox.clear();
            Product_SellingPrice_txtBox.sendKeys(configprop.getProperty("ProductSellingPrice"));
            String SellingpriceMRP=Product_SellingPrice_txtBox.getAttribute("value");
            System.out.println("This is product Selling Price =" +SellingpriceMRP);

            //7. Editing/Updating The HSN Code
            WebElement Product_HSN_Code_txtBox = waithelper.WaitForElement1(Edit_Product_Page_Product_HSN_Code_txtBox, 10);

            Product_HSN_Code_txtBox.click();
            Product_HSN_Code_txtBox.clear();
            Product_HSN_Code_txtBox.sendKeys(randomNumber());

            //8. Editing/Updating The Product Minimum selling price
            WebElement Product_MinSellingPrice_txtBox = waithelper.WaitForElement1(Edit_Product_Page_Product_MinSellingPrice_txtBox, 10);

            Product_MinSellingPrice_txtBox.click();
            Product_MinSellingPrice_txtBox.clear();
            Product_MinSellingPrice_txtBox.sendKeys(configprop.getProperty("Product_MinimumSellingPrice"));

            //9.Editing /Updating the Number of units in the Box
            WebElement ProductUnitInBoxtxtBox = waithelper.WaitForElement1(Edit_Product_Page_Product_UnitInBox_txtBox, 10);

            ProductUnitInBoxtxtBox.click();
            ProductUnitInBoxtxtBox.clear();
            ProductUnitInBoxtxtBox.sendKeys(configprop.getProperty("Product_UnitInBox"));


            //10 Editing/Updating The SellingPrice_PerUnit_txtBox
            WebElement Product_SellingPrice_PerUnit_txtBox = waithelper.WaitForElement1(Edit_Product_Page_Product_SellingPrice_PerUnit_txtBox, 10);
            Product_SellingPrice_PerUnit_txtBox.click();
            Product_SellingPrice_PerUnit_txtBox.clear();
            Product_SellingPrice_PerUnit_txtBox.sendKeys(configprop.getProperty("SellingPrice_PerUnit"));


            //11. Editing/updating The Product Purchase_Price
            WebElement Product_Purchase_Price_txtBox = waithelper.WaitForElement1(Edit_Product_Page_Product_Purchase_Price_txtBox, 10);

            Product_Purchase_Price_txtBox.click();
            Product_Purchase_Price_txtBox.clear();
            Product_Purchase_Price_txtBox.sendKeys(configprop.getProperty("productPrice"));


            //Store DropDown
            WebElement storeDropdown = ldriver.findElement(Product_Store_DropDown);
            storeDropdown.click();

            List<WebElement>Storelist=ldriver.findElements(product_Store_DropDown_List);

            if(!Storelist.isEmpty()){
                for(WebElement list : Storelist){

                    String optionText = list.getText().trim();
                    System.out.println("Dropdown option: " + optionText);

                    if (optionText.equalsIgnoreCase("Select All")) {
                        list.click();
                        break; // Exit loop after clicking
                    }
                    else{
                        Assert.fail();
                    }


                    System.out.println("Store list : " +list.getText());
                }
            }
            else {
                System.out.println("No Store is Present ");
            }


            //12. Store Product price
            WebElement Product_Page_Store_Price = waithelper.WaitForElement1(Edit_Product_Page_Store_Price, 10);

            List<WebElement> list= ldriver.findElements(Edit_Product_Page_Store_Price);
            String lastProductSellingPrice = ""; // variable to hold the last entered price

            for (WebElement productSellingPrice : list) {
                actions.moveToElement(productSellingPrice).click().perform();
                productSellingPrice.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                productSellingPrice.sendKeys(Keys.DELETE);
                lastProductSellingPrice = configprop.getProperty("Store1Price");
                productSellingPrice.sendKeys(configprop.getProperty("Store1Price"));
            }

            // Print the last entered price after the loop
            System.out.println("Last Product Selling Price set: " + lastProductSellingPrice);

            //SellingpriceValue
            System.out.println("Selling price MRP Value = "+SellingpriceMRP);
            String message ="The store has a selling price of "+ lastProductSellingPrice+", which is below the minimum allowed price of product "+SellingpriceMRP+".";
            System.out.println("New Status message = "+message);



            WebElement ProductUpdateButton = waithelper.WaitForElement1(Product_Update_Button, 10);

            if (ProductUpdateButton.isDisplayed()) {
                System.out.println("Product Update Button is Displayed ");
                ProductUpdateButton.click();

            } else {
                System.out.println("Product Update button is Not Displayed");
            }





            WebElement EditStatusMessage=waithelper.WaitForElement1(Product_Page_Status,20);
            String actualStatusMessage = EditStatusMessage.getText().trim();

            System.err.println("Actual message = "+ actualStatusMessage);

            if(actualStatusMessage.equalsIgnoreCase("The store has a selling price of "+ lastProductSellingPrice+", which is below the minimum allowed price of product "+SellingpriceMRP+".")){
                Assert.assertTrue(true);

            }
            else if (actualStatusMessage.equalsIgnoreCase("Update Successfully")) {
                Assert.assertTrue(true);
            }
        else if(actualStatusMessage.equalsIgnoreCase("This Product Code already exists your Organization.")){
                Assert.fail("failed");
            }







        } catch (Exception e) {
            System.out.println("Failed to update Product Code: " + e.getMessage());
        }
    }


}
