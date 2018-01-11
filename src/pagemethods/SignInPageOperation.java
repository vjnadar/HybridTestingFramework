package pagemethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import pageelements.MyAccount;
import pageelements.SignInPage;

import utilities.BrowserConfig;

public class SignInPageOperation 
{
	SignInPage page;
	
	private WebDriver driver;
	
	SoftAssert a;
	
	
	public SignInPageOperation()
	{
		
				
		driver=BrowserConfig.getDriver();
		
		a=new SoftAssert();
	}
	
	public void signIntoPage(String testCaseID,String testStepNo)
	{
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		page=PageFactory.initElements(driver, SignInPage.class);
				
		MyAccount page2=PageFactory.initElements(driver, MyAccount.class);
		
		page.signInTextBox.sendKeys("charismaticjosh84@gmail.com");
		
		page.signInPassword.sendKeys("commoncold");
		
		page.submitButton.click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<WebElement> table=page2.pageTable;
		
		for(WebElement e:table)
		{
			
			a.assertTrue(e.isDisplayed(),"Failed testcase"+testCaseID+testStepNo);
			
			
		}
	
	}
	
	public void assertAll()
	
	{
		a.assertAll();
		
	}

}
