package pom;

import org.openqa.selenium.By;

import baseClass.BaseClass;

public class NonReBalancePOM extends BaseClass {
	public By nonRebalanceButton=By.xpath("//h6[text()='Non-Rebalance']");
	public By NavigationMenuCounts=By.xpath("//ul[@class='nav nav-tabs']//li//a");
	public static By  assetClassMenu=By.xpath("//a[text()='Asset Class']");
	public static By assetClassCount=By.xpath("(//ul[@class='nav nav-tabs']//li//a//span)[1]");
	public static By assetClassInsideActualElements=By.xpath("//div[@id='instrument_type']//div");
	public By aToZIcon=By.xpath("(//button[@value='name'])[1]");
	public static By countryMenu=By.xpath("//a[text()='Country']");
	public static By countryCount=By.xpath("(//ul[@class='nav nav-tabs']//li//a//span)[2]");
	public static By countryInsideActualElements=By.xpath("//div[@id='country']//div");
	public static By industryMenu=By.xpath("//a[text()='Industry']");
	public static By industryCount=By.xpath("(//ul[@class='nav nav-tabs']//li//a//span)[3]");
	public static By industryInsideActualElements=By.xpath("//div[@id='industry']//div");
	public static By sectorMenu=By.xpath("//a[text()='Sector']");
	public static By sectorCount=By.xpath("(//ul[@class='nav nav-tabs']//li//a//span)[4]");
	public static By sectorInsideActualElements=By.xpath("//div[@id='sector']//div");
	public static By ESGMenu=By.xpath("//a[text()='ESG']");
	public static By ESGCount=By.xpath("(//ul[@class='nav nav-tabs']//li//a//span)[5]");
	public static By ESGactualInsideElements=By.xpath("//div[@id='esg']//label");
	public static By marketCapMenu=By.xpath("//a[text()='Market Cap']");
	public static By marketCapCount=By.xpath("(//ul[@class='nav nav-tabs']//li//a//span)[6]");
	public static By marketCapInsideElements=By.xpath("//div[@id='market_cap']//child::div[contains(@class,'MuiBox-root css')]");
	public static By threeCountries=By.xpath("//div[text()='Australia' or text()='Austria' or text()='Belgium'] ");
	public static By twoCountries=By.xpath("//div[text()='Austria' or text()='Belgium'] ");
	public static By selectedStocksLabel=By.xpath("//h6[text()='Selected Stocks']//parent::div//child::span");
	public static By filteredStocksCount=By.xpath("(//div[contains(@class,'wixard-filter')])[1]//p[text()='Filtered Stocks']//preceding-sibling::p");
	public static By filterSelectedStocksCount=By.xpath("(//div[contains(@class,'wixard-filter')])[1]//p[text()='Selected Stocks']//preceding-sibling::p");
	public static By selectedStocksClearAllButton=By.xpath("//div[contains(@class,'text-end fixed')]//button[text()='Clear All']");
	public static By menuClearAllButton=By.xpath("//div[contains(@class,'text-end pt')]//button[text()='Clear All']");
	public static By deSelectedStocksCount=By.xpath("//h6[text()='Deselected Stocks']//parent::div//span");
	public static By SelectedStocksCount=By.xpath("//h6[text()='Selected Stocks']//parent::div//span");
	public static By selectedStocksSelectAllButton=By.xpath("//button[text()='Select All']");
	public By nextButton=By.xpath("//button[text()='Clear All']//following-sibling::button[text()='Next']");
	public By toastMessage=By.xpath("//div[text()='Hurray! Once we finish baking your freshly brewed portfolio, it will be visible in the MY UNIVERSE section , usually in 5-10 seconds!']");
	public By skipButton=By.xpath("//button[text()='Skip']");
	public By customButton=By.xpath("//button[text()='Custom']");
	public By sectorButton=By.xpath("//button[text()='Sector']");
	public By industryButton=By.xpath("//button[text()='Industry']");
	public By weighingStepperNextButton=By.xpath("(//div[contains(@class,'fixed-new-bottom text')]//child::button[text()='Next'])[2]");
	public By additionalStepperNextButton=By.xpath("(//div[contains(@class,'fixed-new-bottom text')]//child::button[text()='Next'])[3]");
	public By nameTextBox=By.xpath("//input[@name='name']");
	public By descriptionTextBox=By.xpath("//input[@name='name']//following::textarea[1]");
	public By image=By.xpath("//div[@class=' wizard-profile-list-image'][1]");
	public By submit=By.xpath("//button[text()='Submit']");
	public By ResetToEqualButton=By.xpath("//button[text()='Reset to Equal Weight']");
	public By ResetToMarketCapWeight=By.xpath("//button[text()='Reset to Market Cap Weight']");
	public static By equalValuesCountry=By.xpath("(//button[text()='Country']//ancestor::div[@class='wizard-weighting-box']//child::div[@class='MuiBox-root css-0']//div)[1]//input");
	public static By equalValuesSector=By.xpath("(//div[@class='MuiBox-root css-15gyk24'])[2]//input");
	public static By equalValuesIndustry=By.xpath("(//div[@class='MuiBox-root css-15gyk24'])[3]//input");

}
