package CORE_SUITE;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import TestUtil.Constant;
import TestUtil.TestDataProvider;

public class ForgottenDetailsTest extends TestBase {

	@BeforeTest
	public void initLogs() {
		initLogs(this.getClass());
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "CORE_SUITEDataProvider")
	public void ForgottenDetailsTest(Hashtable<String, String> table) throws IOException, InterruptedException {
		test = extent.startTest("ForgottenDetailsTest");
		validateRunmodes("ForgottenDetailsTest", Constant.First_Suite, table.get(Constant.RUNMODE_COL));
		openBrowser(table.get(Constant.BROWSER_COL));
		navigate("testsiteURL");
		click("hpForgottenDetails_xpath");// click on the forgotten details link
		// input your  user name
		input("forgottenDetails_Username_xpath", table.get(Constant.USERNAME_COL));
		input("forgottenDetails_Email_xpath", table.get(Constant.EMAIL_COL));
		Thread.sleep(1000L);
		System.out.println(table.get(Constant.DAY_COL));
		input("forgottenDetails_day_xpath", table.get(Constant.DAY_COL));
		input("forgottenDetails_montgh_xpath", table.get(Constant.MONTH_COL));
		input("forgottenDetails_year_xpath", table.get(Constant.YEAR_COL));
		Thread.sleep(2000L);
		click("forggotenDetails_submit_xpath");// click submit button
		System.out.println("Before Condition"+table.get(Constant.Result));
		if(table.get(Constant.Result).equals("Correct")){
		Thread.sleep(2000L);
		input("resetPassword_NewPassword_xpath", table.get(Constant.NEWPASSWORD_COL));
		input("resetPassword_ConfirmedPassword_xpath", table.get(Constant.CONFIRMPASSWORDr_COL));
		click("resetPassword_Submit_xpath");
		// verify is user has successfully res-set his/her password
		String Var1 = getText("YOURPersonalDetailsSuccessFullyUpDated_xpath");
		Thread.sleep(2000L);
		if (Var1.equals("YOUR PERSONAL DETAILS HAVE BEEN SUCCESSFULLY UPDATED")) {
			 System.out.println("user have successfully change is password");
			//test.log(LogStatus.PASS, "user have successfully change is password");
		} else
			System.out.println("user has failed to change is password");
			//test.log(LogStatus.FAIL, "user has failed to change is password");
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
