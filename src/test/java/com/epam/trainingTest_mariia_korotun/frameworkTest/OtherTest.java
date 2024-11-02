package com.epam.trainingTest_mariia_korotun.frameworkTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class OtherTest {
        private WebDriver driver;

        @Before
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    @Test
    public void testGoogleCloudPricingCalculator() {
        driver.get("https://cloud.google.com/products/calculator");

        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search products']"));
        searchField.sendKeys("Google Cloud Platform Pricing Calculator");
        searchField.sendKeys(Keys.RETURN);

        WebElement pricingCalculatorLink = driver.findElement(By.linkText("Google Cloud Platform Pricing Calculator"));
        pricingCalculatorLink.click();
        WebElement computeEngineTab = driver.findElement(By.xpath("//div[contains(text(),'Compute Engine')]"));
        computeEngineTab.click();

        driver.findElement(By.id("input_1")).sendKeys("4");
        driver.findElement(By.id("select_2")).click();
        driver.findElement(By.xpath("//md-option[@value='free']")).click();
        driver.findElement(By.id("select_3")).click();
        driver.findElement(By.xpath("//md-option[@value='regular']")).click();
        driver.findElement(By.id("select_4")).click();
        driver.findElement(By.xpath("//md-option[@value='general-purpose']")).click();
        driver.findElement(By.id("select_5")).click();
        driver.findElement(By.xpath("//md-option[@value='n1']")).click();
        driver.findElement(By.id("select_6")).click();
        driver.findElement(By.xpath("//md-option[@value='n1-standard-8']")).click();
        driver.findElement(By.id("add-gpus")).click();
        driver.findElement(By.xpath("//md-select[@placeholder='GPU type']")).click();
        driver.findElement(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']")).click();
        driver.findElement(By.id("gpus")).sendKeys("1");
        driver.findElement(By.id("local-ssd")).click();
        driver.findElement(By.xpath("//md-option[@value='2x375']")).click();
        driver.findElement(By.id("datacenter-location")).click(); // Datacenter location
        driver.findElement(By.xpath("//md-option[@value='europe-west3']")).click();
        driver.findElement(By.id("committed-usage")).click(); // Committed usage
        driver.findElement(By.xpath("//md-option[@value='1 Year']")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Add to Estimate')]")).click();

        String estimatedCost = driver.findElement(By.xpath("//div[contains(text(),'Total Estimated Cost')]")).getText();
        System.out.println(estimatedCost);

        driver.findElement(By.xpath("//button[contains(text(),'Email Estimate')]")).click();

    }


    @After
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }