package framework.Locators;

import org.openqa.selenium.WebElement;

public class LocatorConstants {


    public static class amazonXpaths {

        public static String checkLandingPage = "//span[@class='nav-sprite nav-logo-base']";
        public static String searchBar = "//input[@id='twotabsearchtextbox']";
        public static String searchedTextResult = "(//div[@class=\"sg-col-inner\"]//span[contains(text(), 'stainless steel kadai')])[1]";
        //public static String finalresultsCheck = "//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']";
        public static String fetchAllResultsSearchedOnTopic = "//div[@data-component-type='s-search-result']";

    }
}


