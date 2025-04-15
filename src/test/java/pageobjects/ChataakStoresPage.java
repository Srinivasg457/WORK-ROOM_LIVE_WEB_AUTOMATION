package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtil;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ChataakStoresPage {

    public WebDriver ldriver;
    WaitHelper waithelper;
    public static Properties configprop;
    public Map<String, String> locators;


    // Declare WebElement variables outside methods, but inside the class
    WebElement totalStoresName;
    WebElement totalStoreCount;
    WebElement activeStoreName;
    WebElement activeStoreCount;
    WebElement inactiveStoreName;
    WebElement inactiveStoreCount;
    List<WebElement> Store_list;
//    WebElement Store_list_ID_Column;
//    WebElement Store_List_Store_UniqueName_Column;
//    WebElement Store_List_Store_Type;
//    WebElement  Store_List_Store_Location;
//    WebElement Store_List_Store_Status;


    //constructor
    public ChataakStoresPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        waithelper = new WaitHelper(ldriver);


        String excelPath = getClass().getClassLoader().getResource("chataakWebApplicationXpath.xlsx").getPath();
        locators = ExcelUtil.readLocators(excelPath);
    }

    // After constructor, use this to safely access locators
    private void setupElements() {
        totalStoresName = ldriver.findElement(By.xpath(locators.get("Store_Card_Total_Stores_Name")));
        totalStoreCount = ldriver.findElement(By.xpath(locators.get("Store_Card_Total_Stores_Count")));
        activeStoreName = ldriver.findElement(By.xpath(locators.get("Store_Card_Active_Stores_Name")));
        activeStoreCount = ldriver.findElement(By.xpath(locators.get("Store_Card_Active_Stores_Count")));
        inactiveStoreName = ldriver.findElement(By.xpath(locators.get("Store_Card_InActive_Stores_Name")));
        inactiveStoreCount = ldriver.findElement(By.xpath(locators.get("Store_Card_InActive_Stores_Count")));

        //for the Store list
        Store_list=ldriver.findElements(By.xpath(locators.get("Store_List")));

//        Store_list_ID_Column= ldriver.findElement(By.xpath(locators.get("Store_list_ID_Column")));
//        Store_List_Store_UniqueName_Column= ldriver.findElement(By.xpath(locators.get("Store_List_Store_UniqueName_Column")));
//        Store_List_Store_Type= ldriver.findElement(By.xpath(locators.get("Store_List_Store_Type")));
//        Store_List_Store_Location= ldriver.findElement(By.xpath(locators.get("Store_List_Store_Location")));
//        Store_List_Store_Status=ldriver.findElement(By.xpath(locators.get("Store_List_Store_Status")));


    }

    {
   try {
        configprop = new Properties();
        String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        FileInputStream configProfile = new FileInputStream(configPath);

        configprop.load(configProfile);


    } catch (
    IOException e) {
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

    //xpath identification


    //Locators
    @FindBy(xpath = "//input[@placeholder='johndoe@example.com']")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    @CacheLookup
    WebElement btnLogin;


    @FindBy(xpath = "//li[normalize-space()='Sign Out']")
    @CacheLookup
    WebElement Logout;

    @FindBy(xpath = "//p[@aria-label='Organization Type : Merchant']")
    @CacheLookup
    WebElement owner;


    @FindBy(xpath = "//p[normalize-space()='Store Manager']")
    @CacheLookup
    WebElement Storemanager_Drp;


    @FindBy(xpath = "//a[contains(@href,'/store/')]//div[contains(@class,'MuiBox-root css-1yhyvdz')]")
    @CacheLookup
    WebElement Storemanager_Stores;


    @FindBy(xpath = "//button[normalize-space()='Add Store']")
    @CacheLookup
    WebElement btn_AddStore;


    //xpath for the add new store form

    @FindBy(xpath = "(//input[@placeholder='Store name'])[1]")
    @CacheLookup
    WebElement txt_StoreUniqueName;

    @FindBy(xpath = "(//input[@placeholder='Display Name'])[1]")
    @CacheLookup
    WebElement txt_DisplayName;

    @FindBy(xpath = "(//div[@class=' css-19bb58m'])[1]")
    @CacheLookup
    WebElement drp_Storetype;


    @FindBy(xpath = "//div[text()='Company Owned']")
    @CacheLookup
    WebElement drp_CompanyOwned;


    @FindBy(xpath = "//div[text()='ALL FURNITURES']")
    @CacheLookup
    WebElement drp_furniture;

    @FindBy(xpath = "//input[@id='react-select-4-input']")
    @CacheLookup
    WebElement drp_industry;

    @FindBy(xpath = "//div[text()='Outlet retailers']")
    @CacheLookup
    WebElement drp_Outletretailer;


    @FindBy(xpath = "//input[@id='react-select-5-input']")
    @CacheLookup
    WebElement drp_Staff;

    @FindBy(xpath = "//div[text()='Store Manager']")
    @CacheLookup
    WebElement drp_Manager;


    @FindBy(xpath = "//input[@id='react-select-6-input']")
    @CacheLookup
    WebElement drp_Country;

    @FindBy(xpath = "(//div[text()='India'])[2]")
    @CacheLookup
    WebElement drp_country_india;

    @FindBy(xpath = "//input[@id='react-select-7-input']")
    @CacheLookup
    WebElement drp_State;

    @FindBy(xpath = "//div[text()='Karnataka']")
    @CacheLookup
    WebElement drp_State_Karnataka;


    //   (//*[local-name()='svg'])[77]
    @FindBy(xpath = "//input[@id='react-select-8-input']")
    @CacheLookup
    WebElement drp_City;


    @FindBy(xpath = "(//div[@role='option'])[2]")
    @CacheLookup
    WebElement drp_City_Bangalore;

    @FindBy(xpath = "//input[@placeholder='Address']")
    @CacheLookup
    WebElement txt_Address;

    //input[@placeholder='Postal code']

    @FindBy(xpath = "//input[@placeholder='Postal Code']")
    @CacheLookup
    WebElement txt_postalCode;

    @FindBy(xpath = "//input[@type='checkbox']")
    @CacheLookup
    WebElement chkbxk_IsMerchantAccount;

    //Merchant account


    @FindBy(xpath = "(//*[local-name()='svg' and @height='20' and @width='20' and @viewBox='0 0 20 20'])[8]")
    @CacheLookup
    WebElement drp_MerchantOrganization;


    @FindBy(xpath = "//div[text()='HOME FURNITURES']")
    @CacheLookup
    WebElement drp_MerchantStore;


    @FindBy(xpath = "//button[normalize-space()='Add Products']")
    @CacheLookup
    WebElement btn_Addproducts;
    //th[@class='MuiTableCell-root MuiTableCell-head MuiTableCell-sizeMedium css-1d4n6qt']//input[@type='checkbox']

    @FindBy(xpath = "/html/body/div[9]/div[3]/div[2]/table/tbody/tr[2]/td[1]/span/input")
    @CacheLookup
    WebElement chkbxk_AllItems;


    @FindBy(xpath = "//div[@class='MuiBox-root css-1xbsatb']//button[@type='button'][normalize-space()='Cancel']")
    @CacheLookup
    WebElement btn_cancel;


    @FindBy(xpath = "//div[@class='MuiTableContainer-root css-58obqq']")
    @CacheLookup
    WebElement table_Products;

    @FindBy(xpath = "//th[@class='MuiTableCell-root MuiTableCell-head MuiTableCell-sizeMedium css-1d4n6qt']//input[@type='checkbox']")
    @CacheLookup
    WebElement table_Data;


    @FindBy(xpath = "//button[normalize-space()='Add Selected Products']")
    @CacheLookup
    WebElement btn_AddSelectedProducts;


    @FindBy(xpath = "//div[@class='MuiBox-root css-19heefx']//button[@type='submit'][normalize-space()='Submit']")
    @CacheLookup
    WebElement btn_SubmitStore;


    //status message
    //  Latitude or Longitude cannot be null, empty, or '0'. Please check with your the address.


    @FindBy(xpath = "//div[@role='status']")
    @CacheLookup
    WebElement msg_Status;


    //new xpaths


    @FindBy(xpath = "//div[@class='MuiListItemIcon-root css-qvvxne']/following-sibling::div")
    @CacheLookup
    WebElement widget_Store;


    @FindBy(xpath = "//p[normalize-space()='Stores']")
    @CacheLookup
    WebElement widget_Stores;

    //button[normalize-space()='Add Store']
    @FindBy(xpath = "//button[normalize-space()='Add Store']")
    @CacheLookup
    WebElement Btn_AddStore;


    @FindBy(xpath = "(//button[contains(text(), 'Get Location')])[1]")
    @CacheLookup
    WebElement btn_getlocation;

    @FindBy(xpath = "//div[@role='status']")
    @CacheLookup
    WebElement status_message;


    @FindBy(xpath = "//label[@for='fileInput']/child::img[@alt='profile picture']")
    @CacheLookup
    WebElement profile_Logo;


    @FindBy(xpath = " (//input[@id='fileInput'])[1]")
    @CacheLookup
    WebElement upload_image;

    //Organization Type
    By Organization_Type = By.xpath(configprop.getProperty("Organization_Type"));

    By Store_list_ID_Column=By.xpath(configprop.getProperty("Store_list_ID_Column"));
    By Store_List_Store_UniqueName_Column = By.xpath(configprop.getProperty("Store_List_Store_UniqueName_Column"));
    By Store_List_Store_Type = By.xpath(configprop.getProperty("Store_List_Store_Type"));
    By Store_List_Store_Location = By.xpath(configprop.getProperty("Store_List_Store_Location"));
    By Store_List_Store_Status = By.xpath(configprop.getProperty("Store_List_Store_Status"));



    //Action Method

    public String logintype(){
        //here if only the organization type is manufacturer or merchant u need to move to add product
        WebElement organizationType = waithelper.WaitForElement1(Organization_Type, 10);
        String Type = organizationType.getText();

        if (Type.equals(configprop.getProperty("ManName")) ||
                Type.equals(configprop.getProperty("MerName"))) {
            System.out.println("Organization Type: " + Type);
            return Type;
        } else {
            throw new IllegalStateException("Invalid login type: " + Type);
        }


    }



    public void Email(String email) {

        txtEmail.click();
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void password(String password) {

        txtPassword.click();
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void Login() throws InterruptedException {
        btnLogin.click();
        Thread.sleep(7000);
    }

    public void Logout() {
        Logout.click();
    }

    public void OwnerType() {
        owner.getText();
        System.out.println(owner.getText());
    }

    public void Storemanager() {
        waithelper.WaitForElement(Storemanager_Drp, 20);
        Storemanager_Drp.click();
    }

    public void Stores() {
        waithelper.WaitForElement(Storemanager_Stores, 20);
        Storemanager_Stores.click();
    }


    public void AddStoreButton() {
        waithelper.WaitForElement(btn_AddStore, 20);
        btn_AddStore.click();
    }

    public void StoreDetails() throws InterruptedException {

        //	txt_StoreUniqueName.click();
        //	txt_StoreUniqueName.sendKeys("Wooden Park");

        waithelper.WaitForElement(profile_Logo, 10);


        if (profile_Logo.isDisplayed()) {
            profile_Logo.click();
            String filePath = System.getProperty("user.dir") + "/src/test/java/images/Dell.jpg";
            profile_Logo.sendKeys(filePath);
            Assert.assertTrue(true);
        }

        waithelper.WaitForElement(txt_StoreUniqueName, 10);
        txt_StoreUniqueName.click();
        txt_StoreUniqueName.clear();
        txt_StoreUniqueName.sendKeys("New Furniture Shop");

        waithelper.WaitForElement(txt_DisplayName, 10);
        txt_DisplayName.click();
        txt_DisplayName.clear();
        txt_DisplayName.sendKeys("INDIAN IKEA");


        //selecting store type

        drp_Storetype.click();
        waithelper.WaitForElement(drp_furniture, 10);
        drp_furniture.click();
        //drp_furniture.click();

        //selecting industry type
        waithelper.WaitForElement(drp_industry, 10);
        drp_industry.click();
        drp_Outletretailer.click();

        //selecting country
        waithelper.WaitForElement(drp_Country, 10);
        drp_Country.click();
        //drp_Country.click();

        drp_country_india.click();

        //Selecting State
        drp_State.click();
        drp_State_Karnataka.click();

        //selecting city
        drp_City.click();
        waithelper.WaitForElement(drp_City_Bangalore, 10);
        drp_City_Bangalore.click();

        //adding address
        txt_Address.click();
        txt_Address.clear();
        txt_Address.sendKeys("#01 kyalasanahalli electronicuty ,Bangalore ");

        //postal code

        txt_postalCode.click();
        txt_postalCode.clear();
        txt_postalCode.sendKeys("560105");

        //	waithelper.WaitForElement(txt_postalCode, 10);
        //	txt_postalCode.click();
        //	txt_postalCode.clear();
        //	txt_postalCode.sendKeys("560100");


        //Thread.sleep(9000);

        //is merchant account


        //		txt_postalCode.clear();
        //		txt_postalCode.sendKeys("560100");


    }

    public void merchantStoreCheckbox() {

        chkbxk_IsMerchantAccount.click();
    }

    public void merchantStoreName() {
        drp_MerchantOrganization.click();
        drp_MerchantStore.click();
    }


    public void AddProducts() {
        btn_Addproducts.click();
    }

    public void Selectitems() {
        waithelper.WaitForElement(table_Products, 10);
        if (table_Products.isDisplayed()) {
            System.out.println("Table  displayed");


        } else {
            System.out.println("Table is not displayed");
        }

        if (!table_Data.isSelected()) {
            table_Data.click();
        }

    }

    public void selectedButton() {
        btn_AddSelectedProducts.click();
    }

    public void postaladdressChange() {
        //waithelper.WaitForElement(txt_postalCode, 10);
        txt_postalCode.click();
        txt_postalCode.clear();
        txt_postalCode.sendKeys("560100");

    }

    public void SubmitButton() {
        btn_SubmitStore.click();
        waithelper.WaitForElement(msg_Status, 10);
        //Assert.assertFalse("Latitude or Longitude cannot be null, empty, or '0'. Please check with your the address.", true);
        String errormessage = msg_Status.getText();
        System.out.println(errormessage);


        try {
            if (errormessage.equals("Latitude or Longitude cannot be null, empty, or '0'. Please check with your the address.")) {
                Assert.assertTrue(false);
            } else {
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void Addstore() throws InterruptedException {


        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        widget_Store.click();
        widget_Stores.click();

        Btn_AddStore.click();

        //waithelper.WaitForElement(profile_Logo, 10);
        Thread.sleep(3000);
        //ldriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        if (profile_Logo.isDisplayed()) {
//            JavascriptExecutor js = (JavascriptExecutor) ldriver;
//            //profile_Logo.sendKeys("/home/limitscale/Documents/ChataakProjectWebAutomation/images/Dell.jpg");
//            js.executeScript("arguments[0].style.display='block';", profile_Logo);
//            profile_Logo.sendKeys("/home/limitscale/Documents/ChataakProjectWebAutomation/images/Dell.jpg");
            System.out.println(profile_Logo.isDisplayed() + "+Profile_Logo is Displayed");

            String filePath = System.getProperty("user.dir") + "/src/test/java/images/Picture-01.png";
            upload_image.sendKeys(filePath);

            //upload_image.sendKeys("/home/limitscale/WorkingProject/Live_ChataakProjectWebautomation/src/test/java/images/Dell.jpg");
            Assert.assertTrue(true);

        }


        txt_StoreUniqueName.click();
        txt_StoreUniqueName.clear();
        txt_StoreUniqueName.sendKeys("Dell Technologies Bangalore ");

        waithelper.WaitForElement(txt_DisplayName, 10);
        txt_DisplayName.click();
        txt_DisplayName.clear();
        txt_DisplayName.sendKeys("Dell Technologies Bangalore Electronicity ");

        waithelper.WaitForElement(drp_Storetype, 10);
        drp_Storetype.click();
        drp_CompanyOwned.click();

        drp_industry.click();
        drp_Outletretailer.click();

        drp_Staff.click();
        drp_Manager.click();

        drp_Country.click();
        drp_country_india.click();

        drp_State.click();
        drp_State_Karnataka.click();

        drp_City.click();
        drp_City_Bangalore.click();

        txt_Address.click();
        txt_Address.clear();
        txt_Address.sendKeys("#01  electronicuty ,Bangalore ");

        //postal code

        txt_postalCode.click();
        txt_postalCode.clear();
        txt_postalCode.sendKeys("560105");


        //waithelper.WaitForElement(btn_getlocation, 10);
        //Thread.sleep(2000);
        btn_getlocation.click();
        Thread.sleep(3000);
        btn_SubmitStore.click();


    }

    public void status() {

        waithelper.WaitForElement(status_message, 10);
        String ExpectedStatus = "The store name already exists in your organization. Please choose unique name to continue";
        String ActualStatus = status_message.getText();
        if (ActualStatus.equals(ExpectedStatus)) {
            Assert.assertTrue(true);
        } else if (ActualStatus.equalsIgnoreCase("Added Successfully")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }


    public void StoreCardCount() throws InterruptedException {


        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        logintype();
        widget_Store.click();
        widget_Stores.click();

        // for the element setup from the excel sheet
        setupElements();


        try {
            WebElement totalstorename = waithelper.WaitForElement2( totalStoresName, 10);
            System.out.println("Card Name : " + totalstorename.getText());
            //Small Delay because i tried all the wait method didnt work so to load the data in the Dom
            //Structure we are waiting for 3 sec
            Thread.sleep(3000);
            WebElement totalStorecount = waithelper.WaitForElement2(totalStoreCount, 10);

            if (totalStorecount.isDisplayed()) {
                System.out.println("Total Store Count := " + totalStorecount.getText());
                Assert.assertTrue(true);
            } else {
                System.out.println("Total Store Count Not Displayed");
                Assert.fail("Scenario Failed");
            }

            WebElement activeStorename = waithelper.WaitForElement2(activeStoreName, 10);
            System.out.println("Card Name : " + activeStorename.getText());

            WebElement activeStorecount = waithelper.WaitForElement2(activeStoreCount, 10);


            if (activeStorecount.isDisplayed()) {
                System.out.println("Active Store Count := " + activeStorecount.getText());
                Assert.assertTrue(true);
            } else {
                System.out.println("Active Store Count Not Displayed");
                Assert.fail("Scenario failed");
            }

            WebElement inactiveStorename = waithelper.WaitForElement2(inactiveStoreName, 10);
            System.out.println("Card Name : " + inactiveStorename.getText());

            WebElement inactiveStorecount = waithelper.WaitForElement2(inactiveStoreCount, 10);

            if (inactiveStorecount.isDisplayed()) {
                System.out.println("InActive Store Count := " + inactiveStorecount.getText());
                Assert.assertTrue(true);
            } else {
                System.out.println("InActive Store Count Not Displayed");
                Assert.fail("scenario Failed");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }


    }



    //Here we will print the list of stores

    //This method helps to get the list of data in the Product List

    public void StoreList() throws InterruptedException {
        ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);

        //here if only the
         logintype();


        widget_Store.click();
        widget_Stores.click();

        setupElements();
        try {

            List<WebElement> list = Store_list;


            if (!list.isEmpty()) {  // Check if the list is not empty
                waithelper.WaitForElement(list.get(0), 20); // Wait for the first element
            } else {
                System.out.println("No Data found for Stores");
            }
            // Locate all rows in the MuiDataGrid table
            List<WebElement> rows = Store_list;

            for (WebElement row : rows) {



                // Extract the Name
                WebElement storeId = row.findElement(Store_list_ID_Column);
                String StoreId = storeId.getText();

                WebElement StoreListStoreUniqueNameColumn = row.findElement(Store_List_Store_UniqueName_Column);
                String storeuniqueName = StoreListStoreUniqueNameColumn.getText();

                WebElement StoreListStoreType  = row.findElement(Store_List_Store_Type);
                String StoreType = StoreListStoreType.getText();

                WebElement StoreListStoreLocation = row.findElement(Store_List_Store_Location);
                String storeLocation = StoreListStoreLocation.getText();

                WebElement StoreListStoreStatus = row.findElement(Store_List_Store_Status);
                String storeStatus = StoreListStoreStatus.getText();





                // Print the extracted data
                System.out.println("Store  Id: "+ StoreId );
                System.out.println("Store Unique  Name: " +  storeuniqueName);
                System.out.println("Store Type: " + StoreType);
                System.out.println("Store Location: " + storeLocation);
               System.out.println("Store Status: " + storeStatus);

                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }








}
