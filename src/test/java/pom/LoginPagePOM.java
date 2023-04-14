package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class LoginPagePOM extends BaseClass {
	public By usernameBox=By.xpath("//input[@name='email']");
	public By passwordBox=By.xpath("//input[@name='password']");
	public By loginButton=By.xpath("//button[text()='Login']");
	
}
