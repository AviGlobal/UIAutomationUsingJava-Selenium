package tests.amazon;


import base.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import pages.LocatorConstants;
import utils.*;
import pages.LocatorConstants.amazonXpaths;
import utils.ElementUtils.userActions;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;



@Slf4j
public class amazonSearch extends BaseTest {

    String textToSearch = "stainless steel kadai";
    amazonXpaths locate = new amazonXpaths();

    WaitUtils waits = new WaitUtils();
    userActions userActions = new userActions();
    SoftAssert softAssert = new SoftAssert();
    ScreenshotUtils screenshotUtil;
    EmailUtils emailUtils;
    ExcelUtils excelUtils;


    @BeforeTest
    public void initializeSetup(){
        BaseTest.getDriver();
        BaseTest.goToUrl(Constants.URLS.AMAZON_URL);
        screenshotUtil = new ScreenshotUtils(BaseTest.getDriver());
        emailUtils = new EmailUtils();
        excelUtils = new ExcelUtils();


    }

    @Test(priority = 1, description = "Verify that the search functionality returns relevant products for a valid query.")
    public void searchOnAmazon(){
        //screenshotUtil.takeScreenshot();
        userActions.setText(locate.searchBar,textToSearch);
        log.info("Searched the text");
        userActions.hitEnter(locate.searchBar);
        String resultsFetched = userActions.getTextofElement(locate.searchedTextResult);
        log.info(resultsFetched.toLowerCase());
        softAssert.assertEquals(resultsFetched.toLowerCase(), textToSearch);
    }

    @AfterSuite
    public void tearDownSuite() {
        emailUtils.sendEmailWithAttachment(
                "aviral11061997@gmail.com",
                "Search Results",
                "Please find the attached test report.",
                "path/to/ExtentReport.html"
        );
    }
}
