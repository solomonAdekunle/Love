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

import TestUtil.Constant;
import TestUtil.TestDataProvider;
import Base.TestBase;

public class AccountSummaryTest extends TestBase{
	
	
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());
	}
	 @Test(enabled=true,dataProviderClass=TestDataProvider.class,dataProvider="CashierDataProvider")
		public void AccountSummarytest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		    navigate("testsiteURL");
		   doDefaultLogin(prop.getProperty("defaultUsername"));
		   Thread.sleep(5000L);
			String  Xpath_menu= "//*[@id='account_box']/ul[1]/li[1]/a";
			String Xpath_subMenu="//*[@id='account_box']/ul[1]/li[3]/a";
			WebElement menu=d.findElement(By.xpath(Xpath_menu));
			WebElement myAccount=d.findElement(By.xpath(Xpath_subMenu));
			// performing an action
			Actions llo = new Actions(d);
			llo.moveToElement(menu).build().perform();
			WebDriverWait wait= new WebDriverWait(d,15);
			 WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account_box']/ul[1]/li[3]/a")));
			myAccount.click();
			Thread.sleep(2000L);
			d.switchTo().frame("cashier-iframe").switchTo().frame(0);
			WebDriverWait wait1= new WebDriverWait(d,30);
			 if(isElementPresent("cashier_Summary_ConvertToMoney_xpath"))
		    	 Assert.assertTrue(true, "Element is present");
		     Thread.sleep(3000L);
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
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="CashierDataProvider")
	 public void DepositLimitTest(Hashtable<String,String>table) throws IOException, InterruptedException{
	validateRunmodes("DepositLimitTest", Constant.Money_Section, table.get(Constant.RUNMODE_COL));
	//openBrowser(prop.getProperty("browserType"));
	doDefaultLogin(table.get("Browser"));
	//navigate("testsiteURL");
	Thread.sleep(5000L);
	String  Xpath_menu= "//*[@id='account_box']/ul[1]/li[1]/a";//Account Menu drop down
	String Xpath_subMenu="//*[@id='account_box']/ul[1]/li[3]/a";//My account link within the Account Menu
	WebElement menu=d.findElement(By.xpath(Xpath_menu));
	WebElement myAccount=d.findElement(By.xpath(Xpath_subMenu));
	// performing an action
	Actions llo = new Actions(d);
	llo.moveToElement(menu).build().perform();
	WebDriverWait wait= new WebDriverWait(d,15);
	 WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account_box']/ul[1]/li[3]/a")));
	myAccount.click();
	Thread.sleep(2000L);
	d.switchTo().frame("cashier-iframe").switchTo().frame(0);//switch to the cashier
	Thread.sleep(2000L);
	click("cashier_MyAccount_DepositLimit_xpath"); //click on responsible gaming link within the cashier
	Thread.sleep(2000L);
	WebDriverWait wait1= new WebDriverWait(d,30);
	WebElement element1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='RG_DepositMultipleLimitChange']/tbody/tr/td[2]")));// wait for Deposit Limit Change Button to Load.
     click("cashier_MyAccount_DepositLimitCHANGE_xpath");
    clear("cashier_MyAccount_NewLimitDaily_xpath");
     input("cashier_MyAccount_NewLimitDaily_xpath",table.get(Constant.DPLDAILY_COL));
     clear("cashier_MyAccount_NewLimitWeekly_xpath");
     input("cashier_MyAccount_NewLimitWeekly_xpath", table.get(Constant.DPLWEEKLY_COL));
     clear("cashier_MyAccount_NewLimitMonthly_xpath");
     input("cashier_MyAccount_NewLimitMonthly_xpath",table.get(Constant.DPLMONTHLY_COL));
     Thread.sleep(1000L);
     click("cashier_MyAccount_DepositLimitSAVEDEPOSITLIMITS_xpath");
     Thread.sleep(5000L);
     boolean result=isElementPresent("cashier_MyAccount_DepositlimitInvalidlimitValueMessage_xpath");
     Thread.sleep(3000L);
     //if(isElementPresent("cashier_MyAccount_DepositlimitInvalidlimitValueMessage_xpath")){
     // verify if user able to set a deposit limit 
    	String actualResult=null;
	 		if(table.get(Constant.EXPECTEDRESULT_COL).equals("FAILURE"))
	 			System.out.println(true);
	 		else
	 			System.out.println("USER ABLE TO CHANGE IS DEPOSIT LIMIT");
     
	 		Thread.sleep(3000L);
			 d.switchTo().defaultContent(); // switch away froth the cashier pop-up box.
			 Thread.sleep(1000L);
			 click("cashier_CloseIcon_xpath");// Close the cashier pop-up box frame.
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
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="CashierDataProvider")
	 public void TimeoutOptionTest(Hashtable<String,String>table) throws InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		 // user should be able to set a time out option
		 // user should not be able to deposit or play games after setting Time-Out Option
		 // doDefaultLogin(table.get("Browser"));
			navigate("testsiteURL");
		 doDefaultLogin(prop.getProperty("defaultUsername"));
			Thread.sleep(5000L);
			String  Xpath_menu= "//*[@id='account_box']/ul[1]/li[1]/a";
			String Xpath_subMenu="//*[@id='account_box']/ul[1]/li[3]/a";
			WebElement menu=d.findElement(By.xpath(Xpath_menu));
			WebElement myAccount=d.findElement(By.xpath(Xpath_subMenu));
			// performing an action
			Actions llo = new Actions(d);
			llo.moveToElement(menu).build().perform();
			WebDriverWait wait= new WebDriverWait(d,15);
			 WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account_box']/ul[1]/li[3]/a")));
			myAccount.click();
			Thread.sleep(2000L);
			d.switchTo().frame("cashier-iframe").switchTo().frame(0);// switch to cashier pop-up frime
			Thread.sleep(2000L);
			click("cashier_MyAccount_DepositLimit_xpath");// click on My Account Responsible gaming link
			Thread.sleep(2000L);
			input("cashier_ResponsibleGaming_TimeOutOptions_Peroid_xpath","24hrs");
			Thread.sleep(2000L);
			click("cashier_ResponsibleGaming_TimeOutOption_StartNotification_xpath");
			Thread.sleep(1000L);
			click("cashier_ResponsibleGaming_TimeOutoption_EndNitification_xpath");
			Thread.sleep(1000L);
			click("cashier_ResponsibleGaming_TimeOutOptions_Save_xpath");// click on the save button after input the period 
			Thread.sleep(3000);
			// verify if  user can set Time Out options
			String Message=getText("cashier_ResponsibleGamining_TimeoutOptiontinMeesage_xpath");
	 		if(isElementPresent("cashier_ResponsibleGamining_TimeoutOptiontinMeesage_xpath")){
	 			System.out.println(Message);
	 		}else{
	 			System.out.println("User unable to change ");
	 		}
	 		Thread.sleep(3000);
	 		// verify if user can make a deposit
	 		click("cashier_ResponsibleGamining_TimeoutOptiontinMessageBox_OK_xpath");
	 		Thread.sleep(2000);
	 		click("cashier_Deposit_xpath");
	 		Thread.sleep(2000);
	 		click("cashier_Deposit_deposit_xpath");
	 		Thread.sleep(3000L);
	 		 input("cashier_DepositAmounToDeposit_xpath","200");
	 	    input("cashier_DepositSelectCard_xpath","1111");
	 	    input("cashier_DepositCVV2_xpath","123");
	 	    //input("cashier_DepositPromocode_xpath",table.get(Constant.PROMOCODE_COL));
	 	    Thread.sleep(500L);
	 	    click("cashier_DepositDeposit_xpath");
	 	    Thread.sleep(3000L);
	 	   String Message1=getText("cashier_TimeoutMessage_Deposit_xpath");
	 		if(isElementPresent("cashier_TimeoutMessage_Deposit_xpath")){
	 			System.out.println(Message1);
	 		}else{
	 			System.out.println("User unable to change ");
	 		}
	 		Thread.sleep(2000);
	 		click("cashier_TimeouOptiomtMessageDeposit_Ok_xpath");
	 		Thread.sleep(2000);
	 		d.switchTo().defaultContent(); 
			 Thread.sleep(1000L);
		 click("cashier_CloseIcon_xpath");
		 Thread.sleep(5000L);
		 String  Xpath_menu1= "//*[@id='account_box']/ul[1]/li[1]/a"; // Move to Account
			String Xpath_subMenu1="//*[@id='account_box']/ul[1]/li[7]/a";//  xpath for signout
			WebElement menu1=d.findElement(By.xpath(Xpath_menu1));
			WebElement Submenu1=d.findElement(By.xpath(Xpath_subMenu1));
			// performing an action
			Actions lla = new Actions(d);
			lla.moveToElement(menu1).build().perform();
			Submenu1.click();
			//WebDriverWait wait1= new WebDriverWait(d,30);
			 
			 
	 }
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="CashierDataProvider")
	 public void SelfExclusiontest(Hashtable<String,String>table) throws InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
			// doDefaultLogin(table.get("Browser"));
				//navigate("testsiteURL");
			 doDefaultLogin(prop.getProperty("defaultUsername"));
				Thread.sleep(5000L);
				String  Xpath_menu= "//*[@id='account_box']/ul[1]/li[1]/a";
				String Xpath_subMenu="//*[@id='account_box']/ul[1]/li[3]/a";
				WebElement menu=d.findElement(By.xpath(Xpath_menu));
				WebElement myAccount=d.findElement(By.xpath(Xpath_subMenu));
				// performing an action
				Actions llo = new Actions(d);
				llo.moveToElement(menu).build().perform();
				WebDriverWait wait= new WebDriverWait(d,15);
				 WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account_box']/ul[1]/li[3]/a")));
				myAccount.click();
				Thread.sleep(2000L);
				d.switchTo().frame("cashier-iframe").switchTo().frame(0);// switch to the Cashier 
				Thread.sleep(2000L);
				click("cashier_MyAccount_DepositLimit_xpath");//click on responsible gaming link
				Thread.sleep(2000L);
				click("cashier_ResponsibleGaming_SelfExclude_AddNew_xpath");//click on self exclude add new button
				Thread.sleep(2000);
				input("cashier_ResponsibleGaming_SelfExclude_selectProduct_xpath","All");
				Thread.sleep(2000);
				input("cashier_responsibleGaming_selfexclude_SelectPeriod_xpath","6 Months");
				Thread.sleep(3000);
				click("cashier_ResponsibleGaming_SelfExclude_SELFEXCLUDE_xpath");
				Thread.sleep(3000);
				// Verify if user has been able to set self exclude
				String Message=getText("cashier_responsibleGaming_SelfExcludeTextMessage_xpath");
		 		if(isElementPresent("cashier_responsibleGaming_SelfExcludeTextMessage_xpath")){ 
		 			System.out.println(Message); //verifing the Text message displayed after user has set his /her self exclude 
		 		}else{
		 			System.out.println("User unable to self exclude ");
		 		}
		 		Thread.sleep(3000);
		 		
		 		click("cashier_responsibleGaming_SelfExcludeTextBox_OK_xpath");
		 		Thread.sleep(3000);
		 		String Message2=getText("cashier_ResonponsibleGaming_SelfExcludedTextMessage2_xpath");//verifing the Text message displayed after user has set his /her self exclude
		 		if(isElementPresent("cashier_ResonponsibleGaming_SelfExcludedTextMessage2_xpath")){
		 			System.out.println(Message2);
		 		}else{
		 			System.out.println("User unable to self exclude ");
		 		}
		 		Thread.sleep(3000);
		 		click("cashier_ResonponsibleGaming_SelfExcludedTextMessage2_OK_xpath");
		 		Thread.sleep(2000);
		 	// verify if user can make a deposit
		 		click("cashier_Deposit_xpath");
		 		Thread.sleep(2000);
		 		click("cashier_Deposit_deposit_xpath");
		 		Thread.sleep(3000L);
		 		 input("cashier_DepositAmounToDeposit_xpath","200");
		 	    input("cashier_DepositSelectCard_xpath","1111");
		 	    input("cashier_DepositCVV2_xpath","123");
		 	   	    Thread.sleep(500L);
		 	    click("cashier_DepositDeposit_xpath");
		 	    Thread.sleep(3000L);
		 	   String Message1=getText("cashier_TimeoutMessage_Deposit_xpath");
		 		if(isElementPresent("cashier_TimeoutMessage_Deposit_xpath")){
		 			System.out.println(Message1);
		 		}else{
		 			System.out.println("User unable to change ");
		 		}
		 		Thread.sleep(2000);
		 		click("cashier_TimeouOptiomtMessageDeposit_Ok_xpath");
		 		Thread.sleep(2000);
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
				Submenu1.click();
		 
	 }
		@AfterMethod
  	   public void close(){
  	   	   	quit();	
}
}
