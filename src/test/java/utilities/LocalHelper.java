package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import constants.Constants;

public class LocalHelper {
	public static int timeOutInSeconds = 14;
	public static int minTime = 10;
	public static int avgTime = 30;
	protected static final Logger logger = LoggerFactory.getLogger(LocalHelper.class);
	protected static List<WebElement> elementList;

	public void clickElement(By element, WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			driver.findElement(element).click();
		}catch (NoSuchElementException | TimeoutException e){
			logger.error("Error found on click Element.");
			logger.error(e.getMessage());
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			driver.findElement(element).click();
		}catch (ElementClickInterceptedException e){
			logger.error("Error found on click Element : ElementClickInterceptedException");
			logger.info("Element : ");
			logger.info(String.valueOf(element));
			jsExecutorClick(element,driver);
		}
	}
	public List<String> getAllText(By element, WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
		List<WebElement> elements= driver.findElements(element);
		List<String> allTexts=new LinkedList<String>();
		for (WebElement webElement : elements) {
			allTexts.add(webElement.getText());
		}
		return allTexts;
	}

	public void clearElement(By element_by,WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		WebElement element = driver.findElement(element_by);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		element.clear();
	}

	public boolean verifyElement(By element,WebDriver driver){
		try{
			driver.manage().timeouts().implicitlyWait(avgTime, TimeUnit.SECONDS);
			return driver.findElement(element).isDisplayed();
		}catch (NoSuchElementException | TimeoutException e){
			return false;
		}
	}

	public boolean verifyElement(By element, int Time, WebDriver driver){
		try{
			driver.manage().timeouts().implicitlyWait(Time, TimeUnit.SECONDS);
			return driver.findElement(element).isDisplayed();
		}catch (NoSuchElementException | TimeoutException e){
			return false;
		}
	}

	public void sendKeys(By element_by,String text,WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		try {
			WebElement element = driver.findElement(element_by);
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			} catch (NoSuchElementException | TimeoutException e) {
				logger.error("No such element exception or Time out exception  on sendKeys");
				wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
				logger.info("We found the element on second time");
			}
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element_by));
				element.click();
			} catch (ElementClickInterceptedException e) {
				WebDriverWait wait2 = new WebDriverWait(driver, minTime);
				wait2.until(ExpectedConditions.visibilityOfElementLocated(element_by));
				wait2.until(ExpectedConditions.elementToBeClickable(element_by));
				scrollIntoView(element_by, driver);
				jsExecutorClick(element_by, driver);
			}
			try {
				element.clear();
				element.sendKeys(text);
			} catch (NoSuchElementException | TimeoutException e) {
				logger.error("Time out Exception or no such element exception found on ");
				logger.info(String.valueOf(element_by));
				wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
				element.clear();
				element.sendKeys(text);
			}
		}catch (NoSuchElementException e){
			logger.info("Send Keys - No such element exception");
			WebElement element = driver.findElement(element_by);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			element.click();
			element.clear();
			element.sendKeys(text);
		}
	}

	public String getText(By element_by,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try{
			WebElement element = driver.findElement(element_by);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			wait.until(ExpectedConditions.presenceOfElementLocated(element_by));
			return element.getText();
		}catch(NoSuchElementException | TimeoutException e) {
			logger.error("Time out exception or No such element exception");
			WebElement element = driver.findElement(element_by);
			WebDriverWait wait2 = new WebDriverWait(driver, avgTime);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			wait2.until(ExpectedConditions.presenceOfElementLocated(element_by));
			return element.getText();
		}
	}
	public String getTextButInteger(By element_by,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try{
			WebElement element = driver.findElement(element_by);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			wait.until(ExpectedConditions.presenceOfElementLocated(element_by));
			wait.until(ExpectedConditions.textMatches(element_by,Pattern.compile("\\b([1-9]|[1-9][0-9]+)\\b")));
			return element.getText();
		}catch(NoSuchElementException | StaleElementReferenceException |TimeoutException u) {
			logger.error("Time out exception or No such element exception");
			WebElement element = driver.findElement(element_by);
			WebDriverWait wait2 = new WebDriverWait(driver, avgTime);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			wait.until(ExpectedConditions.presenceOfElementLocated(element_by));
			wait.until(ExpectedConditions.textMatches(element_by,Pattern.compile("\\b([1-9]|[1-9][0-9]+)\\b")));
			return element.getText();
		}
	}

	public String getTextButIntegerWithZeroExpected(By element_by,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try{
			WebElement element = driver.findElement(element_by);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			wait.until(ExpectedConditions.presenceOfElementLocated(element_by));
			wait.until(ExpectedConditions.textToBe(element_by,"0"));
			return element.getText();
		}catch(NoSuchElementException | StaleElementReferenceException |TimeoutException u) {
			logger.error("Time out exception or No such element exception");
			WebElement element = driver.findElement(element_by);
			WebDriverWait wait2 = new WebDriverWait(driver, avgTime);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(element_by));
			wait.until(ExpectedConditions.presenceOfElementLocated(element_by));
			wait.until(ExpectedConditions.textToBe(element_by,"0"));
			return element.getText();
		}
	}
	public void dropDownSelectByText(By element_by, String text, WebDriver driver){
		WebElement element = driver.findElement(element_by);
		Actions actions = new Actions(driver);
		element.click();
		actions.sendKeys(text).sendKeys(Keys.chord(Keys.ENTER)).perform();
	}

	public void checkDropdownValues(By element_by, String dropdownValues, WebDriver driver) {
		WebElement element = driver.findElement(element_by);
		Select select = new Select(element);
		String[] valueArray = dropdownValues.split(",");
		List<WebElement> options = select.getOptions();
		for (WebElement value : options) {
			for (String s : valueArray) {
				if (!value.getText().equals(s)) {
					logger.info("Value not found in dropdown :");
					logger.info(String.valueOf(value));
				}
			}
		}
	}

	public void waitForPageURL(String url, WebDriver driver){
		new WebDriverWait(driver,timeOutInSeconds).until(ExpectedConditions.urlContains(url));
	}

	public void jsExecutorClick(By element_by,WebDriver driver){
		Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		wait.until(ExpectedConditions.elementToBeClickable(element_by));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element=driver.findElement(element_by);
		js.executeScript("arguments[0].click()",element);
		logger.info("Button clicked using Js Executor");
	}
	public boolean checkButtonisPresent(By element_by,WebDriver driver) {
		jsExecutorHighlight(element_by, driver);
		return driver.findElement(element_by).isEnabled();
	}
	public void jsExecutorHighlight(By element_by,WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		wait.until(ExpectedConditions.presenceOfElementLocated(element_by));
		wait.until(ExpectedConditions.elementToBeClickable(element_by));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element=driver.findElement(element_by);
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');", element);
		logger.info("Button Highlighted using Js Executor");
	}
	public void uploadUsingRobot(String location,WebDriver driver,By element) throws AWTException {
		StringSelection selection=new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot=new Robot(); 
		//robot.keyPress(KeyEvent.VK_ENTER);
	  	//robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));

	}
	public void uploadDirectlyMissingField(By element,By afterUpload,WebDriver driver) throws AWTException {
		String location="C:\\Users\\ayyappan.g\\git\\AllIndex\\AllIndex\\portfolio_format.xlsx";
		sendKeys(element, location, driver);
		jsExecutorHighlight(element, driver);

		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(afterUpload));
	}
	public void clearUsingRobot() throws AWTException {
		Robot robot=new Robot();
    	robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_A);
    	robot.keyRelease(KeyEvent.VK_A);
    	robot.keyRelease(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_DELETE);
    	robot.keyRelease(KeyEvent.VK_DELETE);
	}


	public void jsExecutorSendValue(By element_by,String Value,WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		WebElement element=driver.findElement(element_by);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		element.sendKeys(Value);
	}

	public void multipleClicks(By element_by, WebDriver driver){
		Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element_by));
		wait.until(ExpectedConditions.elementToBeClickable(element_by));

		List<WebElement> element= driver.findElements(element_by);
		for(WebElement ClickElement:element){
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", ClickElement);
				ClickElement.click();
			}catch(ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", ClickElement);
				((JavascriptExecutor) driver).executeScript("arguments[0].click()",ClickElement);
			}
		}
	}

	public void selectDropdownByVisibleText(By element_by,String Value,WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		WebElement element=driver.findElement(element_by);
		Select select = new Select(element);
		select.selectByVisibleText(Value);
	}

	public boolean verifyEnabledElement(By element_by,WebDriver driver) throws TimeoutException{
		driver.manage().timeouts().implicitlyWait(avgTime, TimeUnit.SECONDS);
		return driver.findElement(element_by).isEnabled();
	}

	public void pressTabKey(By element_by, WebDriver driver){
		WebElement element = driver.findElement(element_by);
		element.click();
		new Actions(driver).sendKeys(Keys.chord(Keys.TAB)).perform();
	}

	public void scrollIntoView(By element_by, WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		WebElement element = driver.findElement(element_by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
		wait.until(ExpectedConditions.elementToBeClickable(element_by));
	}

	public String getAttributeValue(By element_by,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		return driver.findElement(element_by).getAttribute("value");
	}
	public List<String> getAllAttributeValue(List<WebElement>  elements,WebDriver driver,String attribute) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		List<String> allAttributes=new LinkedList<String>();
		for (WebElement webElement : elements) {
			String attribute2 = webElement.getAttribute(attribute);
			allAttributes.add(attribute2);
		}
		return allAttributes;
	}

	public void sendTextByCharacter(By element_by, String sendChar, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));

		for (int i=0;i<=sendChar.length()-1;i++){
			StringBuilder sb = new StringBuilder();
			driver.findElement(element_by).sendKeys(sb.append(sendChar.charAt(i)).toString());
		}
	}

	public void clickAllElements(By elements,WebDriver driver) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elements));
		List<WebElement> findElements = driver.findElements(elements);
		for (WebElement webElement : findElements) {
			try {
				Thread.sleep(2000);
				webElement.click();
			}catch (StaleElementReferenceException e) {
				List<WebElement> findElementsAgain = driver.findElements(elements);
				for (WebElement webElementAgain : findElementsAgain) {
					try {
						webElementAgain.click();
					}catch (StaleElementReferenceException qq) {
						List<WebElement> findElementsAgainAgain = driver.findElements(elements);
						for (WebElement webElementAgainAgain : findElementsAgainAgain) {
							webElement.click();
						}
					}
				}
			}catch(ElementClickInterceptedException z) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click()",webElement);
			}
		}
		Thread.sleep(2000);
	}
	public WebElement getRandomElement(By element_by, WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
		elementList = driver.findElements(element_by);
		int eleSize = elementList.size();
		// logger.info("Element size: "+String.valueOf(eleSize));
		if(eleSize==1){
			if(elementList.get(0).getText().equalsIgnoreCase("No options")||elementList.get(0).getText().contains("Loading")){
				logger.info("No option or loading found in the drop-down");
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element_by));
				elementList = driver.findElements(element_by);
			}
			logger.info("The dropdown is showing only one value");
			return elementList.get(new Random().nextInt(eleSize));
		}
		logger.info("Get one random element");
		return elementList.get(new Random().nextInt(eleSize));

	}

	public Boolean checkLoader(By element_by, WebDriver driver, String loader_txt) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds + timeOutInSeconds);
			return wait.until(ExpectedConditions.invisibilityOfElementWithText(element_by,loader_txt));
		}catch (NoSuchElementException | TimeoutException e){
			return true;
		}
	}

	public Boolean checkLoader(By element_by,WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try{
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(element_by));
		}catch (TimeoutException e){
			logger.error("The page takes very long time to load");
			WebDriverWait wait2 = new WebDriverWait(driver, timeOutInSeconds+timeOutInSeconds);
			return wait2.until(ExpectedConditions.invisibilityOfElementLocated(element_by));
		}
		catch (NoSuchElementException  e){
			return true;
		}
	}

	public void get(String url, WebDriver driver){
		driver.get(url);
	}

	public void switchTab(WebDriver driver){
		ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
	}

	public void closeTab(WebDriver driver){
		driver.close();
	}

	public void hardRefresh(WebDriver driver){
		driver.manage().deleteAllCookies();
		((JavascriptExecutor) driver).executeScript("location.reload(true);");
		logger.info("Cache removed");
		driver.navigate().refresh();
	}


	public String readPropertyFile(String key) throws IOException {
		FileInputStream stream=new FileInputStream(new File("C:\\Users\\ayyappan.g\\git\\AllIndex\\AllIndex\\src\\test\\resources\\config.properties"));
		Properties properties=new Properties();
		properties.load(stream);
		return properties.getProperty(key);
	}
	public void loadProperties() throws IOException {
		FileInputStream stream=new FileInputStream(new File("C:\\Users\\ayyappan.g\\git\\AllIndex\\AllIndex\\src\\test\\resources\\config.properties"));
		Properties properties=new Properties(); 
		properties.load(stream);
		Constants.App_url=properties.getProperty("appurl");
		Constants.Browser=properties.getProperty("browser");
		Constants.username=properties.getProperty("username");
		Constants.password=properties.getProperty("password");
		Constants.stock1=properties.getProperty("stock1");
		Constants.stock2=properties.getProperty("stock2");
		Constants.stock3=properties.getProperty("stock3");
		Constants.noOfStocks=properties.getProperty("noOfStocks");
	}

	public void robotZoomout(WebDriver driver) throws AWTException {
		Robot robot=new Robot();
		for(int i=0;i<3;i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);

		}
	}
	public void zoomoutUsingJS(WebDriver driver) {
		String zoomJS;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		zoomJS = "document.body.style.zoom='0.70'";  
		js.executeScript(zoomJS);
	}
	public void zoomoutUsingChourd(WebDriver driver) {
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.COMMAND, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.COMMAND, Keys.SUBTRACT));
		html.sendKeys(Keys.chord(Keys.COMMAND, Keys.SUBTRACT));

	}

	public void callRobot() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public boolean checkFileintheDownload(String fileNameToBeCheck) {
		File file=new File("C:\\Users\\ayyappan.g\\Downloads");
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			if(file2.getName().contains(fileNameToBeCheck)) {
				return true;
			}
		}
		return false;
	}
}
