package utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utility {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileHandler.copy(source,
					new File(System.getProperty("user.dir") + "//Screenshot//" + screenshotName + ".png"));

			Log.info("Screenshot taken");
		} catch (Exception e) {
			Log.error("Exception while taking screenshot " + e.getMessage());
		}
	}

}
