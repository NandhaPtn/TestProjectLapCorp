package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import qa.factory.DriverFactory;
import qa.util.ConfigReader;

import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    public DriverFactory df;

    @Before
    public void setUp() throws IOException {
       df = new DriverFactory();
       driver = df.init_driver(ConfigReader.getData("browser"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        System.out.println("browser launch");
        String username = ConfigReader.getData("username");
        String password = ConfigReader.getData("password");
        String baseUrl = ConfigReader.getData("app_URL");  // Replace with your base URL
        String authUrl = "http://" + username + ":" + password + "@" + baseUrl.split("://")[1];
        driver.get(authUrl);
        DriverFactory.handleAcceptCookiesPopup();

    }
    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
