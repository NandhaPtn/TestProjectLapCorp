package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.factory.DriverFactory;
import qa.util.ElementUtil;

public class LoginPage extends ElementUtil {

    ElementUtil elementUtil;
    @FindBy (xpath = "//span[text()='Shop Tests']")
    private WebElement shopTestButton;
    @FindBy (xpath = "(//*[local-name()='svg' and @fill='none']/*[local-name()='g'])[1]")
    private WebElement searchIcon;
    @FindBy (name = "search_query")
    private WebElement searchProduct;
    @FindBy (xpath = "//span[text()='Vitamin C Test']")
    private WebElement productName;
    @FindBy (xpath = "//button[text()='No Thanks']")
    private WebElement noThanksBtn;
    @FindBy (xpath = "//span[@id='addToCart' and @data-name='Vitamin C Test']//span[text()='Add To Cart']")
    private WebElement addToCart;
    @FindBy (xpath = "//h2[text()='Item successfully added to your cart.']")
    private WebElement cartAddSuccessfullMsg;
    @FindBy (xpath = "//button[text()='Continue Shopping']")
    private WebElement continueShoppingBtn;
    @FindBy (xpath = "//h2[text()='Quantity Limit Reached']")
    private WebElement cartAddErrorMsg;
    @FindBy (xpath = "//label[text()='Email Address']")
    private WebElement emailAddressLabel;
    @FindBy (xpath = "//nav[@id='labcorp-ondemand-header']//img[@class='logo-image']")
    private WebElement onDemandIcon;

    public LoginPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
        elementUtil = new ElementUtil(DriverFactory.getDriver());
    }

    public boolean checkForOnDemandIconDisplayed(){
        return elementUtil.isDisplayed(onDemandIcon);
    }
    public String getHomePageTitle(){
        return elementUtil.getTitle();
    }
    public void doClickShopTestsBtn(){
        elementUtil.doClick(shopTestButton);
    }

    public String getProductPageTitle(){
        return elementUtil.getTitle();
    }

    public void doClickSearchIcon(){
       elementUtil.moveToElement(searchIcon);

    }
    public void searchProduct(){
        elementUtil.doSendKeys(searchProduct,"Vitamin C Test");
    }
    public String getProductName(){
        return elementUtil.getText(productName);
    }
    public boolean emailAddressLabelIsDisplayed(){
        elementUtil.waitForElementToBeDisplayed(emailAddressLabel);
        return elementUtil.isDisplayed(emailAddressLabel);
    }
    public void noThanksBtn(){
        elementUtil.doClick(noThanksBtn);
    }
    public void addToCart(){
        elementUtil.doClick(addToCart);
    }

    public String cartAddSuccessfullMsg(){
        elementUtil.waitForElementToBeDisplayed(cartAddSuccessfullMsg);
        return elementUtil.getText(cartAddSuccessfullMsg);
    }

    public void continueShoppingBtn(){
        elementUtil.doClick(continueShoppingBtn);
    }

    public String cartAddErrorMsg(){
        elementUtil.waitForElementToBeDisplayed(cartAddErrorMsg);
        return elementUtil.getText(cartAddErrorMsg);
    }

}
