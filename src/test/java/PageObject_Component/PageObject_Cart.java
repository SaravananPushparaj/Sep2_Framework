package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Cart {
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/btnAddToBasket")
	public WebElement Add_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/basketCountViewContainer")
	public WebElement Basket_Img;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement AddCart_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement Delete_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Delete_msg;
	
	public PageObject_Cart(AppiumDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void Click_addbutton()
	{
		Add_btn.click();
	}
	
	
	public void Click_Img()
	{
		Basket_Img.click();
	}
	
	public String getAddCartmsg()
	{
		return AddCart_msg.getText();
	}
	
	public void Click_Deletebutton()
	{
		Delete_btn.click();
	}
	
	public String getDeletemsg()
	{
		return Delete_msg.getText();
	}

}
