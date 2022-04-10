package DataDriven.DataD.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

private static Logger Log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	
	
	public static void startLog(String testClassName) {
		Log.info("Test is starting...");
	}
	
	public static void endLog(String testClassName) {
		Log.info("Test is ending...");
	}

	public static void info(String message) {
		Log.info(message);
	}
	
	public static void warn(String message) {
		Log.warn(message);
	}
	
	public static void error(String message) {
		Log.error(message);
	}
	
	
}
