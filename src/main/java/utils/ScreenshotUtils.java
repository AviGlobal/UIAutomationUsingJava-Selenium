package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {


    private WebDriver driver;
    private static final String SCREENSHOT_FOLDER = "target/screenshots/";

    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
        createScreenshotFolder();
    }

    private void createScreenshotFolder() {
        File dir = new File(SCREENSHOT_FOLDER);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public String takeScreenshot(String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = SCREENSHOT_FOLDER + screenshotName + "_" + timestamp + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public String takeScreenshot() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return takeScreenshot("screenshot_" + timestamp);
    }
}
