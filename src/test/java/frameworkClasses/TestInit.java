package frameworkClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;


public class TestInit {
    public WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    boolean headless = false;

    @BeforeMethod
    public void setUp() {
            setProperty("src/main/resources/chromedriver1.exe");

        driver = new ChromeDriver(options);
        if(headless) {
            driver.manage().window().setSize(new Dimension(1920, 1200));
        } else {
            driver.manage().window().maximize();
        }
    }


    private void setProperty(String path) {
        System.setProperty("webdriver.chrome.driver", path);
        if (headless){
            options.addArguments("--headless");
        }
    }

    private String getOSName() {
        return System.getProperty("os.name").toLowerCase();
    }
    public void openUrl(String site) {
        driver.get(site);
    }
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebElement getElement(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
   }
