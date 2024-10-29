package com.epam.training.student_mariia_korotun.webDriver_task3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class GoogleCloudPage {
    private final WebDriver driver;
        private final WebDriverWait wait;

        public GoogleCloudPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void selectComputeEngine() {
            driver.findElement(By.xpath("//md-tab-item/div[@title='Compute Engine']")).click();
        }

        public void enterNumberOfInstances(String numberOfInstances) {
            WebElement instancesInput = driver.findElement(By.xpath("//input[@ng-model='listingCtrl.computeServer.quantity']"));
            instancesInput.sendKeys(numberOfInstances);
        }

        public void selectOperatingSystem(String osOption) {
            WebElement osDropdown = driver.findElement(By.xpath("//md-select[@placeholder='Operating System / Software']"));
            osDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='free']"))).click();
        }

        public void selectProvisioningModel(String model) {
            WebElement provisioningDropdown = driver.findElement(By.xpath("//md-select[@placeholder='Provisioning model']"));
            provisioningDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='regular']"))).click();
        }

        public void selectMachineFamily() {
            WebElement machineFamilyDropdown = driver.findElement(By.xpath("//md-select[@placeholder='Machine Family']"));
            machineFamilyDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='general']"))).click();
        }

        public void selectSeries(String series) {
            WebElement seriesDropdown = driver.findElement(By.xpath("//md-select[@placeholder='Series']"));
            seriesDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='n1']"))).click();
        }

        public void selectMachineType(String machineType) {
            WebElement machineTypeDropdown = driver.findElement(By.xpath("//md-select[@placeholder='Machine type']"));
            machineTypeDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']"))).click();
        }

        public void addGpu() {
            driver.findElement(By.xpath("//md-checkbox[@aria-label='Add GPUs']")).click();
            WebElement gpuTypeDropdown = driver.findElement(By.xpath("//md-select[@placeholder='GPU type']"));
            gpuTypeDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']"))).click();
            WebElement numberOfGpusDropdown = driver.findElement(By.xpath("//md-select[@placeholder='Number of GPUs']"));
            numberOfGpusDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='1']"))).click();
        }

        public void selectLocalSsd(String ssdOption) {
            WebElement localSsdDropdown = driver.findElement(By.xpath("//md-select[@placeholder='Local SSD']"));
            localSsdDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='2x375']"))).click();
        }

        public void selectRegion(String region) {
            WebElement regionDropdown = driver.findElement(By.xpath("//md-select[@placeholder='Datacenter location']"));
            regionDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='europe-west4']"))).click();
        }

        public void addToEstimate() {
            driver.findElement(By.xpath("//button[@aria-label='Add to Estimate']")).click();
        }
        public String getEstimatedCost() {
            return driver.findElement(By.xpath("//b[@class='ng-binding']")).getText();
        }
    }