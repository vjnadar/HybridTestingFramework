package utilities;


import constants.CommonConstants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

/**
 * Created by Vijay Joshua Nadar on 3/6/2017.
 */
public class BrowserConfig
{

   private static WebDriver driver;

   public static void setBrowser(String browserName)

    {

        if(browserName.equalsIgnoreCase("firefox"))

        {
            System.setProperty("webdriver.gecko.driver", CommonConstants.FIREFOX_DRIVERPATH);

            ProfilesIni pro =new ProfilesIni();

            FirefoxProfile profile=pro.getProfile("default");

            driver=new FirefoxDriver(profile);

        }

        else if(browserName.equalsIgnoreCase("chrome"))

        {
            System.setProperty("webdriver.chrome.driver", CommonConstants.CHROME_DRIVERPATH);

            driver=new ChromeDriver();
            
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        

    }
   
   public static WebDriver getDriver()
   
   {
	   return driver;
	   
   }
   



}
