package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class balck {

    RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {

        String username = "ankitclambdatest";
        String authkey = "hR73QCNxdF0BuMAlPNX68ECLoRl6TI8RsWkq8hfpi15roLzYju";

        String hub = "@hub.lambdatest.com/wd/hub";


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 11");
        caps.setCapability(      "acceptSslCerts", true);
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "latest");
        caps.setCapability("acceptInsecureCerts", true);
//        caps.setCapability("dedicatedProxy", true);

        caps.setCapability("build","ankit");

//        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.setCapability("platformName","Windows 10");
//        browserOptions.setCapability("version","latest");
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", "ankitclambdatest");
//        ltOptions.put("accessKey", "PnyIl8jWlSbpmJFvuFTPuX3us9g8tRLm7z67X0E4PfZ39HZHOq");
//        ltOptions.put("project", "Untitled");
//        ltOptions.put("selenium_version", "4.0.0");
//        ltOptions.put("w3c", true);
//        browserOptions.setCapability("LT:Options", ltOptions);


        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
        driver.setFileDetector(new LocalFileDetector());

    }


    @Test
    public void basicTest() throws Exception {
        String spanText;
        System.out.println("Loading Url");

        driver.get("https://www.tripadvisor.com/UserReviewEdit-g3157806-d20832844-Automated_Test_Product_Only_Tour_Freesale-Bulli_Wollongong_New_South_Wales.html");

        WebElement fileInput = driver.findElement(By.cssSelector("[data-automation='photo-upload-trigger'] + input"));
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", fileInput);
        // Using above because that field is hidden using above we unhide it so that we can access it

        Thread.sleep(2000);

        String filePath = "C:/Users/ankitc/Downloads/5.jpg";
        fileInput.sendKeys(filePath);

        Thread.sleep(8000);
        Status = "passed";

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}