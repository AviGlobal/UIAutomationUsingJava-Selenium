package utils;


import base.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ElementUtils {

    public static class userActions {

        static WebDriver driver = new ChromeDriver();

        public void click(String Xpath) {
            WebElement element = BaseTest.getDriver().findElement(By.xpath(Xpath));
            element.click();
        }

        public void setText(String Xpath, String text) {
            WebElement element = BaseTest.getDriver().findElement(By.xpath(Xpath));
            element.clear();
            element.sendKeys(text);
        }

        public static void hitEnter(String Xpath) {
            WebElement element = BaseTest.getDriver().findElement(By.xpath(Xpath));
            element.sendKeys(Keys.ENTER);
        }

        public static String getTextofElement(String Xpath) {
            WebElement element = BaseTest.getDriver().findElement(By.xpath(Xpath));
            String getTextFromElement = element.getText();
            return getTextFromElement;
        }

        public static List<String> getTextOfAllElements(String Xpath) {
            List<WebElement> elements = BaseTest.getDriver().findElements(By.xpath(Xpath));
            List<String> texts = new ArrayList<>();
            for (WebElement element : elements) {
                texts.add(element.getText());
            }
            return texts;
        }


        public void fetchTextShown(WebElement element) {
            element.getText();
        }

        public void fetchTheAttributes(WebElement element, String text) {
            element.getAttribute(text);
        }

        public static WebElement findElement(String Xpath){
            return driver.findElement(By.xpath(Xpath));
        }

        public static List<WebElement> findElements(String xpath) {
            return driver.findElements(By.xpath(xpath));
        }

    }

}
