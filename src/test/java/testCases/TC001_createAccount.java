package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.enterAccountCreationDetails;
import pageObjects.openingPage;
import testBase.baseClass;

import java.time.Duration;

public class TC001_createAccount extends baseClass {


    @Test(groups={"SIT","Regression"})
    public void loginTest() throws InterruptedException {

        logger.info("********Starting TC001_createAccount");

        try {

            openingPage op = new openingPage(driver);
            logger.info("********Clicked on My Account link");
            op.setClickOnMyAccountOpeningPage();
            Thread.sleep(1000);
            logger.info("********Clicked on Register link");
            op.setClickOnRegister();
            Thread.sleep(2000);

            logger.info("********Entering user details");
            enterAccountCreationDetails enterdetails = new enterAccountCreationDetails(driver);
            enterdetails.setEnterfirstname(randomString());
            enterdetails.setEnterlastName(randomString());
            enterdetails.setEnterEmailId(randomString() + "@dummygmail.com");
            enterdetails.setEntertelephoneNumber(randomNumbers());
            String password = randomAlphanumeric();
            enterdetails.setEnterPassword(password);
            enterdetails.setConfirmPassword(password);
            enterdetails.setClickOnCheckbox();

            logger.info("********Clicking on continue button");
            enterdetails.setClickOnContinuewButton();
            Thread.sleep(3000);

            logger.info("validating expected message");
            String accountStatusDetails = enterdetails.setAccountVerification();
            if (accountStatusDetails.equals("Your Account Has Been Created!")){

                Assert.assertTrue(true);
            }
            else{
                logger.error("Test Failed");
                logger.debug("Debug the error");
                Assert.assertTrue(false);
            }
        }
        catch(Exception e){

            Assert.fail();

        }




    }

}
