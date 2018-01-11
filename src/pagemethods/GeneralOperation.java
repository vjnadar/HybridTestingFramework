package pagemethods;

import java.lang.reflect.Field;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.CommonConstants;
import pageelements.MyAccount;
import pageelements.SignInPage;
import utilities.BrowserConfig;
import utilities.ExcelConfig;

public class GeneralOperation
{
	private WebDriver driver;
	 
	Field [] fields; 
	
	SoftAssert a;
	
	public GeneralOperation()
	{
		driver=BrowserConfig.getDriver();
		
		 a=new SoftAssert();
	}
	
	
	public void navigate(String input) throws IllegalArgumentException, IllegalAccessException
	{
				
		driver.manage().window().maximize();
		
		driver.get(input);
		
		
			
	}
	
	public void getPageTitle(String expected) throws IllegalArgumentException, IllegalAccessException
	
	{
		
		driver=BrowserConfig.getDriver();
		
		String actual=driver.getTitle();
				
		a.assertEquals(actual.replaceAll(" ", ""), expected);
		
	}
	
	public void sendKeys(String page,String object,String input)
	{
		
	        driver=BrowserConfig.getDriver();
			
			WebElement element = null;
			
			switch(page.toLowerCase())
			
			{
			case "signinpage":
				
				SignInPage siPage= PageFactory.initElements(driver, SignInPage.class);
				
				element=this.<SignInPage>getElement(siPage,object);
				
				element.sendKeys(input);
				
				break;
				
			case "myaccount":
				
				MyAccount ma=PageFactory.initElements(driver, MyAccount.class);
				
				element=this.<MyAccount>getElement(ma,object);
				
				element.sendKeys(input);
				
				break;
						
			}
		
	}
	
	public void getAttribute(String page,String object, String expected,String attributeName)
	
	{
        driver=BrowserConfig.getDriver();
		
		WebElement element = null;
		
		switch(page.toLowerCase())
		
		{
		case "signinpage":
			
			SignInPage siPage= PageFactory.initElements(driver, SignInPage.class);
			
			element=this.<SignInPage>getElement(siPage,object);
			
			String actual=element.getAttribute(attributeName);
			
			a.assertEquals(actual, expected);
			
			break;
			
		case "myaccount":
			
			MyAccount ma=PageFactory.initElements(driver, MyAccount.class);
			
			element=this.<MyAccount>getElement(ma,object);
			
            String actual1=element.getAttribute(attributeName);
			
			a.assertEquals(actual1, expected);
			
			break;
			
			
				
		}
			
	}
	
	public void getWindowSize(String expectedWidth,String expectedHeight) throws IllegalArgumentException, IllegalAccessException
	{
        int exWidth=Integer.parseInt(expectedWidth);
		
		int exHeight=Integer.parseInt(expectedHeight);
		
		driver=BrowserConfig.getDriver();
		
		Dimension windowSize=driver.manage().window().getSize();
		
		int actualWidth=windowSize.width;
		
		int actualHeight=windowSize.height;
		
		a.assertEquals(actualWidth, exWidth,"The width size does not match the expected width size");
		
		a.assertEquals(actualHeight, exHeight,"The height does not match the expected height");
		
		
		
	}
	
	public void getAndSetWindowSize(String expectedWidth,String expectedHeight) throws IllegalArgumentException, IllegalAccessException
	{
		int exWidth=Integer.parseInt(expectedWidth);
		
		int exHeight=Integer.parseInt(expectedHeight);
				
		driver=BrowserConfig.getDriver();
		
		driver.manage().window().setPosition(new Point(45,70));
		
		Dimension windowSize=driver.manage().window().getSize();
		
		int actualWidth=windowSize.width;
		
		int actualHeight=windowSize.height;
		
		a.assertEquals(actualWidth, exWidth);
		
		a.assertEquals(actualHeight, exHeight);
		
		
		
	}
	
public void getElementLocation(String page,String object, String x, String y)
	
	{
	   int exX=Integer.parseInt(x);
	
	   int exY=Integer.parseInt(x);
	   
        driver=BrowserConfig.getDriver();
		
		SoftAssert a=new SoftAssert();
		
		WebElement element = null;
		
		switch(page.toLowerCase())
		
		{
		
		case "signinpage":
			
			SignInPage siPage= PageFactory.initElements(driver, SignInPage.class);
			
			element=this.<SignInPage>getElement(siPage,object);
			
			Point actual=element.getLocation();
			
			int actualXValue=actual.getX();
			
			int actualYValue=actual.getY();
					
			a.assertEquals(actualXValue, exX,"Wrong x coordinate");
			
			a.assertEquals(actualYValue, exY,"Wrong y coordinate");
			
	        break;
			
		case "myaccount":
			
			MyAccount ma=PageFactory.initElements(driver, MyAccount.class);
			
			element=this.<MyAccount>getElement(ma,object);
			
            Point actual1=element.getLocation();
			
			int actualXValue1=actual1.getX();
			
			int actualYValue1=actual1.getY();
					
			a.assertEquals(actualXValue1, exX,"Wrong x coordinate");
			
			a.assertEquals(actualYValue1, exY,"Wrong y coordinate");
			
			break;
			
			
				
		}
			
	}


	
	 public void click(String page,String object) throws IllegalArgumentException, IllegalAccessException
	
	{
		driver=BrowserConfig.getDriver();
		
		WebElement element = null;
		
		switch(page.toLowerCase())
		{
		case "signinpage":
			
			SignInPage siPage= PageFactory.initElements(driver, SignInPage.class);
			
			element=this.<SignInPage>getElement(siPage,object);
			
			element.click();
			
			break;
			
       case "myaccount":
			
			MyAccount ma=PageFactory.initElements(driver, MyAccount.class);
			
			element=this.<MyAccount>getElement(ma,object);
			
			element.click();
			
			break;
			
		}
				
			
	}
	
	public void elementIsDisplayed(String page,String object) throws IllegalArgumentException, IllegalAccessException
	{
		driver=BrowserConfig.getDriver();
		
		WebElement element = null;
		
		switch(page.toLowerCase())
		{
		case "signinpage":
			
			SignInPage siPage= PageFactory.initElements(driver, SignInPage.class);
			
			element=this.<SignInPage>getElement(siPage,object);
			
			a.assertTrue(element.isDisplayed(),"Element not present");
			
			break;
			
	    case "myaccount":
				
				MyAccount ma=PageFactory.initElements(driver, MyAccount.class);
				
				element=this.<MyAccount>getElement(ma,object);
				
				a.assertTrue(element.isDisplayed(),"Element not present");
				
				break;
			
			
				
		}
			
	}
	
	public void assertInnerText(String page,String object, String expected) throws IllegalArgumentException, IllegalAccessException
	{
		driver=BrowserConfig.getDriver();
		
		WebElement element = null;
		
		switch(page.toLowerCase())
		{
		case "signinpage":
			
			SignInPage siPage= PageFactory.initElements(driver, SignInPage.class);
			
			element=this.<SignInPage>getElement(siPage,object);
			
			String actual=element.getText();
			
			a.assertEquals(actual, expected);
			
		case "myaccount":
			
			MyAccount ma=PageFactory.initElements(driver, MyAccount.class);
			
			element=this.<MyAccount>getElement(ma,object);
			
            String actual1=element.getText();
			
			a.assertEquals(actual1, expected);
			
			break;	
			
			
				
		}
			
	}
	
	public void assertAll() throws InterruptedException
	
	{
		
		a.assertAll();
		
		Thread.sleep(5000);
		
	}
	
	
    private <T> WebElement getElement(T page, String object)
    {
    	
    	WebElement elementToBeRetrieved = null;
    	
    	fields=page.getClass().getFields();
		
		for(int j=0;j<fields.length;j++)
		{
			if(fields[j].getName().equalsIgnoreCase(object))
           {
        	  try {
        		  
				  elementToBeRetrieved=(WebElement)fields[j].get(page);
				  
			} catch (IllegalArgumentException e) {
				
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				
			} catch (IllegalAccessException e) {
				
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				
			}
        	  	
           }

		}
    	
    	
    	return elementToBeRetrieved;
    }
    
   
    
    
}
