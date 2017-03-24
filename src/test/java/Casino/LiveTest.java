package Casino;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TestUtil.TestDataProvider;
import Base.TestBase;

public class LiveTest extends TestBase {

	@BeforeTest
	public void initLogs() {
		initLogs(this.getClass());
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "CasinoDataProvider")
	public void LiveTest(Hashtable<String, String> table) throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		navigate("testsiteURL");
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000L);
		click("hpLiveTab_Selector");
		Thread.sleep(2000L);
		click("live_winnerblockWinners_xpath");
		Thread.sleep(2000L);
		d.navigate().back();
		Thread.sleep(6000L);
		click("live_RouletteExpPremium_Selector");

	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "CasinoDataProvider")
	public void LiveFooterTest(Hashtable<String, String> table) throws IOException, InterruptedException {
		test = extent.startTest("LiveFooterTest");
		openBrowser(prop.getProperty("browserType"));
		navigate("testsiteURL");
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(1000);
		click("hpLiveTab_Selector");
		Thread.sleep(3000L);
		click("live_footerGettingStarted_xpath");
		Thread.sleep(2000L);
		d.navigate().back();
		Thread.sleep(3000L);
		click("live_footerTvPresenter_Selector");
		Thread.sleep(1000L);
		Assert.assertTrue(isElementPresent("Prenter_xpath"),
				"if Element is present then user has navigated to the right page");
		d.navigate().back();
		Thread.sleep(2000L);
		click("live_footerVideo_Selector");
		Thread.sleep(2000L);
		d.navigate().back();
		Thread.sleep(2000L);
		click("live_footerVIP_Selector");
		Thread.sleep(2000L);
		Boolean header = isElementPresent("Lobby_Selector");
		System.out.println(header);
		d.navigate().back();
		Thread.sleep(2000L);
		click("live_footerWinners_Selector");
		Thread.sleep(2000L);
		Boolean Header = isElementPresent("Winners_xpath");
		System.out.println(Header);
		d.navigate().back();
		Thread.sleep(2000L);
		click("live_footerAboutUS_Selector");
		Thread.sleep(500L);
		String Element = getText("AboutSupercasino_xpath");
		if (Element.equals("Lobby"))
			// System.out.println(Element);
			test.log(LogStatus.PASS, Element);
		else
			// System.out.println(false);
			test.log(LogStatus.FAIL, "User has navigated to the wrong page");
		d.navigate().back();
		Thread.sleep(1000L);
		click("live_footerContactUS_Selector");
		Thread.sleep(2000L);
		String Text = getText("ContactUS_xpath");
		if (isElementPresent("ContactUS_xpath"))
			// System.out.println(Text);
			test.log(LogStatus.PASS, Text);
		else
			// System.out.println(false);
			test.log(LogStatus.FAIL, "User has navigated to the wrong page");
		d.navigate().back();
		Thread.sleep(1000L);
		click("live_footerEnjoyResp_Selector");
		Thread.sleep(1000L);
		String Text1 = getText("EnjoyResponsibly_xpath");
		if (isElementPresent("EnjoyResponsibly_xpath"))
			// System.out.println(Text1);
			test.log(LogStatus.PASS, Text1);
		else
			// System.out.println(false);
			test.log(LogStatus.FAIL, "User has navigated to the wrong page");

		d.navigate().back();
		Thread.sleep(1000L);
		click("live_footerHelp&FAQs_Selector");
		Thread.sleep(1000L);
		String Text2 = getText("FAQs_xpath");
		if (isElementPresent("FAQs_xpath"))
			// System.out.println(Text2);
			test.log(LogStatus.PASS, Text2);
		else
			// System.out.println(false);
			test.log(LogStatus.FAIL, "User has navigated to the wrong page");
		d.navigate().back();
		Thread.sleep(1000L);
		click("live_footerPrivacyPolicy_Selector");
		Thread.sleep(1000L);
		String Text3 = getText("FAQs_xpath");
		if (isElementPresent("FAQs_xpath"))
			// System.out.println(Text3);
			test.log(LogStatus.PASS, Text3);
		else
			// System.out.println(false);
			test.log(LogStatus.FAIL, "User has navigated to the wrong page");
		d.navigate().back();
		Thread.sleep(1000L);
		click("live_footerTerms_Selector");
		String Text4 = getText("supercasinoTerms&conditions_xpath");
		Thread.sleep(1000L);
		if (isElementPresent("supercasinoTerms&conditions_xpath"))
			// System.out.println(Text4);
			test.log(LogStatus.PASS, Text4);
		else
			// System.out.println(false);
			test.log(LogStatus.FAIL, "User has navigated to the wrong page");
		d.navigate().back();
		Thread.sleep(200L);
		click("live_footerFaceBookIcon_Selector");
		Thread.sleep(200L);
		click("live_footerTwitterIcon_Selector");
		Thread.sleep(200L);
		click("live_footerNetPlayTv_Selector");
		Thread.sleep(200L);
		click("live_footer18+Icon_Selector");
		d.navigate().back();
		Thread.sleep(2000L);
		click("live_footerGamCare_Seletor");

	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "CasinoDataProvider")
	public void LiveForgottenDetailsTest(Hashtable<String, String> table) throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		navigate("testsiteURL");
		Thread.sleep(5000L);
		click("hpLiveTab_Selector");
		Thread.sleep(2000L);
		click("hpForgottenDetails_xpath");
		Thread.sleep(1000L);
		String T = getText("forgottenDetails_xpath");
		if (isElementPresent("forgottenDetails_xpath"))
			Assert.assertTrue(true);
		System.out.println(T);
		d.navigate().back();

	}

	@AfterMethod
	public void close() {
		quit();
	}
}
