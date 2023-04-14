package baseClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import utilities.LocalHelper;
import utilities.TestUtil;

public class BaseClass {
	protected static final Logger logger = LoggerFactory.getLogger(BaseClass.class);
	private final LocalHelper localHelper = new LocalHelper();

	protected WebDriver driver;
	protected Properties prop;
	protected String appURL;
	//  protected JsonPath jsonPathEvaluator;
	protected String baseURI;


	@BeforeMethod(alwaysRun = true)
	protected void SetUp() throws IOException {
		localHelper.loadProperties();
		String browser=Constants.Browser;
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
			logger.error("Please check the Browser name");
		logger.info(browser+" BROWSER WAS STARTED SUCCESSFULLY");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(Constants.App_url);
	}

	public WebDriver getDriver(){
		return this.driver;
	}

	@AfterMethod(alwaysRun = true)
	protected void tearDown(ITestResult result) {
		logger.info(("[tearDown]"));
		if(result.getStatus()==ITestResult.FAILURE||result.getStatus()==ITestResult.SKIP){
			try {
				TestUtil.getScreenshot(driver, String.valueOf(result.getName()));
				attachScreenshotsToAllureReport(driver);
				attachLog(String.valueOf(result.getMethod()).replaceAll("[()]",""));

				logger.info("Screenshot taken for Failed TC");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			driver.quit();
	}
	@Attachment(value = "Failed TC Screenshot",type = "image/png")
	public void attachScreenshotsToAllureReport(WebDriver driver){
		((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "{0}",type = "text/plain")
	public static void attachLog(String message){
		logger.info(message);
	}

}
