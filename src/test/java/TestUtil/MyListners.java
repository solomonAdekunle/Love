package TestUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MyListners extends AbstractWebDriverEventListener{
	
	
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Hello");
	}

 

}
