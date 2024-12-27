package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

public class LoginTest {

    LoginPage loginPage = new LoginPage();

    @Given("The user navigates to the login page with username and password from config.properties")
    public void navigateToLoginPageWithAuth() {
        Assert.assertTrue(loginPage.checkForOnDemandIconDisplayed());
    }
    @Given("I check the home page title as {string}")
    public void i_check_the_home_page_title_as(String expectedTitle) {
        String actualTitle = loginPage.getHomePageTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("I click on the shop tests button.")
    public void i_click_on_the_shop_tests_button() {
         loginPage.doClickShopTestsBtn();
    }
    @Then("I should be on the product list page to check the title as {string}")
    public void i_should_be_on_the_product_list_page_to_check_the_title_as(String expectedTitle) {
         String actualTitle = loginPage.getProductPageTitle();
         Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("I click on the search icon and am able to navigate the search page.")
    public void i_click_on_the_search_icon() {
        loginPage.doClickSearchIcon();
    }
    @Then("I fill the product name in the search bar and by clicking the enter button")
    public void i_fill_with_product_name() {
         loginPage.searchProduct();
    }
    @Then("I should able to see \\(Sign up now to receive your discount.) window")
    public void i_should_able_to_see_sign_up_now_to_receive_your_discount_window(){
        Assert.assertTrue(loginPage.emailAddressLabelIsDisplayed());
    }
    @When("I click on the No thanks button.")
    public void i_click_on_the_no_thanks_button(){
        loginPage.noThanksBtn();
    }
    @And("I should see the product name {string}")
    public void i_fill_with_product_name(String expectedProductName){
        String actualProductName = loginPage.getProductName();
        Assert.assertEquals(actualProductName,expectedProductName);
    }
    @When("I click on the add to cart button.")
    public void i_click_on_the_add_to_cart_button() {
         loginPage.addToCart();
    }
    @Then("I should be able to see {string}")
    public void i_should_be_able_to_see_item_successfully_added_to_your_cart(String expectedAddCartSuccessfullMessage) {
        String actualAddCartSuccessfullMessage = loginPage.cartAddSuccessfullMsg();
        Assert.assertEquals(actualAddCartSuccessfullMessage,expectedAddCartSuccessfullMessage);
    }
    @When("I click on the continue shopping button and am able to navigate same product page.")
    public void i_click_on_the_continue_shopping_button()  {
        loginPage.continueShoppingBtn();
    }
    @Then("I try to add the same product.")
    public void i_try_to_add_the_same_product() {
        loginPage.addToCart();
    }
    @Then("I should get the message {string}")
    public void i_should_get_the_message(String expectedAddCartSuccessfullMessage) {
        String actualAddCartSuccessfulMessage = loginPage.cartAddErrorMsg();
        Assert.assertEquals(actualAddCartSuccessfulMessage,expectedAddCartSuccessfullMessage);
    }
}
