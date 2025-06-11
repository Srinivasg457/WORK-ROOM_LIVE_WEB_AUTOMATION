package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExcelUtil;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class WorkroomLoginPage {
    public WebDriver ldriver;
    WaitHelper waitHelper;
    public Properties configprop;
    public Map<String, String> locators; // <- NEW

    // Declare WebElement variables outside methods, but inside the class
    WebElement txtEmail;
    WebElement txtPassword;
    WebElement loginbutton;
//    WebElement logoutbutton;

    public WorkroomLoginPage(WebDriver rdriver) throws IOException {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
        waitHelper=new WaitHelper(ldriver);

        configprop = new Properties();
        FileInputStream configProfile = new FileInputStream("/home/limitscale/Desktop/WorkRoom/Live_WorkRoomWebautomation/src/test/resources/config.properties");
        configprop.load(configProfile);

        // Load XPath locators from Excel
       // locators = ExcelUtil.readLocators("/home/limitscale/WorkingProject/Live_ChataakProjectWebautomation/src/test/resources/chataakWebApplicationXpath.xlsx");

        String excelPath = getClass().getClassLoader().getResource("chataakWebApplicationXpath.xlsx").getPath();
        locators = ExcelUtil.readLocators(excelPath);

        // Now initialize elements
//        setupElements();


    }

    //xpath identification
    @FindBy(xpath="//a[normalize-space()='Create here a free trial']")
    @CacheLookup
    WebElement ClickLink_SignUpLink;



    @FindBy(xpath="//span[normalize-space()='Employees']")
   @CacheLookup
    WebElement sideMenu_Employees;

    @FindBy(id = "dg_table")
    @CacheLookup
    WebElement dg_table;


    @FindBy(css = "#dg_table tbody tr")
    @CacheLookup
    private List<WebElement> rows;




    @FindBy(xpath = "//span[normalize-space()='Analytics']")
    @CacheLookup
    WebElement analytics;



    @FindBy(xpath = "//span[normalize-space()='View Screenshots']")
    @CacheLookup
    WebElement screenShots;


    //Locators
//    @FindBy(xpath="//input[@placeholder='johndoe@example.com']")
//    @CacheLookup
//    WebElement txtEmail;


//    @FindBy(xpath="//input[@placeholder='Password']")
//    @CacheLookup
//    WebElement txtPassword;

//    @FindBy(xpath="//button[normalize-space()='Login']")
//    @CacheLookup
//    WebElement btnLogin;


    @FindBy(xpath="//li[normalize-space()='Sign Out']")
    @CacheLookup
    WebElement Logout;

    @FindBy(xpath="//p[@aria-label='Organization Type : Merchant']")
    @CacheLookup
    WebElement owner;



    @FindBy(xpath="//div[@role='status']")
    @CacheLookup
    WebElement status;



    @FindBy(xpath="//div[@class='error text-danger bg-danger-soft rounded-1 py-2 px-3']")
    @CacheLookup
    WebElement loginstatus;




    //xpath reading from the xcelfile

    // After constructor, use this to safely access locators
    private void setupElements() {
        txtEmail = ldriver.findElement(By.xpath(locators.get("EmailAddress")));
        txtPassword = ldriver.findElement(By.xpath(locators.get("password")));
        loginbutton = ldriver.findElement(By.xpath(locators.get("login_Button")));
//        logoutbutton=ldriver.findElement(By.xpath(locators.get("logout_Button")));

    }


    //Action Method
    public void clickLink() {
        ClickLink_SignUpLink.click();
    }


    public void Email(String email) {
        // waithelper.WaitForElement(txtEmail,10);
//        txtEmail.click();
//        txtEmail.clear();
//        txtEmail.sendKeys(email);
 //       WebElement txtEmail = ldriver.findElement(By.xpath(locators.get("EmailAddress")));
            setupElements();
            txtEmail.click();
            txtEmail.clear();
            txtEmail.sendKeys(email);

    }

    public void password(String password) {

//        txtPassword.click();
//        txtPassword.clear();
//        txtPassword.sendKeys(password);
 //       WebElement txtPassword = ldriver.findElement(By.xpath(locators.get("password")));


        setupElements();
        txtPassword.click();
        txtPassword.clear();
        txtPassword.sendKeys(password);


    }

    public void Login() {
 //       btnLogin.click();

 //       WebElement loginbutton= ldriver.findElement(By.xpath(locators.get("login_Button")));
        setupElements();
        loginbutton.click();
    }

    public void Logout() {
        Logout.click();
    }

    public void  OwnerType() {
        owner.getText();
        System.out.println(owner.getText());
    }


//    public void statusmessage() throws InterruptedException {
//        Thread.sleep(4000); // Wait for 4 seconds
//        System.out.println("Attempting to click sideMenu_Employees");
//
//        waitHelper.WaitForElement(sideMenu_Employees, 10);
//        sideMenu_Employees.click();
//        System.out.println("Clicked sideMenu_Employees");
//        System.out.println(ldriver.getCurrentUrl());
//
//        WebElement table = dg_table;
//
//        if (table.isDisplayed()) {
//            try {
//                List<WebElement> row = rows;
//
//                if (row.isEmpty()) {
//                    System.out.println("No employee data found.");
//                    return;
//                }
//
//                // Print table headers with wider columns
//                System.out.printf(
//                        "%-5s %-30s %-30s %-15s %-40s %-60s %-12s %-100s%n",
//                        "No.", "Name", "Email", "Phone", "Department", "Address", "Status", "Image URL"
//                );
//                System.out.println(
//                        "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
//                );
//
//                for (int i = 0; i < row.size(); i++) {
//                    WebElement ro = row.get(i);
//                    List<WebElement> cells = ro.findElements(By.tagName("td"));
//
//                    String image = "";
//                    try {
//                        image = cells.get(1).findElement(By.tagName("img")).getAttribute("src");
//                    } catch (Exception e) {
//                        image = "No image";
//                    }
//
//                    List<WebElement> nameDetails = cells.get(2).findElements(By.tagName("p"));
//                    String name = nameDetails.size() > 0 ? nameDetails.get(0).getText() : "No name";
//                    String email = nameDetails.size() > 1 ? nameDetails.get(1).getText() : "No email";
//                    String phone = nameDetails.size() > 2 ? nameDetails.get(2).getText() : "No phone";
//
//                    String department = cells.get(3).getText().trim();
//
//                    List<WebElement> addressLines = cells.get(4).findElements(By.tagName("p"));
//                    StringBuilder address = new StringBuilder();
//                    for (WebElement line : addressLines) {
//                        if (!line.getText().isEmpty()) {
//                            address.append(line.getText().trim()).append(", ");
//                        }
//                    }
//                    String addressStr = address.length() > 0
//                            ? address.substring(0, address.length() - 2)
//                            : "No address";
//
//                    String status = cells.get(5).getText().trim();
//
//                    // Print employee row
//                    System.out.printf(
//                            "%-5d %-30s %-30s %-15s %-40s %-60s %-12s %-100s%n",
//                            i + 1, name, email, phone, department, addressStr, status, image
//                    );
//                    System.out.println("End");
//
//
//                }
//
//
//            } catch (Exception e) {
//                System.out.println("Error occurred: " + e.getMessage());
//                e.printStackTrace();
//            }
//
//        } else {
//            System.out.println("Employees List is Empty or table not visible.");
//        }
//
//      waitHelper.WaitForElement(analytics,10);
//        analytics.click();
//        waitHelper.WaitForElement(screenShots,10);
//        screenShots.click();
//
//
//        try {
//            // Find all screenshot cards
//            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".screenshot-card")));
//            List<WebElement> screenshotCards = ldriver.findElements(By.cssSelector(".screenshot-card"));
//
//            if (screenshotCards.isEmpty()) {
//                System.out.println(" No screenShots Data found   ");
//            } else {
//                for (WebElement card : screenshotCards) {
//                    try {
//                        // Extract activity percent
//                        String activityPercent = card.findElement(By.cssSelector(".donut-chart div")).getText().trim();
//
//                        // Extract time
//                        String time = card.findElement(By.cssSelector("p")).getText().trim();
//
//                        System.out.println("Time: " + time + " | Activity: " + activityPercent);
//                    } catch (Exception innerEx) {
//                        System.out.println("Error parsing a screenshot card: " + innerEx.getMessage());
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            System.out.println("An error occurred while extracting data: " + e.getMessage());
//        }
//    }


    public void statusmessage() throws InterruptedException {
        Thread.sleep(4000); // Wait for 4 seconds
        System.out.println("Attempting to click sideMenu_Employees");

        waitHelper.WaitForElement(sideMenu_Employees, 10);
        sideMenu_Employees.click();
        System.out.println("Clicked sideMenu_Employees");
        System.out.println(ldriver.getCurrentUrl());

        WebElement table = dg_table;

        if (table.isDisplayed()) {
            try {
                List<WebElement> row = rows;

                if (row.isEmpty()) {
                    System.out.println("No employee data found.");
                } else {
                    // Print table headers with wider columns
                    System.out.printf(
                            "%-5s %-30s %-30s %-15s %-40s %-60s %-12s %-100s%n",
                            "No.", "Name", "Email", "Phone", "Department", "Address", "Status", "Image URL"
                    );
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
                    );

                    for (int i = 0; i < row.size(); i++) {
                        WebElement ro = row.get(i);
                        List<WebElement> cells = ro.findElements(By.tagName("td"));

                        String image = "";
                        try {
                            image = cells.get(1).findElement(By.tagName("img")).getAttribute("src");
                        } catch (Exception e) {
                            image = "No image";
                        }

                        List<WebElement> nameDetails = cells.get(2).findElements(By.tagName("p"));
                        String name = nameDetails.size() > 0 ? nameDetails.get(0).getText() : "No name";
                        String email = nameDetails.size() > 1 ? nameDetails.get(1).getText() : "No email";
                        String phone = nameDetails.size() > 2 ? nameDetails.get(2).getText() : "No phone";

                        String department = cells.get(3).getText().trim();

                        List<WebElement> addressLines = cells.get(4).findElements(By.tagName("p"));
                        StringBuilder address = new StringBuilder();
                        for (WebElement line : addressLines) {
                            if (!line.getText().isEmpty()) {
                                address.append(line.getText().trim()).append(", ");
                            }
                        }
                        String addressStr = address.length() > 0
                                ? address.substring(0, address.length() - 2)
                                : "No address";

                        String status = cells.get(5).getText().trim();

                        // Print employee row
                        System.out.printf(
                                "%-5d %-30s %-30s %-15s %-40s %-60s %-12s %-100s%n",
                                i + 1, name, email, phone, department, addressStr, status, image
                        );
                        System.out.println("End");
                    }
                }

            } catch (Exception e) {
                System.out.println("Error occurred while reading employee data: " + e.getMessage());
                e.printStackTrace();
            }

        } else {
            System.out.println("Employees List is Empty or table not visible.");
        }

        try {
            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(analytics));
            ((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", analytics);
            Thread.sleep(500);
            ((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", analytics);
            System.out.println("Clicked on Analytics successfully.");
        } catch (Exception e) {
            System.out.println("Failed to click on Analytics: " + e.getMessage());
        }

        try {
            waitHelper.WaitForElement(screenShots, 10);
            screenShots.click();
            System.out.println("Clicked on Screenshots tab.");

            ((JavascriptExecutor) ldriver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(2000); // Allow time for dynamic content to load

//            // Handle iframe if screenshots are inside one
//            List<WebElement> iframes = ldriver.findElements(By.tagName("iframe"));
//            boolean switchedToIframe = false;
//            for (WebElement iframe : iframes) {
//                ldriver.switchTo().frame(iframe);
//                List<WebElement> test = ldriver.findElements(By.cssSelector(".screenshot-card"));
//                if (!test.isEmpty()) {
//                    System.out.println("Switched to iframe containing screenshot cards.");
//                    switchedToIframe = true;
//                    break;
//                }
//                ldriver.switchTo().defaultContent(); // try next iframe
//            }

            // Now safely attempt to get screenshot cards
            List<WebElement> screenshotCards = ldriver.findElements(By.cssSelector(".screenshot-card"));

            if (screenshotCards.isEmpty()) {
                System.out.println("No screenshot data found.");
            } else {
                System.out.println("Found " + screenshotCards.size() + " screenshot cards.");
                for (WebElement card : screenshotCards) {
                    try {
                        String activityPercent = card.findElement(By.cssSelector(".donut-chart div")).getText().trim();
                        String time = card.findElement(By.cssSelector("p")).getText().trim();
                        System.out.println("Time: " + time + " | Activity: " + activityPercent);
                    } catch (Exception innerEx) {
                        System.out.println("Error parsing a screenshot card: " + innerEx.getMessage());
                    }
                }
            }

            // Always switch back to default content
//            if (switchedToIframe) {
//                ldriver.switchTo().defaultContent();
//            }

        } catch (Exception e) {
            System.out.println("An error occurred while extracting screenshot data: " + e.getMessage());
        }
    }




    public void loginStatus() throws InterruptedException {
        Thread.sleep(4000); // Wait for 4 seconds
        waitHelper.WaitForElement(loginstatus,10);
        System.out.println(loginstatus.getText());
        String loginStatusMessage=loginstatus.getText();

        if(loginStatusMessage.equalsIgnoreCase("Sorry your username or password is not correct!")){
            Assert.assertTrue(true);
        }
        else{
            Assert.fail("Error Message is Not  According to Expected");
        }


    }







}
