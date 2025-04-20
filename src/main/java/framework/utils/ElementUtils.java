package framework.utils;

import framework.DriverSetup;
import org.openqa.selenium.*;


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


public class ElementUtils {

    public static class userActions {

        public void click(String Xpath) {
            WebElement element = DriverSetup.getDriver().findElement(By.xpath(Xpath));
            element.click();
        }

        public void setText(String Xpath, String text) {
            WebElement element = DriverSetup.getDriver().findElement(By.xpath(Xpath));
            element.clear();
            element.sendKeys(text);
        }

        public static void hitEnter(String Xpath) {
            WebElement element = DriverSetup.getDriver().findElement(By.xpath(Xpath));
            element.sendKeys(Keys.ENTER);
        }

        public static String getTextofElement(String Xpath) {
            WebElement element = DriverSetup.getDriver().findElement(By.xpath(Xpath));
            String getTextFromElement = element.getText();
            return getTextFromElement;
        }

        public static List<String> getTextOfAllElements(String Xpath) {
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

}
