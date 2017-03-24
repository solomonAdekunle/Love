package Cashier;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestUtil.TestDataProvider;
import Base.TestBase;

public class AccountSummary3Test extends TestBase{
	
	

	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());
	}
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="CashierDataProvider")
		public void AccountSessiontest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		    navigate("testsiteURL");
		   doDefaultLogin(prop.getProperty("defaultUsername"));
		   Thread.sleep(5000L);
			String  Xpath_menu= "//*[@id='account_box']/ul[1]/li[1]/a";//
			String Xpath_subMenu="//*[@id='account_box']/ul[1]/li[3]/a";//MyAccount link within the Account Menu
			WebElement menu=d.findElement(By.xpath(Xpath_menu));
			WebElement myAccount=d.findElement(By.xpath(Xpath_subMenu));
			// performing an action
			Actions llo = new Actions(d);
			llo.moveToElement(menu).build().perform();
			WebDriverWait wait= new WebDriverWait(d,15);
			 WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account_box']/ul[1]/li[3]/a")));
			myAccount.click();
			Thread.sleep(2000L);
			d.switchTo().frame("cashier-iframe").switchTo().frame(0);//switch to the Cashier
			Thread.sleep(3000L);
			click("cashier_MyAccount_Session_xpath");//click 
			Thread.sleep(2000L);
			input("cashier_MyAccount_SessionSelectPeriod_xpath","Last 30 days");
			click("cashier_MyAccount_SessionVIEWSESSION_xpath");
			d.close();
		}
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="CashierDataProvider")
		public void AccountGameHistorytest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		    navigate("testsiteURL");
		   doDefaultLogin(prop.getProperty("defaultUsername"));
		   Thread.sleep(5000L);
			String  Xpath_menu= "//*[@id='account_box']/ul[1]/li[1]/a";
			//  click on my History link within the menu
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
			d.switchTo().frame("cashier-iframe").switchTo().frame(0);//switch to the cashier
			Thread.sleep(3000L);
			click("cashier_MyAccount_GameHistory_xpath");//Game History Tab within the cashier
			Thread.sleep(6000L);
			input("cashier_MyAccount_GameHistoryTimePeriod_xpath","Last 7 days");
			input("cashier_MyAccount_GameHistoryStartDate_xpath","");
			input("cashier_MyAccount_GameHistoryEndDate_xpath","");
			input("cashier_MyAccount_GameHistoryGameType_xpath","");
			input("cashier_MyAccount_GameHistoryGameName_xpath","");
			input("cashier_MyAccount_GameHistoryGameState_xpath","");
			input("cashier_MyAccount_GameHistoryResultPerpage_xpath","100 games");
			click("cashier_MyAccount_GameHistorySearch_xpath");
			d.close();

}
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="CashierDataProvider")
		public void AccountBonusestest(Hashtable<String,String>table) throws IOException, InterruptedException{
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
			Thread.sleep(3000L);
			click("cashier_MyAccount_Bonuses_xpath");//click on the Bonuses tab link within the cashier
	 		Thread.sleep(2000L);
	 		input("cashier_MyAccount_BonusesBonuseCode_xpath","BONUS500");//input your bonus code
	 		click("cashier_MyAccount_BonusesSubmit_xpath");
	 		Thread.sleep(3000L);
	 		// verify if system will accept invalid Bonus code
	 		String texts=getText("cashier_MyAccount_BonusesInvalidcodeMessage_xpath");
	 		if(texts.equalsIgnoreCase(("Your bonus code is invalid."))){
	 				System.out.println("user has failed to use invalid Bonuse Code");
	 		}else{
	 			System.out.println("System Accepted Invalid Bonuse Code, please this a Bug");
	 		}
	 		click("cashier_MyAccount_BonusesInvalidcodeMessageOK_xpath");
	 		Thread.sleep(2000L);
	 		click("cashier_MyAccount_PendingWithdarwal_xpath");
	 		Thread.sleep(2000L);
	 		click("cashier_Withdraw_PendingWithdrawalTransferBackToBal_xpath");
	 		// Verify if user can tranfer back to balance without requset code not set
	 		String Text3= getText("cashier_Withdraw_PendingWithdrawalTransferBackToBalMessage_xpath");
	 		if(Text3.equals("Request code is not set.")){
	 			System.out.println("User unable to tranfer back to balance woth reqest code set");
	 		}else{
	 			System.out.println("user tranfer back to balance with request code not set");
	 		}
	 		Thread.sleep(1000L);
	 		click("cashier_Withdraw_PendingWithdrawalTransferBackToBalMessageOK_xpath");
	 		Thread.sleep(2000L);
	 		click("cashier_Withdraw_xpath");
	 		Thread.sleep(1000L);
	 		input("cashier_Withdraw_AmountToWidraw_xpath","20");
	 		Thread.sleep(1000L);
	 		Actions action= new Actions(d);
		    action.moveToElement(d.findElement(By.xpath("//*[@id='W_CardNumber']"))).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys((Keys.ENTER)).build().perform();
	 		//input("cashier_Withdraw_CardNumber_xpath","3625");
		    Thread.sleep(1000L);
	 		click("cashier_Withdraw_WITHDRAW_xpath");
	 		Thread.sleep(1000L);
	 		String Message=getText("cashier_withdraw_WithdrawalRequestRecicedText_xpath");
	 		if(isElementPresent("cashier_withdraw_WithdrawalRequestRecicedText_xpath")){
	 			System.out.println(Message);
	 		}else
	 			System.out.println("User unable to withdraw Money");
	 		d.switchTo().defaultContent(); 
			 Thread.sleep(1000L);
		 click("cashier_CloseIcon_Seletor");
		 Thread.sleep(5000L);
		 String  Xpath_menu1= "//*[@id='account_box']/ul[1]/li[1]/a"; // Move to Account
			String Xpath_subMenu1="//*[@id='account_box']/ul[1]/li[7]/a";//  xpath for signout
			WebElement menu1=d.findElement(By.xpath(Xpath_menu1));
			WebElement Submenu1=d.findElement(By.xpath(Xpath_subMenu1));
			// performing an action
			Actions lla = new Actions(d);
			lla.moveToElement(menu1).build().perform();
			Submenu1.click();
	 		//d.close();
	 		
	 } 

@AfterMethod
public void close(){
	   	quit();	
}
}