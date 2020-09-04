package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserManager extends Util
{

    //Crate Object Of LoadProp
    public static LoadProp loadProp = new LoadProp();
    //Create a variable for store String value.
    public static final String USERNAME = loadProp.getProperty("SAUCE_LAB_USERNAME");
    //Create a variable for store String value.
    public static final String ACCESS_KEY = loadProp.getProperty("SAUCE_LAB_ACCESS_KEY");
    //Create a variable for store String value And String Concatenation.
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    //Create a variable for store boolean value.
    public static final boolean SAUCE_LAB = Boolean.parseBoolean(loadProp.getProperty("SauceLab"));
    //Create a variable for store String value.
    public static final String browserName = loadProp.getProperty("BROWSER");

    public void setUpBrowser() {
        //If sauce lab true then start this condition and start automation in sauce lab.
        if (SAUCE_LAB)
        {
            //String concatenation and string value print
            System.out.println("*** Automation  Start  In  (  ***  Sauce Lab ***  ) && " + "  (  ***  " + browserName + "  ***  )");
            //browser name match ( Chrome ) run this browser
            if (browserName.equalsIgnoreCase("Chrome"))
            {
                //sauce lab open In (Firefox) and create virtual machine for automation
                MutableCapabilities sauceOptions = new MutableCapabilities();
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 8");//start in windows 10 OS.
                browserOptions.setCapability("browserVersion", "84.0");//chrome version 84.0
                browserOptions.setCapability("sauce:options", sauceOptions);
                try
                {
                    driver = new RemoteWebDriver(new URL(URL),browserOptions);
                } catch (MalformedURLException e)
                { e.printStackTrace(); }
            }
            //browser name match ( Firefox ) run this browser
            else if (browserName.equalsIgnoreCase("Firefox"))
            {
                //sauce lab open In (Firefox) and create virtual machine for automation
                MutableCapabilities sauceOptions = new MutableCapabilities();

                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 10");//start in windows 10 OS.
                browserOptions.setCapability("browserVersion", "79.0");//chrome version 79.0
                browserOptions.setCapability("sauce:options", sauceOptions);
                try
                {//Exception handling when remote the browser
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e)
                { e.printStackTrace(); }
                //browser name match ( InternetExplorer ) run this browser
            } else if (browserName.equalsIgnoreCase("InternetExplorer"))
            {
                //sauce lab open In (InternetExplorer) and create virtual machine for automation
                MutableCapabilities sauceOptions = new MutableCapabilities();

                InternetExplorerOptions browserOptions = new InternetExplorerOptions();
                browserOptions.setCapability("platformName", "Windows 10");//start in windows 10 OS.
                browserOptions.setCapability("browserVersion", "11.285");//chrome version 11.28
                browserOptions.setCapability("sauce:options", sauceOptions);
                try
                {//Exception handling when remote the browser
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e)
                { e.printStackTrace(); }
                //browser name match ( Safari ) run this browser
            } else if (browserName.equalsIgnoreCase("Safari"))
            {
                //sauce lab open In (Safari) and create virtual machine for automation
                MutableCapabilities sauceOptions = new MutableCapabilities();
                sauceOptions.setCapability("screenResolution", "1024x768");//set screenResolution

                SafariOptions browserOptions = new SafariOptions();
                browserOptions.setCapability("platformName", "macOS 10.15");//start in Mac OS.
                browserOptions.setCapability("browserVersion", "13.1");//safari version is 12.0
                browserOptions.setCapability("sauce:options", sauceOptions);
                try
                {//Exception handling when remote the browser
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e)
                { e.printStackTrace(); }
            } else
                {
                //String concatenation and string value print
                System.out.println(" You Enter Wrong Browser Name Or Empty , Please Enter Valid Browser Name !!!" + browserName.equalsIgnoreCase(""));
                }
        } else
            {
            //else sauce lab false then start this condition and start automation in Local Device.
            System.out.println("***  Automation Start With ( *** Local Device *** ) && " + " ( ***  " + browserName + "  *** )");//print string value
            //if else if condition for cross browsing
            //browser name match ( Chrome ) run this browser
            if (browserName.equalsIgnoreCase("Chrome"))
            {
//                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--incognito");
                //   capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDrivers\\chromedriver85.exe");
                driver = new ChromeDriver();
                //browser name match ( Firefox ) run this browser
            } else if (browserName.equalsIgnoreCase("Firefox"))
            {
                System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\BrowserDrivers\\geckodriver.exe");
                //  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                //   capabilities.setCapability("browser.privatebrowsing.autostart", true);
                driver = new FirefoxDriver();

                //browser name match ( InternetExplorer ) run this browser
            } else if (browserName.equalsIgnoreCase("InternetExplorer"))
            {
                //   DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
                // Set ACCEPT_SSL_CERTS  variable to true
                //   cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                // Set the driver path
                System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDrivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                //object of InternetExplorerDriver or InternetExplorer open
            } else
                {
                //String concatenation and string value print
                System.out.println("You Enter Wrong Browser Name Or Empty ,Please Enter Valid Browser Name !!!" + browserName.equalsIgnoreCase(""));
                }
            }
        driver.manage().window().maximize();//run time windows size maximize
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//wait for 60 second before all test case
        driver.get(loadProp.getProperty("URL"));//type URL by get property
    }

    public void closeBrowser() {
        driver.close();//close Browser
    }

}

