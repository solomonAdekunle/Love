package CORE_SUITE;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import TestUtil.Constant;
import TestUtil.TestDataProvider;

public class RegistrationTest extends TestBase {

	@BeforeTest
	public void initLogs() {
		initLogs(this.getClass());
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "CORE_SUITEDataProvider")
	public void RegistrationTest(Hashtable<String, String> table) throws IOException, InterruptedException {
		// verify if user can register with incorrect data
		// verify if user can register with correct data
		// verify if user will be taking to welcome page after successfully
		// completed the form and click submit
		test = extent.startTest("RegistrationTest");
		String consValue = Constant.First_Suite;
		String tableValue = table.get(Constant.RUNMODE_COL);
		validateRunmodes("RegistrationTest", consValue, tableValue);
		openBrowser(table.get(Constant.BROWSER_COL));
		navigate("testsiteURL");
		click("hpJoinNow1_xpath");// click join now button

		// Generating Dynanic username
		String Username = table.get(Constant.REGUSERNAME_COL).toString();
		System.out.println(Username);
		if (Username.equals("{generator}")) {
			Username = generateStringWithAllobedSplChars(20, "");
			System.out.println(Username);
		}
		input("regUsername_xpath", Username);// input username
		input("regPassword_xpath", table.get(Constant.REGPASSWORD_COL));
		input("regConfirmPassword_xpath", table.get(Constant.CONFPASSWORD_COL));
		String Screenname = table.get(Constant.SCREENNAME_COL).toString();
		if (Screenname.equals("{generator}")) {
			Screenname = generateStringWithAllobedSplChars(16,"");
			//System.out.println(Screenname);
		}
		input("regScreenName_xpath", Screenname);
		input("regEmail_xpath", table.get(Constant.EMAIL_COL));
		input("regTitle_xpath", table.get(Constant.TITLE_COL));
		input("regFirstname_xpath", table.get(Constant.FIRSTNAME_COL));
		input("regSurname_xpath", table.get(Constant.LASTNAME_COL));
		input("regDay_xpath", table.get(Constant.DAY_COL));
		input("regMonth_xpath", table.get(Constant.MONTH_COL));
		input("regYear_xpath", table.get(Constant.YEAR_COL));
		Thread.sleep(2000L);
		click("regEnterAddManually_xpath");
		Thread.sleep(2000L);
		input("regAddress_xpath", table.get(Constant.ADDRESS_COL));
		input("regCity_xpath", table.get(Constant.CITY_COL));
		input("regCounty_xpath", table.get(Constant.COUNTY_COL));
		input("regPostCode_xpath", table.get(Constant.POSTCODE_COL));
		input("regContactPhone_xpath", table.get(Constant.CONTACTNUMBER_COL));
		// input("regPromoCode_xpath",table.get(Constant.PROMOCODE_COL));
		click("regtTermOver18_xpath");
		Thread.sleep(500L);
		click("regSubmit_xpath");// click on submit button
		Thread.sleep(500L);
		// verify if user will be taking to welcome page after successfully
		// completed the register form.
		boolean result = isElementPresent("register_error_Selector");
		String actualResult = null;
		if (result)
			actualResult = "FAILURE";
		else
			actualResult = "SUCCESS";

		Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult);
		if (table.get(Constant.EXPECTEDRESULT_COL).equals("SUCCESS")) {
			// verify if user can login with invalid data
			boolean result1 = isElementPresent("userNameHolder_xpath");
			String actualResult1 = null;
			if (result1)
				actualResult1 = "SUCCESS";
			else
				actualResult1 = "FAILURE";
			Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult1);
			//
		}

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
