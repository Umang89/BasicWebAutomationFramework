package init;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.NewJobSubmissionPage;
import utility.Log;
import utility.utility;

public class initClass {

	public static WebDriver driver;

	public static LoginPage loginPage;
	public static DashboardPage dashboardPage;
	public static NewJobSubmissionPage newJobSubmissionPage;

	public static Properties config;

	@BeforeClass
	public void beforeclass() throws IOException {
		driver = WebDriverLaunch.launchDriver();
		// LOGGER.info("Creating Objects");
		createPageObject();
		FileReader reader = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Config.properties");
		config = new Properties();
		config.load(reader);
		DOMConfigurator.configure("log4jConfig.xml");
	}

	/* Create Objects of all page classes */
	public static void createPageObject() {
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		newJobSubmissionPage = new NewJobSubmissionPage(driver);
	}

	@BeforeMethod
	public void beforemethod(Method method) {
		Log.startTestCase("Test Execution Started for " + method.getName());
		try {
			driver.get(config.getProperty("url"));
			Log.info("URL launched successfully");
		} catch (Exception e) {
			Log.error("Failed while launching URL");
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			utility.captureScreenshot(driver, result.getName());
			Log.endTestCase("Test Failed : Test Execution Completed for " + result.getName());
		} else {
			Log.endTestCase("Test Passed : Test Execution Completed for " + result.getName());
		}
	}

	@AfterClass
	public void afterclass() {
		driver.close();
	}

}
