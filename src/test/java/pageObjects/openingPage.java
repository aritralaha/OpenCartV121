package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class openingPage extends basePage {

  public openingPage(WebDriver driver)
  {
      super(driver);
  }

    @FindBy(xpath="//span[text()='My Account']")
    WebElement clickOnMyAccount;

    @FindBy(xpath="//a[text()='Register']")
    WebElement clickOnRegister;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement clickOnLogin;

    @FindBy(xpath="//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
    WebElement validationErrorMsg;

    public void setClickOnMyAccountOpeningPage(){

        clickOnMyAccount.click();
    }

    public void setClickOnRegister(){

        clickOnRegister.click();

    }

    public void setClickOnLogin()
    {
        clickOnLogin.click();
    }

    public boolean setvalidationErrorMsg(){
        boolean validationError = validationErrorMsg.isDisplayed();
        return validationError;
    }


}
