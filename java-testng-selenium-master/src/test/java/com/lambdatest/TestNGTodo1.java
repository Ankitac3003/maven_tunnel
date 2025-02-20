package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo1 {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "ankitclambdatest";
        String authkey = "LT_OnEL30AtoPH0BkcY83K0VnpQOcfFpX71axsfQgHGLhvNfUP";
        String hub = "https://"+ username + ":" + authkey + "@hub.lambdatest.com/wd/hub";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows 10");
        chromeOptions.setCapability("browserName", "chrome");

        // LambdaTest Options with Network Logging
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", authkey);
        ltOptions.put("project", "CDP Network Capture");
        ltOptions.put("pageLoadStrategy", "eager");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
//        ltOptions.put("console", true);
        ltOptions.put("dedicatedProxy", true);
//        ltOptions.put("network", true); // Enable network logging in LambdaTest
        ltOptions.put("region", "us");

        chromeOptions.setCapability("LT:Options", ltOptions);
        driver = new RemoteWebDriver(new URL(hub), chromeOptions);
    }

    @Test
    public void basicTest() {
        try {
            driver.get("https://Vuitton:Rv65lD3S@jp-ppf.louisvuitton.com/jpn-jp/broadcasts?showId=yfpyhQ31Nhms2PWDJh21&dispatchCountry=JP&lvAppConfig=digital&nodeEnv=t4f");

            Thread.sleep(60000);
            Thread.sleep(60000);

            driver.quit();

            WebDriverWait wait = new WebDriverWait(driver, (10));

            // Close popup if it appears
            try {
                WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("#lv-modal-target > div.lv-modal.-popin.lv-localize-modal > div:nth-child(3) > div > div > button > svg")));
                closePopup.click();
            } catch (TimeoutException e) {
                System.out.println("No popup appeared.");
            }

            // Click button
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"main\"]/div/div[2]/div/button")));
            button.click();

            // Wait for video playback (if needed)
            Thread.sleep(40000);

            // Retrieve VM time
            String vmTime = (String) driver.executeScript("return new Date().toString();");
            System.out.println("Current Time on LambdaTest VM: " + vmTime);

            Status = "passed";
            System.out.println("Test Finished");

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
        }
    }
    @AfterMethod
    public void tearDown() {
        try {
            driver.executeScript("lambda-status=" + Status);
        } catch (Exception e) {
            System.err.println("Error setting LambdaTest status: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
