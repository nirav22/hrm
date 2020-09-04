package org.example;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import static org.apache.commons.io.FileUtils.copyFile;

public class Hooks extends Util
{
    BrowserManager browserManager = new BrowserManager();

    @Before
    public void openBrowser() {
        browserManager.setUpBrowser();
    }// calling browser method to open home page


    @After
    public void closeBrowser(Scenario scenario)
    {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(".,:;?!", "") + timeStamp() + ".png";
            try {
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/target/Destination/screenshots/" + screenshotName);
                copyFile(sourcePath, destinationPath);
                scenario.write("!!!!!!......Scenario Failed....!!!!!! Please see attached screenshot for the error/issue");
                scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        browserManager.closeBrowser();// calling browser method to close the browser
    }


}