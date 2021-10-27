package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import utility.Log;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Object Repository
	By email_TextField_xpath = By.xpath("//*[@type='email']");
	By password_TextField_xpath = By.xpath("//*[@type='password']");
	By signIn_Button_xpath = By.xpath("//*[@type='submit']");
	By email_Label_xpath = By.xpath("//*[@type='email']/..//*[@class='col-form-label']");
	By register_Button_xpath = By.xpath("//*[@class='btn btn-light btn-block']");

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	public void enterUserName(String userName) {
		try {
			driver.findElement(email_TextField_xpath).sendKeys(userName);
			Log.info("Username entered successfully");
		} catch (Exception e) {
			Log.error("Issue while entering Username");
		}
	}

	public void enterPassword(String password) {
		try {
			driver.findElement(password_TextField_xpath).sendKeys(password);
			Log.info("Password entered successfully");
		} catch (Exception e) {
			Log.error("Issue while entering Password");
		}
	}

	public void clickOnSignInButton() {

		try {
			driver.findElement(signIn_Button_xpath).click();
			Log.info("Successfully clicked on SignIn button");
		} catch (Exception e) {
			Log.error("Issue while clicking on SignIn button");
		}
	}

	public void validateEmailLabel() {
		String actualText = driver.findElement(email_Label_xpath).getText();
		Assert.assertEquals("Email", actualText);
	}

	public void validateRegisterButtonLabel(String expectedText) {
		String actualText = driver.findElement(register_Button_xpath).getText();
		Assert.assertEquals(expectedText, actualText);
	}

}
