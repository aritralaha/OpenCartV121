package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class enterAccountCreationDetails extends basePage {

    public enterAccountCreationDetails(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement enterfirstname;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement enterlastName;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement enterEmailId;

    @FindBy(xpath ="//input[@id='input-telephone']")
    WebElement entertelephoneNumber;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement enterPassword;

    @FindBy(xpath ="//input[@id='input-confirm']")
    WebElement confirmPassword;

    @FindBy(xpath="//input[@type='checkbox']")
    WebElement clickOnCheckbox;

    @FindBy(xpath="//input[@type='submit']")
    WebElement clickOnContinuewButton;

    @FindBy(xpath="//h1[contains(text(),'Account Has Been Created')]")
    WebElement accountVerification;

    public void setEnterfirstname(String firstname){
        enterfirstname.sendKeys(firstname);
    }

    public void setEnterlastName(String lastName){
        enterlastName.sendKeys(lastName);
    }

    public void setEnterEmailId(String emailid){
        enterEmailId.sendKeys(emailid);
    }

    public void setEntertelephoneNumber(String telephonenumber){
        entertelephoneNumber.sendKeys(telephonenumber);
    }

    public void setEnterPassword(String password){
        enterPassword.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPasswords){

        confirmPassword.sendKeys(confirmPasswords);
    }

    public void setClickOnCheckbox(){
        clickOnCheckbox.click();
    }

    public void setClickOnContinuewButton(){
        clickOnContinuewButton.click();
    }

    public String setAccountVerification(){
        return accountVerification.getText();

    }





}
