package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_class;
import PageObject_Component.PageObject_Cart;
import PageObject_Component.PageObject_Search;

public class Scenario_Cart extends Base_class {
	
	public static Logger log=Logger.getLogger(Scenario_Cart.class);
	
	@Test(dataProvider="dp_AddCart", dataProviderClass=DataProvider_Component.DataProvider_testdata.class, groups={"smoke"})
	public void testAddCart(Map<String,String> Cart) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Cart.get("TC_ID");
		String Order_Set = Cart.get("Order_Set");
		String Exp_Result = Cart.get("Exp_Result");
		String Search_Item = Cart.get("Search_Item");
		
		Start_Server();
		LaunchApp();
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		Explicit_Wait(BS_Pob.Searchtxtbox, 30);
		BS_Pob.EnterSearchitem(Search_Item);
		
		PageObject_Cart BC_pob=new PageObject_Cart(driver);
		Explicit_Wait(BC_pob.Add_btn, 30);
		
		BC_pob.Click_addbutton();
		Explicit_Wait(BC_pob.Basket_Img, 30);
		BC_pob.Click_Img();
		
		Explicit_Wait(BC_pob.AddCart_msg, 30);
		String Actual_Result = BC_pob.getAddCartmsg();
		
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

	
	@Test(dataProvider="dp_DeleteCart", dataProviderClass=DataProvider_Component.DataProvider_testdata.class, groups={"regression"})
	public void testDeleteCart(Map<String,String> Cart) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Cart.get("TC_ID");
		String Order_Set = Cart.get("Order_Set");
		String Exp_Result = Cart.get("Exp_Result");
		String Search_Item = Cart.get("Search_Item");
		
		Start_Server();
		LaunchApp();
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		Explicit_Wait(BS_Pob.Searchtxtbox, 30);
		BS_Pob.EnterSearchitem(Search_Item);
		
		PageObject_Cart BC_pob=new PageObject_Cart(driver);
		Explicit_Wait(BC_pob.Add_btn, 30);
		
		BC_pob.Click_addbutton();
		Explicit_Wait(BC_pob.Basket_Img, 30);
		BC_pob.Click_Img();
		
		Explicit_Wait(BC_pob.AddCart_msg, 30);
		BC_pob.Click_Deletebutton();
		
		Explicit_Wait(BC_pob.Delete_msg, 30);
		String Actual_Result = BC_pob.getDeletemsg();
		
		
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

}
