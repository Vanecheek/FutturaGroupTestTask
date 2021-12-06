package pages;

import frameworkClasses.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement getVPNButton(){
        return findElement("//a[contains(@class,'initchackout')]");
    }
    public WebElement emailInput(){
        return findElement("//input[contains(@id,'email')]");
    }
    public WebElement checkPlace(){
        return findElement("//i");
    }
    public WebElement emailWindowGetNow(){
        return findElement("//button[contains(@name,'get_now')]");
    }
}
