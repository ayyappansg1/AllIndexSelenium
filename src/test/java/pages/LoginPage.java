package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pom.LoginPagePOM;
import utilities.LocalHelper;

public class LoginPage extends LoginPagePOM{
	
	  protected static final Logger logger = LoggerFactory.getLogger(CreatePortfolioByManualSearchPage.class);
	    
	    private final LocalHelper localHelper = new LocalHelper();

	    private final WebDriver driver;
	    
	    public LoginPage(WebDriver driver) {
	        this.driver=driver;
	    }
	    public void clickLoginButton() {
			try {
				localHelper.jsExecutorHighlight(loginButton, driver);
				localHelper.clickElement(loginButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(loginButton, driver);
			}
		}
		public void enterUsername(String username) {
			localHelper.jsExecutorHighlight(usernameBox, driver);
			localHelper.sendKeys(usernameBox, username,driver);
		}
		public void enterPassword(String password) {
			localHelper.jsExecutorHighlight(passwordBox, driver);
			localHelper.sendKeys(passwordBox, password, driver);
		}
	    
}
