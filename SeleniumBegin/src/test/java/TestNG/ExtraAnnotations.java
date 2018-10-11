package TestNG;

import org.testng.annotations.Test;

public class ExtraAnnotations {

	@Test(threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
	public void testCase1(){
		System.out.println("PASSED");
	}

}

/*
 * In this example, the function testCase1 will be invoked ten times from three different threads. 
 * Additionally, a time-out of ten seconds guarantees that none of the threads will block on this thread forever.
*/