package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.accountHomePage;
import pageObjects.openingPage;
import testBase.baseClass;
import utilities.dataProviders;

public class TC003_LoginToAccountDDT extends baseClass {

    @Test(dataProvider = "dp1",dataProviderClass = dataProviders.class)
    public void loginUsingDDT(String email,String pwd, String validOrInvalid) throws InterruptedException {

        openingPage op = new openingPage(driver);
        op.setClickOnMyAccountOpeningPage();
        op.setClickOnLogin();
        Thread.sleep(2000);


        LoginPage lp = new LoginPage(driver);
        lp.setEnterEmailAddress(email);
        lp.setEnterPassword(pwd);
        lp.setClkOnLoginButton();
        Thread.sleep(2000);


        accountHomePage ahp = new accountHomePage(driver);
        boolean observedValue = ahp.setMyAccountVisible();

        if(validOrInvalid.equalsIgnoreCase("ValidData")){
            if(observedValue==true){
                ahp.setClickOnMyAccountAccountPage();
                ahp.setClickOnLogOutFromTop();
                Thread.sleep(2000);
                Assert.assertTrue(true);

        }
            else{
                Assert.assertTrue(false);
            }
        }

        if (validOrInvalid.equalsIgnoreCase("InvalidData")) {

            boolean observedValidationMsg = op.setvalidationErrorMsg();
            if(observedValidationMsg==true){
                Assert.assertTrue(true);

            }
            else{
                Assert.assertTrue(false);

            }

        }

    }
}
