package Casino;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestUtil.TestDataProvider;

public class GamesLunchTest extends TestBase {
	
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());
	}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void GettingStartedTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		  openBrowser(prop.getProperty("browserType"));
		    navigate("testsiteURL");
		   doDefaultLogin(prop.getProperty("defaultUsername"));
    	  Thread.sleep(4000L);
    	  click("hpRouletteDoubleUpPlayNow_Selector");
    	 Thread.sleep(3000);
    	 click("doubleUpRoulette_LuncheGamesSelectRoulleteNation_Selector");
    	 click("doubleUpRoulette_LuncheGamesSelectRoulleteExpressPremium_Selector");
    	 click("doubleUpRoulette_LunchGames_Selector");
    	 

}
	
	 
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void HelpAndFAQsTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		 	navigate("testsiteURL");
		 	click("hp_footerHelp&FAQS_xpath");
		 	
		 		 	
}
	 
	 
	 
	 
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void TermTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		 	navigate("testsiteURL");
			Thread.sleep(5000L);
		 	click("hp_footertiwitterIcon_xpath");
		 	Thread.sleep(2000L);
		 	Set<String> Windowids = d.getWindowHandles();
			Iterator<String> it = Windowids.iterator();
			String MainWindowids = it.next();
			String tabbedWindowId = it.next();
			System.out.println(MainWindowids);
			System.out.println(tabbedWindowId);
			while(it.hasNext());
				Thread.sleep(3000L);
				d.switchTo().window(tabbedWindowId);
				Assert.assertEquals(d.getCurrentUrl(),"https://twitter.com/supercasinocom");
				d.switchTo().window(MainWindowids);
				Thread.sleep(2000L);
				click("hp_footerFacebookIcon_xpath");
		 	click("hp_footerNetplayTVIcon_xpath");
		 	click("hp_footer18Icon_xpath");
		 		Thread.sleep(2000L);
		 	click("hp_footerGamcare_xpath");
		 	
	 }
	 @AfterMethod
	   public void close(){
	   	   	quit();
	 }
	 
}