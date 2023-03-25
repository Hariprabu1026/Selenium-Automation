package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdowns {
	public static void main (String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//	//a[@value='MAA']
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(2000);
		String departureCity = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText();
		System.out.println(departureCity);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CJB']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div/div/table/tbody/tr[3]/td[4]/a)[1]")).click();
		//  (//div/table/tbody/tr[3]/td[4]/a)[2] - date xpath
		// (//div/div/table/tbody/tr[3]/td[4]/a)[1] - select depart date
		// (//div/div/table/tbody/tr[3]/td[4]/a)[2] - select return date
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		driver.findElement(By.xpath("(//div/div/table/tbody/tr[3]/td[4]/a)[2]")).click();
		
		driver.quit();
		
		
		
		
	}

}
