package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
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
    By Catalog_Products_Link = By.xpath(configprop.getProperty("Catalog_Products_Link"));
    By catalog_Products_AddProducts_Button = By.xpath(configprop.getProperty("catalog_Products_AddProducts_Button"));

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
    By Product_CategoryOrBrand_DropDown = By.xpath(configprop.getProperty("Product_CategoryOrBrand_DropDown"));

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


                //click the dropdown box
                //              DropdownBox.click();
//                WebElement list1 =waithelper.WaitForElement1(Product_category_DropdownList,10);
//               list1.click();
            WebElement button = ldriver.findElement(Product_page_Product_Submit_Button);

                Actions actions = new Actions(ldriver);
                actions.moveToElement(button).click().perform();



//                // WebElement ProductSubmitButton=waithelper.WaitForElement1(Product_page_Product_Submit_Button,10);
//                WebElement button = ldriver.findElement(Product_page_Product_Submit_Button);
//                button.click();


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


}
