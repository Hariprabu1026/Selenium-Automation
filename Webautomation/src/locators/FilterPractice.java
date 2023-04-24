package locators;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterPractice {
	@Test
	public void filter()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32_111\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("in");
		
		List<WebElement> veggies = driver.findElements(By.id("//tbody/tr/td[1]"));
		
		
		
		
		
		
		
//		List<WebElement> filteredVeggie = veggies.stream().filter(veggie->veggie.getText().contains("Rice"))
//		.collect(Collectors.toList());
//		Assert.assertEquals(veggies.size(), filteredVeggie.size());
		
		driver.quit();
		
	}

}
