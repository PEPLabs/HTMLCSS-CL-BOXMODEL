import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        File file = new File("CSSBoxModel.html");
        // Open the HTML file
        driver.get(file.getAbsolutePath());
    }

    @Test
    public void testPizza1Padding() {
        WebElement pizza1 = driver.findElement(By.id("pizza1"));
        assertEquals("20px", pizza1.getCssValue("padding"));
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}