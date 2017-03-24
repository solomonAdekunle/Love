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

import com.relevantcodes.extentreports.LogStatus;

import TestUtil.Constant;
import TestUtil.TestDataProvider;
import Base.TestBase;

public class DepositTest extends TestBase {

	@BeforeTest
	public void initLogs() {
		initLogs(this.getClass());
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "CashierDataProvider")
	public void DepositTest(Hashtable<String, String> table) throws IOException, InterruptedException {
		test = extent.startTest("CashierTest");
		validateRunmodes("DepositTest", Constant.Money_Section, table.get(Constant.RUNMODE_COL));
		doDefaultLogin(table.get("Browser"));
		click("hpDeposit_xpath");
		Thread.sleep(5000L);
		// WebDriverWait wait1= new WebDriverWait(dr,30);
		// wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("sb-player"));
		d.switchTo().frame("cashier-iframe").switchTo().frame(0);
		Thread.sleep(2000L);
		WebElement PendingMessagebox=d.findElement(By.xpath("//*[@id='UM_Buttons']"));
		if(PendingMessagebox.isDisplayed()){
			PendingMessagebox.click();
		}
		input("cashier_DepositAmounToDeposit_xpath", table.get(Constant.AMOUNT_Col));
		input("cashier_DepositSelectCard_xpath", table.get(Constant.CARD_COL));
		input("cashier_DepositCVV2_xpath", table.get(Constant.CVV2_Col));
		input("cashier_DepositPromocode_xpath", table.get(Constant.PROMOCODE_COL));
		Thread.sleep(500L);
		click("cashier_DepositDeposit_xpath");
		Thread.sleep(3000L);
		String Text = getText("Cashier_CreditcardApprovedMessage_xpath");
		System.out.println(Text);
		Thread.sleep(2000L);
		if (Text.equalsIgnoreCase("Your credit card deposit has been approved and will be charged as NetPlayTV Grp.Thank you and good luck!")) {
			 System.out.println(Text);
			//test.log(LogStatus.PASS, Text);
		} else {
			 System.out.println("Credit Card Not Approved for Payment");
			//test.log(LogStatus.FAIL, Text);
		}
		click("Cashier_CreditcardApprovedMessageOK_xpath");
		Thread.sleep(3000L);
		d.switchTo().defaultContent();
		d.findElement(By.cssSelector("div.cashier-modal a i.icon-close")).click();
		Thread.sleep(1000L);
		String Xpath_menu = "//*[@id='account_box']/ul[1]/li[1]/a";
		String Xpath_subMenu = "//*[@id='account_box']/ul[1]/li[7]/a";
		WebElement menu = d.findElement(By.xpath(Xpath_menu));
		WebElement Submenu = d.findElement(By.xpath(Xpath_subMenu));
		// performing an action
		Actions llo = new Actions(d);
		llo.moveToElement(menu).build().perform();
		WebDriverWait wait2 = new WebDriverWait(d, 30);
		WebElement element3 = wait2	.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='account_box']/ul[1]/li[7]/a")));
		Submenu.click();
	}

	@AfterMethod
	public void close() {
		if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}
		quit();
	}

}