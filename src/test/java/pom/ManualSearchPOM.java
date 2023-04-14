package pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;

public class ManualSearchPOM  extends BaseClass{
	public By manualSearch=By.xpath("//h6[text()='Manual Search']//parent::div");

	public By searchBox=By.xpath("//h5[contains(text(),'Manually')]//following::input[@type='text' and @role='combobox'][1]");

	public By selectStockAfterSearch=By.xpath("//div[@role='presentation']//ul//li[1]//span");
	public By selectedStocksCount=By.xpath("//h6[text()='Selected Stocks']//parent::div//span");
	public By DeselectedStocksCount=By.xpath("//h6[text()='Deselected Stocks']//parent::div//span");
	public By selectAllButton=By.xpath("//button[text()='Select All']");
	public By clearAllButton=By.xpath("//button[text()='Clear All']");
	public By cancelSelectedStocksfromSelectedStocks=By.xpath("//h6[text()='Selected Stocks']//following::div[contains(@class,'MuiPaper-rounded')]//*[local-name()='svg' and contains(@class,'iconify ')]");
	public By resetToEqualWeight=By.xpath("//button[text()='Reset to Equal Weight']");
	public By nextButton=By.xpath("//button[text()='Clear All']//following-sibling::button[text()='Next']");
	public By weighingStepperNextButton=By.xpath("//span[text()='Weighting Criteria']//ancestor::div[contains(@class,'MuiPaper-elevation')]//following::div[contains(@style,'block')]//button[text()='Next']");
	public By equallyDividedWeight=By.xpath("//div[@class='w-40']//input");
	public By toastMessage=By.xpath("(//div[@role='alert'])[1]//div[2]");
	public By afterUpload=By.xpath("//h4[text()='Stocks Uploaded']");
	public By afterUploadNextButton=By.xpath("//h4[text()='Stocks Uploaded']//following::button[text()='Next']");
	public By warningMessage=By.xpath("//p[@class='text-warning ms-3']");
	public By nameTextBox=By.xpath("//input[@name='name']");
	public By descriptionTextBox=By.xpath("//input[@name='name']//following::textarea[1]");
	public By image=By.xpath("//div[@class=' wizard-profile-list-image'][1]");
	public By submit=By.xpath("//button[text()='Submit']");
	public By uploadButton=By.xpath("//button[text()='Upload a File']");
	public By uploadDirectLink=By.xpath("//input[@id='uploadFile']");
	public By downloadTemplate=By.xpath("//a[text()='Download Template']");
	

}
