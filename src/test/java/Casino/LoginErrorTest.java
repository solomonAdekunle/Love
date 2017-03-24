package Casino;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestUtil.Constant;
import TestUtil.ErrorUtil;
import TestUtil.TestDataProvider;

public class LoginErrorTest extends TestBase {

	
	
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());
	}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void LoginErrorTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 validateRunmodes("LoginErrorTest", Constant.SECOND_SUITE, table.get(Constant.RUNMODE_COL));
			openBrowser(table.get(Constant.BROWSER_COL));
			navigate("testsiteURL");
			input("hpUsername_xpath",table.get(Constant.USERNAME_COL));
	    	 input("hpPassword_xpath",table.get(Constant.PASSWORD_COL));
	    	 click("hpSignin_Selector");
	    	 Thread.sleep(3000L);
	    	 boolean  Element=isElementPresent("errorMessage_Selector");
	    	 if(isElementPresent("errorMessage_Selector"))
	    		 System.out.println(true);
	    	 else
	    		 System.out.println(false);
	    	  Thread.sleep(3000L);
	    	  click("hpLoginPopUpBox_NewUser_Selector");
	    	  
	    			  

}
	 @AfterMethod
	   public void close() throws InterruptedException{
		 Thread.sleep(2000L); 
	   	   	quit();
}
}
