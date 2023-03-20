package test.java;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageFilter {
	@Test
	public void filterTable() throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		List<WebElement> actualList = driver.findElements(By.xpath("//tr/td[1]"));

		List<WebElement> filteredList = actualList.stream().filter(veggies -> veggies.getText().contains("Rice"))
				.collect(Collectors.toList());

		Assert.assertEquals(actualList.size(), filteredList.size());

	}
}
