package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends basePage {

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-email']")
    WebElement enterEmailAddress;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement enterPassword;

    @FindBy(xpath="//input[@value='Login']")
    WebElement clkOnLoginButton;


    public void setEnterEmailAddress(String email){
        enterEmailAddress.sendKeys(email);
    }

    public void setEnterPassword(String pwd){
        enterPassword.sendKeys(pwd);
    }

    public void setClkOnLoginButton(){
        clkOnLoginButton.click();
    }
}
