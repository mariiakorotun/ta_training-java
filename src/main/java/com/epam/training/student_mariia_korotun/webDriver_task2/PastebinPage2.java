package com.epam.training.student_mariia_korotun.webDriver_task2;

import com.epam.training.student_mariia_korotun.webDriver_task1.PastebinPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PastebinPage2 {
    private WebDriver driver;
    private final By codeInput = By.id("postform-text");
    private final By highlightingDropdown = By.id("select2-postform-format-container");
    private final By bashOption = By.xpath("//li[contains(text(), 'Bash')]");
    private final By expirationDropdown = By.id("select2-postform-expiration-container");
    private final By expirationOption = By.xpath("//li[contains(text(), '10 Minutes')]");
    private final By nameInput = By.id("postform-name");
    private final By createButton = By.xpath("//button[text()='Create New Paste']");

    public PastebinPage2(WebDriver driver){
        this.driver = driver;
    }
    public void enterCode(String code){
        driver.findElement(codeInput).sendKeys(code);
    }
    public void selectHighlightingSyntax(){
        driver.findElement(highlightingDropdown).click();
        driver.findElement(bashOption).click();
    }
    public void selectPasteExpiration() {
        driver.findElement(expirationDropdown).click();
        driver.findElement(expirationOption).click();
    }

    public void enterPasteName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void createPaste() {
        driver.findElement(createButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    public String getSyntaxHighlighting() {
        return driver.findElement(By.xpath("//a[contains(@class, 'bash')]")).getText();
    }

    public String getCodeContent() {
        return driver.findElement(By.xpath("//textarea")).getText();
    }
}
