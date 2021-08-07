package TestNG_All;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNGListerner implements ITestListener{
  
	
	
	
	
	public void onTestStart(ITestResult result) {
		System.err.println("test case start details are--" + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.err.println("test case success details are--" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.err.println("Failed test case name are--" + result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.err.println("test case skipped details are" + result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		System.err.println("Ftest case start details are" + context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.err.println("test case finish details are" + context.getName());
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
