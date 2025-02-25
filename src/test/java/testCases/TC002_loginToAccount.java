package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.accountHomePage;
import pageObjects.openingPage;
import testBase.baseClass;

public class TC002_loginToAccount extends baseClass {

    @Test(groups={"SIT"})
    public void LoginToAcc() throws InterruptedException {

        openingPage op = new openingPage(driver);
        op.setClickOnMyAccountOpeningPage();
        op.setClickOnLogin();
        Thread.sleep(2000);

        LoginPage lp = new LoginPage(driver);
        lp.setEnterEmailAddress(obj.getProperty("emailId"));
        lp.setEnterPassword(obj.getProperty("password"));
        lp.setClkOnLoginButton();
        Thread.sleep(2000);
        accountHomePage ahp = new accountHomePage(driver);
        Boolean observed=ahp.setMyAccountVisible();
       Assert.fail();

    }


}
