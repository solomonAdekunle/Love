package Casino;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestUtil.Constant;
import TestUtil.TestDataProvider;

public class SearchGamesTest extends TestBase {
	
	
	
	
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
		@Test(dataProviderClass=TestDataProvider.class,dataProvider="CasinoDataProvider")
		public void SearchGamesTest(Hashtable<String,String>table) throws IOException, InterruptedException{
			validateRunmodes("SearchGamesTest", Constant.SECOND_SUITE, table.get(Constant.RUNMODE_COL));
			doDefaultLogin(table.get("Browser"));
			//navigate("testsiteURL");
			Thread.sleep(2000);
			click("hpGamesSearchIcon_Selector");
			Thread.sleep(2000L);
			input("hpGamesSearchTextBox_xpath",table.get(Constant.GAMES_COL));
			d.findElement(By.xpath("//input[@class='search_field']")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			// Verifying if the game is displayed.
			boolean result=isElementPresent("game_title_Selector");
			//click("game_title_Selector");
		    String actualResult=null;
		    if(result)
				actualResult="SUCCESS";
			else
				actualResult="FAILURE";
		    Assert.assertNotSame(table.get(Constant.EXPECTEDRESULT_COL), actualResult);
		   
		    /*if(isElementPresent("game_title_Selector"))
				click("game_title_Selector");
			else
				System.out.println(false);
					*/
			

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
//}