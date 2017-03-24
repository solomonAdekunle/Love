package Cashier;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestUtil.Constant;
import TestUtil.TestDataProvider;

public class AccountSummary2Test  extends TestBase{
	
	

	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());
	}
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="CashierDataProvider")
	 public void TransactionsTest(Hashtable<String,String>table) throws IOException, InterruptedException{
	validateRunmodes("TransactionsTest", Constant.Money_Section, table.get(Constant.RUNMODE_COL));
	//openBrowser(prop.getProperty("browserType"));
	doDefaultLogin(table.get("Browser"));// lunch the browser
	navigate("testsiteURL");// navigate to the Webpage 
	Thread.sleep(5000L);
	String  Xpath_menu= Constant.Account_xpath;// Account Menu
	// click on History link within the Account menu
	String Xpath_subMenu=Constant.AccountMenu_History;
	WebElement menu=d.findElement(By.xpath(Xpath_menu));
	WebElement myAccount=d.findElement(By.xpath(Xpath_subMenu));
	// performing an action
	Actions llo = new Actions(d);
	llo.moveToElement(menu).build().perform();
	WebDriverWait wait= new WebDriverWait(d,15);
	 WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account_box']/ul[1]/li[3]/a")));// wait for My Account link
	myAccount.click();// click MyAccount link with the Account Menu
	Thread.sleep(2000L);
	d.switchTo().frame("cashier-iframe").switchTo().frame(0);//switch to the cashier
	Thread.sleep(2000L);
	click("cashier_MyAccount_Transaction_xpath");// click on the Transaction link
	Thread.sleep(2000L);
	//Actions look= new Actions(d);
	//look.moveToElement(SelectPeriod).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	input("cashier_MyAccount_TransactionSelectPeriod_xpath",table.get(Constant.TrSELECETPERIOD_COL));// input data 
	Thread.sleep(500L);
	clear("cashier_MyAccount_TransactionStartDate_xpath");
	Thread.sleep(500L);
	input("cashier_MyAccount_TransactionStartDate_xpath",table.get(Constant.TrSTARTDATE_COL));
	Thread.sleep(500L);
	clear("cashier_MyAccount_TransactionEndDate_xpath");
	Thread.sleep(500L);
	input("cashier_MyAccount_TransactionEndDate_xpath",table.get(Constant.TrENDDATE_COL));
	Thread.sleep(500L);
	click("cashier_MyAccount_TransactionVIEWHISTORY_xpath");
	Thread.sleep(2000L);
	//verify if the text displayed on the page after user input all the time period
	boolean result=isElementPresent("cashier_MyAccount_TransactionsDateFormatInccorectMessage_xpath");
    String actualResult=null;
    if(result)
		actualResult="SUCCESS";
	else
		actualResult="FAILURE";
 		Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult);
 		/*if(table.get(Constant.EXPECTEDRESULT_COL).equals("FAILURE")){
 			System.out.println("User failured to set View History more than last 60 days");
 		}else{
 				System.out.println(false);
 				
 		}
 		*/
 		d.switchTo().defaultContent(); 
		 Thread.sleep(1000L);
	 click("cashier_CloseIcon_Selector");
	 Thread.sleep(5000L);
	 String  Xpath_menu1= "//*[@id='account_box']/ul[1]/li[1]/a"; // Move to Account
		String Xpath_subMenu1="//*[@id='account_box']/ul[1]/li[7]/a";//  xpath for signout
		WebElement menu1=d.findElement(By.xpath(Xpath_menu1));
		WebElement Submenu1=d.findElement(By.xpath(Xpath_subMenu1));
		// performing an action
		Actions lla = new Actions(d);
		lla.moveToElement(menu1).build().perform();
		 Thread.sleep(1000L);
		Submenu1.click();
	 }
		@AfterMethod
	   public void close(){
	   	   	quit();	

}
}