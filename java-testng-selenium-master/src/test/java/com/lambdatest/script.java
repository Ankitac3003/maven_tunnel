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
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class script {

    private static RemoteWebDriver driver;

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "ankitclambdatest";
        String authkey = "Jdss0sjCiLWvzHrnPwS2is9nklBaEEnMo6lE8XB24IiYLa3Jtn";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "129");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "ankitclambdatest");
        ltOptions.put("accessKey", "Jdss0sjCiLWvzHrnPwS2is9nklBaEEnMo6lE8XB24IiYLa3Jtn");
        ltOptions.put("platformName", "Windows 10");
     //   ltOptions.put("resolution", "1920x1080");
        ltOptions.put("resolution", "2560x1440");

        ltOptions.put("project", "Untitled");
        capabilities.setCapability("LT:Options", ltOptions);

       // caps.setCapability("name", m.getName() + this.getClass().getName());

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), capabilities);
    }
public void abc(String URL) {

    try {
        // URL to send the request to
        URL url = new URL(URL);
        // Open a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Set request method to GET (the default)
        connection.setRequestMethod("GET");
        // Enable verbose output (similar to -vvv in curl)
        connection.setInstanceFollowRedirects(true); // Optional: follow redirects if needed
        // Print response details
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine).append("\n");
        }
        in.close();
        // Print the full response
        System.out.println("Response Body:");
        System.out.println(response.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

//public void xyz() {
//    try {
//        // Define the curl command and arguments
//        ProcessBuilder processBuilder = new ProcessBuilder(
//                "curl", "-vvv","-L", "https://lambdatest.com"
//        );
//        // Start the process
//        Process process = processBuilder.start();
//        // Capture the output from the curl command
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line;
//        StringBuilder output = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            output.append(line).append("\n");
//        }
//        // Close the reader
//        reader.close();
//        // Wait for the process to finish
//        int exitCode = process.waitFor();
//        System.out.println("Exited with code: " + exitCode);
//        // Print the output from the curl command
//        System.out.println("Curl Output: ");
//        System.out.println(output.toString());
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}

    @Test
    public void basicTest() throws InterruptedException {
        System.out.println("Loading Url");
        Thread.sleep(100);

        JavascriptExecutor jse =  driver;

// Replace <any string> with your data and <info/warn/debug/error> with the log level
        jse.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \"Test step message\", \"level\": \"info\"}}");
String S= "http://localhost/dashboard/";

System.out.println("================================================================");


abc(S);
        //xyz();
        System.out.println("================================================================");

        driver.get("https://www.lambdatest.com/support/docs/lambda-tunnel-modifiers/");
        Thread.sleep(5000);
        driver.quit();




//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[1]/div/div[2]/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[3]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath(" //*[@id=\"root\"]/div[2]/div/div[1]/div/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p ").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[3]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div[2]/button[2]").click();
//        Thread.sleep(3000);
//
////22
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[3]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[3]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div[7]/div/p").click();
//        Thread.sleep(3000);
//
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[3]/div/input").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[1]/div/input").click();
//        Thread.sleep(3000);
//
//
//       driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[3]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div/button[2]").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[3]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[2]/div/input").click();
//        Thread.sleep(3000);
//
//
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[4]/div/input").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath(" //*[@id=\"root\"]/div[2]/div/div[1]/div/div[3]/div/input").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div[3]/div/input").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
////        driver.findElementByXPath(" //*[@id=\"root\"]/div[2]/div/div[2]/div/div/label/input").click();
////
////        Thread.sleep(3000);
//
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/label/input")).sendKeys("160");
//
//Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[3]/button/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"checkbox_kg\"]").click();
//        Thread.sleep(3000);
//
//
//
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/label/input")).sendKeys("70");
//
//        Thread.sleep(3000);
//
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[3]/button/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/label/input")).sendKeys("70");
//
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[3]/button/p").click();
//        Thread.sleep(3000);
//
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/label/input")).sendKeys("30");
//
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[3]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div/div[3]/div/input").click();
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button[1]/p").click();
//        Thread.sleep(3000);
//
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//
//
//
//        Thread.sleep(20000);
//
//        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ankitchauhanac11112222@gmail.com");
//
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/button/p").click();
//        Thread.sleep(3000);
//
//
//        Thread.sleep(5000);
//        Thread.sleep(5000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div/div[2]/button[1]/p").click();
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button/p").click();
//        Thread.sleep(3000);
//        Thread.sleep(3000);
//
//        driver.findElementByXPath("//*[@id=\"root\"]/div[2]/div/header/div[2]/div/button/p").click();
//        Thread.sleep(3000);
//        Thread.sleep(3000);
//
//
//        driver.findElementByXPath("//*[@id=\"t__product_select_cta\"]/button/p").click();
//        Thread.sleep(3000);
//        Thread.sleep(3000);



        driver.quit();



        driver.findElementByXPath("").click();
        Thread.sleep(3000);

        driver.findElementByXPath("").click();
        Thread.sleep(5000);
        Thread.sleep(5000);






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
