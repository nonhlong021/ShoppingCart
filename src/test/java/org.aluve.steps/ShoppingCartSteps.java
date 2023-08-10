package org.aluve.steps;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aluve.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class ShoppingCartSteps {
    ShoppingCartPage shoppingCartPage;

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Given("the user is on the product page")
    public void givenUserOnProductPage() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    @When("the user selects {string} from the size filter")
    public void theUserSelectsFromTheSizeFilter(String size) {
        shoppingCartPage.clickOnSize(size);
    }

    @Then("only products of size {string} are displayed")
    public void onlyProductsOfSizeAreDisplayed(String product) {
        boolean isProduct = shoppingCartPage.isProductEqual(product);
        assertTrue(isProduct);
    }

    @When("the user clicks the Add to Cart button for a product")
    public void theUserClicksTheButtonForAProduct() {
        shoppingCartPage.clickAddToCartBtn();

    }

    @Then("the product is added to the cart with {string} price")
    public void theProductIsAddedToTheCart(String price) {
       boolean isPrice =  shoppingCartPage.isPriceReturned(price);
       assertTrue(isPrice);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

