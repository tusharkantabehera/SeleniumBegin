package HashMapUsage;

import java.util.HashMap;

public class Data {

	public static HashMap<String, String> UserLoginCreds() 
	{
		HashMap<String, String> creds = new HashMap<String, String>();
		creds.put("admin", "tusharkec143_lenovopc@12");
		creds.put("user", "tusharkec_dejj@12");
		return creds;
	}
	
	public static HashMap<Integer, String> monthMap()
	{
		HashMap<Integer, String> month = new HashMap<Integer, String>();
		month.put(1, "January");
		month.put(2, "February");
		month.put(3, "March");
		month.put(4, "April");
		month.put(5, "May");
		month.put(6, "June");
		month.put(7, "July");
		month.put(8, "August");
		month.put(9, "September");
		month.put(10, "October");
		month.put(11, "November");
		month.put(12, "December");
		return month;
	}
	
}
