package CORE_SUITE;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.configuration.ConfigurationException;
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
import TestUtil.Utility;
import Base.TestBase;

public class ChangePasswordTest extends TestBase {

	@BeforeTest
	public void initLogs() {
		initLogs(this.getClass());
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "CORE_SUITEDataProvider")
	public void ChangePasswordTest(Hashtable<String, String> table)
			throws IOException, InterruptedException, ConfigurationException {
		test = extent.startTest("ChangePasswordTest");
		validateRunmodes("ChangePasswordTest", Constant.First_Suite, table.get(Constant.RUNMODE_COL));
		doDefaultLogin(table.get("Browser"));
		// (table.get(Constant.BROWSER_COL));
		// navigate("testsiteURL");
		Thread.sleep(2000L);
		String xpath_menu = "//*[@id='account_box']/ul[1]/li[1]/a";
		String xpath_submenu = "//*[@id='account_box']/ul[1]/li[6]/a";
		WebElement Menu = d.findElement(By.xpath(xpath_menu));
		Actions sol = new Actions(d);
		sol.moveToElement(Menu).build().perform();
		WebElement SubMenu = d.findElement(By.xpath(xpath_submenu));
		Thread.sleep(1000L);
		SubMenu.click();
		Thread.sleep(1000L);
		input("changePassword_OldPassword_xpath", table.get(Constant.OLDPASSWORD_COL));
		String NewPassWord = table.get(Constant.NEWPASSWORD_COL).toString();
		if (NewPassWord.equals("{generator}")) {
			NewPassWord = generateRandomAlphaNumeric(20, "");
		}
		input("changePassword_NewPassword_xpath", NewPassWord);
		if (table.get(Constant.CONFIRMPASSWORD_COL).equals("{generator}")) {
			input("changePassword_ConfirmPassword_xpath", NewPassWord);
			System.out.println(NewPassWord);
		} else {
			input("changePassword_ConfirmPassword_xpath", table.get(Constant.CONFIRMPASSWORD_COL));
		}
		click("changePassword_Sumit_xpath");
		Thread.sleep(2000);
		String Var1 = getText("PasswordSuccessfullyChange_xpath");
		Thread.sleep(2000L);
		System.out.println(Var1);
		Utility.updateproperty("defaultPassword", NewPassWord);
		// Update the Old Passwords colum in the excel sheet
		Utility.writeXLSXFile(35, 3, NewPassWord);
		if (Var1.equalsIgnoreCase("YOUR PASSWORD HAS BEEN SUCCESSFULLY CHANGED")) {
			// System.out.println("user have successfully change is password");
			test.log(LogStatus.PASS, "user have successfully change is password");
			System.out.println(NewPassWord);

			// Update the DefaultPassword in the project.properties file.

		} else
			System.out.println("user has failed to change is password");
		// test.log(LogStatus.FAIL, "user has failed to change is password");
		//// www.release.supercasino.com/personal-details/password-changed
		

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