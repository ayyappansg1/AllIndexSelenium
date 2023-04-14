package com.dev.allIndex.createPortfolio;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.AWTException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import constants.Constants;
import pages.CreatePortfolioByManualSearchPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NonReBalancePage;
import pom.NonReBalancePOM;

public class CreatePortfolioByNonRebalance extends BaseClass {
	private CreatePortfolioByManualSearchPage createPortFolioManual;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private NonReBalancePage nonRebalance;
	
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
	@Test
	public void checkPresenceOfNon_ReBalanceButton() {
		logger.info("Running method checkPresenceOfNon_ReBalanceButton ");
		createPortFolioManual.clickCreatePortfolio();
		nonRebalance=new NonReBalancePage(driver);
		boolean checkPresenseOfNonRebalanceButton = nonRebalance.checkPresenseOfNonRebalanceButton();
		Assert.assertTrue(checkPresenseOfNonRebalanceButton,"Checking presence of Non reBalanceButton");
	}

@Test
public void checkCountofEachNavigationTabs() {
	logger.info("Running method checkCountofEachNavigationTabs ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	List<String> textOfLabelInNavigationTabs = nonRebalance.textOfLabelInNavigationTabs();
	List<String> actualNavigationMenuList=new LinkedList<String>();
	actualNavigationMenuList.add("Asset Class");
	actualNavigationMenuList.add("Country");
	actualNavigationMenuList.add("Industry");
	actualNavigationMenuList.add("Sector");
	actualNavigationMenuList.add("ESG");
	actualNavigationMenuList.add("Market Cap");
	assertThat(actualNavigationMenuList).hasSameElementsAs(textOfLabelInNavigationTabs);
}
@Test
public void verifyCountOfAssetClass() {
	logger.info("Running method verifyCountOfAssetClass ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.assetClassMenu);
	String count = nonRebalance.getCount(NonReBalancePOM.assetClassCount);
	int countOfInsideElements = nonRebalance.getCountOfInsideElements(NonReBalancePOM.assetClassInsideActualElements);
	Assert.assertEquals(countOfInsideElements, Integer.parseInt(count),"Verify count mentioned in the  menu and Elements inside of that menu count should match");
}
@Test
public void verifyCountOfCountry() {
	logger.info("Running method verifyCountOfCountry ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	String count = nonRebalance.getCount(NonReBalancePOM.countryCount);
	int countOfInsideElements = nonRebalance.getCountOfInsideElements(NonReBalancePOM.countryInsideActualElements);
	Assert.assertEquals(countOfInsideElements, Integer.parseInt(count),"Verify count mentioned in the  menu and Elements inside of that menu count should match");
}
@Test
public void verifyCountOfIndustryMenu() {
	logger.info("Running method verifyCountOfIndustryMenu ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	String count = nonRebalance.getCount(NonReBalancePOM.industryCount);
	int countOfInsideElements = nonRebalance.getCountOfInsideElements(NonReBalancePOM.industryInsideActualElements);
	Assert.assertEquals(countOfInsideElements, Integer.parseInt(count),"Verify count mentioned in the  menu and Elements inside of that menu count should match");
}
@Test
public void verifyCountOfSectorMenu() {
	logger.info("Running method verifyCountOfSectorMenu ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.sectorMenu);
	String count = nonRebalance.getCount(NonReBalancePOM.sectorCount);
	int countOfInsideElements = nonRebalance.getCountOfInsideElements(NonReBalancePOM.sectorInsideActualElements);
	Assert.assertEquals(countOfInsideElements, Integer.parseInt(count),"Verify count mentioned in the  menu and Elements inside of that menu count should match");
}
@Test
public void verifyCountOfESGMenu() {
	logger.info("Running method verifyCountOfESGMenu ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.ESGMenu);
	String count = nonRebalance.getCount(NonReBalancePOM.ESGCount);
	int countOfInsideElements = nonRebalance.getCountOfInsideElements(NonReBalancePOM.ESGactualInsideElements);
	Assert.assertEquals(countOfInsideElements, Integer.parseInt(count),"Verify count mentioned in the  menu and Elements inside of that menu count should match");
}
@Test
public void verifyCountOfMarketCapMenu() {
	logger.info("Running method verifyCountOfMarketCapMenu ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.marketCapMenu);
	String count = nonRebalance.getCount(NonReBalancePOM.marketCapCount);
	int countOfInsideElements = nonRebalance.getCountOfInsideElements(NonReBalancePOM.marketCapInsideElements);
	Assert.assertEquals(countOfInsideElements, Integer.parseInt(count),"Verify count mentioned in the  menu and Elements inside of that menu count should match");
}	
@Test
public void checkSortingFunctioninAssetClassStocksAtoZ() {
	logger.info("Running method checkSortingFunctioninAssetClassStocksAtoZ ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.assetClassMenu);
	List<String> allElements = nonRebalance.getAllElements(NonReBalancePOM.assetClassInsideActualElements);
	Set<String> sortedElements=new LinkedHashSet<String>(allElements);
	assertThat(allElements).hasSameElementsAs(sortedElements);
}	
@Test
public void checkSortingFunctioninCountryAtoZ() {
	logger.info("Running method checkSortingFunctioninCountryAtoZ ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	List<String> allElements = nonRebalance.getAllElements(NonReBalancePOM.countryInsideActualElements);
	Set<String> sortedElements=new LinkedHashSet<String>(allElements);
	assertThat(allElements).hasSameElementsAs(sortedElements);
}	
@Test
public void checkSortingFunctioninIndustryAtoZ() {
	logger.info("Running method checkSortingFunctioninIndustryAtoZ ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.industryMenu);
	List<String> allElements = nonRebalance.getAllElements(NonReBalancePOM.industryInsideActualElements);
	Set<String> sortedElements=new LinkedHashSet<String>(allElements);
	assertThat(allElements).hasSameElementsAs(sortedElements);
}	
@Test
public void checkSortingFunctioninSectorAtoZ() {
	logger.info("Running method checkSortingFunctioninSectorAtoZ ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.sectorMenu);
	List<String> allElements = nonRebalance.getAllElements(NonReBalancePOM.sectorInsideActualElements);
	Set<String> sortedElements=new LinkedHashSet<String>(allElements);
	assertThat(allElements).hasSameElementsAs(sortedElements);
}	
@Test
public void checkSortingFunctioninMArketCapAtoZ() {
	logger.info("Running method checkSortingFunctioninMArketCapAtoZ ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.marketCapMenu);
	List<String> allElements = nonRebalance.getAllElements(NonReBalancePOM.marketCapInsideElements);
	Set<String> sortedElements=new LinkedHashSet<String>(allElements);
	assertThat(allElements).hasSameElementsAs(sortedElements);
}	
@Test
public void checkSelectedStocksSumforMultipleStocksSelection() throws InterruptedException {
	logger.info("Running method checkSelectedStocksSumforMultipleStocksSelection ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
	List<Integer> allElements = nonRebalance.getAllElementsOnlyCount(NonReBalancePOM.threeCountries);
	int sum=0;
	for (Integer integer : allElements) {
		sum=sum+integer;
	}
	System.out.println("Count is "+sum);
	String count = nonRebalance.getCount(NonReBalancePOM.selectedStocksLabel);
	Assert.assertEquals(Integer.parseInt(count), sum,"Verify sume of selected stocks and count showing in Selected stocks matching or not");
}	
@Test
public void verifyFilterStocksCountMatchesWithSumOfSelected() throws InterruptedException {
	logger.info("Running method verifyFilterStocksCountMatchesWithSumOfSelected ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
	List<Integer> allElements = nonRebalance.getAllElementsOnlyCount(NonReBalancePOM.threeCountries);
	int sum=0;
	for (Integer integer : allElements) {
		sum=sum+integer;
	}
	System.out.println("Count is "+sum);
	String count = nonRebalance.getCount(NonReBalancePOM.filteredStocksCount);
	Assert.assertEquals(Integer.parseInt(count), sum,"Verify sum of selected stocks and count showing in Filtered stocks matching or not");
}	
@Test
public void verifyFilterSelectedStocksCountMatchesWithSumOfSelected() throws InterruptedException {
	logger.info("Running method verifyFilterSelectedStocksCountMatchesWithSumOfSelected ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
	List<Integer> allElements = nonRebalance.getAllElementsOnlyCount(NonReBalancePOM.threeCountries);
	int sum=0;
	for (Integer integer : allElements) {
		sum=sum+integer;
	}
	System.out.println("Count is "+sum);
	String count = nonRebalance.getCount(NonReBalancePOM.filterSelectedStocksCount);
	Assert.assertEquals(Integer.parseInt(count), sum,"Verify sum of selected stocks and count showing in Selected Filter stocks matching or not");
}	
@Test
public void validationOfMenuClearAllButton() throws InterruptedException {
	logger.info("Running method validationOfMenuClearAllButton ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
	nonRebalance.clickMenuClearButton();
	String count = nonRebalance.getCountZeroExpected(NonReBalancePOM.filteredStocksCount);
	Assert.assertEquals(Integer.parseInt(count), 0,"Verify After clear All selected stocks should be Zero");
}	
@Test
public void validationOfSelectedStocksClearAllButton() throws InterruptedException {
	logger.info("Running method validationOfSelectedStocksClearAllButton ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
	String selectedStockscount = nonRebalance.getCount(NonReBalancePOM.filterSelectedStocksCount);
	nonRebalance.clickSelectedStocksClearButton();
	String count = nonRebalance.getCount(NonReBalancePOM.deSelectedStocksCount);
	Assert.assertEquals(Integer.parseInt(count), Integer.parseInt(selectedStockscount),"Verify After ClearAll Button click all Selected stocks should be moved to DeSelected Stocks");
}	
@Test
public void validationOfDeSelectedStocksSelectAllButton() throws InterruptedException {
	logger.info("Running method validationOfDeSelectedStocksSelectAllButton ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
	String selectedStockscount = nonRebalance.getCount(NonReBalancePOM.filterSelectedStocksCount);
	nonRebalance.clickSelectedStocksClearButton();
	nonRebalance.clickSelectedStocksSelectAllButton();
	String count = nonRebalance.getCount(NonReBalancePOM.SelectedStocksCount);
	Assert.assertEquals(Integer.parseInt(count), Integer.parseInt(selectedStockscount),"Verify After ClearAll Button click all Selected stocks should be moved to DeSelected Stocks");
}	

@Test
public void verifyCountrywiseResetToEqualWeight() throws InterruptedException, AWTException {
	logger.info("Running method verifyCountrywiseResetToEqualWeight ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
//	String selectedStockscount = nonRebalance.getCount(NonReBalancePOM.filterSelectedStocksCount);
	nonRebalance.clickNextButton();
	nonRebalance.clickSkipButton();
	nonRebalance.clickCustomButton();
	nonRebalance.clickResetToEqualButton();
	List<String> equallyDividedWeight = nonRebalance.getEquallyDividedWeightCountry();
	List<String> noOfStocksDividingBasedonHundredPercent = nonRebalance.getNoOfStocksDividingBasedonHundredPercent();
	assertThat(equallyDividedWeight).hasSameElementsAs(noOfStocksDividingBasedonHundredPercent);
}	
@Test
public void verifyCountrywiseResetToMarketCaplWeight() throws InterruptedException, AWTException {
	logger.info("Running method verifyCountrywiseResetToMarketCaplWeight ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
//	String selectedStockscount = nonRebalance.getCount(NonReBalancePOM.filterSelectedStocksCount);
	nonRebalance.clickNextButton();
	nonRebalance.clickSkipButton();
	nonRebalance.clickCustomButton();
	nonRebalance.clickResetToMarketCapButton();
	List<String> equallyDividedWeight = nonRebalance.getEquallyDividedWeightCountry();
	boolean checkTotalWithHundred = nonRebalance.checkTotalWithHundred(equallyDividedWeight);
	Assert.assertTrue(checkTotalWithHundred, "Checking the sume of all weights Equal to 100");
}	
@Test
public void verifySectorwiseResetToEqualWeight() throws InterruptedException, AWTException {
	logger.info("Running method verifySectorwiseResetToEqualWeight ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
//	String selectedStockscount = nonRebalance.getCount(NonReBalancePOM.filterSelectedStocksCount);
	nonRebalance.clickNextButton();
	nonRebalance.clickSkipButton();
	nonRebalance.clickCustomButton();
	nonRebalance.clickSectorButton();
	nonRebalance.clickResetToEqualButton();
	List<String> equallyDividedWeight = nonRebalance.getEquallyDividedWeightSector();
	boolean checkTotalWithHundred = nonRebalance.checkTotalWithHundred(equallyDividedWeight);
	Assert.assertTrue(checkTotalWithHundred, "Checking the sume of all weights Equal to 100");
}	
@Test
public void verifySectorwiseResetToMarketCaplWeight() throws InterruptedException, AWTException {
	logger.info("Running method verifySectorwiseResetToMarketCaplWeight ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
//	String selectedStockscount = nonRebalance.getCount(NonReBalancePOM.filterSelectedStocksCount);
	nonRebalance.clickNextButton();
	nonRebalance.clickSkipButton();
	nonRebalance.clickCustomButton();
	nonRebalance.clickSectorButton();
	nonRebalance.clickResetToMarketCapButton();
	List<String> marketKapDividedWeight = nonRebalance.getEquallyDividedWeightSector();
	boolean checkTotalWithHundred = nonRebalance.checkTotalWithHundred(marketKapDividedWeight);
	Assert.assertTrue(checkTotalWithHundred, "Checking the sume of all weights Equal to 100");
}	
@Test
public void verifyIndustrywiseResetToEqualWeight() throws InterruptedException, AWTException {
	logger.info("Running method verifyIndustrywiseResetToEqualWeight ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
//	String selectedStockscount = nonRebalance.getCount(NonReBalancePOM.filterSelectedStocksCount);
	nonRebalance.clickNextButton();
	nonRebalance.clickSkipButton();
	nonRebalance.clickCustomButton();
	nonRebalance.clickIndustryButton();
	nonRebalance.clickResetToEqualButton();
	List<String> equallyDividedWeight = nonRebalance.getEquallyDividedWeightIndustry();
	boolean checkTotalWithHundred = nonRebalance.checkTotalWithHundred(equallyDividedWeight);
	Assert.assertTrue(checkTotalWithHundred, "Checking the sume of all weights Equal to 100");
}	
@Test
public void verifyIndustrywiseResetToMarketCaplWeight() throws InterruptedException, AWTException {
	logger.info("Running method verifyIndustrywiseResetToMarketCaplWeight ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectThreeCountries();
//	String selectedStockscount = nonRebalance.getCount(NonReBalancePOM.filterSelectedStocksCount);
	nonRebalance.clickNextButton();
	nonRebalance.clickSkipButton();
	nonRebalance.clickCustomButton();
	nonRebalance.clickIndustryButton();
	nonRebalance.clickResetToMarketCapButton();
	List<String> marketKapDividedWeight = nonRebalance.getEquallyDividedWeightIndustry();
	boolean checkTotalWithHundred = nonRebalance.checkTotalWithHundred(marketKapDividedWeight);
	Assert.assertTrue(checkTotalWithHundred, "Checking the sume of all weights Equal to 100");
}	
@Test
public void createPortFolioNonRebalance() throws InterruptedException, AWTException {
	logger.info("Running method verifyNavigatetoTheUploadImageStepper ");
	createPortFolioManual.clickCreatePortfolio();
	nonRebalance=new NonReBalancePage(driver);
	nonRebalance.clickNonRebalanceButton();
	nonRebalance.clickMenu(NonReBalancePOM.countryMenu);
	nonRebalance.selectTwoCountries();
//	String selectedStockscount = nonRebalance.getCount(NonReBalancePOM.filterSelectedStocksCount);
	nonRebalance.clickNextButton();
	nonRebalance.clickSkipButton();
	nonRebalance.clickWeighingStepperNextButton();
	nonRebalance.clickAdditionalStepperNextButton();
	nonRebalance.setPortfolioName(driver);
	nonRebalance.setDescription(driver);
	nonRebalance.selectImage(driver);
	nonRebalance.clickSubmit(driver);
	String successToastMessage = nonRebalance.getSuccessToastMessage();
	Assert.assertEquals(successToastMessage, "Hurray! Once we finish baking your freshly brewed portfolio, it will be visible in the MY UNIVERSE section , usually in 5-10 seconds!","Validation of success message");
}
	
}
