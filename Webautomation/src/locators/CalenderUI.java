package locators;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderUI {
	public static void main (String args[]) throws InterruptedException {
//		System.setProperty("webdriver.edge.driver", "D:\\Automation\\edge\\edgedriver_win64\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
				
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.path2usa.com/travel-companion/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1300)", "");
		Thread.sleep(5000);
		
		
		
		
		WebDriverWait webWait = new WebDriverWait(driver,Duration.ofSeconds(5));
		webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='form-field-travel_comp_date']")));
		
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		
		String months = driver.findElement(By.cssSelector(".cur-month")).getText();
		System.out.println(months);
		
		while(!driver.findElement(By.cssSelector(".cur-month")).getText().contains("May"))
		{
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".flatpickr-day"));
		
		int count = driver.findElements(By.cssSelector(".flatpickr-day")).size();
		for(int i=0; i<count; i++) {
			String datesText = driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText();
			System.out.println(datesText);
			
			if(datesText.equalsIgnoreCase("20")) {
				driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
				break;
			}
		}
		
	}

}
