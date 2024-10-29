package com.epam.trainingTest_mariia_korotun.webDriverTest_task2;

import com.epam.training.student_mariia_korotun.webDriver_task2.PastebinPage2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class PatebinPageTest2 {
    private WebDriver driver;
    private PastebinPage2 pastebinPage;

    private static final String CODE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String TITLE_TEXT = "how to gain dominance among developers";
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        pastebinPage = new PastebinPage2(driver);
    }

    @Test
    public void testCreateNewPaste() {
        // Create new paste
        pastebinPage.enterCode(CODE_TEXT);
        pastebinPage.selectHighlightingSyntax();
        pastebinPage.selectPasteExpiration();
        pastebinPage.enterPasteName(TITLE_TEXT);
        pastebinPage.createPaste();

        assertEquals(TITLE_TEXT + " - Pastebin.com", pastebinPage.getPageTitle());
        assertEquals("bash", pastebinPage.getSyntaxHighlighting().toLowerCase());
        assertEquals(CODE_TEXT, pastebinPage.getCodeContent());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
