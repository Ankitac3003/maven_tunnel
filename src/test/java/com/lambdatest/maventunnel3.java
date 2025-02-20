package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import com.lambdatest.tunnel.Tunnel;
//import com.lambdatest.tunnel.TunnelException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class maventunnel3 {

    private RemoteWebDriver driver;
    private String Status = "passed";
    private Tunnel t; // Declaring Tunnel object

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException, Exception {
        String username = "ankitclambdatest";
        String authkey = "LT_OnEL30AtoPH0BkcY83K0VnpQOcfFpX71axsfQgHGLhvNfUP";

        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("visual", true);
        caps.setCapability("browserName", "Safari");
        caps.setCapability("browserVersion", "17.5");
        caps.setCapability("platformName", "macOS Sonoma");
//        caps.setCapability("region", "us");
//        caps.setCapability("network", true);
        caps.setCapability("tunnel",true);
        caps.setCapability("tunnelName", "MavenSingle3");


        // Initialize the Tunnel object
        t = new Tunnel();
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user", username);
        options.put("key", authkey);
        options.put("tunnelName", "MavenSingle3");

        try {
            // Start tunnel
            t.start(options);
        } catch (Exception e) {
            System.out.println("Error starting Tunnel: " + e.getMessage());
        }

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        System.out.println("Loading Url");

        // Navigate to the website
        driver.get("https://www.tripadvisor.com/");
        Thread.sleep(5000);  // Sleep for 5 seconds (consider using WebDriverWait instead of Thread.sleep in real tests)
    }

    @AfterMethod
    public void tearDown() {
        try {
            // Mark test status as failed or passed
            driver.executeScript("lambda-status=" + Status);
        } catch (Exception e) {
            System.out.println("Error in executing lambda status: " + e.getMessage());
        }

        if (driver != null) {
            // Quit the driver
            driver.quit();
        }

        try {
            // Stop the tunnel
            if (t != null) {
                t.stop();
            }
        } catch (Exception e) {
            System.out.println("Error stopping Tunnel: " + e.getMessage());
        }
    }
}
