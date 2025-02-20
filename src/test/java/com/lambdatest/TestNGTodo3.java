package com.lambdatest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo3 {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "ankitclambdatest";//System.getenv("LT_USERNAME") == null ? "Your LT Username" : System.getenv("LT_USERNAME");
        String authkey = "hR73QCNxdF0BuMAlPNX68ECLoRl6TI8RsWkq8hfpi15roLzYju";//System.getenv("LT_ACCESS_KEY") == null ? "Your LT AccessKey" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("platform","Windows 10");
        browserOptions.setCapability("browserVersion","123");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "ankitclambdatest");
        ltOptions.put("accessKey", "hR73QCNxdF0BuMAlPNX68ECLoRl6TI8RsWkq8hfpi15roLzYju");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);


        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), browserOptions);
    }

    @Test
    public void basicTest() throws InterruptedException {
        System.out.println("Loading Url");

        driver.get("https://auth-staging.onclusive.com/u/login/identifier?state=hKFo2SBKTEk2aHlLT2JiOGVmb0l5VTJ2ZGhDVjhGU3FnekFmdqFur3VuaXZlcnNhbC1sb2dpbqN0aWTZIDd4ei1pNnJZVWRuSDdUdEowXzR3VW9XdUJPWGx5WjVTo2NpZNkgUHFGcEc0N2RrajdDSzlIZm5PeGl5bDA5Z3RNSVNqSDk");

        // Print the session ID
        String sessionId = driver.getSessionId().toString();
        System.out.println("Session ID: " + sessionId);

        Thread.sleep(5000);
        driver.quit();
    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Adding Test Result and Closing Browser\", \"level\": \"info\"}}");
        driver.executeScript("lambda-status=" + Status);

        driver.quit();

        String sessionID = String.valueOf(driver.getSessionId());
        System.out.println("Session ID: " + sessionID);
        fetchVideoFromLambdaTest(sessionID);
    }

    private void fetchVideoFromLambdaTest(String sessionId) {
        try {
            String username = "ankitclambdatest";  // Replace with your username if required
            String authkey = "hR73QCNxdF0BuMAlPNX68ECLoRl6TI8RsWkq8hfpi15roLzYju";
            String apiURL = "https://api.lambdatest.com/automation/api/v1/sessions/" + sessionId + "/video";

            // Set up connection
            URL url = new URL(apiURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Basic " +
                    java.util.Base64.getEncoder().encodeToString((username + ":" + authkey).getBytes()));

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    // Print the API response (video link)
                    System.out.println("Video URL Response: " + response.toString());
                }
            } else {
                System.out.println("Failed to fetch video URL. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

