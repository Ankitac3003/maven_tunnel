package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Browserstack {

    private static RemoteWebDriver driver;

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        // BrowserStack credentials (use environment variables for security)
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String authkey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        String hubURL = "https://" + username + ":" + authkey + "@hub.browserstack.com/wd/hub";

        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<>();

        // Set BrowserStack options for Windows 10 with Chrome
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "10");
        bstackOptions.put("browserName", "Chrome");
        bstackOptions.put("browserVersion", "latest"); // Use latest Chrome version
        bstackOptions.put("projectName", "BrowserStack Test");
        bstackOptions.put("buildName", "Windows Chrome Test");

        capabilities.setCapability("bstack:options", bstackOptions);

        // Initialize the RemoteWebDriver with BrowserStack hub URL and capabilities
        driver = new RemoteWebDriver(new URL(hubURL), capabilities);
    }

    @Test
    public void basicTest() {
        try {
            System.out.println("Loading URL");

            // Load URL
            driver.get("https://Vuitton:Rv65lD3S@jp-ppf.louisvuitton.com/jpn-jp/broadcasts?showId=yfpyhQ31Nhms2PWDJh21&dispatchCountry=JP&lvAppConfig=digital&nodeEnv=t4f");

            // Wait for page to load
            WebDriverWait wait = new WebDriverWait(driver, 30);

            // Example: Checking if a specific element is visible after loading
            WebElement someElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
            System.out.println("Page loaded successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
