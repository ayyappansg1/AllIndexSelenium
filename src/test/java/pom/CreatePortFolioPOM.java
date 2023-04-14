package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePortFolioPOM {
	
	public By loginButtonInDashboard=By.xpath("(//button[contains(@class,'MuiButtonBase-root Mui')])[1]");

	public By cookiesAccept=By.xpath("//button[@id='rcc-confirm-button']");

	public By acceptTermsAndConditions=By.xpath("//button[text()='Accept']");

	public By clickNoalreadyHaveLogin=By.xpath("//button[text()='No, I have an account']");

	public By forScrollDown=By.xpath("//a[contains(text(),'500px')]");
	
	public static By createPortfolio=By.xpath("//span[text()='create portfolio']");

	
}
