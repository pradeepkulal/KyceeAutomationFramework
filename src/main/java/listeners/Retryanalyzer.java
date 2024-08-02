package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanalyzer implements IRetryAnalyzer {

	private int retryCount = 0;
	private final int MaxRetryCount = 3;
	
	
	
	public boolean retry(ITestResult result) {
		if (retryCount < MaxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

	
}
