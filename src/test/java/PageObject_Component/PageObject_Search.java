package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Search {
	
	//2nd section collect the attribute
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public WebElement Searchtxtbox;	
	
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public WebElement Searchtxtbox2;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Invalidmsg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement Validmsg;
	
	
	//1st section-- initialize page factory
	public PageObject_Search(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	//3rd section
	
	public void EnterSearchitem(String Search_Item)
	{
		Searchtxtbox.click();
		Searchtxtbox2.sendKeys(Search_Item +"\n");
				
	}
	
	
	public String getInvalidmsg()
	{		
		return Invalidmsg.getText();
	}
	
	
	public String getValidmsg()
	{
		return Validmsg.getText();
	}

}
