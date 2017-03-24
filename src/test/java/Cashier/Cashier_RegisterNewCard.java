package Cashier;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestUtil.Constant;
import TestUtil.TestDataProvider;
import Base.TestBase;

public class Cashier_RegisterNewCard extends TestBase {

	@BeforeTest
	public void initLogs() {
		initLogs(this.getClass());
	}

	@Test(enabled=false,dataProviderClass = TestDataProvider.class, dataProvider ="CashierDataProvider")
	public void RegisterNewCardTest(Hashtable<String, String> table) throws IOException, InterruptedException {
		validateRunmodes("RegisterNewCardTest", Constant.Money_Section, table.get(Constant.RUNMODE_COL));
		doDefaultLogin(table.get("Browser"));
		click("hpDeposit_xpath");
		Thread.sleep(5000L);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("cashier-iframe")));
		d.switchTo().frame("cashier-iframe").switchTo().frame(0);
		Thread.sleep(5000L);
		WebElement PendingMessagebox=d.findElement(By.xpath("//*[@id='UM_Buttons']"));
		if(PendingMessagebox.isDisplayed()){
			PendingMessagebox.click();
		}
		//click("cashier_DepositRegisterNewCard_pleaseclickMessageOK_xpath");
		//Thread.sleep(500L);
		click("cashier_DepositRegisterNewCreditCard_xpath");
		Thread.sleep(500L);
		input("cashier_DepositRegisterNewCard_CardType_xpath", table.get(Constant.RegNewCardCARDTYPE_COL));
		Thread.sleep(300L);
		input("cashier_DepositRegisterNewCard_CardNumber_xpath", table.get(Constant.RegNewCardCARDNUM_COL));
		Thread.sleep(300L);
		input("cashier_DepositRegisterNewCard_ExipireDateMonth_xpath", table.get(Constant.RegNewCardEXPIREMONTH_COL));
		Thread.sleep(300L);
		input("cashier_DepositRegisterNewCard_ExipireDateYear_xpath", table.get(Constant.RegNewCardEIXPIREYEAR_COL));
		input("cashier_DepositRegisterNewCard_Country_xpath", table.get(Constant.RegNewCardCOUNTRY_COL));
		Thread.sleep(1000L);
		click("Cashier_RegisterNewCard_CheckBox_xpath");
		click("cashier_DepositRegisterNewCard_REGISTER_xpath");
		/* verify that user can register a new valid card
		 verify that user user can not register an invalid card
		 verify that user cannot register card with expired date */
		String Text = getText("cashier_DepositRegisterNewCard_validcardNumberMessage_xpath");
		if (Text.equals("Your credit card has been successfully registered with our system.")) {
			System.out.println(Text);
		} else {
			System.out.println(Text + "--------" + "user unable to register invalid card");
		}
		Thread.sleep(3000L);
		click("cashier_DepositRegisterNewCreditCard_PopOk_id");
		d.switchTo().defaultContent();
		Thread.sleep(1000L);
		click("cashier_CloseIcon_Selector");
		Thread.sleep(5000L);
		String Xpath_menu1 = "//*[@id='account_box']/ul[1]/li[1]/a"; // Move to
																		// Account
		String Xpath_subMenu1 = "//*[@id='account_box']/ul[1]/li[7]/a";// xpath
																		// for
																		// signout
		WebElement menu1 = d.findElement(By.xpath(Xpath_menu1));
		WebElement Submenu1 = d.findElement(By.xpath(Xpath_subMenu1));
		// performing an action
		Actions lla = new Actions(d);
		lla.moveToElement(menu1).build().perform();
		Submenu1.click();

	}

	@AfterMethod
	public void close() {
		quit();

	}
}

// Your credit card has been successfully registered with our system.