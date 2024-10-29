package com.epam.trainingTest_mariia_korotun.webDriverTest_task1;

import com.epam.training.student_mariia_korotun.webDriver_task1.PastebinPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PastebinPageTest {
    private WebDriver driver;
    private PastebinPage pastebinPage;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://pastebin.com/");
        pastebinPage = new PastebinPage(driver);
    }

    @Test
    public void testCreatePaste(){
        pastebinPage.enterCode("Hello from WebDriver");
        pastebinPage.pasteExpiration();
        pastebinPage.pasteName("MyName");
        pastebinPage.createPaste();
    }

    @After
    public void down(){
        driver.quit();
    }
}
