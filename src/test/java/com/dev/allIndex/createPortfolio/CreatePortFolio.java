package com.dev.allIndex.createPortfolio;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.AWTException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import constants.Constants;
import pages.CreatePortfolioByManualSearchPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ManualSearchpage;
import pom.CreatePortFolioPOM;
import pom.ManualSearchPOM;

public class CreatePortFolio extends BaseClass {


	private CreatePortfolioByManualSearchPage createPortFolioManual;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private ManualSearchpage manualSearchPage;
	@BeforeMethod(alwaysRun = true)
	public void setUp(){
		logger.info("Initial setup is in progress");
		createPortFolioManual = new CreatePortfolioByManualSearchPage(driver);
		createPortFolioManual.scrollToAcceptTermsAndConditions();
		createPortFolioManual.acceptTermsAndConditions();
		dashboardPage=new DashboardPage(driver);
		dashboardPage.acceptCookies();
		dashboardPage.clickLoginInButton();
		createPortFolioManual.clickAlreadyHaveLoginButton();
		loginPage=new LoginPage(driver);
		loginPage.enterUsername(Constants.username);
		loginPage.enterPassword(Constants.password);
		loginPage.clickLoginButton();
		createPortFolioManual.scrollToAcceptTermsAndConditions();
		createPortFolioManual.acceptTermsAndConditions();
	}

	@Test(priority = 0)
	public void verifyCountOfSelectedStocksMatchingWithSelectedManually() {
		logger.info("Running method verifyCountOfSelectedStocksMatchingWithSelectedManually ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		manualSearchPage.sendTextToTheSearchBox(Constants.stock1,Constants.stock2,Constants.stock3);
		String countOfSelectedStocks = manualSearchPage.countOfSelectedStocks();
		Assert.assertEquals(Integer.parseInt(countOfSelectedStocks), Integer.parseInt(Constants.noOfStocks),"Verify count of Selected Stocks");
	}
	@Test(priority = 1)
	public void verifyCountOfDeselectedStocksAfterRemovedFromSelectedStocks() throws InterruptedException {
		logger.info("Running method verifyCountOfDeselectedStocksAfterRemovedFromSelectedStocks ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		manualSearchPage.sendTextToTheSearchBox(Constants.stock1,Constants.stock2,Constants.stock3);
		manualSearchPage.deselectAllSelectedStocks();
		String countOfDeSelectedStocks = manualSearchPage.countOfDeSelectedStocks();
		Assert.assertEquals(Integer.parseInt(countOfDeSelectedStocks), Integer.parseInt(Constants.noOfStocks),"Verify count of DeSelected Stocks");
	}
	@Test(priority = 2)
	public void VerificationOfWorkingOfClearAllButton() throws InterruptedException {
		logger.info("Running method VerificationOfWorkingOfClearAllButton ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		manualSearchPage.sendTextToTheSearchBox(Constants.stock1,Constants.stock2,Constants.stock3);
		manualSearchPage.clickClearAllAllButton();
		String countOfDeSelectedStocks = manualSearchPage.countOfDeSelectedStocks();
		Assert.assertEquals(Integer.parseInt(countOfDeSelectedStocks), Integer.parseInt(Constants.noOfStocks),"Verify count of DeSelected Stocks");
	}

	@Test(priority = 3)
	public void VerificationOfWorkingOfSelectAllButton() throws InterruptedException {
		logger.info("Running method VerificationOfWorkingOfSelectAllButton ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		manualSearchPage.sendTextToTheSearchBox(Constants.stock1,Constants.stock2,Constants.stock3);
		manualSearchPage.clickClearAllAllButton();
		manualSearchPage.clickSelectAllButton();
		String countOfSelectedStocks = manualSearchPage.countOfSelectedStocks();
		Assert.assertEquals(Integer.parseInt(countOfSelectedStocks), Integer.parseInt(Constants.noOfStocks),"Verify count of Selected Stocks");
	}
	@Test(priority = 4)
	public void verificationOfEqualStockDistributionInWeighingStepper() throws InterruptedException, AWTException {
		logger.info("Running method verificationOfEqualStockDistributionInWeighingStepper ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		manualSearchPage.sendTextToTheSearchBox(Constants.stock1,Constants.stock2,Constants.stock3);
		manualSearchPage.clickNextbutton();
		manualSearchPage.clickResetToEqualWeight();
		List<String> equallyDividedWeight = manualSearchPage.getEquallyDividedWeight();
		List<String> noOfStocksDividingBasedonHundredPercent = manualSearchPage.getNoOfStocksDividingBasedonHundredPercent();
		assertThat(equallyDividedWeight).hasSameElementsAs(noOfStocksDividingBasedonHundredPercent);
	}
	@Test(priority = 5)
	public void createPortfolioManulSearch() throws InterruptedException, AWTException {
		logger.info("Running method createPortfolioManulSearch ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		manualSearchPage.sendTextToTheSearchBox(Constants.stock1,Constants.stock2,Constants.stock3);
		manualSearchPage.clickNextbutton();
		manualSearchPage.clickResetToEqualWeight();
		manualSearchPage.clickNextbuttoninWeighingStepper();
		manualSearchPage.clickNextbuttoninWeighingStepper();
		manualSearchPage.setPortfolioName(driver);
		manualSearchPage.setDescription(driver);
		manualSearchPage.selectImage(driver);
		manualSearchPage.clickSubmit(driver);
		if(manualSearchPage.getToastMessage().contains("Ensure this field has no more than 50 characters.")) {
			Assert.fail("Name of the Portfolio exceeding allowed 50 characters");
		}else if(manualSearchPage.getToastMessage().contains("Something went wrong")) {
			Assert.fail("Test Failed.Something went Wrong");
		}else {
			logger.info("Successfully Created the PortFolio");
		}
	}
	@Test(priority = 6)
	public void checkUploadButtonPresent() throws InterruptedException {
		logger.info("Running method checkUploadButtonPresent ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		Assert.assertTrue(manualSearchPage.checkUploadButtonisPresent(),"Check Upload Button is Present");

	}
	@Test(priority = 7)
	public void checkDownloadButtonPresent() throws InterruptedException {
		logger.info("Running method checkDownloadButtonPresent ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		Assert.assertTrue(manualSearchPage.checkDownloadTemplateButtonisPresent(),"Check Download Template Button is Present");
	}
	@Test(priority = 8)
	public void verifyFileDownloadedOrNot() throws InterruptedException {
		logger.info("Running method verifyFileDownloadedOrNot ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		manualSearchPage.downloadExcelFile(driver);
		Assert.assertTrue(manualSearchPage.verifyFileDownloadedOrNot(),"Verify File Downloaded");
	}
	@Test(priority = 9)
	public void checkWarningMEssageIfExcelUploadedWithMissedWeighing() throws InterruptedException, AWTException {
		logger.info("Running method checkWarningMEssageIfExcelUploadedWithMissedWeighing ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		manualSearchPage.uploadExcelFileWithOneMissingField(driver);
		Assert.assertTrue(manualSearchPage.getErrorMessage(driver), "Check the Warning message after uploading Missed fielded ExcelFile");
	}
	@Test(priority = 10)
	public void createPortfoliowithExcelFileUpload() throws InterruptedException, AWTException {
		logger.info("Running method createPortfoliowithExcelFileUpload ");
		manualSearchPage=new ManualSearchpage(driver);
		createPortFolioManual.clickCreatePortfolio();
		manualSearchPage.clickManualSearch();
		manualSearchPage.uploadExcelFileWithAllField(driver);
		manualSearchPage.clickNextButtonAfterUpload();
		manualSearchPage.clickNextbutton();
		manualSearchPage.clickResetToEqualWeight();
		manualSearchPage.clickNextbuttoninWeighingStepper();
		manualSearchPage.clickNextbuttoninWeighingStepper();
		manualSearchPage.setPortfolioName(driver);
		manualSearchPage.setDescription(driver);
		manualSearchPage.selectImage(driver);
		manualSearchPage.clickSubmit(driver);
		if(manualSearchPage.getToastMessage().contains("Ensure this field has no more than 50 characters.")) {
			Assert.fail("Name of the Portfolio exceeding allowed 50 characters");
		}else if(manualSearchPage.getToastMessage().contains("Something went wrong")) {
			Assert.fail("Test Failed.Something went Wrong");
		}else {
			logger.info("Successfully Created the PortFolio");
		}
	}
}
