package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ivy {

    private static RemoteWebDriver driver;

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "ankitclambdatest";
        String authkey = "aLUgd5KFYN0EdT2goOgehYni7amc56TGvV2km1OlZFBgQ21oJs";
        String hub = "@hub.lambdatest.com/wd/hub";


//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "Chrome");
//        capabilities.setCapability("browserVersion", "130");
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", "ankitclambdatest");
//        ltOptions.put("accessKey", "aLUgd5KFYN0EdT2goOgehYni7amc56TGvV2km1OlZFBgQ21oJs");
//        ltOptions.put("platformName", "Windows 10");
//        ltOptions.put("console", true);
//
//        ltOptions.put("project", "Untitled");
//        capabilities.setCapability("LT:Options", ltOptions);
// below are chrrome options added

//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // replace with your actual path

//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setCapability("platform","Windows 10");
//        browserOptions.setCapability("browserVersion","110");
//        browserOptions.setCapability("disable-popup-blocking", true);
//        browserOptions.addArguments("--disable-web-security");
//        browserOptions.addArguments("--allow-running-insecure-content");
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", "ankitclambdatest");
//        ltOptions.put("accessKey", "aLUgd5KFYN0EdT2goOgehYni7amc56TGvV2km1OlZFBgQ21oJs");
//        ltOptions.put("project", "Untitled");
//        ltOptions.put("selenium_version", "4.0.0");
//        ltOptions.put("console", true);
//        //ltOptions.put("dedicatedProxy", true);
//        ltOptions.put("command", false);
//
//       // ltOptions.put("smartwait", 20);




//        ltOptions.put("w3c", true);
//        browserOptions.setCapability("LT:Options", ltOptions);

        // Setting capabilities


        // Initializing the driver with options
//        WebDriver driver = new ChromeDriver(options);


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Safari");
        capabilities.setCapability("browserVersion", "11");

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "ankitclambdatest");
        ltOptions.put("accessKey", "aLUgd5KFYN0EdT2goOgehYni7amc56TGvV2km1OlZFBgQ21oJs");
        ltOptions.put("platformName", "macOS Mojave");

        ltOptions.put("project", "Untitled");
//        ltOptions.put("smartWait", 10);


        capabilities.setCapability("LT:Options", ltOptions);
//        System.out.println(Capabilities.toString());



//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "60");
//        //
//       // capabilities.setCapability("dedicatedProxy", true);
//
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", "ankitclambdatest");
//        ltOptions.put("accessKey", "Jdss0sjCiLWvzHrnPwS2is9nklBaEEnMo6lE8XB24IiYLa3Jtn");
//        ltOptions.put("platformName", "Windows 10");
//        ltOptions.put("project", "Untitled");
////        ltOptions.put("dedicatedProxy", true);
//






//        System.out.println(Capabilities.toString());
//        System.out.println(Capabilities.toString());

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), capabilities);
    }

    @Test
    public void basicTest() throws InterruptedException {
        System.out.println("Loading Url");

        driver.get("https://WebUser:9b4m57aB7+M@preprod-hcp.merckgroup.com/br-pt/medinfo/home/neurology.html");
        Thread.sleep(1000);
        Thread.sleep(1000);
        Thread.sleep(5000);

        driver.get("https://www.fakemail.net/");
        System.out.println(driver.getPageSource());





        // driver.get("https://mobile-api.lambdatest.com/mobile-automation/api/v1/list?utm_source=lambdatest-community");
       Thread.sleep(5000);
//        Thread.sleep(5000);
//        Thread.sleep(5000);
//        Thread.sleep(50000);

//driver.quit();
        Thread.sleep(5000);

        driver.findElementByXPath("//button[@id='onetrust-accept-btn-handler']\n").click();

        Thread.sleep(5000);
        Thread.sleep(5000);
        driver.quit();




        driver.findElementByXPath("//*[@id=\"centerPanel\"]/div/div[2]/div/div/c-member-custom-login/div/div/div/div[1]/div[3]/div/input")
                .sendKeys("k6086314501@emblemhealth.com");
        Thread.sleep(3000);

        driver.findElementByXPath("//*[@id=\"centerPanel\"]/div/div[2]/div/div/c-member-custom-login/div/div/div/div[2]/div/div/input")
                .sendKeys("Member@1234");
        Thread.sleep(3000);

        driver.findElementByXPath("//*[@id=\"centerPanel\"]/div/div[2]/div/div/c-member-custom-login/div/div/div/div[4]/div[1]/a")
                .click();
        Thread.sleep(5000);
        Thread.sleep(5000);

        // Clicking 'Request Code' button
        driver.findElementByXPath("//button[@id='TwoStepVerification_nextBtn' and contains(@class, 'roundButton') and contains(text(), 'Request Code')]")
                .click();
        Thread.sleep(15000); // Waiting for the next step

        // Fetch the 'first' element and set the value using JavaScriptExecutor
        driver.findElementByXPath("//*[@id=\"first\"]").click();
        Thread.sleep(5000);
        Map<String, Object> params1 = new HashMap<>();
        params1.put("command", "keyevent");
        params1.put("keycode", 16);
        driver.executeScript("lambda-adb",params1);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", element, "2");
        Thread.sleep(5000);
        Thread.sleep(5000);
        //input[@id='second']

        WebElement element1 = driver.findElementByXPath("//input[@id='second']");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].setAttribute('value', arguments[1]);", element1, "4");
        Thread.sleep(5000);


        WebElement element2 = driver.findElementByXPath("//input[@id='third']");
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].setAttribute('value', arguments[1]);", element2, "7");
        Thread.sleep(5000);


        WebElement element3 = driver.findElementByXPath("//input[@id='fourth']");
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("arguments[0].setAttribute('value', arguments[1]);", element3, "9");
        Thread.sleep(5000);


        WebElement element4 = driver.findElementByXPath("//input[@id='fifth']");
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("arguments[0].setAttribute('value', arguments[1]);", element4, "8");
        Thread.sleep(5000);
        Thread.sleep(5000);
        Thread.sleep(5000);

        // Proceed with the rest of the OTP inputs
//        driver.findElementByXPath("//*[@id=\"second\"]").sendKeys("1");
//        Thread.sleep(5000);
//        driver.findElementByXPath("//*[@id=\"third\"]").sendKeys("3");
//        Thread.sleep(3000);
//        driver.findElementByXPath("//*[@id=\"fourth\"]").sendKeys("2");
//        Thread.sleep(3000);
//        driver.findElementByXPath("//*[@id=\"fifth\"]").sendKeys("8");
//        Thread.sleep(3000);
    }
}
