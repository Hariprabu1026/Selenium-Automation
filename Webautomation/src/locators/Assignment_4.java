package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment_4 {
	public static void main (String args[]) throws InterruptedException {
//		System.setProperty("webdriver.edge.driver", "D:\\Automation\\edge\\edgedriver_win64\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--headless");
		ChromeDriver driver = new ChromeDriver(options);
		
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> rowsCount = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		System.out.println("Rows Count : "+rowsCount.size());
		
		List<WebElement> columnCount = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th"));
		System.out.println("Columns count : "+columnCount.size());
		
		List<WebElement> tableText = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
		for(int i=0 ; i<tableText.size() ; i++)
		{
			String tableTexts = tableText.get(i).getText();
			if(tableTexts.contains("Learn SQL in Practical + Database Testing from Scratch"))
			{
				System.out.println(tableTexts);
			}
		}
		
	}

}
