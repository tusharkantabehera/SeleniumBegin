package TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	
  @Test
  @Parameters({"data1","data2"})
  public void test(@Optional("default1") String data1,@Optional("default2") String data2) {
	  System.out.println(data1);
	  System.out.println(data2);
  }
}
