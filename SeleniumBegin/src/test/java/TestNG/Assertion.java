package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {                  //HARD ASSERT
  @Test
  public void test01() {
	  Assert.assertEquals("Test", "Test1");
  }
  @Test
  public void test02() {
	  Assert.assertNotEquals("Test", "Test");
  }
  @Test
  public void test03() {
	  Assert.assertTrue(true);
	  Assert.assertTrue(false);
  }
  @Test
  public void test04() {
	  Assert.assertTrue(false, "As expected");
  }

}
