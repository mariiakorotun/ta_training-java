package com.epam.trainingTest_mariia_korotun.webDriverTest_task3;
import com.epam.training.student_mariia_korotun.webDriver_task3.GoogleCloudPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
public class GoogleCloudPageTest {

        private WebDriver driver;
        private GoogleCloudPage calculatorPage;

        @Before
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://cloud.google.com/products/calculator/");
            calculatorPage = new GoogleCloudPage(driver);
        }

        @Test
        public void testComputeEngineEstimate() {
            calculatorPage.selectComputeEngine();
            calculatorPage.enterNumberOfInstances("4");
            calculatorPage.selectOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL");
            calculatorPage.selectProvisioningModel("Regular");
            calculatorPage.selectMachineFamily();
            calculatorPage.selectSeries("N1");
            calculatorPage.selectMachineType("n1-standard-8");
            calculatorPage.addGpu();
            calculatorPage.selectLocalSsd("2x375 Gb");
            calculatorPage.selectRegion("Netherlands (europe-west4)");
            calculatorPage.addToEstimate();

            // Switch to Estimate Summary and Validate the Cost
            String estimatedCost = calculatorPage.getEstimatedCost();
            System.out.println("Estimated Cost: " + estimatedCost);

            assertTrue("Estimated cost should match expected values", estimatedCost.contains("Expected Value Here"));
        }

        @After
        public void tearDown() {
            driver.quit();
        }
    }