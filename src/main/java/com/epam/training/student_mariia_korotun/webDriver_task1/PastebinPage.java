package com.epam.training.student_mariia_korotun.webDriver_task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PastebinPage {
    private final WebDriver webDriver;
    private final By codeInput = By.id("postform-text");
    private final By expirationDropdown = By.id("select2-postform-expiration-container");
    private final By expirationTime = By.xpath("//li[contains(text(), '10 Minutes')]");
    private final By nameInput = By.id("postform-name");
    private final By createButton = By.xpath("//button[text()='Create New Paste']");
    public PastebinPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void enterCode(String code){
        webDriver.findElement(codeInput).sendKeys(code);
    }
    public void pasteExpiration(){
        webDriver.findElement(expirationDropdown).click();
        webDriver.findElement(expirationTime).click();
    }
    public void pasteName(String name){
        webDriver.findElement(nameInput).sendKeys(name);
    }
    public void createPaste(){
        webDriver.findElement(createButton).click();
    }
}