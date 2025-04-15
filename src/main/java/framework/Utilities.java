package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



        /*element.click();
element.sendKeys("text");
element.clear();
element.getText();
element.getAttribute("value");
element.isDisplayed();
element.isEnabled();
element.isSelected();*/


public class Utilities {

    public static class userActions {

        public void click(String Xpath) {
            WebElement element = DriverSetup.getDriver().findElement(By.xpath(Xpath));
            element.click();
        }

        public void setText(String Xpath,String text) {
            WebElement element = DriverSetup.getDriver().findElement(By.xpath(Xpath));
            element.clear();
            element.sendKeys(text);
        }

        public static void hitEnter(String Xpath) {
            WebElement element = DriverSetup.getDriver().findElement(By.xpath(Xpath));
            element.sendKeys(Keys.ENTER);
        }

        public static List<String> getTextOfAllElements(String Xpath){
            List<WebElement> elements = DriverSetup.getDriver().findElements(By.xpath(Xpath));
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
    }


    public static class Waits {
        private static final int DEFAULT_TIMEOUT = 10;

        public static void waitForElementVisible(WebDriver driver, WebElement element) {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.visibilityOf(element));
        }

        public static void waitForElementClickable(WebDriver driver, WebElement element) {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.elementToBeClickable(element));
        }

        public static void waitForUrlContains(WebDriver driver, String urlPart) {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.urlContains(urlPart));
        }

        public static void waitForTitleContains(WebDriver driver, String titlePart) {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.titleContains(titlePart));
        }

        // Optional: overloaded method to specify custom timeout
        public static void waitForElementVisible(WebDriver driver, WebElement element, int timeout) {
            new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.visibilityOf(element));
        }
    }
}
