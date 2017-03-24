package Casino;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class VegasTest extends TestBase {
	
	
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());
	}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void VegasTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 validateRunmodes("VegasTest", Constant.SECOND_SUITE, table.get(Constant.RUNMODE_COL));
		// openBrowser(table.get(Constant.BROWSER_COL));
		 doDefaultLogin(table.get("Browser"));
		 //navigate("testsiteURL");
		 Thread.sleep(2000L);
		 click("hpVegasTab_Selector");
		 Thread.sleep(2000L);
		 	click("vegasSlot_Selector");
		 	Thread.sleep(6000L);
		 	//click("vegasFeatureGame_WesternBell_xpath");
		 	// verify that user can lunch westerbell demo Games
		 	click("vegasFeatureGame_WesternBell_xpath");
		 	
		 	click("");
		 	click("");
		 	click("");
		 	click("");
		 	click("");
		 	click("");
		 	click("");
		 	click("");
		 	click("");
	
	

}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void VegasJackpotTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		 navigate("testsiteURL");
		 Thread.sleep(2000L);
		 click("hpVegasTab_Selector");
		 Thread.sleep(2000L);
		 click("hpForgottenDetails_xpath");
		   String T=getText("forgottenDetails_xpath");
		   if(isElementPresent("forgottenDetails_xpath"))
				 Assert.assertTrue(true);
		   System.out.println(T);
		   d.navigate().back();
		 WebDriverWait wait= new  WebDriverWait(d,50);
		 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.jackpot_slider li:nth-child(1) a")));
		// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.jackpot_slider a:nth(0)")));
		 	click("vegasJackpotblock_AddWonderlandGame_Selector");
		 	//Assert.assertEquals(d.getCurrentUrl(), "https://vegas.release.supercasino.com/game-info/adventures-in-wonderland", "if user has navigated to the right page");
		 	Thread.sleep(2000L);
		 	d.navigate().back();
		    click("vegasJackpotbloc_winners_xpath");
		   Thread.sleep(2000L);
		 	Assert.assertTrue(isElementPresent("Winners_xpath"), "if user has navigated to the right page");
		 	 d.navigate().back();
			 Thread.sleep(2000L);
		 	click("vegas_footerGettingStarted_xpath");
		 	//Assert.assertEquals(d.getCurrentUrl(), "https://vegas.release.supercasino.com/getting-started", "if user click on Jackpot omn Jackpoty Block");
		 	 Thread.sleep(2000L);
		 	 d.navigate().back();
			 Thread.sleep(2000L);
			click("vegas_footerTVPresenter_Selector");
			  	Thread.sleep(2000L);
		 	Assert.assertTrue(isElementPresent("Prenter_xpath"), "if user has navigated to the right page");
		 	Thread.sleep(2000L);
			 d.navigate().back();
			 Thread.sleep(2000L);
		 	click("vegas_footerVideso_Selector");
		 	//Assert.assertEquals(d.getCurrentUrl(), "https://vegas.release.supercasino.com/videos", "if user click on Jackpot omn Jackpoty Block");
		 	Thread.sleep(2000L);
		 	d.navigate().back();
			 Thread.sleep(2000L);
		 	click("vegas_footerVIP_Selector");
		 	 Thread.sleep(2000L);
		 	Assert.assertTrue(isElementPresent("Lobby_Selector"),"if user has navigated to the right page");
		 	Thread.sleep(2000L);
		 	d.navigate().back();
			 Thread.sleep(2000L);
		 	click("vegas_footerWinners_Selector");
		 	 Thread.sleep(2000L);
		 	Assert.assertTrue(isElementPresent("Winners_xpath"), "if user has navigated to the right page");
		 	d.navigate().back();
			 Thread.sleep(2000L);
		 	click("vegas_footerAboutUs_Selector");
		 	Assert.assertTrue(isElementPresent("AboutSupercasino_xpath"), "if user has navigated to the right page");
		 	d.navigate().back();
			 Thread.sleep(2000L);
			 click("");
			 	click("");
			 	click("");
			 	click("");
			 	click("");
			 	click("");
			 	click("");
			 	click("");
			 	click("");
		
	
	   
}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void VegasFooterTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		 navigate("testsiteURL");
		 Thread.sleep(2000L);
		 click("hpVegasTab_Selector");
		 Thread.sleep(2000L);
		 click("vegas_footerAffiliates_Selector");
		 Thread.sleep(2000L);
		 Set <String> Windowids = d.getWindowHandles();
			Iterator<String> it = Windowids.iterator();
			String MainWindowids = it.next();
			String tabbedWindowId = it.next();
			System.out.println(MainWindowids);
			System.out.println(tabbedWindowId);
			while(it.hasNext());
				//System.out.println(it.next());
				d.switchTo().window(tabbedWindowId);
		 	 Thread.sleep(2000L);
		 Assert.assertEquals(d.getCurrentUrl(), "http://www.netplayaffiliates.com/", "if user click on Jackpot omn Jackpoty Block");
		d.switchTo().window(MainWindowids);
		Thread.sleep(2000L);
		 	click("vegas_footerContactUs_Selector");
		 	Thread.sleep(200);
		 	Assert.assertTrue(isElementPresent("ContactUS_xpath"), "if user has navigated to the right page");
		 	d.navigate().back();
			 Thread.sleep(2000L);
		 click("vegas_footerEnjoyRes_Selector");
		 	Thread.sleep(2000L);
		 	Assert.assertTrue(isElementPresent("EnjoyResponsibly_xpath"), "if user has navigated to the right page");
		 	d.navigate().back();
			 Thread.sleep(2000L);
		 	click("vegas_footerHelp&FAQs_Selector");
		 	 Thread.sleep(2000L);
		 	Assert.assertTrue(isElementPresent("FAQs_xpath"), "if user has navigated to the right page");
		 	d.navigate().back();
			 Thread.sleep(2000L);
		 	click("vegas_footerPrivacyPolicy_Selector");
		 	 Thread.sleep(3000L);
		 	Assert.assertTrue(isElementPresent("privacyP_xpath"),"if user has navigated to the right page");
		 	d.navigate().back();
			 Thread.sleep(2000L);
		 	click("vegas_footerTerms_Selector");
		 	 Thread.sleep(2000L);
		 	Assert.assertTrue(isElementPresent("supercasinoTerms&conditions_xpath"), "if user has navigated to the right page");
		 	//d.navigate().back();
			// Thread.sleep(2000L);
		 	click("");
		 	click("");
		 	click("");
	
}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void VegasGamesLunhTest(Hashtable<String,String>table) throws InterruptedException {
		  openBrowser(prop.getProperty("browserType"));
		    navigate("testsiteURL");
		   doDefaultLogin(prop.getProperty("defaultUsername"));
		   //doDefaultLogin(prop.getProperty("defaultPassword"));
		   Thread.sleep(6000L);
		   click("hpVegasTab_Selector");
		   //click("");
		   //click("vegasSlot_Selector");
		   Thread.sleep(6000L);
		 	//click("vegasSlotGames_MonsterMashPlayNow_xpath");
		 	click("vegasJackopts_Selector");
		 	Thread.sleep(5000L);
		 	
		 	 //WebDriverWait wait= new  WebDriverWait(d,30);
			 //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[3]/div[2]/div/div[5]/div[1]/div[8]/div[3]/div[2]")));
		 	//WebElement Game= d.findElement(By.cssSelector("div.view-content"));
		 /*	List<WebElement> GameList = d.findElements(By.cssSelector("div.play_for_real[data-game-launch-type=VirtueFusion]"));
		 	System.out.println("numbers of GameType is" +"-------"+ GameList.size());
		 	
		 	//returns the first game which is visible
		 	WebElement visibleGame = null;
		 	
		 	for (WebElement game : GameList) {
		 		if (game.isDisplayed()) {
		 			visibleGame = game;
		 			break;
		 			// correct method: isDisplayed()
		 		}
		 	}
		 	
		 	*/
		 	
		 	
		 	
		 //	System.out.println("numbers of link is" +"-------"+ links.size());
			//for (int i=0; i<links.size(); i++){
				//System.out.println("name of the link is"+"-------"+ links.get(i).getText());
		 
		 	click("vegasJackpoGames_FarestPlaynow_xpath");
		 	click("");
		 	click("");
		 	Thread.sleep(2000L); 
}
	 @AfterMethod
	   public void close() throws InterruptedException{
		 Thread.sleep(2000L); 
	   	   	quit();
}
}