package my.projects;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class AppTest extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.google.com.vn/");
		selenium.start();
	}

	@Test
	public void testDummy() throws Exception {
		selenium.open("/");
		selenium.type("id=gbqfq", "selenium");
		selenium.click("id=gbqfb");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("link=Selenium - Web Browser Automation")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("link=Selenium - Web Browser Automation");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("What is Selenium?"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
