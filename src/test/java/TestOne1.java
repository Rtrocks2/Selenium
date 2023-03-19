package test.java;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestOne1 {

	@Test
	public void searchPage() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.google.com");

	}

}
