package Casino;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestUtil.TestDataProvider;

public class GameInfoPageTest  extends TestBase{
	
	
	
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());

}
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
	 public void GameInfoTest(Hashtable<String,String>table) throws InterruptedException{
		openBrowser(prop.getProperty("browserType"));
		  //navigate("testsiteURL");
		  doDefaultLogin(prop.getProperty("defaultUsername"));
		 WebDriverWait wait= new WebDriverWait(d,20);
		 //Wait for Deposit Button to pressent.
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#account_box a.deposit")));
		  click("live_RouletteExpPremiumGameinfo_Selector");
		   Thread.sleep(4000L);
		  click("gameinfoRouletteExpressPremiumPlayNow_Selector");
		  d.quit();
		  
		  
}
	 @AfterMethod
		public void close(){
//			if(extent!=null){
//				extent.endTest(test);
//				extent.flush();
//			}
			quit();
		}
}