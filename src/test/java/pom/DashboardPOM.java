package pom;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException; import
org.openqa.selenium.StaleElementReferenceException; import
org.openqa.selenium.TimeoutException; import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; import
org.openqa.selenium.support.PageFactory; import
org.openqa.selenium.support.ui.ExpectedConditions; import
org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass; 

public class DashboardPOM extends BaseClass{ 

	public By loginButtonInDashboard=By.xpath("//*[local-name()='svg' and contains (@class,'iconify--prime')]");

	public By cookiesAccept=By.xpath("//button[@id='rcc-confirm-button']");



}
