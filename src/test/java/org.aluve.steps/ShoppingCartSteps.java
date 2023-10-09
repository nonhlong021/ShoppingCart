package org.aluve.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aluve.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class ShoppingCartSteps {
    public ShoppingCartPage shoppingCartPage;
    WebDriver driver;

    public ShoppingCartSteps() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        shoppingCartPage = new ShoppingCartPage(driver);

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

    @When("the user clicks the Add to Cart button for a product {string}")
    public void theUserClicksTheButtonForAProduct(String product) {
        shoppingCartPage.clickAddToCartBtn();

    }

    @Then("the product {string} is present in the cart")
    public void theProductIsPresentInTheCart(String arg0) {
    }

}

