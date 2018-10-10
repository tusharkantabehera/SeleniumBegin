package TestNG;

import org.testng.annotations.Test;

public class DataProvider {

	@org.testng.annotations.DataProvider
	public Object[][] testData() {
		Object[][] data = new Object[3][2];

		data[0][0] = "Username1";
		data[0][1] = "Password1";

		data[1][0] = "Username2";
		data[1][1] = "Password2";

		data[2][0] = "Username3";
		data[2][1] = "Password3";
		return data;
	}

	@Test(dataProvider = "testData")
	public void Test(String s1, String s2) 
	{
		System.out.println(s1 + "---" + s2);
	}
}
