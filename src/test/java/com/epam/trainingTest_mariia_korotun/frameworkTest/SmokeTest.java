package com.epam.trainingTest_mariia_korotun.frameworkTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
public class SmokeTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @org.junit.Test
    public void testGoogleCloudPricingCalculator() {
        driver.get("https://cloud.google.com/products/calculator");

        driver.findElement(By.id("inputFieldId")).sendKeys("4");

        String expectedCost = "USD 100.00 per 1 month";
        String actualCost = driver.findElement(By.id("totalCostId")).getText();
        assertEquals(actualCost, expectedCost, "Total estimated cost does not match!");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            takeScreenshot("testExample");
            driver.quit();
        }
    }
    private void takeScreenshot(String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "screenshots/" + testName + "_" + timestamp + ".png";

        try {
            // Ensure the screenshots directory exists
            new File("screenshots").mkdirs();
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot taken: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}