package pages;

import java.awt.AWTException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

import constants.Constants;
import pom.CreatePortFolioPOM;
import pom.ManualSearchPOM;
import pom.NonReBalancePOM;
import utilities.LocalHelper;

public class NonReBalancePage  extends NonReBalancePOM {
	
    Faker faker = new Faker();
	protected static final Logger logger = LoggerFactory.getLogger(CreatePortfolioByManualSearchPage.class);

	private final LocalHelper localHelper = new LocalHelper();

	private final WebDriver driver;
	public NonReBalancePage(WebDriver driver) {
		this.driver=driver;
	}

	public boolean checkPresenseOfNonRebalanceButton() {
    	logger.info("checkPresenseOfNonRebalanceButton");

		try {
			boolean checkButtonisPresent = localHelper.checkButtonisPresent(nonRebalanceButton, driver);
			return checkButtonisPresent;
		}catch (TimeoutException u) {
			localHelper.jsExecutorHighlight(CreatePortFolioPOM.createPortfolio, driver);
			localHelper.clickElement(CreatePortFolioPOM.createPortfolio, driver);
			localHelper.jsExecutorHighlight(nonRebalanceButton, driver);
			boolean checkButtonisPresent = localHelper.checkButtonisPresent(nonRebalanceButton, driver);
			return checkButtonisPresent;
		}
	}
	public List<String> textOfLabelInNavigationTabs() {
    	logger.info("Getting textOfLabelInNavigationTabs");
		localHelper.jsExecutorHighlight(NavigationMenuCounts, driver);
		List<String> allText = localHelper.getAllText(NavigationMenuCounts, driver);
		List<String> newList=new LinkedList<>();
		for (String string : allText) {
			StringBuffer alpha = new StringBuffer();
			for (int i = 0; i < string.length(); i++) {
				if(Character.isAlphabetic(string.charAt(i))) {
					alpha.append(string.charAt(i));
				}else if(Character.isDigit(string.charAt(i))) {
					//	number.append(string.charAt(i));
				}else {
					alpha.append(string.charAt(i));
				}
			}
			String trim = alpha.toString().trim();
			newList.add(trim);
		}
		return newList;
	}
	public void clickNonRebalanceButton() {
    	logger.info("Clicking NonRebalanceButton");
		try {
		localHelper.jsExecutorHighlight(nonRebalanceButton, driver);
		localHelper.clickElement(nonRebalanceButton, driver);
		}catch (TimeoutException e) {
			localHelper.clickElement(CreatePortFolioPOM.createPortfolio, driver);
			localHelper.clickElement(nonRebalanceButton, driver);
		}
		}
	public void clickMenu(By element) {
    	logger.info("Clicking Menu");
		localHelper.jsExecutorHighlight(element, driver);
		localHelper.clickElement(element, driver);
	}
	public void selectThreeCountries() throws InterruptedException {
    	logger.info("Selecting Three countries");
		localHelper.clickAllElements(threeCountries, driver);
	}
	public void selectTwoCountries() throws InterruptedException {
    	logger.info("Selecting Two countries");
		localHelper.clickAllElements(twoCountries, driver);
	}
	public String getSuccessToastMessage() {
    	logger.info("getSuccessToastMessage");
    	return localHelper.getText(toastMessage, driver);
	}
	public String getCount(By element) {
		logger.info("Getting count of Elements");
		localHelper.jsExecutorHighlight(element, driver);
		return localHelper.getTextButInteger(element, driver);
	}
	public String getCountZeroExpected(By element) {
		logger.info("Getting count of Elements");
		localHelper.jsExecutorHighlight(element, driver);
		return localHelper.getTextButIntegerWithZeroExpected(element, driver);
	}
	public int getCountOfInsideElements(By element) {
		logger.info("Getting count of Inside Elements");
		return driver.findElements(element).size();
	}
	public List<String> getAllElements(By element) {
		logger.info("Getting count of All Elements");
		List<String> li=new LinkedList<>();
		List<WebElement> findElements = driver.findElements(element);
		for (WebElement webElement : findElements) {
			String text = webElement.getText();
			String[] split = text.split("\\r?\\n|\\r");
			li.add(split[0]);
		}
		return li;
	}
	public List<Integer> getAllElementsOnlyCount(By element) {
		logger.info("Getting count of All Elements");
		List<Integer> li=new LinkedList<>();
		List<WebElement> findElements = driver.findElements(element);
		for (WebElement webElement : findElements) {
			String text = webElement.getText();
			String[] split = text.split("\\r?\\n|\\r");
			li.add(Integer.parseInt(split[1].replaceAll("[()]", "")));
		}
		return li;
	}
	public void clickAtoZTwoTimes() {
		logger.info("clickAtoZTwoTimes");
		try {
		localHelper.jsExecutorClick(aToZIcon, driver);
		localHelper.jsExecutorHighlight(aToZIcon, driver);
		localHelper.jsExecutorClick(aToZIcon, driver);
		localHelper.jsExecutorHighlight(aToZIcon, driver);
		}catch (NoSuchElementException e) {
			clickMenu(assetClassMenu);
			localHelper.jsExecutorClick(aToZIcon, driver);
			localHelper.jsExecutorHighlight(aToZIcon, driver);
		}
	}
	public void clickMenuClearButton() {
		logger.info("clickMenuClearButton");
		localHelper.jsExecutorHighlight(menuClearAllButton, driver);
		localHelper.jsExecutorClick(menuClearAllButton, driver);
	}
	public void clickSelectedStocksClearButton() {
		logger.info("clickSelectedStocksClearButton");
		localHelper.jsExecutorHighlight(selectedStocksClearAllButton, driver);
		localHelper.jsExecutorClick(selectedStocksClearAllButton, driver);
	}
	public void clickSelectedStocksSelectAllButton() {
		logger.info("clickSelectedStocksSelectAllButton");
		localHelper.jsExecutorHighlight(selectedStocksSelectAllButton, driver);
		localHelper.jsExecutorClick(selectedStocksSelectAllButton, driver);
	}
	public void clickNextButton() {
		logger.info("clickNextButton");
		localHelper.jsExecutorHighlight(nextButton, driver);
		localHelper.jsExecutorClick(nextButton, driver);
	}
	public void clickWeighingStepperNextButton() {
		logger.info("clickWeighingStepperNextButton");
		localHelper.jsExecutorHighlight(weighingStepperNextButton, driver);
		localHelper.jsExecutorClick(weighingStepperNextButton, driver);
	}
	public void clickAdditionalStepperNextButton() {
		logger.info("clickAdditionalStepperNextButton");
		localHelper.jsExecutorHighlight(additionalStepperNextButton, driver);
		localHelper.jsExecutorClick(additionalStepperNextButton, driver);
	}
	
	public void clickSkipButton() {
		localHelper.jsExecutorHighlight(skipButton, driver);
		localHelper.jsExecutorClick(skipButton, driver);
	}
	public void clickCustomButton() throws InterruptedException {
		Thread.sleep(3000);
		localHelper.jsExecutorHighlight(customButton, driver);
		localHelper.clickElement(customButton, driver);
		//WebDriverWait wait= new WebDriverWait(driver,15);
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(NonReBalancePOM.equalValuesCountry));
	}
	public void clickSectorButton() throws InterruptedException {
		localHelper.jsExecutorHighlight(sectorButton, driver);
		localHelper.clickElement(sectorButton, driver);
		//WebDriverWait wait= new WebDriverWait(driver,15);
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(NonReBalancePOM.equalValuesCountry));
	}
	public void clickIndustryButton() throws InterruptedException {
		localHelper.jsExecutorHighlight(industryButton, driver);
		localHelper.clickElement(industryButton, driver);
		//WebDriverWait wait= new WebDriverWait(driver,15);
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(NonReBalancePOM.equalValuesCountry));
	}
	
	public void clickResetToEqualButton() {
		localHelper.jsExecutorHighlight(ResetToEqualButton, driver);
		localHelper.jsExecutorClick(ResetToEqualButton, driver);
	}
	public void clickResetToMarketCapButton() {
		localHelper.jsExecutorHighlight(ResetToMarketCapWeight, driver);
		localHelper.jsExecutorClick(ResetToMarketCapWeight, driver);
	}
	 public List<String> getEquallyDividedWeightCountry() throws AWTException {
	    	logger.info("List of Equally divided weights Returned as a List of String");
	    	localHelper.robotZoomout(driver);
	    	logger.info("Zoom out page");
	    	List<String> allText = localHelper.getAllAttributeValue(driver.findElements(equalValuesCountry), driver,"value");
	    	return allText;
	    }
	 public List<String> getEquallyDividedWeightSector() throws AWTException {
	    	logger.info("List of Equally divided weights Returned as a List of String");
	    	localHelper.robotZoomout(driver);
	    	logger.info("Zoom out page");
	    	List<String> allText = localHelper.getAllAttributeValue(driver.findElements(equalValuesSector), driver,"value");
	    	return allText;
	    }
	 public List<String> getEquallyDividedWeightIndustry() throws AWTException {
	    	logger.info("List of Equally divided weights Returned as a List of String");
	    	localHelper.robotZoomout(driver);
	    	logger.info("Zoom out page");
	    	List<String> allText = localHelper.getAllAttributeValue(driver.findElements(equalValuesIndustry), driver,"value");
	    	return allText;
	    }
	 public boolean checkTotalWithHundred(List<String> list) {
		 double sum=0;
	    	NumberFormat formatter = new DecimalFormat("##.00");
		 for (String string : list) {
			sum=sum+Double.parseDouble(formatter.format(Double.parseDouble(string)));
		}
		 System.out.println("Sum is "+sum);
		 return sum>=99.5;
	 }
	  public List<String> getNoOfStocksDividingBasedonHundredPercent() {
	    	logger.info("List of Stocks divided based on number of stocks");
	    	double  percentage=100;
	    	double noOfStocks=Double.parseDouble(Integer.toString(driver.findElements(threeCountries).size()));
	    	NumberFormat formatter = new DecimalFormat("##.00");
	    	List<String> equallyDividedPercentage = new LinkedList<String>();
	    	for (int i = 1; i <=Integer.parseInt(Integer.toString(driver.findElements(threeCountries).size())); i++) {
	    		equallyDividedPercentage.add( formatter.format(percentage/noOfStocks));
			}
	    	return equallyDividedPercentage;
	    }
	  public List<String> getNoOfStocksDividingBasedonHundredPercentSectorWise() {
	    	logger.info("List of Stocks divided based on number of stocks");
	    	double  percentage=100;
	    	double noOfStocks=Double.parseDouble(Integer.toString(driver.findElements(threeCountries).size()));
	    	NumberFormat formatter = new DecimalFormat("##.00");
	    	List<String> equallyDividedPercentage = new LinkedList<String>();
	    	for (int i = 1; i <=Integer.parseInt(Integer.toString(driver.findElements(threeCountries).size())); i++) {
	    		equallyDividedPercentage.add( formatter.format(percentage/noOfStocks));
			}
	    	return equallyDividedPercentage;
	    }
	  public void setPortfolioName(WebDriver driver) throws AWTException {
	    	logger.info("Clearing TextBox");
	    	localHelper.clickElement(nameTextBox, driver);
	    	localHelper.clearUsingRobot();
//	    	localHelper.clearElement(nameTextBox, driver);
	    	localHelper.sendKeys(nameTextBox, faker.name().firstName()+"_Automated PortFolio", driver);
	    	logger.info("Portfolio Name is set on the TextBox");
	    }
	  public void setDescription(WebDriver driver) throws AWTException {
	    	logger.info("Clearing Description Box");
	    	localHelper.clickElement(descriptionTextBox, driver);
	    	localHelper.clearUsingRobot();
	    	//localHelper.clearElement(descriptionTextBox, driver);
	    	localHelper.sendKeys(descriptionTextBox, faker.address().fullAddress(), driver);
	    	logger.info("Description is set on the Description box");
	    }
	    public void selectImage(WebDriver driver) {
	    	localHelper.clickElement(image, driver);
	    	logger.info("Image is selected");
	    }
	    public void clickSubmit(WebDriver driver) {
	    	localHelper.clickElement(submit, driver);
	    	logger.info("Submit Button is Clicked");
	    }
}
