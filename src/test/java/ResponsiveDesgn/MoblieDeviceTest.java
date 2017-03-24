package ResponsiveDesgn;

import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class MoblieDeviceTest  extends TestBase{
	@BeforeTest
	public void initLogs (){
		initLogs(this.getClass());

}
	
	
	@Test
	public void Iphone4(){
		openBrowser(prop.getProperty("browserType"));
		Dimension k = new Dimension(320,580); //Smalltouch devices such as iPhone, Android and Windows phones
	     d.manage().window().setSize(k);
	     System.out.println(d.manage().window().getSize()); 
	    navigate("testsiteURL");
	    click("hp_footerAboutUS_xpath");
	}
}