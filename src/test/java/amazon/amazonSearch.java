package amazon;


import framework.Constants;
import framework.DriverSetup;
import framework.Locators.LocatorConstants.amazonXpaths;
import framework.utils.ElementUtils.userActions;
import framework.utils.EmailUtils;
import framework.utils.ExcelUtils;
import framework.utils.ScreenshotUtils;
import framework.utils.WaitUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;



@Slf4j
public class amazonSearch {

    String textToSearch = "stainless steel kadai";
    DriverSetup driverSetup = new DriverSetup();
    amazonXpaths locate = new amazonXpaths();

    WaitUtils waits = new WaitUtils();
    userActions userActions = new userActions();
    SoftAssert softAssert = new SoftAssert();
    ScreenshotUtils screenshotUtil;
    EmailUtils emailUtils;
    ExcelUtils excelUtils;


    @BeforeTest
    public void initializeSetup(){
        driverSetup.getDriver();
        driverSetup.goToUrl(Constants.URLS.AMAZON_URL);
        screenshotUtil = new ScreenshotUtils(driverSetup.getDriver());
        emailUtils = new EmailUtils();
        excelUtils = new ExcelUtils();

    }

    @Test(priority = 1, description = "This will search the text and check the results")
    public void searchOnAmazon(){
        screenshotUtil.takeScreenshot();
        userActions.setText(locate.searchBar,textToSearch);
        log.info("Searched the text");
        userActions.hitEnter(locate.searchBar);
        String resultsFetched = userActions.getTextofElement(locate.searchedTextResult);
        log.info(resultsFetched.toLowerCase());
        softAssert.assertEquals(resultsFetched.toLowerCase(), textToSearch);
        /*List<String> allSearchedItems = userActions.getTextOfAllElements(locate.fetchAllResultsSearchedOnTopic);
        emailUtils.sendEmailWithAttachment("aviral11061997@gmail.com","Search Results",String.valueOf(allSearchedItems),"path/to/ExtentReport.html");
        int count = allSearchedItems.size();
        log.info(String.valueOf(count));
        log.info(String.valueOf(allSearchedItems));*/
    }

    @Test
    public void readExcel() throws IOException {
        String filePath1= "/Users/aviralsingh/Downloads/ui-automation/target/sample_data.xlsx";
        String filePath = "/Users/aviralsingh/Downloads/ui-automation/target/sample_data-2.xlsx";
        List<String> sheetData = excelUtils.ReadAndPrintCompleteExcel(filePath1,"Sheet1");
        log.info(sheetData.toString());
        List<Cell> columnData = excelUtils.ReadExcelByColumnName(filePath,"Sheet1","Name");
        log.info(columnData.get(1).toString());

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


    @Test
    public void lowestPrice(){
    }
}
