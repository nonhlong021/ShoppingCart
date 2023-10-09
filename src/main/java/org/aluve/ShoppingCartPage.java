package org.aluve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By byAddToCart = By.xpath("//button[contains(text(),'Add to cart')]");
    By byProduct = By.xpath("//main[@class='sc-ebmerl-4 iliWeY']//p");
    By byPrice = By.xpath("//div[@class='sc-1h98xa9-8 bciIxg']//p[contains(text(), '$')]");


    public String getByProduct(String product) {
        return "//div[@class='sc-uhudcz-0 iZZGui']//div[@alt='"+product+"']";
    }
    By getbySize(String size){
        return By.xpath("//div[@class='sc-bj2vay-0 DCKcC']//div//label//span[ text()='"+size+"']");
    }

    public void clickOnSize(String size){
        click(getbySize(size));
    }

    public void clickAddToCartBtn(){
        click(byAddToCart);
    }

    public boolean isProductEqual(String product){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(byProduct, product));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPriceReturned(String price){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(45L));
            boolean value =  wait.until(ExpectedConditions.textToBePresentInElementLocated(byPrice, price));
            boolean cents =  wait.until(ExpectedConditions.textToBePresentInElementLocated(byPrice, price ));
            return value && cents;
        } catch (Exception e) {
            return false;
        }
    }

    public void click(By byLocator) {
        boolean exceptionOccurred = false;
        int numberOfTries = 0;
        do {
            try {
                numberOfTries++;
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byLocator));
                (new Actions(driver)).scrollToElement(element).moveToElement(element);
                wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator)).click();
            } catch (Exception e) {
                exceptionOccurred = true;
            }
        } while (exceptionOccurred && numberOfTries < 3);
    }
}
