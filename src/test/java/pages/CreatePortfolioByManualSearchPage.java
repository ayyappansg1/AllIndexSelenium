package pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pom.CreatePortFolioPOM;
import utilities.LocalHelper;

public class CreatePortfolioByManualSearchPage  extends CreatePortFolioPOM{
	protected static final Logger logger = LoggerFactory.getLogger(CreatePortfolioByManualSearchPage.class);

	private final LocalHelper localHelper = new LocalHelper();

	private final WebDriver driver;

	public CreatePortfolioByManualSearchPage(WebDriver driver) {
		this.driver=driver;
	}
	public void clickCreatePortfolio() {
		try {
			localHelper.jsExecutorHighlight(createPortfolio, driver);
			localHelper.clickElement(createPortfolio, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(createPortfolio, driver);
		}catch(Exception e) {
			localHelper.jsExecutorHighlight(createPortfolio, driver);
			localHelper.clickElement(createPortfolio, driver);
		}
	}

	public void scrollToAcceptTermsAndConditions() {
		localHelper.scrollIntoView(forScrollDown, driver);
	}

	public void clickAlreadyHaveLoginButton() {
		localHelper.jsExecutorHighlight(clickNoalreadyHaveLogin, driver);
		localHelper.clickElement(clickNoalreadyHaveLogin, driver);
	}

	public void acceptTermsAndConditions() {
		localHelper.jsExecutorHighlight(acceptTermsAndConditions, driver);
		localHelper.clickElement(acceptTermsAndConditions, driver);
	}
}
