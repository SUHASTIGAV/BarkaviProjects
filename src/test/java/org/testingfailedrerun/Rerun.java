package org.testingfailedrerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rerun implements IRetryAnalyzer {
int min=1,max=3;
	@Override
	public boolean retry(ITestResult arg0) {
		
			if(min<=max) {
				min++;
			return true;
		}
		return false;
	}

}
