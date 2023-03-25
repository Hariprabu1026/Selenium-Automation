package locators;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class addToCard_Practice2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32_111\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(5000);

		String[] itemsNeeded = { "Cucumber", "Beetroot", "Brocolli", "Carrot" };
		addItems(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("driver.findElement(By.xpath(\"//button[text()='PROCEED TO CHECKOUT']\"))")).getText(),"PROCEED TO CHECKOUT");
		driver.findElement(By.xpath("driver.findElement(By.xpath(\"//button[text()='PROCEED TO CHECKOUT']\"))")).click();
		
		
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> vegetableNames = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < vegetableNames.size(); i++) {
			String[] vegNames = vegetableNames.get(i).getText().split("-");
			String actualVegNames = vegNames[0].trim();
			System.out.println(actualVegNames);

			// Changing the itemNeeded array to Array List
			List itemNeededList = Arrays.asList(itemsNeeded);
			if (itemNeededList.contains(actualVegNames)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}

		}

	}

}
