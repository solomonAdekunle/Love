package CORE_SUITE;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Rough {

	public static void main(String[] args) throws InterruptedException {
		File file= new File("H:\\IEDriver\\chromedriver.exe");
		// File file= new File("C:\\Users\\solomon.adekunle\\OneDrive for Business\\workspace\\BetVernons\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("no-sandbox");
			WebDriver d= new ChromeDriver();
		EventFiringWebDriver dr= new EventFiringWebDriver(d);
		d.get("https://www.release.supercasino.com/");
		Thread.sleep(1000L);
		d.findElement(By.xpath("//*[@id='username']")).sendKeys("testquick");
		d.findElement(By.xpath("//*[@id='password']")).sendKeys("bola123");
		d.findElement(By.xpath("//*[@id='playtech_login_submit']")).click();
		Thread.sleep(2000L);
		String xpath_menu="//*[@id='account_box']/ul[1]/li[1]";
		String xpath_submenu="//*[@id='account_box']/ul[1]/li[4]/a";
		WebElement Menu=d.findElement(By.xpath(xpath_menu));
		WebElement SubMenu=d.findElement(By.xpath(xpath_submenu));
		Actions sol= new Actions(d);
		sol.moveToElement(Menu).build().perform();
		SubMenu.click();
		
		
	}

	}


