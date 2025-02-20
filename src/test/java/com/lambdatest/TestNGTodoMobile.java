package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodoMobile {

    private static RemoteWebDriver driver;

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "ankitclambdatest";
        String authkey = "PnyIl8jWlSbpmJFvuFTPuX3us9g8tRLm7z67X0E4PfZ39HZHOq";
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "OnePlus 10 Pro");
        caps.setCapability("platformVersion", "13");
        caps.setCapability("console",true);

        caps.setCapability("build", "URL issue");
        caps.setCapability("visual", true);
        caps.setCapability("app", "lt://APP10160341241734536047003303");

        caps.setCapability("name", m.getName() + this.getClass().getName());

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        System.out.println("Loading Url");
        Thread.sleep(100);
//        driver.get("https://emblemhealth--uat.sandbox.my.site.com/member/s/");
        Thread.sleep(5000);

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
