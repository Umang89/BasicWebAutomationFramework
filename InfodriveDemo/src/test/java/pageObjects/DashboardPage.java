package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Object Repository
	By newJobSubmission_Link_xpath = By.xpath("//*[@href='/job/create']");

	public void clickOnNewJobSubmission() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(newJobSubmission_Link_xpath));
			Log.info("Waiting for \"New Job Submission\" link to be ready for click");
			WebElement element = driver.findElement(newJobSubmission_Link_xpath);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Log.info("Click on \"New Job Submission\" link is successful");
		} catch (Exception e) {
			Log.error("Issue while click on \"New Job Submission\" link");
		}
	}

}
