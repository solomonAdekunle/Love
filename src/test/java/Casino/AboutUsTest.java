package Casino;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TestUtil.ErrorUtil;
import TestUtil.TestDataProvider;
import Base.TestBase;

public class AboutUsTest extends TestBase {
	
	
	
	
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());
	}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void AboutTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 test=extent.startTest("AboutTest");
		 openBrowser(prop.getProperty("browserType"));
		    navigate("testsiteURL");
		    click("hp_footerAboutUS_xpath");
		   // d.navigate().back();
		    Thread.sleep(2000L);
		    click("aboutus_Netplaytv_xpath");
		 	Thread.sleep(3000L);
		 	click("aboutus_Chnnel5inUK_xpath");
		 	Thread.sleep(2000L);
		 	
		 	String varT= getText("Prenter_xpath");//failed
		 	if(varT.equals("Prenter_xpath"))
		 		//System.out.println("User has navigated to the Presnter page");
		 	 test.log(LogStatus.PASS, "User has navigated to the Presnter page");
		 	else
		 		//System.out.println(false);
		 		 test.log(LogStatus.FAIL, "User has navigated to the wrong page");
		 		
		 	 d.navigate().back();
		 	  Thread.sleep(6000L);
		 	click("aboutus_LiveRoulettegames_xpath");
		 	Thread.sleep(2000);
		 	String relativeURL = TestBase.getRelativeUrl(d.getCurrentUrl());
		 	Assert.assertEquals(relativeURL, "/games/live-tv-games", "User has navigated to the right page if expected is equal Actual");
		 	d.navigate().back();
		 click("aboutus_ProgressiveJackpot_xpath");
		 	Thread.sleep(2000);
		 	d.navigate().back();
		 	 Thread.sleep(200L);
		 	click("aboutus_Blackjack_xpath");
		 	d.navigate().back();
		 	 Thread.sleep(2000L);
		 	click("aboutus_slot_xpath");
		 	d.navigate().back();
		 	 Thread.sleep(200L);
		 	click("aboutus_vegasgames_Selector");
		 	d.navigate().back();
		 	 Thread.sleep(200L);
		 	
		 	

}
	 
		 	@Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
			public void EnjoyRespoTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 		test=extent.startTest("AboutTest");
			 openBrowser(prop.getProperty("browserType"));
			    navigate("testsiteURL");
			    Thread.sleep(2000L);
			    click("hp_footerContactUS_xpath");
			    Thread.sleep(2000L);
			    String varT=getText("ContactUS_xpath");
			 	if(varT.equals("ContactUS_xpath"))
			 		System.out.println("User has navigated to the Presnter page");
			 	else
			 		System.out.println(false);
			 	Thread.sleep(3000L);
			 	click("contactUs_forgottenYourPassword_xpath");
			 	Thread.sleep(3000L);
			 	String varTa=getText("forgottenDetails_xpath");
			 	if(varTa.equals("forgottenDetails_xpath"))
			 		System.out.println("User has navigated to the Presnter page");
			 	else
			 		System.out.println(false);
			 	d.navigate().back();
			 	 Thread.sleep(200L);
			 	click("hp_footerEnjoyResponsible_xpath");
			 	Thread.sleep(2000L);
			 	click("enjoyRespoCybersitter_xpath");
			 	click("enjoyRespoeCOGRA_Policies_xpath");
			 	d.navigate().back();
			 	Thread.sleep(2000L);
			 			 	
}
	 	@AfterMethod
     	   public void close(){
	 		if(extent!=null){
				extent.endTest(test);
				extent.flush();
			}
     	   	   	quit();	
     	   	   	
}
}