package pageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountHomePage extends basePage {

    public accountHomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//a[@title='My Account']")
    WebElement clickOnMyAccount;

    @FindBy(xpath="//ul//a[text()='Logout']")
    WebElement clickOnLogOutFromTop;

    @FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
    WebElement clickOnLogOut;


    public boolean setMyAccountVisible(){
        Boolean myacc = myAccount.isDisplayed();
        return myacc;
    }

    public void setClickOnLogOut(){
        clickOnLogOut.click();

        }

    public void setClickOnMyAccountAccountPage(){
        clickOnMyAccount.click();
    }

    public void setClickOnLogOutFromTop(){
        clickOnLogOutFromTop.click();
    }
}

