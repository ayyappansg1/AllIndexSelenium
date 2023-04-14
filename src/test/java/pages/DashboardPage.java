package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pom.DashboardPOM;
import utilities.LocalHelper;

public class DashboardPage extends DashboardPOM {

	protected static final Logger logger = LoggerFactory.getLogger(CreatePortfolioByManualSearchPage.class);

	private final LocalHelper localHelper = new LocalHelper();

	private final WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}

	public void acceptCookies() {
		try {
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(cookiesAccept));
			localHelper.jsExecutorHighlight(cookiesAccept, driver);
			localHelper.jsExecutorHighlight(cookiesAccept, driver);
			localHelper.clickElement(cookiesAccept, driver);
		}catch(TimeoutException e) { 
			//e.printStackTrace();
			try { 
				localHelper.jsExecutorHighlight(cookiesAccept, driver);
				localHelper.clickElement(cookiesAccept, driver);
			}catch(NoSuchElementException y) {
				System.out.println("Inside no such element exception block"); }
		}catch(StaleElementReferenceException m) { 
			try {
				localHelper.jsExecutorHighlight(cookiesAccept, driver);
				localHelper.clickElement(cookiesAccept, driver);
			}catch(NoSuchElementException z) { 
				System.out.println("Nothing  inside");
			}
		}
	}

	public void clickLoginInButton() {
		localHelper.jsExecutorHighlight(loginButtonInDashboard, driver);
		localHelper.clickElement(loginButtonInDashboard, driver);

	}
}
