package CORE_SUITE;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import TestUtil.TestDataProvider;
import Base.TestBase;

/**
 * Unit test for simple App.
 */
public class HomePageTest extends TestBase{
	
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());
	}
	        
    	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CORE_SUITEDataProvider")
			public void marktest(Hashtable<String,String>table) throws IOException, InterruptedException{
			//validateRunmodes("RandomTest", Constant.First_Suite, table.get(Constant.RUNMODE_COL));
    		 test=extent.startTest("marktest");
        	 openBrowser(prop.getProperty("browserType"));
        	 navigate("testsiteURL");
        	 Thread.sleep(2000L);
        	 if(isElementPresent("superLogo_xpath"))// Click on the supercasino logo
        		 click("superLogo_xpath");
        	 else
        		 System.out.println(false);
    	 
        	 Thread.sleep(3000L);
        	               	 
        	 //System.out.println(d.getCurrentUrl());
        	  click("hpLiveON5Logo_xpath");// click on the channel 5 Logo
        	 Thread.sleep(1000L);
        	// verify if you are taking to the presenter page
        	String var=getText("Prenter_xpath");
        	if (var.equals("PRESENTERS"))
        		//System.out.println(true);
        		 test.log(LogStatus.PASS, "navigated to the Presenter's page");
        		else
        		//System.out.println(false);
        		test.log(LogStatus.FAIL, "navigated to wrong");
        	 d.navigate().back();// navigate back
        	 Thread.sleep(2000);
        	  WebDriverWait wait= new WebDriverWait(d,20);
        	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.view-jackpots div.jackpot_slider li a[href='/game-info/gold-rally']")));// Beachlife within the Jackpot block to be clickable
        	 
        	  click("hpJackpotGodRally_Selector"); //within the Jackpot block
        	  String relativeURL1 = TestBase.getRelativeUrl(d.getCurrentUrl());
        	  if(relativeURL1.equals("/game-info/info/gold-rally"))
         		System.out.println(true);
         	 else
         		System.out.println(false);
         	 d.navigate().back();
        	  Thread.sleep(2000L);
        	  click("hpWinner_Selector"); //click on Winner within the Winner Block on the Home page
        	  Thread.sleep(2000L);
        	  String var1= getText("Winners_xpath");
        	  Assert.assertEquals(var1, "WINNERS");
//        	  d.navigate().back();
//        	  WebDriverWait Ele= new  WebDriverWait(d,30);
//       	  Ele.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='flexslider_views_slideshow_promotions-flex_promo']/li[2]/div[3]/span/a")));
//        	  click("hpJoinNow2_Selector");
//        	  String relativeURL2 = TestBase.getRelativeUrl(d.getCurrentUrl());
//        	  if(relativeURL2.equals("/register"))
//        		  //System.out.println("navigated to the registration page");
//        		  test.log(LogStatus.PASS, "navigated to the registration page");
//        	  else
//        		 // System.out.println("Page Not Found");
//        		  test.log(LogStatus.FAIL, "navigated to the wrong page");
        	  d.navigate().back();
        	  Thread.sleep(2000);
        	  click("hpRouletteExpPremiumGameInfo_Selector");//
        	  Thread.sleep(2000L);
        	  if(isElementPresent("RouletteEXpPremium_xpath"))
        		  //System.out.println("navigated to the  Roulette Express Premium gameinfo page");
        		  test.log(LogStatus.PASS, "navigated to the  Roulette Express Premium gameinfo page");
        	  else
        		  //System.out.println("Page Not Found");
        		  test.log(LogStatus.FAIL, "Page not Found");
        		  d.navigate().back();
        	  Thread.sleep(2000L);
        	 click("hpHelp_xpath");
        	 Thread.sleep(2000L);
        	  String var3=getText("ContactUS_xpath");
        	  if(var3.equals("CONTACT US"))
        		  //System.out.println("Navigated to Contact US page");
        	   test.log(LogStatus.PASS, var3);
        	  else
        		  //System.out.println(false);
        		  test.log(LogStatus.FAIL, "Navigated to wrong page");
        	   d.navigate().back();
        	   Thread.sleep(2000);
        	   click("hpChat_Selector");
        	 
        	   
    
    }
    	 
@Test(dataProviderClass=TestDataProvider.class,dataProvider="CORE_SUITEDataProvider")
 public void footertest(Hashtable<String,String>table) throws InterruptedException, MalformedURLException{
	test=extent.startTest("footertest");
	openBrowser(prop.getProperty("browserType"));
	 navigate("testsiteURL");
	 click("hp_FooterGettingStrated_xpath");
	// verify that user navigated to Getting Started page
	 String relativeURL1 = TestBase.getRelativeUrl(d.getCurrentUrl());
	 WebDriverWait ele=new WebDriverWait(d,20);
	 ele.until(ExpectedConditions.urlContains("/getting-started"));
	  if(relativeURL1.equals("/getting-started"))
		  System.out.println("navigated to the getting Started page");
		// test.log(LogStatus.PASS,"navigated to the getting Started page");
	    else
		  System.out.println(relativeURL1);
		  //test.log(LogStatus.FAIL,relativeURL1);
		 
	  d.navigate().back();
	  Thread.sleep(2000L);
	  click("hp_footerTVPresenter_xpath");
	  Thread.sleep(2000L);
	// verify that user navigated to Presenters page
	  String var4=getText("Prenter_xpath");
	 	if (var4.equals("PRESENTERS"))
	 		//System.out.println(true);
	 		test.log(LogStatus.PASS, var4);
	 		else
	 		//System.out.println(false);
	 			test.log(LogStatus.FAIL, "404 PAGE");
	 	 d.navigate().back();
	 	 Thread.sleep(2000L);
	 	click("hp_footerVideo_xpath");
	 // verify that user navigated to Video page
	 	String relativeURL = TestBase.getRelativeUrl(d.getCurrentUrl());
	 	if(relativeURL.equals("/videos"))
			  //System.out.println("navigated to the video page");
	 		test.log(LogStatus.PASS, relativeURL);
		  else
			 //System.out.println("Page Not Found");
			  test.log(LogStatus.FAIL, "Page Not Found");
			   d.navigate().back();
		  Thread.sleep(2000L);
		click("hp_footerVIP_xpath");
		// verify that user navigated to VIP page
		String var1=getText("Lobby_Selector");
		if (var1.equals("Lobby"))
	 		//System.out.println(true);
			test.log(LogStatus.PASS, var1);
	 	else
	 		//System.out.println(false);
	 		test.log(LogStatus.FAIL, "Page not found");
	 	 d.navigate().back();
	 	Thread.sleep(2000L);
	 	 click("hp_footerWinner_xpath");
	 	 Thread.sleep(2000);
	 	// verify that user navigated to Winner page
	 	String var2= getText("Winners_xpath");
		  Assert.assertEquals(var2, "WINNERS");
		  d.navigate().back();
		  Thread.sleep(2000L);
		  click("hp_footerBlog_xpath");
		  Thread.sleep(2000);
		  Set <String> Windowids = d.getWindowHandles();
			Iterator<String> it = Windowids.iterator();
			String MainWindowids = it.next();
			String tabbedWindowId = it.next();
			System.out.println(MainWindowids);
			System.out.println(tabbedWindowId);
			while(it.hasNext());
				//System.out.println(it.next());
				d.switchTo().window(tabbedWindowId);
				// verify that user navigated to Blog  page
		  if(d.getCurrentUrl().equals("http://blog.supercasino.com/"))
			  System.out.println("navigated to the  Blog page");
		  else
			  System.out.println("Page Not Found");
		  d.switchTo().window(MainWindowids);
		  Thread.sleep(2000L);
	 	 click("hp_footerAboutUS_xpath");
	 	Thread.sleep(2000L);
	 	 String var5=getText("AboutSupercasino_xpath");
	 	// verify that user navigated to About-US page
	 	if (var5.equals("ABOUT SUPERCASINO"))
	 		//System.out.println(true);
	 		test.log(LogStatus.PASS, var5);
	 	else
	 		//System.out.println(false);
	 		test.log(LogStatus.FAIL, "Page not found");
	 	 d.navigate().back();
	 	Thread.sleep(2000L);
	 	click("hp_footerAffiliates_xpath");
	 // verify that user navigated to Getting Started page
	 	Set <String> Windowids1 = d.getWindowHandles();
		Iterator<String> it1 = Windowids.iterator();
		String MainWindowids1 = it1.next();
		String tabbedWindowId1 = it1.next();
		System.out.println(MainWindowids1);
		System.out.println(tabbedWindowId1);
		while(it1.hasNext());
		d.switchTo().window(tabbedWindowId1);
		if(d.getCurrentUrl().equals("http://www.netplayaffiliates.com/"))
			  System.out.println("navigated to the video page");
		  else
			  System.out.println("Page Not Found");
		 d.switchTo().window(MainWindowids1);
		 // d.navigate().back();
		  Thread.sleep(2000L);
		  click("hp_footerContactUS_xpath");
		  Thread.sleep(2000L);
		// verify that user navigated to Contact US page
		  String var6=getText("ContactUS_xpath");
		  if(var6.equals("CONTACT US"))
    		  //System.out.println("Navigated to Contact US page");
			  test.log(LogStatus.PASS, var6);
    	  else
    		 // System.out.println(false);
    		  test.log(LogStatus.FAIL, "Page not found");
    	   d.navigate().back();
    	   Thread.sleep(2000L);
    	   click("hp_footerEnjoyResponsible_xpath");
    	   Thread.sleep(2000L);
    	// verify that user navigated to  Enjoy Responsibly page
    	   String var7=getText("EnjoyResponsibly_xpath");
 		  if(var7.equals("ENJOY RESPONSIBLY"))
     		  //System.out.println("Navigated to  Enjoy Responsibly page");
 			 test.log(LogStatus.PASS, var7);
     	  else
     		  //System.out.println(false);
     		 test.log(LogStatus.FAIL, "Page not found");
     	   d.navigate().back();
     	   Thread.sleep(2000L);
     	   click("hp_footerHelp&FAQS_xpath");
     	  Thread.sleep(2000L);
     	// verify that user navigated to FAQS page
     	  String var8=getText("FAQs_xpath");
 		  if(var8.equals("FAQS"))
     		  //System.out.println("Navigated to FAQS page");
 			 test.log(LogStatus.PASS, var8);
     	  else
     		 // System.out.println(false);
     		 test.log(LogStatus.FAIL, "Page not found");
     	   d.navigate().back();
     	   Thread.sleep(2000L);
     	   click("hp_footerPrivacyPolicy_Selector");
     	  Thread.sleep(3000L);
     	// verify that user navigated to Privacy Policy page
     	  String var9=getText("privacyP_xpath");
 		  if(var9.equals("PRIVACY POLICY UK"))
     		  //System.out.println("Navigated to Privacy Policy  page");
 			 test.log(LogStatus.PASS, var9);
     	  else
     		  //System.out.println(false);
     		 test.log(LogStatus.FAIL,"Page not found" );
     	   d.navigate().back();
     	   Thread.sleep(2000L);
     	   click("hp_footerTerms_xpath");
     	  Thread.sleep(2000L);
     	// verify that user navigated to  Privacy Policy page
     	  String var10=getText("supercasinoTerms&conditions_xpath");
 		  if(var10.equals("TERMS AND CONDITIONS FOR UK"))
     		  //System.out.println("Navigated to  terms and conditions  page");
 			 test.log(LogStatus.PASS, var10);
     	  else
     		 // System.out.println(false);
     		 test.log(LogStatus.FAIL, "Page not found");
     	   d.navigate().back();
     	   Thread.sleep(2000L);
     	   click("hp_footerFacebookIcon_xpath");
     	   click("hp_footertiwitterIcon_xpath");
     	   click("hp_footerNetplayTVIcon_xpath");
     	   click("hp_footer18Icon_xpath");
     	  Thread.sleep(2000L);
     	   click("hp_footerGamcare_xpath");
     	   
     	   // Verify if footer test is displayed at the bottom of the page.
     	   boolean Footertest=isElementPresent("footerLgalMessage_Selector");
     	   System.out.println(Footertest);
     }


@Test(dataProviderClass=TestDataProvider.class,dataProvider="CORE_SUITEDataProvider")
public void JackpotBlockBeachTest(Hashtable<String,String>table) throws InterruptedException, MalformedURLException{
	test=extent.startTest("JackpotBlockBeachTest");
	 openBrowser(prop.getProperty("browserType"));
	 navigate("testsiteURL");
	 WebDriverWait pdp= new  WebDriverWait(d,45);
	   pdp.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[3]/div[2]/div[3]/div/div[2]/div/ul/li[2]/a")));
	   click("hp_jackpotblockGoldRally_xpath");
	   String relativeURL = TestBase.getRelativeUrl(d.getCurrentUrl());
	   if(relativeURL.equals("/game-info/gold-rally"))
		  // System.out.println("User naivagted to the Right page");
		   test.log(LogStatus.PASS, "User naivagted to the Right page");
	   else
		   //System.out.println(false);
		   test.log(LogStatus.FAIL, "User naivagted to the WRONG PAGE");
	   d.navigate().back();
	   WebDriverWait APC= new  WebDriverWait(d,30);
	   APC.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/game-info/beach-life']")));
	   click("hpJackpotBeachlife_Selector");
	   String relativeURL1 = TestBase.getRelativeUrl(d.getCurrentUrl());
	   if(relativeURL1.equals("/game-info/beach-life"))
		   //System.out.println("User naivagted to the Right page");
		   test.log(LogStatus.PASS, "User naivagted to the Right page");
	   else
		 // System.out.println(false);
		   test.log(LogStatus.FAIL, "User naivagted to the wrong page");
	  
	   
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
//}