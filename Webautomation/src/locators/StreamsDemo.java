package locators;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class StreamsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32_111\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized");
		ChromeDriver driver = new ChromeDriver(options);

		// driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.linkText("Top Deals")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);

		driver.findElement(By.cssSelector("span.sort-icon.sort-descending")).click();
		
//		for(int i=0 ; i<vegNames.size() ; i++)
//		{
//			String vegName = vegNames.get(i).getText();
//			System.out.println(vegName);
//			if(vegName.contains("Beans")) {
//				
//				
//			}
//		}
		//List<String> originalNames = vegNames.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sorting the originalNames
//		List<String> sortedNames = originalNames.stream().sorted().collect(Collectors.toList());

		//Assert.assertTrue(originalNames.equals(sortedNames));
		List<String> price;
		// Get p rice of each vegetables
		do {
			List<WebElement> vegNames = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			price = vegNames.stream().filter(s -> s.getText().contains("Strawberry")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();

			}
		} while (price.size() < 1);

	}

	private static String getPriceVeggie(WebElement s) {

		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
