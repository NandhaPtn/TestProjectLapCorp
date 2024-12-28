package qa.factory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.time.Duration;


public class DriverFactory {

    private static WebDriver driver;

    public WebDriver init_driver(String browser) throws IOException {

        System.out.println("browser value is: " + browser);

        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("safari")) {
            driver = new SafariDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        return getDriver();
    }
    public static void handleAcceptCookiesPopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", element);
        } catch (TimeoutException e) {
            System.out.println("No cookies popup found, continuing...");
        }
    }

    public static synchronized WebDriver getDriver() {
        return driver;
    }
}
