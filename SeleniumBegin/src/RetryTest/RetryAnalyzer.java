package RetryTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{


	int retryCount=0;
	int maxRetryCount=3;
	
	public boolean retry(ITestResult result) 
	{
		if(retryCount < maxRetryCount)
		{
			System.out.println("Retrying test "+result.getName()+
					" with status "+getTestStatus(result.getStatus())+" for the "+(retryCount+1)+"time(s)");
			
			retryCount++;
			return true;
		}
		return false;
	}
	
	public String getTestStatus(int status)
	{
		String result=null;
		
		if(status==1)
		{
			result="PASS";
		}
		if(status==2)
		{
			result="FAIL";
		}
		if(status==3)
		{
			result="SKIPED";
		}
		return result;
	}

	
}

