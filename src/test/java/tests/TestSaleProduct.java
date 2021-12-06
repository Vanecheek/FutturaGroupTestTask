package tests;

import frameworkClasses.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SpecialOfferPage;

public class TestSaleProduct extends TestInit {
    HomePage homePage;
    SpecialOfferPage specialOfferPage;
    public void fillCardValidate(){
        String cardNum = "453245661814269";
        for(int i = 0; i <= cardNum.length()-1; i++){
            specialOfferPage.cardNumberInput().sendKeys(cardNum.charAt(i)+"");
        }
        specialOfferPage.cardExpiryDateInput().sendKeys("032029");
        specialOfferPage.cvvInput().sendKeys("967");
        specialOfferPage.cardNumberInput().sendKeys("2");
        specialOfferPage.cvvInput().click();
    }
    public void fillCardInvalidate(){
        String cardNum = "4532456618142";
        for(int i = 0; i <= cardNum.length()-1; i++){
            specialOfferPage.cardNumberInput().sendKeys(cardNum.charAt(i)+"");
        }
        specialOfferPage.cardExpiryDateInput().sendKeys("032029");
        specialOfferPage.cvvInput().sendKeys("967");
        specialOfferPage.cardNumberInput().sendKeys("2");
        specialOfferPage.cvvInput().click();
    }
    @Test
    public void testSaleProductPositive(){
        homePage = new HomePage(driver);
        openUrl("https://ironvpn.me/?source=test");
        homePage.getVPNButton().click();
        homePage.emailInput().sendKeys("qa@test.com");
        homePage.checkPlace().click();
        homePage.emailWindowGetNow().click();
        specialOfferPage = new SpecialOfferPage(driver);
        Boolean wait = new WebDriverWait(driver,10).until(
                ExpectedConditions.urlContains("processing"));
        specialOfferPage.getVPNButton().click();
        WebDriver frame = new WebDriverWait(driver,10).until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt("solid-payment-form-iframe"));
        getElement("//input[contains(@name,'cardNumber')]");
        fillCardValidate();
        getElement("//button[contains(@name,'submit')]");
        specialOfferPage.payBtn().click();
        driver.switchTo().defaultContent();
        Boolean wait1 = new WebDriverWait(driver,10).until(
                ExpectedConditions.urlContains("successful"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://ironvpn.me/successful.html");
    }


    @Test
    public void testSaleProductNegative(){
        homePage = new HomePage(driver);
        openUrl("https://ironvpn.me/?source=test");
        homePage.getVPNButton().click();
        homePage.emailInput().sendKeys("qa@test.com");
        homePage.checkPlace().click();
        homePage.emailWindowGetNow().click();
        specialOfferPage = new SpecialOfferPage(driver);
        Boolean wait = new WebDriverWait(driver,10).until(
                ExpectedConditions.urlContains("processing"));
        specialOfferPage.getVPNButton().click();
        WebDriver frame = new WebDriverWait(driver,10).until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt("solid-payment-form-iframe"));
        getElement("//input[contains(@name,'cardNumber')]");
        fillCardInvalidate();
        Assert.assertTrue(specialOfferPage.cardNumError().isDisplayed());
        driver.switchTo().defaultContent();
    }
}
