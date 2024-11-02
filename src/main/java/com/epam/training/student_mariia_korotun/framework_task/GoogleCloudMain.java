package com.epam.training.student_mariia_korotun.framework_task;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleCloudMain {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver chromedriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromedriver,Duration.ofSeconds(10));
        try{
            chromedriver.get("https://cloud.google.com/");
            WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[aria-label='Search']")));
            searchIcon.click();

            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[aria-label='Search']")));
            searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
            searchInput.submit();

            WebElement calculator = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Google Cloud Platform Pricing Calculator")));
            calculator.click();

            WebElement computeEngine = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-tab[contains(., 'COMPUTE ENGINE')]")));
            computeEngine.click();

            chromedriver.findElement(By.name("numberOfInstances")).sendKeys("4");

            chromedriver.findElement(By.xpath("/md-select[@placeholder='Operating System / Software']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[contains(., 'Free: Debian, CentOS, CoreOS, Ubuntu, or another User-Provided OS')]"))).click();

            chromedriver.findElement(By.xpath("//md-select[@placeholder='Machine family")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[contains(., 'General purpose')]"))).click();

            chromedriver.findElement(By.xpath("//md-select[@placeholder='Series']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[contains(., 'N1')]"))).click();

            chromedriver.findElement(By.xpath("//md-select[@placeholder='Machine type']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[contains(., 'n1-standard-8 (vCPUs: 8, RAM: 30 GB)')]"))).click();

            WebElement addGpusCheckbox = chromedriver.findElement(By.xpath("//md-checkbox[@aria-label='Add GPUs']"));
            if (!addGpusCheckbox.isSelected()) {
                addGpusCheckbox.click();
            }

            chromedriver.findElement(By.xpath("//md-select[@placeholder='GPU type']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[contains(., 'NVIDIA Tesla V100')]"))).click();

            chromedriver.findElement(By.name("numberOfGpus")).sendKeys("1");

            chromedriver.findElement(By.xpath("//md-select[@placeholder='Local SSD']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[contains(., '2x375 Gb')]"))).click();

            chromedriver.findElement(By.xpath("//md-select[@placeholder='Datacenter location']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[contains(., 'Frankfurt (europe-west3)')]"))).click();

            chromedriver.findElement(By.xpath("//md-select[@placeholder='Committed usage']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[contains(., '1 Year')]"))).click();

            chromedriver.findElement(By.xpath("//button[contains(., 'Add to Estimate')]")).click();

            WebElement estimatedCost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(., 'Total Estimated Cost:')]")));
            String strCost = estimatedCost.getText();
            System.out.println("Estimated Cost -> " + strCost);

            chromedriver.findElement(By.xpath("//button[contains(., 'EMAIL ESTIMATE')]")).click();

            chromedriver.get("https://yopmail.com/");

            String myEmail = "myemail@yopmail.com";  // Replace with logic to generate a random email if necessary
            chromedriver.findElement(By.id("login")).sendKeys("log12345");
            chromedriver.findElement(By.id("loginbutton")).click();

            chromedriver.switchTo().window(chromedriver.getWindowHandle());
            chromedriver.findElement(By.xpath("//input[@type='email']")).sendKeys(myEmail);

            chromedriver.findElement(By.xpath("//button[contains(., 'SEND EMAIL')]")).click();

            checkEmail(chromedriver, myEmail);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            chromedriver.quit();
        }
    }
    private static void checkEmail(WebDriver driver, String email) {
        driver.get("https://yopmail.com/");
        driver.findElement(By.id("login")).sendKeys(email.split("@")[0]); // Use the part before @
        driver.findElement(By.id("loginbutton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement emailLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'read')]")));
        emailLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body")));

        String emailBody = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Email Body -> " + emailBody);

        String estimatedCostEmail = extractCostFromEmail(emailBody);
        System.out.println("Estimated Cost from Email: " + estimatedCostEmail);
    }
    private static String extractCostFromEmail(String emailBody) {
        String regex = "Total Estimated Monthly Cost: USD ([\\d.,]+) per 1 month";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailBody);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "Cost not found";
    }
}
