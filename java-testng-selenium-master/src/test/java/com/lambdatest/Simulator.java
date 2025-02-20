package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Simulator {

    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private String Status = "passed"; // Default status as 'passed'

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "ankitclambdatest";
        String authkey = "hR73QCNxdF0BuMAlPNX68ECLoRl6TI8RsWkq8hfpi15roLzYju";

        String hub = "https://" + username + ":" + authkey + "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("deviceName", "iPhone 15");
        capabilities.setCapability("appiumVersion", "2.6.0");
        capabilities.setCapability("platformVersion", "17.0");



        driver = new RemoteWebDriver(new URL(hub), capabilities);

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void basicTest() {
        try {
            // Open the target URL
            driver.get("https://emblemhealth--uat.sandbox.my.site.com/ccimember/s/login/?ec=301&startURL=%2Fccimember%2Fs%2Fbenefits");

            // Wait and interact with email input field using JavaScriptExecutor
          driver.findElement(By.xpath("//*[@id='centerPanel']/div/div[2]/div/div/c-member-custom-login/div/div/div/div[1]/div[3]/div/input")).sendKeys("k1020031001@emblemhealth.com");

          Thread.sleep(5000);
          driver.findElement(By.xpath("//*[@id='centerPanel']/div/div[2]/div/div/c-member-custom-login/div/div/div/div[2]/div/div/input")).sendKeys( "Welcome@2025");

            // Click the login button
            driver.findElement(By.xpath("//*[@id='centerPanel']/div/div[2]/div/div/c-member-custom-login/div/div/div/div[4]/div[1]/a"))
                    .click();

            Thread.sleep(10000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
//            // Wait and interact with the "Next" button for two-step verification
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='TwoStepVerification_nextBtn']")));
            driver.findElement(By.xpath("//*[@id='TwoStepVerification_nextBtn']")).click();
            Thread.sleep(10000);
//
//            // Wait and interact with OTP fields using JavaScriptExecutor
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='otp']")));
//            js.executeScript("arguments[0].setAttribute('value', arguments[1]);",
//                    driver.findElement(By.xpath("//*[@id='first']")), "1");
//            js.executeScript("arguments[0].setAttribute('value', arguments[1]);",
//                    driver.findElement(By.xpath("//*[@id='second']")), "2");
//            js.executeScript("arguments[0].setAttribute('value', arguments[1]);",
//                    driver.findElement(By.xpath("//*[@id='third']")), "3");
//            js.executeScript("arguments[0].setAttribute('value', arguments[1]);",
//                    driver.findElement(By.xpath("//*[@id='fourth']")), "4");
//            js.executeScript("arguments[0].setAttribute('value', arguments[1]);",
//                    driver.findElement(By.xpath("//*[@id='fifth']")), "5");

            // If all interactions succeed, set the status to 'passed'
            Status = "passed";
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            // Update the LambdaTest test status
            driver.executeScript("lambda-status=" + Status);

            // Quit the driver
            driver.quit();
        }
    }
}
