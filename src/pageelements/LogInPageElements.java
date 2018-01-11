    package pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by V.J.Nadar on 3/24/2017.
 */
public class LogInPageElements
{
    @FindBy(how=How.XPATH,using=".//*[@id='ap_email']")
    WebElement userNameTextbox;
    @FindBy(how=How.XPATH,using=".//*[@id='ap_password']")
    WebElement passwordTextbox;
}
