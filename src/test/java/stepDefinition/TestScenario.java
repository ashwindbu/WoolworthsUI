package stepDefinition;

import Helper.BaseTest;
import Helper.CommonFunction;
import Helper.Config;
import cucumber.api.java.en.And;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TestScenario extends BaseTest {

    WebDriver driver;


    public TestScenario() {
        super("./config/config.properties");
        this.driver = super.getDriver();
    }

    @After
    public void afterTest() {
        driver.quit();
    }

    @Given("^Open chrome and start application$")
    public void Open_chrome_and_start_application() throws Throwable {

        driver.manage().window().maximize();
        driver.get(Config.read("AutomationPracticeURL"));
    }


    @When("^User adds the short sleeve tshirt to cart$")
    public void userAddsTheShortSleeveTshirtToCart() {

        try {

            WebElement HoverTshirt = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]"));
            Actions action = new Actions(driver);
            action.moveToElement(HoverTshirt).clickAndHold().build().perform();
            CommonFunction.explicitWait("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span", driver);
            WebElement AddToCartTshirt = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]"));

            if (AddToCartTshirt.isDisplayed()) {
                AddToCartTshirt.click();
            } else {
                Assert.fail();
                System.out.println("Could not click the webelement short sleeve tshirt:" + AddToCartTshirt + "");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^User adds the Blouse to cart$")
    public void userAddsTheBlouseToCart() {
        try {
            WebElement ContinueShopping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
            CommonFunction.explicitWaitUntilElementClickable(ContinueShopping, driver);
            ContinueShopping.click();

            WebElement HoverTshirt = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/h5/a"));
            Actions action = new Actions(driver);
            action.moveToElement(HoverTshirt).clickAndHold().build().perform();
            CommonFunction.explicitWait("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]/span", driver);
            WebElement AddToCartBlouse = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]/span"));


            if (AddToCartBlouse.isDisplayed()) {
                AddToCartBlouse.click();
            } else {
                Assert.fail();
                System.out.println("Could not click the webelement blouse:" + AddToCartBlouse + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User proceeds to checkout$")
    public void userProceedsToCheckout() {

        try {
            WebElement ContinueShopping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
            CommonFunction.explicitWaitUntilElementClickable(ContinueShopping, driver);
            ContinueShopping.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User proceeds to checkout in shopping cart summary$")
    public void userProceedsToCheckoutInShoppingCartSummary() {
        try {
            CommonFunction.WebElementClick("//*[@id=\"center_column\"]/p[2]/a[1]/span", driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User enters the credential signing in and proceeds to checkout in Addresses screen$")
    public void userEntersTheCredentialSigningInAndProceedsToCheckoutInAddressesScreen() {

        try {
            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Config.read("UserName"));
            driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(Config.read("Password"));
            CommonFunction.WebElementClick("//*[@id=\"SubmitLogin\"]/span", driver);
            CommonFunction.WebElementClick("//*[@id=\"center_column\"]/form/p/button/span", driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^User agrees for terms of service and clicks on proceed in shipping screen$")
    public void customerAgreesForTermsOfServiceAndClicksOnProceedInShippingScreen() {

        CommonFunction.WebElementClick("//*[@id=\"form\"]/div/p[2]/label" , driver);
        CommonFunction.WebElementClick("//*[@id=\"form\"]/p/button/span", driver);
    }

    @Then("^User selects pay by bank wire option in payment method screen and confirms order$")
    public void userSelectsPayByBankWireOptionInPaymentMethodScreen() {

        CommonFunction.WebElementClick("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a", driver);
        CommonFunction.WebElementClick("//*[@id=\"cart_navigation\"]/button/span", driver);
    }

    @And("^Validate the order confirmation screen is displayed$")
    public void validateTheOrderConfirmationScreenIsDisplayed() {

        try {
            String OrderConfirmationText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
            Assert.assertEquals(OrderConfirmationText, "ORDER CONFIRMATION");
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}