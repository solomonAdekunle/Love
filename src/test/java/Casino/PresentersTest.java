package Casino;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestUtil.TestDataProvider;
import Base.TestBase;

public class PresentersTest  extends TestBase{
	
	
	
	
	
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());

}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
	 public void TvPresnterTest(Hashtable<String,String>table) throws InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		  navigate("testsiteURL");
		 click("hp_footerTVPresenter_xpath");
		 Thread.sleep(2000L);
		 click("presenterLeeBaldry_xpath");
		 Thread.sleep(2000L);
		 String P= getText("leeBaldry_xpath");
		 if(isElementPresent("leeBaldry_xpath"))
			 System.out.println(P);
		 else
			 System.out.println("wrong page");
		 d.navigate().back();
		 Thread.sleep(2000L);
		 click("presenterEmilyDeCosimo_xpath");
		 Thread.sleep(2000L);
		 String P1= getText("emilyDeCosimo_xpath");
		 if(isElementPresent("emilyDeCosimo_xpath"))
			 System.out.println(P1);
		 else
			 System.out.println("wrong page");
		 d.navigate().back();
		 Thread.sleep(2000L);
		  click("presentDerekGibbson_xpath");
		  Thread.sleep(2000L);
		  String P2= getText("derekGibbons_xpath");
			 if(isElementPresent("derekGibbons_xpath"))
				 System.out.println(P2);
			 else
				 System.out.println("wrong page");
			 d.navigate().back();
			 Thread.sleep(2000L);
		  click("presenterAnnaJardine_xpath");
		  Thread.sleep(2000L);
		  String P3= getText("annaJardineJones_xpath");
			 if(isElementPresent("annaJardineJones_xpath"))
				 Assert.assertTrue(true);
				 System.out.println(P3);
			  d.navigate().back();
			 Thread.sleep(2000L);
		  click("presenterRobLammar_xpath");
		  Thread.sleep(2000L);
		  String P4= getText("robLamarr_xpath");
			 if(isElementPresent("robLamarr_xpath"))
				 Assert.assertTrue(true);
			 System.out.println(P4);
			 d.navigate().back();
			 Thread.sleep(2000L);
			 click("presenterBryLucas_xpath");
			 Thread.sleep(2000L);
			 if(isElementPresent("brynLucas_xpath"))
				 Assert.assertTrue(true);
			 String P5= getText("brynLucas_xpath");
			 System.out.println(P5);
			 d.navigate().back();
			 Thread.sleep(2000L);
			  click("presenterJohnMason_xpath");
			  Thread.sleep(2000L);
			  String P6= getText("johnMason_xpath");
				 if(isElementPresent("johnMason_xpath"))
					Assert.assertTrue(true);
				 d.navigate().back();
				 Thread.sleep(2000L);
			  click("presenterEilidhNairn_xpath");
			  Thread.sleep(2000L);
			  String P7= getText("eliddhNairn_xpath");
				 if(P7.equals("Eilidh Nairn"))
					 System.out.println(P7);
				 else
					 System.out.println("wrong page");
				 d.navigate().back();
				 Thread.sleep(2000L);
			  click("presenterHelenShepard_xpath");
			  Thread.sleep(2000L);
			  String P8= getText("HelenShephard_xpath");
				 if(P8.equals("Elidh Nairn"))
					 System.out.println(P8);
				 else
					 System.out.println("wrong page");
				 d.navigate().back();
				 Thread.sleep(2000L);
    	     	  click("hp_footerVideo_xpath");
    	  
    	     	  
	 }
	 @AfterMethod
	   public void close(){
	   	   	quit();
}
}
