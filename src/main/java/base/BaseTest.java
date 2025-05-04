package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class BaseTest {
    private static WebDriver driver;


    public static void setDriver(WebDriver driverInstance){
        driver = driverInstance;
    }

    public static WebDriver getDriver(){
       if (driver == null){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.manage().window().maximize();
       }
       return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    public static void goToUrl(String URL){
        driver.get(URL);
    }
}
