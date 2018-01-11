package pageelements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindAll;

public class MyAccount 
{
	@FindBy(how=How.XPATH,using=".//ul[@class='myaccount-link-list']/li/a[@title='Orders']")
	
	public WebElement orderButton;
	
	@FindAll({@FindBy(how=How.XPATH,using=".//*[@class='row addresses-lists']/div[1]/ul/li[1]"),
		@FindBy(how=How.XPATH,using=".//*[@class='row addresses-lists']/div[1]/ul/li[2]"),
		@FindBy(how=How.XPATH,using=".//*[@class='row addresses-lists']/div[1]/ul/li[3]"),
        @FindBy(how=How.XPATH,using=".//*[@class='row addresses-lists']/div[1]/ul/li[4]")})
	
	public List <WebElement> pageTable;
	

}
