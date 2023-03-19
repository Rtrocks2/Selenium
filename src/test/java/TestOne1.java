package test.java;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import junit.framework.Assert;

public class TestOne1 {

	@SuppressWarnings("deprecation")
	@Test
	public void searchPage() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement footerList = driver.findElement(By.xpath("//div[@class='navFooterLinkCol navAccessibility']"));

		System.out.println("Number of links presernt:" + footerList.findElements(By.tagName("a")).size());

		int actualSize = footerList.findElements(By.tagName("a")).size();
		int reqSize = 4;
		Assert.assertEquals(actualSize, reqSize);

		for (int i = 0; i < footerList.findElements(By.tagName("a")).size(); i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerList.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		}
		Set<String> winHand = driver.getWindowHandles();
		Iterator<String> it = winHand.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
