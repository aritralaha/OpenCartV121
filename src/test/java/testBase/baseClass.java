package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class baseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties obj;

    @BeforeClass(groups = {"SIT", "Regression"})
    public void setUp() throws IOException {
        //generating logs
        logger = LogManager.getLogger(this.getClass());

        obj = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
        obj.load(file);


        driver = new ChromeDriver();
        driver.get(obj.getProperty("appurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass(groups = {"SIT,Regression"})
    public void tearDown() {
        driver.quit();
    }


    public String randomString() {
        String alphabets = RandomStringUtils.randomAlphabetic(6);
        return alphabets;
    }

    public String randomNumbers() {
        String numbers = RandomStringUtils.randomNumeric(10);
        return numbers;
    }

    public String randomAlphanumeric() {
        return (randomString() + "@" + randomNumbers());
    }

    public String captureScreen(String tname) {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot)driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        String targetfilePath = System.getProperty("user.dir")+"\\src\\test\\screenshots\\"+tname+"_"+timeStamp+".png";
        File targetFile = new File(targetfilePath);
        sourceFile.renameTo(targetFile);
        return targetfilePath;
    }




}
