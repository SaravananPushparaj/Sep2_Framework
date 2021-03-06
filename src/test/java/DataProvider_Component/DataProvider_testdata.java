package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_testdata {

	@DataProvider(name="dp_InvalidSeach")
	public static Iterator<Object[]> getInvalidSearchdata() throws IOException
	{
		
		return common_method_test_data("Scenario_Search","Invalid_Search");
		
	}
	
	@DataProvider(name="dp_ValidSeach")
	public static Iterator<Object[]> getValidSearchdata() throws IOException
	{
		
		return common_method_test_data("Scenario_Search","Valid_Search");
		
	}
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<Object[]> getAddCart() throws IOException
	{
		return common_method_test_data("Scenario_Cart","AddCart");
	}
	

	@DataProvider(name="dp_DeleteCart")
	public static Iterator<Object[]> getDeleteCart() throws IOException
	{
		return common_method_test_data("Scenario_Cart","DeleteCart");
	}
	
	
	public static Iterator<Object[]> common_method_test_data(String sheetname,String scriptname) throws IOException
	{
		
		ExcelReadWrite xl= new ExcelReadWrite("D:\\Augbatch_files\\TestData\\TestData.xls");
		HSSFSheet Sheet = xl.Setsheet(sheetname);
		
		int RowCount = xl.getrowcount(Sheet);
		int ColCount = xl.getcolcount(Sheet, 0);
		
		List<Object[]> arr_list= new ArrayList<Object[]>();
		
		for(int i=1;i<=RowCount;i++)
		{
			String Execute_Flag = xl.Readvalue(Sheet, i, "Execute_Flag");
			String Script_name = xl.Readvalue(Sheet, i, "Script_name");
			
			if((Execute_Flag.equalsIgnoreCase("Y") && (Script_name.equals(scriptname))))
			{
				Object[] x= new Object[1];
				Map<String,String> dMap= new HashMap<String,String>();
				
				for(int j=0;j<ColCount;j++)
				{
					String Skey = xl.Readvalue(Sheet, 0, j);
					String Value = xl.Readvalue(Sheet, i, j);
					
					dMap.put(Skey, Value);					
					
				}//end of inner loop
				
				x[0]=dMap;
				arr_list.add(x);				
				
				
			}//end of if condition
			
			
			
			
		}//end of outer for loop
		
		
		return arr_list.iterator();
		
		
	}
	
	
}
