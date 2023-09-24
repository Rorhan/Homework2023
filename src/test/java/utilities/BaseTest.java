package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {
  public   WebDriver driver;



    protected static ExtentReports reports;


   protected static ExtentSparkReporter sparkReporter;



   protected static ExtentTest extentLogger;
    WebDriverWait wait;

    protected static ExtentHtmlReporter htmlReporter;
    @BeforeTest
    public void beforeTest(){
        reports=new ExtentReports();

        String projectPath=System.getProperty("user.dir");
        String path=projectPath+"/test-output/report.html";

       // sparkReporter=new ExtentSparkReporter(path);
       htmlReporter=new ExtentHtmlReporter(path);

        reports.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Extent Report Test");

        reports.setSystemInfo("Environment","QA");
        reports.setSystemInfo("Browser",ConfigReader.getProperties("browser"));
        reports.setSystemInfo("OS","os.name");
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser) throws InterruptedException {

        driver=Driver.getDriver();

        driver.get(ConfigReader.getProperties("url"));

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        wait=new WebDriverWait(driver, Duration.ofSeconds(30));




    }


    @AfterMethod
    public void tarayiciyiKapat(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE){
            extentLogger.fail(result.getName());

            String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String screenShotPath=System.getProperty("user.dir")+ "/test-output/ScreenShots/"+result.getName()+"date" +".jpg";

            //ekran fotografini almamiza yardimci olur
            TakesScreenshot ts=(TakesScreenshot) Driver.getDriver();

            File kaynak=ts.getScreenshotAs(OutputType.FILE);

            File sonDosya=new File(screenShotPath);
            FileUtils.copyFile(kaynak,sonDosya);
            
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            
            extentLogger.fail(result.getThrowable());
        } else if (result.getStatus()==ITestResult.SKIP) {
            extentLogger.skip("Test Skipped: "+result.getName());
        }


        Driver.closeDriver();
    }

    @AfterTest
    public void reportKapat(){
        reports.flush();
    }
}
