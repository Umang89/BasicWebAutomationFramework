package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import init.initClass;
import utility.Log;

public class SmokeTest extends initClass {

	@Test
	public void Test1() throws InterruptedException {
		Log.info("Testcase Description: Validating \"New Job Submission Page\" functionality");
		loginPage.login(config.getProperty("username"), config.getProperty("password"));
		dashboardPage.clickOnNewJobSubmission();
		newJobSubmissionPage.enterTextinS3Path(config.getProperty("s3Path"));
		newJobSubmissionPage.clickSearchButton();
		newJobSubmissionPage.selectTemplateRadioButtonByText("India Import Excel JET", config.getProperty("s3Path"));
		newJobSubmissionPage.clickPreviewRecordsButton();
	}

	@Test
	public void Test2() throws InterruptedException {
		Log.info("This is my second testcase");
	}

	@Test
	public void Test3() throws InterruptedException {
		Log.info("This is my third testcase");
	}

	@Test
	public void Test4() throws InterruptedException {
		try {
//			Log.error("My fourth testcase is getting failed");
			Assert.fail("Failing Intentionally");
			Log.info("This is my fourth testcase");
		} catch (Throwable t) {
			Log.error("My fourth testcase is getting failed");
		}
	}

	@Test
	public void Test5() throws InterruptedException {
		Log.info("This is my fifth testcase");
	}
}
