package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Component.Base_class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_class {
	
	public static Logger log=Logger.getLogger(Scenario_Search.class);
	
	@Test(dataProvider="dp_InvalidSeach", dataProviderClass=DataProvider_Component.DataProvider_testdata.class, groups={"smoke"})
	public void testInvalidSearch(Map<String,String> Search) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result");
		
		Start_Server();
		LaunchApp();
		
		
		
		log.info("Executing the Testcase  " +TC_ID + " Order set is "+Order_Set);
		
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		Explicit_Wait(BS_Pob.Searchtxtbox, 30);		
		BS_Pob.EnterSearchitem(Search_Item);
		
		Explicit_Wait(BS_Pob.Invalidmsg, 30);
		String Actual_Result = BS_Pob.getInvalidmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is  " +Actual_Result +  "Expected Result is " +Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
			
		}
		else
		{
			log.info("Failed as Actual Result is  " +Actual_Result +  "Expected Result is " +Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
			
			sAssert.fail("Failed as Actual Result is  " +Actual_Result +  "Expected Result is " +Exp_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
	}
	
	@Test(dataProvider="dp_ValidSeach",dataProviderClass=DataProvider_Component.DataProvider_testdata.class, groups={"regression"})
	public void testValidSearch(Map<String,String> Search) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result").replace(".0", "");
		
		Start_Server();
		LaunchApp();
		
		log.info("Executing the Testcase " +TC_ID +" Order Set is "+Order_Set);
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		Explicit_Wait(BS_Pob.Searchtxtbox, 30);
		BS_Pob.EnterSearchitem(Search_Item);
		
		Explicit_Wait(BS_Pob.Validmsg, 30);
		String Output = BS_Pob.getValidmsg();
		String Actual_Result = Output.split(" ")[0];
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is "+Actual_Result + " Expected Result is " +Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
		}
		else
		{
			log.info("Failed as Actual Result is "+Actual_Result + " Expected Result is " +Exp_Result);
			Capture_Screenshot(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is "+Actual_Result + " Expected Result is " +Exp_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
	}



}
