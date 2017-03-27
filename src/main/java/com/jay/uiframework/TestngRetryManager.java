package com.jay.uiframework;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.jay.config.LocalConfig;

public class TestngRetryManager implements IRetryAnalyzer {
	Log log = new Log(TestngRetryManager.class);
	int defaultCount = Integer.parseInt(LocalConfig.DEFAULT_COUNT);
	int maxTryCount=Integer.parseInt(LocalConfig.MAX_TRY_COUNT);

	public TestngRetryManager() {
	}

	@Override
	public boolean retry(ITestResult result) {

		if (defaultCount <= maxTryCount) {
			String message = "running retry for  '" + result.getName()
					+ "' on class " +

					this.getClass().getName() + " Retrying " + defaultCount
					+ " times";
			log.info(message);
			Reporter.setCurrentTestResult(result);
		//	Reporter.log("RunCount=" + (defaultCount + 1));
			defaultCount++;
			return true;
		}
		return false;
	}

}
