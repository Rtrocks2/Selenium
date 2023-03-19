package test.java;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SortStream {

	@Test
	public void sortTable() throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//span[@class='sort-icon sort-descending']")).click();
		Thread.sleep(5000);
		List<WebElement> grid = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> OrignalList = grid.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = OrignalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(OrignalList.equals(sortedList));
	}
}
