package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicAnnotations {
  @BeforeSuite
  public void test01() {
	  System.out.println("Before Suit");
  }
  @BeforeTest
  public void test03() {
	  System.out.println("Before Test");
  }
  @BeforeClass
  public void test04() {
	  System.out.println("Before Class");
  }
  @BeforeMethod
  public void test05() {
	  System.out.println("Before Method");
  }
  @AfterMethod
  public void test06() {
	  System.out.println("After Method");
  }
  @AfterTest
  public void test07() {
	  System.out.println("Before Suit");
  }
  @AfterClass
  public void test08() {
	  System.out.println("After Class");
  }
  @AfterTest
  public void test11() {
	  System.out.println("After Test");
  }
  @AfterSuite
  public void test09() {
	  System.out.println("After Suite");
  }
  @Test
  public void login() {
	  System.out.println("login");
  }
  @Test
  public void logout() {
	  System.out.println("logout");
  }
}

/*
Before Suit
Before Test
Before Class
Before Method
login---------------------
After Method
Before Method
logout--------------------
After Method
After Class
Before Suit
After Test
PASSED: login
PASSED: logout   */