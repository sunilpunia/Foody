package utility;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class RerunFailedTC {

	
	public static void rexecuteFailTCofTestNG(String testngfailxmlPath ) {

		TestNG test = new TestNG();
		List<String> list = new ArrayList();
		list.add(testngfailxmlPath);
		test.setTestSuites(list);
		test.run();

	}
	
	
	
	
}
