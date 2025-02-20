package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Amulator {

    private static RemoteWebDriver driver;
    private static String username = "ankitclambdatest";  // Your LambdaTest username
    private static String authkey = "aief12PkGvo5QIW4xnIcPSslNTqLMQy7Vv4FsyNHNhfIgKkhBJ"; // Your LambdaTest authkey

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "ASUS ZenFone 8");
        capabilities.setCapability("appiumVersion", "2.6.0");
        capabilities.setCapability("platformVersion", "13");


        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), capabilities);
    }

    @Test
    public void basicTest() throws InterruptedException {
        System.out.println("Loading Url");

        Thread.sleep(2000);
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(5000);
        driver.quit();


        // Get the session ID and use it to fetch console logs
//        Thread.sleep(10000);
        String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
        System.out.println("Session ID: " + sessionId);



        driver.quit();

        Thread.sleep(30000);

        String apiUrl = "https://api.lambdatest.com/automation/api/v1/sessions/" + sessionId + "/log/console";
        String consoleLogs = fetchConsoleLogs(apiUrl, username, authkey);
        System.out.println("Console Logs: " + consoleLogs);

       // Thread.sleep(5000);
    }

    // Method to fetch console logs from LambdaTest
    public static String fetchConsoleLogs(String apiUrl, String username, String accessKey) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("accept", "application/json");

            // Set the Authorization header
            String auth = username + ":" + accessKey;
            String basicAuth = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
            connection.setRequestProperty("Authorization", basicAuth);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                return "Failed to fetch logs. Response Code: " + responseCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
