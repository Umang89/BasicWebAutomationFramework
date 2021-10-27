package utility;

import org.apache.log4j.Logger;

import junit.framework.Assert;

public class Log {

	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());//

	// This is to print log for the beginning of the test case, as we usually
	// run so many test cases as a test suite
	public static void startTestCase(String message) {
		Log.info("***************************************************************************************");
		Log.info("***************************************************************************************");
		Log.info("************************" + message + "**************************");
	}

	// This is to print log for the ending of the test case
	public static void endTestCase(String message) {
		Log.info("************************" + message + "**************************");
		Log.info("***************************************************************************************");
		Log.info("***************************************************************************************");
	}

	// Need to create these methods, so that they can be called
	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
		Assert.fail(message);
	}

	public static void fatal(String message) {
		Log.fatal(message);
	}

	public static void debug(String message) {
		Log.debug(message);
	}

}