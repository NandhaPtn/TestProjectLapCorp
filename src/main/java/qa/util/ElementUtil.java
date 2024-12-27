package qa.util;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtil {

    private WebDriver driver;
    private WebElement svgElement;
    private Actions actions;
    private WebDriverWait wait;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public ElementUtil() {
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void doClick(WebElement element){
        element.click();
    }

    public void moveToElement(WebElement element){
        svgElement = element;
        actions = new Actions(driver);
        actions.moveToElement(svgElement).click().perform();
    }

    public void doSendKeys(WebElement element, String productName){
        element.sendKeys(productName + Keys.ENTER);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }
}
