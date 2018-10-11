package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethod {
  @Test
  public void test01() {
	  Assert.assertTrue(true);
  }
  @Test(dependsOnMethods = {"test01"})
  public void test02() {
	  Assert.assertTrue(true);
  }
  @Test(dependsOnMethods = {"test01","test02"})
  public void test03() {
	  System.out.println("PASSED");
  }
  @Test
  public void test04() {
	  Assert.assertTrue(false);
  }
  @Test(dependsOnMethods = {"test04"})
  public void test05() {
	 System.out.println("PASSED");
  }
}

/*
PASSED: test01
PASSED: test02
PASSED: test03
FAILED: test04

Total tests run: 5, Failures: 1, Skips: 1    */