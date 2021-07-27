package Academy;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.base;

public class listeners implements ITestListener  {





	public void onFinish(ITestContext context) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		 
			System.err.println("This is only test text"+ result.getName());
			
		
	}

	public void onTestSkipped(ITestResult result) {
	
		
	}

	public void onTestStart(ITestResult result) {
	
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

}
