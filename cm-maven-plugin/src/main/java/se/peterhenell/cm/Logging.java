package se.peterhenell.cm;

import org.apache.maven.plugin.logging.Log;

import se.peterhenell.cm.parsers.SysOutLogger;

public class Logging {

	private static Log logger;

	static {
		logger = new SysOutLogger();
	}

	public static void SetLogging(BaseCMMojo mojo) {
		if (null != mojo) {
			logger = mojo.getLog();
		}
	}

	public static Log getLog() {
		return logger;
	}
}
