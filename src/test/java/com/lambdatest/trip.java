package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class trip {

    private static RemoteWebDriver driver;

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.load();

        String username = dotenv.get("LT_USERNAME");
        String authKey = dotenv.get("LT_ACCESS_KEY");
        String hubUrl = dotenv.get("LT_HUB_URL", "@hub.lambdatest.com/wd/hub");

        if (username == null || authKey == null) {
            throw new RuntimeException("Missing LambdaTest credentials in .env file.");
        }

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("visual", true);
        caps.setCapability("browserName", "chrome");
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("network", true);
        caps.setCapability("network.full.har", true);
        caps.setCapability("name", m.getName() + this.getClass().getName());

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authKey + hubUrl), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        // To start a test case
        ((JavascriptExecutor) driver).executeScript("lambda-testCase-start=find Name");
        System.out.println("Loading Url");
        Thread.sleep(10000);
        driver.get("chrome://extensions/?id=aeghledigokaedmpimgnfplidhdhlchg");
        Thread.sleep(10000);
        driver.quit();
    }
}
