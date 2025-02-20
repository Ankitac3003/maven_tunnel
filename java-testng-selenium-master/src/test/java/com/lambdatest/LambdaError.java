package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static javax.swing.UIManager.put;

public class LambdaError {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "ankitclambdatest";
        String authkey = "aief12PkGvo5QIW4xnIcPSslNTqLMQy7Vv4FsyNHNhfIgKkhBJ";

        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        // Common capabilities
        desiredCapabilities.setCapability("acceptInsecureCerts", true);
        desiredCapabilities.setCapability("browserName", "firefox");
        desiredCapabilities.setCapability("browser_version", "71.0");
        desiredCapabilities.setCapability("platformName", "windows 7");
        desiredCapabilities.setCapability("pageLoadStrategy", "normal");
        desiredCapabilities.setCapability("moz:debuggerAddress", true);

        // Logging preferences
        desiredCapabilities.setCapability("loggingPrefs", Map.of(
                "browser", "ALL",
                "driver", "ALL",
                "performance", "ALL",
                "server", "ALL"
        ));

        // LambdaTest specific options
        Map<String, Object> ltOptions = Map.of(
                "browser_name", "firefox",
                "browser_version", "71.0",
                "build", "Tracker: 7.39.0 FULL 2024-12-09 03:39",
                "local", "false",
                "name", "firefox 71.0 windows 7 Simulated",
                "plugin", "python-python",
                "w3c", true
        );
        desiredCapabilities.setCapability("lt:options", ltOptions);

        // Additional custom capabilities
        desiredCapabilities.setCapability("headless", false);
        desiredCapabilities.setCapability("network", false);
        desiredCapabilities.setCapability("performance", false);
        desiredCapabilities.setCapability("console", "false");
        desiredCapabilities.setCapability("extendedDebuging", true);
        desiredCapabilities.setCapability("visual", false);
        desiredCapabilities.setCapability("video", true);
        desiredCapabilities.setCapability("resolution", "1920x1080");

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub),desiredCapabilities);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;

//        Thread.sleep(10000);
//        Thread.sleep(10000);

//        System.out.println("Loading URL");
        driver.get("https://en.wikipedia.org/wiki/Wiki");
        Thread.sleep(20000);

        driver.quit();

//        driver.findElementByXPath("//*[@id=\"paymentInfo\"]/section/div/button/div").click();
//        Thread.sleep(5000);
//        driver.quit();
//
//        // Click checkboxes
//        System.out.println("Checking Boxes");
//        driver.findElement(By.name("li1")).click();
//        driver.findElement(By.name("li2")).click();
//        driver.findElement(By.name("li3")).click();
//        driver.findElement(By.name("li4")).click();
//
//        // Add items to the list
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
//        driver.findElement(By.id("addbutton")).click();
//
//        // Click additional checkboxes
//        driver.findElement(By.name("li1")).click();
//        driver.findElement(By.name("li3")).click();
//        driver.findElement(By.name("li7")).click();
//        driver.findElement(By.name("li8")).click();
//
//        // Add final todo item
//        driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.name("li9")).click();
//
//        // Assert that the item was added
//        spanText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[9]/span")).getText();
//        Assert.assertEquals(spanText, "Get Taste of Lambda and Stick to It");

        Status = "passed";
        Thread.sleep(8000);

        System.out.println("Test Finished");
    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }
}
