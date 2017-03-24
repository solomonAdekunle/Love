package Casino;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestUtil.TestDataProvider;
import Base.TestBase;

public class PromotionTest extends TestBase{
	
	
	
	
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());
	}
	 
		 	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
	 public void Promopage1(Hashtable<String,String>table) throws IOException, InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		    navigate("testsiteURL");
		    click("hpPromotion_Selector");
		    Thread.sleep(1000L);
		    WebElement promo=d.findElement(By.cssSelector("div.view-promotions .view-content"));
		   List <WebElement> Promlist=promo.findElements(By.cssSelector("div.promo-wrapper"));
		   
		   System.out.println(Promlist.size());
		   
		   for(int i=0; i < Promlist.size(); i++) {
			   
			   System.out.println(i);
			   // Repolulate  the list of all the Elements on all the banner.
			    promo=d.findElement(By.cssSelector("div.view-promotions .view-content"));
			   Promlist = promo.findElements(By.cssSelector("div.promo-wrapper"));
			   WebElement promotion = Promlist.get(i);
					   
			   //get promotion title
			   String promotionTitle = promotion.findElement(By.cssSelector(".promotion-title a")).getText();
			   System.out.println(promotionTitle);
//			   
//			   //navigate
		 WebElement Button1=promotion.findElement(By.cssSelector("a.promo-more-info"));
		 	Button1.click();
		 	Thread.sleep(2000);
     		 //get page title
		 	String pagetitle=getText("titlePage_xpath");
		 	Thread.sleep(200);
		 	System.out.println(pagetitle);
		 	if(pagetitle.equalsIgnoreCase(promotionTitle)){
		 		System.out.println(true);
		 		
		 		Thread.sleep(1000);
		 		d.navigate().back();
		 	}else{
		 		System.out.println(false);
		 		return;

		 	}	
			   
			   
			   //compare
			   
			   
		   }
			//System.out.println(Promlist.get(1).getText());
		   	
		 	
		 	

}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void COMPETITIONTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		    navigate("testsiteURL");
		   doDefaultLogin(prop.getProperty("defaultUsername"));
		   Thread.sleep(2000);
		   click("hpPromotion_Selector");
		   Thread.sleep(1000);
		   click("promotionCompetition_Selector");
		   
			
	 
}
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void Wageringest(Hashtable<String,String>table) throws IOException, InterruptedException{
		 openBrowser(prop.getProperty("browserType"));
		    navigate("testsiteURL");
		    WebDriverWait Elee= new  WebDriverWait(d,30);
		    Elee.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[3]/div/div[2]/span/a")));
		    click("hpHeroBanner_�10FreeForNewPlayer_Button_xpath");
		    if(d.getCurrentUrl().equals("https://www.release.supercasino.com/register"))
	     		   System.out.println(true);
	     	   else
	     		   System.out.println(false);
	     	  d.navigate().back();
	     	 WebDriverWait Elee1= new  WebDriverWait(d,30);
			    Elee1.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[3]/div[2]/div/div[1]/div/div/div[1]/div/div[3]/div/div[2]/span/a")));
	     	  click("hpHeroBanner�10FreeForNewPlayer_18+Terms&Wagering_xpath");
	     	 WebDriverWait Elee2= new  WebDriverWait(d,30);
			    Elee2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='views_slideshow_cycle_div_promotions-flex_promo_0']/div/div[2]/span/a")));
	     	  
	 }
	  
	   
	 @AfterMethod
	   public void close(){
	   	   	quit();
	   	   	

	  }
	 
	 
	
}