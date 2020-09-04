package org.example;

import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Util extends BasePage
{

    //Reusable method for Thread.sleep
    public static void sleep(int a)
    {
        try
        {
            Thread.sleep(a * 1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    //Reusable method for Click On Element
    public static void clickOnElement (By by)
    { driver.findElement(by).click(); }

    //Reusable method for Get Text From Element
    public static String getTextFromElement (By by)
    { return driver.findElement(by).getText();}

    //Reusable method for Wait Until Element is Clickable
    public static void waitUntilElementToBeClickable (By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.<WebElement>until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitUntilElementToBeVisible (By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.<List<WebElement>>until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    //Reusable method for Type Text In To Text Box
    public static void typeText(By by,String text)
    { driver.findElement(by).sendKeys(text);}

    //Reusable method for Select From DropDown By VisibleText
    public static void selectFromDropDownByVisibleText (By by,String text)
    { new Select(driver.findElement(by)).selectByVisibleText(text); }

    //Reusable method for Select From DropDown By Index
    public static void selectFromDropDownByIndex (By by, int  index)
    { new Select(driver.findElement(by)).selectByIndex(index);}

    //Reusable method for Select From DropDown By Value
    public static void selectFromDropDownByValue (By by,String value)
    { new Select(driver.findElement(by)).selectByValue(value);}

    //Reusable method to Timestamp Use For Print Current Time
    public static long timeStamp()
    { return (System.currentTimeMillis());}

    public static void asserttextmessage(String actucl, String expected, String message) {

        Assert.assertEquals(actucl, expected, "");// comparing two texts
    }

    public static void assertURL(String text) {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    //Reusable method to takeScreenShot
    public void takeScreenShot(String methodName)
    {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        try {//set path for screen shot store
            FileUtils.copyFile(scrFile, new File("src\\ScreenShots\\" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

