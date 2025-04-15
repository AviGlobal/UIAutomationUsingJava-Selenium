package amazon;


import framework.Constants;
import framework.DriverSetup;
import framework.LocatorConstants.amazonXpaths;
import framework.Utilities;
import framework.Utilities.userActions;
import framework.Utilities.Waits;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v121.preload.model.RuleSetErrorType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@Slf4j
public class amazonSearch {

    DriverSetup driverSetup = new DriverSetup();
    amazonXpaths locate = new amazonXpaths();
    Waits waits = new Waits();
    userActions userActions = new userActions();

    @BeforeTest
    public void initializeSetup(){
        driverSetup.getDriver();
        driverSetup.goToUrl(Constants.URLS.AMAZON_URL);
    }

    @Test
    public void Search(){
        userActions.setText(locate.searchBar,"Stailness Still Kadhai");
        log.info("Searched");
        userActions.hitEnter(locate.searchBar);
        List<String> allSearchedItems = userActions.getTextOfAllElements(locate.fetchAllResultsSearchedOnTopic);
        int count = allSearchedItems.size();
        log.info(String.valueOf(count));
        log.info(String.valueOf(allSearchedItems));
    }

}
