package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.concurrent.TimeUnit;

public class ChataakStoresPage {

    public WebDriver ldriver;
    WaitHelper waithelper;

    //constructor
    public ChataakStoresPage (WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
        waithelper=new WaitHelper(ldriver);
    }




    //xpath identification


    //Locators
    @FindBy(xpath="//input[@placeholder='johndoe@example.com']")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(xpath="//input[@placeholder='Password']")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="//button[normalize-space()='Login']")
    @CacheLookup
    WebElement btnLogin;


    @FindBy(xpath="//li[normalize-space()='Sign Out']")
    @CacheLookup
    WebElement Logout;

    @FindBy(xpath="//p[@aria-label='Organization Type : Merchant']")
    @CacheLookup
    WebElement owner;


    @FindBy(xpath="//p[normalize-space()='Store Manager']")
    @CacheLookup
    WebElement Storemanager_Drp;


    @FindBy(xpath="//a[contains(@href,'/store/')]//div[contains(@class,'MuiBox-root css-1yhyvdz')]")
    @CacheLookup
    WebElement Storemanager_Stores;


    @FindBy(xpath="//button[normalize-space()='Add Store']")
    @CacheLookup
    WebElement btn_AddStore;


    //xpath for the add new store form

    @FindBy(xpath="(//input[@placeholder='Store name'])[1]")
    @CacheLookup
    WebElement txt_StoreUniqueName;

    @FindBy(xpath="(//input[@placeholder='Display Name'])[1]")
    @CacheLookup
    WebElement txt_DisplayName;

    @FindBy(xpath="(//div[@class=' css-19bb58m'])[1]")
    @CacheLookup
    WebElement drp_Storetype;



    @FindBy(xpath="//div[text()='Company Owned']")
    @CacheLookup
    WebElement drp_CompanyOwned;



    @FindBy(xpath="//div[text()='ALL FURNITURES']")
    @CacheLookup
    WebElement drp_furniture;

    @FindBy(xpath="//input[@id='react-select-4-input']")
    @CacheLookup
    WebElement drp_industry;

    @FindBy(xpath="//div[text()='Outlet retailers']")
    @CacheLookup
    WebElement drp_Outletretailer;



    @FindBy(xpath="//input[@id='react-select-5-input']")
    @CacheLookup
    WebElement drp_Staff;

    @FindBy(xpath="//div[text()='Store Manager']")
    @CacheLookup
    WebElement drp_Manager;






    @FindBy(xpath="//input[@id='react-select-6-input']")
    @CacheLookup
    WebElement drp_Country;

    @FindBy(xpath="(//div[text()='India'])[2]")
    @CacheLookup
    WebElement drp_country_india;

    @FindBy(xpath="//input[@id='react-select-7-input']")
    @CacheLookup
    WebElement drp_State;

    @FindBy(xpath="//div[text()='Karnataka']")
    @CacheLookup
    WebElement drp_State_Karnataka;


    //   (//*[local-name()='svg'])[77]
    @FindBy(xpath="//input[@id='react-select-8-input']")
    @CacheLookup
    WebElement drp_City;



    @FindBy(xpath="(//div[@role='option'])[2]")
    @CacheLookup
    WebElement drp_City_Bangalore;

    @FindBy(xpath="//input[@placeholder='Address']")
    @CacheLookup
    WebElement txt_Address;

    //input[@placeholder='Postal code']

    @FindBy(xpath="//input[@placeholder='Postal Code']")
    @CacheLookup
    WebElement txt_postalCode;

    @FindBy(xpath="//input[@type='checkbox']")
    @CacheLookup
    WebElement chkbxk_IsMerchantAccount;

    //Merchant account


    @FindBy(xpath="(//*[local-name()='svg' and @height='20' and @width='20' and @viewBox='0 0 20 20'])[8]")
    @CacheLookup
    WebElement drp_MerchantOrganization;


    @FindBy(xpath="//div[text()='HOME FURNITURES']")
    @CacheLookup
    WebElement drp_MerchantStore;


    @FindBy(xpath="//button[normalize-space()='Add Products']")
    @CacheLookup
    WebElement btn_Addproducts;
    //th[@class='MuiTableCell-root MuiTableCell-head MuiTableCell-sizeMedium css-1d4n6qt']//input[@type='checkbox']

    @FindBy(xpath="/html/body/div[9]/div[3]/div[2]/table/tbody/tr[2]/td[1]/span/input")
    @CacheLookup
    WebElement chkbxk_AllItems;



    @FindBy(xpath="//div[@class='MuiBox-root css-1xbsatb']//button[@type='button'][normalize-space()='Cancel']")
    @CacheLookup
    WebElement btn_cancel;





    @FindBy(xpath="//div[@class='MuiTableContainer-root css-58obqq']")
    @CacheLookup
    WebElement table_Products;

    @FindBy(xpath="//th[@class='MuiTableCell-root MuiTableCell-head MuiTableCell-sizeMedium css-1d4n6qt']//input[@type='checkbox']")
    @CacheLookup
    WebElement table_Data;




    @FindBy(xpath="//button[normalize-space()='Add Selected Products']")
    @CacheLookup
    WebElement btn_AddSelectedProducts;


    @FindBy(xpath="//div[@class='MuiBox-root css-19heefx']//button[@type='submit'][normalize-space()='Submit']")
    @CacheLookup
    WebElement btn_SubmitStore;


    //status message
    //  Latitude or Longitude cannot be null, empty, or '0'. Please check with your the address.


    @FindBy(xpath="//div[@role='status']")
    @CacheLookup
    WebElement msg_Status;


    //new xpaths


    @FindBy(xpath="//div[@class='MuiListItemIcon-root css-qvvxne']/following-sibling::div")
    @CacheLookup
    WebElement widget_Store;



    @FindBy(xpath="//p[normalize-space()='Stores']")
    @CacheLookup
    WebElement widget_Stores;

    //button[normalize-space()='Add Store']
    @FindBy(xpath="//button[normalize-space()='Add Store']")
    @CacheLookup
    WebElement Btn_AddStore;



    @FindBy(xpath="(//button[contains(text(), 'Get Location')])[1]")
    @CacheLookup
    WebElement btn_getlocation;

    @FindBy(xpath="//div[@role='status']")
    @CacheLookup
    WebElement status_message;

    //Action Method


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

    public void  OwnerType() {
        owner.getText();
        System.out.println(owner.getText());
    }

    public void  Storemanager() {
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
        if(table_Products.isDisplayed()) {
            System.out.println("Table  displayed");


        }else {
            System.out.println("Table is not displayed");
        }

        if(!table_Data.isSelected()) {
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
        String errormessage=msg_Status.getText();
        System.out.println(errormessage);


        try {
            if(errormessage.equals("Latitude or Longitude cannot be null, empty, or '0'. Please check with your the address.")) {
                Assert.assertTrue(false);
            }
            else {
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

    public void status(){

        waithelper.WaitForElement(status_message, 10);
        String ExpectedStatus="The store name already exists in your organization. Please choose unique name to continue";
        String ActualStatus=status_message.getText();
        if(ActualStatus.equals(ExpectedStatus)){
            Assert.assertTrue(true);
        } else if (ActualStatus.equalsIgnoreCase("Added Successfully")) {
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }




}
