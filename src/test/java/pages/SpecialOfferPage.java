package pages;

import frameworkClasses.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpecialOfferPage extends BasePage {
    public SpecialOfferPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getVPNButton(){
        return findElement("//a[contains(@class,'initchackout')]");
    }
    public WebElement cardNumberInput(){
        return findElement("//input[contains(@name,'cardNumber')]");
    }
    public WebElement cardExpiryDateInput(){
        return findElement("//input[contains(@name,'cardExpiry')]");
    }
    public WebElement cvvInput(){
        return findElement("//input[contains(@name,'cardCvv')]");
    }
    public WebElement payBtn(){
        return findElement("//button[contains(@name,'submit')]");
    }
    public WebElement cardNumError(){
        return findElement("//div[contains(@class,'body')]/div[contains(@class,'error-text')]");
    }
}
