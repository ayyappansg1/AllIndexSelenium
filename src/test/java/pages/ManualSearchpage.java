package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

import constants.Constants;
import pom.CreatePortFolioPOM;
import pom.ManualSearchPOM;
import utilities.LocalHelper;

public class ManualSearchpage  extends ManualSearchPOM{
    Faker faker = new Faker();


protected static final Logger logger = LoggerFactory.getLogger(ManualSearchpage.class);
    
    private final LocalHelper localHelper = new LocalHelper();

    private final WebDriver driver;
    
    public ManualSearchpage(WebDriver driver) {
        this.driver=driver;
    }
    public void clickManualSearch() {
    	try {
			localHelper.jsExecutorHighlight(manualSearch, driver);
    	localHelper.clickElement(manualSearch, driver);
    	}catch(TimeoutException e) {
			localHelper.jsExecutorHighlight(CreatePortFolioPOM.createPortfolio, driver);
			localHelper.clickElement(CreatePortFolioPOM.createPortfolio, driver);
			localHelper.jsExecutorHighlight(manualSearch, driver);
	    	localHelper.clickElement(manualSearch, driver);
		}
    	logger.info("Manual Search Button is Clicked");
	}
    public void sendTextToTheSearchBox(String first,String second,String third) {
		localHelper.jsExecutorHighlight(searchBox, driver);
    	localHelper.jsExecutorClick(searchBox, driver);
    	localHelper.sendKeys(searchBox, first, driver);
    	localHelper.clickElement(selectStockAfterSearch, driver);
    	localHelper.sendKeys(searchBox, second, driver);
    	localHelper.clickElement(selectStockAfterSearch, driver);
    	localHelper.sendKeys(searchBox, third, driver);
    	localHelper.clickElement(selectStockAfterSearch, driver);
    	logger.info("Text is passed in the TextBox");

	}
    public boolean checkUploadButtonisPresent() {
    	logger.info("Checking Button is present of Not");
    	return localHelper.checkButtonisPresent(uploadButton, driver);
    }
    public boolean checkDownloadTemplateButtonisPresent() {
    	logger.info("Checking Button is present of Not");
    	return localHelper.checkButtonisPresent(downloadTemplate, driver);
    }
    public String countOfSelectedStocks() {
    	logger.info("Getting Countof Selected Stocks");
    	return localHelper.getText(selectedStocksCount, driver);
    }
    public void deselectAllSelectedStocks() throws InterruptedException {
    	localHelper.clickAllElements(cancelSelectedStocksfromSelectedStocks, driver);
    	logger.info("Deselecting all selected stocks");

    }
    public String countOfDeSelectedStocks() {
    	logger.info("Getting Countof DeSelected Stocks");
    	return localHelper.getText(DeselectedStocksCount, driver);
    }
    public void clickSelectAllButton() {
    	localHelper.clickElement(selectAllButton, driver);
    	logger.info("Selectall button is Clicked");

    }
    public void clickClearAllAllButton() {
    	localHelper.clickElement(clearAllButton, driver);
    	logger.info("ClearAll button is Clicked");

    }
    public void clickNextbutton() {
    	localHelper.clickElement(nextButton, driver);
    	logger.info("Next button is Clicked");

    }
    public String getToastMessage() {
    	logger.info("Getting Toast Message");
    	return localHelper.getText(toastMessage, driver);

    }
    public void clickNextbuttoninWeighingStepper() {
    	localHelper.clickElement(weighingStepperNextButton, driver);
    	logger.info("Weighing Stepper Next button is Clicked");
    }
    public void clickResetToEqualWeight() {
    	localHelper.clickElement(resetToEqualWeight, driver);
    	logger.info("Reset to equal weight button is Clicked");
    }
    public List<String> getEquallyDividedWeight() throws AWTException {
    	logger.info("List of Equally divided weights Returned as a List of String");
    	localHelper.robotZoomout(driver);
    	logger.info("Zoom out page");
    	List<String> allText = localHelper.getAllAttributeValue(driver.findElements(equallyDividedWeight), driver,"value");
    	return allText;
    }
    public List<String> getNoOfStocksDividingBasedonHundredPercent() {
    	logger.info("List of Stocks divided based on number of stocks");
    	double  percentage=100;
    	double noOfStocks=Double.parseDouble(Constants.noOfStocks);
    	NumberFormat formatter = new DecimalFormat("##.00");
    	List<String> equallyDividedPercentage = new LinkedList<String>();
    	for (int i = 1; i <=Integer.parseInt(Constants.noOfStocks); i++) {
    		equallyDividedPercentage.add( formatter.format(percentage/noOfStocks));
		}
    	return equallyDividedPercentage;
    }
    public void setPortfolioName(WebDriver driver) throws AWTException {
    	logger.info("Clearing TextBox");
    	localHelper.clickElement(nameTextBox, driver);
    	localHelper.clearUsingRobot();
//    	localHelper.clearElement(nameTextBox, driver);
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
    public void uploadExcelFileWithOneMissingField(WebDriver driver) throws AWTException, InterruptedException {
    	//localHelper.sendKeys(uploadButton,"C:\\Users\\ayyappan.g\\git\\AllIndex\\AllIndex\\portfolio_format.xlsx", driver);
		String location="C:\\Users\\ayyappan.g\\git\\AllIndex\\AllIndex\\portfolio_format.xlsx";
    	localHelper.clickElement(uploadButton, driver);
    	Thread.sleep(2000);
    	localHelper.uploadUsingRobot(location,driver,afterUpload);
    	//Thread.sleep(30000);
    	logger.info("Excel uploaded successfully");

    }
    public void uploadExcelFileWithAllField(WebDriver driver) throws AWTException, InterruptedException {
    	//localHelper.sendKeys(uploadButton,"C:\\Users\\ayyappan.g\\git\\AllIndex\\AllIndex\\portfolio_format.xlsx", driver);
		String location="C:\\Users\\ayyappan.g\\git\\AllIndex\\AllIndex\\portfolio_format AllFields.xlsx";
    	localHelper.clickElement(uploadButton, driver);
    	Thread.sleep(2000);
    	localHelper.uploadUsingRobot(location,driver,afterUpload);
    	//Thread.sleep(30000);
    	logger.info("Excel uploaded successfully");

    }
    public void clickNextButtonAfterUpload() {
    	localHelper.clickElement(afterUploadNextButton, driver);
    }
    public boolean getErrorMessage(WebDriver driver) {
		String text = localHelper.getText(warningMessage, driver);
    	return text.contains("One or more stocks do not have weight . Weights");
    			
    }
    public void downloadExcelFile(WebDriver driver) throws InterruptedException {
    	localHelper.clickElement(downloadTemplate, driver);
    	Thread.sleep(5000);
    	logger.info("Button clicked successfully");
    }
    public boolean verifyFileDownloadedOrNot() {
    	logger.info("File Checked SuccessFully ");
    	return localHelper.checkFileintheDownload("portfolio_format");
    }
    
    
}
