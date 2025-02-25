package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testBase.baseClass;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReports implements ITestListener {
    public ExtentSparkReporter sparkReporter; //UI of the report
    public com.aventstack.extentreports.ExtentReports extent; //common info like username
    public ExtentTest test; //updating test case entries and status of the test cases

    String repName;


    public void onStart(ITestContext context) {
        //SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.ss");
       // Date dt = new Date();
        //String currentDateTimeStamp = df.format(dt);

        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
        repName = "Test-Report-"+timestamp+".html";
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\reports\\"+repName);
        sparkReporter.config().setDocumentTitle("OpenCart Automation report"); //title of the report
        sparkReporter.config().setReportName("OpenCart Functional testing"); //name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent =new com.aventstack.extentreports.ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("Tester name", "Aritra");
        extent.setSystemInfo("username",System.getProperty("user.name"));
        extent.setSystemInfo("Env", "QA");

       String os =  context.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = context.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser",browser);

    }

    public void onTestSuccess(ITestResult result) {
        test =extent.createTest(result.getName()); //creating a new entry
        test.log(Status.PASS,"Test case passed is :"+result.getName()); //update the status of the report
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL,"test case failed is :"+result.getName());
        test.log(Status.INFO,"test case failed because :"+result.getThrowable().getMessage());

        try{
            String imgPath = new baseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP,"test case skipped is :"+result.getName());
        test.log(Status.INFO,result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
        String pathOfExtentReport = System.getProperty("user.dir")+"\\src\\test\\reports\\"+repName;
        File extentReport = new File(pathOfExtentReport);
        try{
            Desktop.getDesktop().browse(extentReport.toURI());
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


}
