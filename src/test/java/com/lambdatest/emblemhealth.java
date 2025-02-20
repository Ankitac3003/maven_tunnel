package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
//import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class emblemhealth {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "ankitclambdatest";//System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = "atW7tb1cf1bcEX9K4MZMW6mEPLWIhWZJWMdQeRtedrqf56wNxp";//System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");

        String hub = "@mobile-hub.lambdatest.com/wd/hub";

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "ios");
//        caps.setCapability("app","lt://APP1016038711727190524277622");
//        caps.setCapability("deviceName", "iPhone 15");
////        caps.setCapability("appiumVersion", "1.22.0");
//       // caps.setCapability("network", true);
//
//        caps.setCapability("selenium_version","3.13.0");
//        caps.setCapability("platformVersion", "17.2");
//        caps.setCapability("isRealMobile", false);
//        caps.setCapability("build", "TestNG With Java - Emblemhealth");
//        caps.setCapability("name", m.getName() + this.getClass().getName());
//        caps.setCapability("wc3", true);
//        caps.setCapability("isAppAutomate", true);

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("w3c", true);
//        ltOptions.put("platformName", "ios");
//        ltOptions.put("isRealMobile", false);
//        ltOptions.put("deviceName", "iPhone 15");
//        ltOptions.put("platformVersion", "17.2");
//        ltOptions.put("app", "lt://APP1016038711727190524277622");
//        capabilities.setCapability("lt:options", ltOptions);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("platformName", "ios");
        ltOptions.put("deviceName", "iPhone 15 Pro Max");
        ltOptions.put("platformVersion", "17.0");
        ltOptions.put("autoAcceptAlerts", true);
        ltOptions.put("network", true);
        ltOptions.put("visual", true);
        ltOptions.put("autoDismissAlerts", true);
        ltOptions.put("safariAllowPopups", true);
        ltOptions.put("build", "EmblemHealth - Previous plan");
        ltOptions.put("app", "lt://APP10160451051728399421740505");
        ltOptions.put("lambdaMaskCommands", new String[]{"setValues"});
        capabilities.setCapability("lt:options", ltOptions);




        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), capabilities);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;

        System.out.println("Loading Url");
        Thread.sleep(100);

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"I Accept\"]")).click();
        Thread.sleep(4000);

        WebElement element = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"Playground\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextField"));
        element.click();
        element.clear();
        element.sendKeys("https://emblemhealth--uat.sandbox.my.site.com/member/s/");
        Thread.sleep(4000);

        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Continue\"]")).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Username']")).sendKeys("k4991829101@emblemhealth.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@label='Done']")).click();
        Thread.sleep(3000);


        WebElement element1 = driver.findElement(By.xpath("//XCUIElementTypeSecureTextField[@name='Password']"));
        element1.click();
        element1.sendKeys("Welcome@1234");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Sign In\"]")).click();
        Thread.sleep(8000);

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Request Code']")).click();
        Thread.sleep(4000);


        driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"Haven't received a code?\"]/parent::*/parent::*/parent::*/XCUIElementTypeOther[3]//XCUIElementTypeTextField)[1]")).click();
        Thread.sleep(4000);

        Actions actions = new Actions(driver);
        actions.sendKeys("91328").perform();


        driver.findElement(By.xpath("//*[@label='Done']")).click();
        Thread.sleep(3000);

        driver.findElementById("Next").click();
        Thread.sleep(4000);


        driver.findElementById("FABIcon").click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//*[@label='Hide Button for Session'])[1]")).click();
        Thread.sleep(5000);
//        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Find Care\"]")).click();
//        Thread.sleep(7000);
//
//
//        // Scroll down on iOS
//  //      ((JavascriptExecutor) driver).executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
//
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        HashMap<String, String> scrollObject = new HashMap<String, String>();
////        scrollObject.put("direction", "down");
////        scrollObject.put("percent", "0.5");
////        js.executeScript("mobile: scroll", scrollObject);
//
//
//
//        WebElement element2 = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Primary Care Provider Service Type\"]"));
//        Actions actions1 = new Actions(driver);
//
//
//        actions1.doubleClick(element2).perform();
//        Thread.sleep(8000);
//
//
//        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next will take you to Location and Distance Page\"]")).click();
//        Thread.sleep(4000);
//
//
//        driver.findElementById("Allow While Using App").click();
//        Thread.sleep(4000);
//
//        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next will take you to Provider Search Results Page\"]")).click();
//        Thread.sleep(4000);
//
//        ((JavascriptExecutor) driver).executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
//        Thread.sleep(9000);
//
//        driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"View Profile will take you to Provider Details Page\"])[1]")).click();
//        Thread.sleep(4000);
        driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name=\"Menu\"])[1]")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("(//XCUIElementTypeLink[@name=\"Benefits and Spending\"])[1]")).click();
        Thread.sleep(6000);

        WebElement element2 = driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Benefits and Spending']"));
        System.out.println("Benefits and Spending" + element2.getText());
        Thread.sleep(5000);

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Previous Plan(s)\"]")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Current Plan(s)\"]")).click();
        Thread.sleep(4000);


        Status = "passed";
        Thread.sleep(8000);

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}