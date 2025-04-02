package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
    By Product_Code = By.xpath(configprop.getProperty("Product_Code"));

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
    By ProductSku = By.xpath(configprop.getProperty("ProductSku"));
    By Product_HSN_Code = By.xpath(configprop.getProperty("Product_HSN_Code"));


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


}
