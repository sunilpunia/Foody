package TestNG_All;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners
public class MyFirstTestCase {
	
	
	@Test
	public static void mylistnerstest() {
		System.err.println("This is only for testing purpose");
		Assert.assertTrue(false);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
