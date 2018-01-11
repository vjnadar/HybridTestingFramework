package pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage
{
@FindBy(how=How.XPATH,using=".//input[@id='email']")

public WebElement signInTextBox;

@FindBy(how=How.XPATH, using=".//*[@id='passwd']")

public WebElement signInPassword;

@FindBy(how=How.XPATH,using=".//*[@id='SubmitLogin']")

public WebElement submitButton;
}
