import java.util.HashMap;

import com.kh.IRA.Utilities.ExcelReader;

public class ExcelTest {

	
	
	public static void main(String[] args) {
		String path="//src//main//resources//com//kh//IRA//TestData//TestData.xlsx";
		ExcelReader er=new ExcelReader(path);
		
		System.out.println(path);
		
		HashMap<String, String> data=er.readTestData("CMS","Login");
		System.out.println(data.get("UserName"));
		System.out.println(data.get("Password"));

		System.out.println("-----------------------------------------------------------------------------------");
		
		HashMap<String, String> data1=er.readTestData("CMS","Reg");
		System.out.println(data1.get("UserName"));
		System.out.println(data1.get("Password"));
		
	}
}