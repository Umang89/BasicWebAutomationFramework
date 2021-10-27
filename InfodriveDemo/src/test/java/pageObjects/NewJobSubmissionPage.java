package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class NewJobSubmissionPage {

	WebDriver driver;

	public NewJobSubmissionPage(WebDriver driver) {
		this.driver = driver;

	}

	// Object Repository
	By s3Path_TextField_xpath = By.xpath("//*[@name='archivePath']");
	By search_Button_xpath = By.xpath("//*[text()='Search']");
	By IndiaImportExcel_RadioButton_xpath = By.xpath("//*[text()='India Import Excel JET']/../..//input");
	By PreviewRecords_Button_xpath = By.xpath("//*[@id='next-button']");

	public void enterTextinS3Path(String text) throws InterruptedException {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].setAttribute('value', '" + text + "')",
					driver.findElement(s3Path_TextField_xpath));
			Thread.sleep(5000);
			driver.findElement(s3Path_TextField_xpath).clear();
			Thread.sleep(5000);
			driver.findElement(s3Path_TextField_xpath).sendKeys(text);
			Log.info("Entering S3Path as \"" + text + "\" is successful");
		} catch (Exception e) {
			Log.error("Issue while entering S3Path as \"" + text + "\"");
		}
	}

	public void clickSearchButton() {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(search_Button_xpath));
			Log.info("Click on Search button is successful");
		} catch (Exception e) {
			Log.error("Issue while clicking on Search button");
		}
	}

	public void selectTemplateRadioButtonByText(String templateRadioButtonText, String s3Path)
			throws InterruptedException {
		try {
			By templateRadioButton_xpath = By.xpath("//*[text()='" + templateRadioButtonText + "']/../..//input");
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(templateRadioButton_xpath));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			Thread.sleep(5000);
			executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(templateRadioButton_xpath));
			Thread.sleep(5000);
			executor.executeScript("arguments[0].click();", driver.findElement(templateRadioButton_xpath));
			Thread.sleep(5000);
			executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(s3Path_TextField_xpath));
			Thread.sleep(5000);
			enterTextinS3Path(s3Path);
			Log.info("Successfully selected \"" + templateRadioButtonText + "\" radio button");
		} catch (Exception e) {
			Log.error("Issue while selecting \"" + templateRadioButtonText + "\" radio button");
		}
	}

	public void clickPreviewRecordsButton() throws InterruptedException {
		try {
			Thread.sleep(5000);
			driver.findElement(PreviewRecords_Button_xpath).click();
			Log.info("Click on Preview Record button is successful");
		} catch (Exception e) {
			Log.error("Issue while clicking on Preview Records button");
		}
	}

}
