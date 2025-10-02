////////////////////////////////////////////////////////////
// This is the new testing infrastructure. Merge this     //
// into the other file without altering the test methods. //
////////////////////////////////////////////////////////////

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(SeleniumTest.class.getName());
    private Process httpServerProcess;
    private String browserType; // "chrome" or "edge"
    
    // Architecture and system detection
    private static final String OS_NAME = System.getProperty("os.name").toLowerCase();
    private static final String OS_ARCH = System.getProperty("os.arch").toLowerCase();
    private static final boolean IS_ARM = OS_ARCH.contains("aarch64") || OS_ARCH.contains("arm");
    private static final boolean IS_WINDOWS = OS_NAME.contains("windows");
    private static final boolean IS_LINUX = OS_NAME.contains("linux");
    private static final boolean IS_MAC = OS_NAME.contains("mac");
  
    @BeforeEach
    public void setUp() {
        // ... body omitted for brevity (same as prototype) ...
    }

    @AfterEach
    public void tearDown() {
        System.out.println("\n=== TEARDOWN ===");
        cleanup();
        System.out.println("Teardown completed");
    }
    
    // Helper class to store browser configuration
    private static class BrowserConfig {
        final String browserType;
        final String driverPath;
        final String binaryPath;
        
        BrowserConfig(String browserType, String driverPath, String binaryPath) {
            this.browserType = browserType;
            this.driverPath = driverPath;
            this.binaryPath = binaryPath;
        }
    }


    @Test
    public void testAllPizzaPadding() {
        WebElement pizza = webDriver.findElement(By.className("pizza"));
        assertEquals("20px", pizza.getCssValue("padding"));
    }

    @Test
    public void testAllPizzaMargin() {
        WebElement pizza = webDriver.findElement(By.className("pizza"));
        assertEquals("20px", pizza.getCssValue("margin"));
    }

    @Test
    public void testPizza1BackgroundColor() {
        WebElement pizza1 = webDriver.findElement(By.id("pizza1"));
        assertEquals("rgba(255, 255, 0, 1)", pizza1.getCssValue("background-color"));
    }

    @Test
    public void testPizza2Color() {
        WebElement pizza2 = webDriver.findElement(By.id("pizza2"));
        assertEquals("rgba(255, 0, 0, 1)", pizza2.getCssValue("color"));
    }

    @Test
    public void testPizza2Border() {
        WebElement pizza2 = webDriver.findElement(By.id("pizza2"));
        assertEquals("solid", pizza2.getCssValue("border-style"));
        assertEquals("rgb(139, 69, 19)", pizza2.getCssValue("border-color"));
        double borderWidth = Double.valueOf(pizza2.getCssValue("border-width").replace("px",""));
        borderWidth = Math.round(borderWidth);
        assertEquals(5.0, borderWidth, 0.01);
    }

    @Test
    public void testPizza3Border() {
        WebElement pizza3 = webDriver.findElement(By.id("pizza3"));
        assertEquals("10px solid rgb(0, 0, 0)", pizza3.getCssValue("border"));
    }

}
