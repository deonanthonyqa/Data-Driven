package DataDriven.DataD.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

//import DataDriven.DataD.PageObjects.HomePage;
import DataDriven.DataD.PageObjects.signUpPage;
import DataDriven.DataD.Utils.CommonMethods;
import DataDriven.DataD.Utils.ReadConfigDetails;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static String appURL = null;
	private static WebDriver driver;
	public static String browserType = null;
	public static String configPath = null;
	

	public ExtentHtmlReporter  htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	signUpPage sp = new signUpPage();
	
	public ReadConfigDetails configDtls = new ReadConfigDetails();
	
	CommonMethods cm;
	
	@BeforeClass
	public void initDriver() {
		System.out.println("Initialized Driver");
		try {
			// Reading the Config details info with object reference
		
			//browserType = configDtls.getBrowser();
			appURL = configDtls.getPropertyValue("url");
			
		} catch (Exception e) {
			// logger.error("Error in initializeSuite Method: ", e.getMessage());
			System.out.println(e.getMessage());
		}
		try {
			String browser = configDtls.getPropertyValue("browser");
			System.out.println(browser+"It is browser");
			switch (browser.toLowerCase()) {
			case "chrome":
				initChromeDriver();
				break;
			case "firefox":
				initFirefoxDriver(appURL);
				break;
			case "ie":
				initIEDriver(appURL);
				break;

		}
			
		} catch (Exception e) {
			//logger.error("Error in initDriver Method: ", e.getMessage());
			e.printStackTrace();
		}
	}

	
	public void initFirefoxDriver(String appURL) {
		//logger.info("Launching Google Chrome browser......");
		WebDriverManager.firefoxdriver().setup();
		setDriver(new FirefoxDriver());
		getDriver().manage().window().maximize();
		getDriver().get(appURL);
		//driver.manage().timeouts().implicitlyWait(null);
		//logger.info("Launched URL : " + appURL);
	}
	
	public void initIEDriver(String appURL) {
		//logger.info("Launching Google Chrome browser......");
		WebDriverManager.iedriver().setup();
		setDriver(new InternetExplorerDriver());
		getDriver().manage().window().maximize();
		getDriver().get(appURL);
		//driver.manage().timeouts().implicitlyWait(null);
		//logger.info("Launched URL : " + appURL);
	}
	
	public void initChromeDriver() {
		//logger.info("Launching Google Chrome browser......");
		WebDriverManager.chromedriver().setup();
		setDriver(new ChromeDriver());
		getDriver().manage().window().maximize();
		//session id
		getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		
		//driver.manage().timeouts().implicitlyWait(null);
		//logger.info("Launched URL : " + appURL);
	}
    
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Base.driver = driver;
	}
	
	@BeforeSuite
	public void setupSuite()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extentReports/"+repName);
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","deonanthonyqa@gmail.com");
		
		htmlReporter.config().setDocumentTitle("Celonis Test Report"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	@BeforeMethod
	public void loadUrl() {

		 Base.getDriver().get(configDtls.getPropertyValue("url"));
	}	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		try {
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			
			String screenshotPath = cm.takeScreenshot(result.getName(), Base.getDriver());
			
			
			File f = new File(screenshotPath); 
			//System.out.println("The user logged out from listners on failure");
			
			if(f.exists())
			{
				
				try {
					logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				} 
			extent.flush();
			} 
		
		extent.flush();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		}
		

	 @AfterClass
	  public void tearDownSuite() {

	  
		Base.getDriver().quit();
		 
		  
	  }
	 
	
}
