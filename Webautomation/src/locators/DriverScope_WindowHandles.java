package locators;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DriverScope_WindowHandles {
	public static void main (String args[]) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32_111\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println("Total Links in the page : "+driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver = driver.findElement(By.cssSelector("footer.clearfix.simple"));
		
		System.out.println("Links in footer section : "+footerDriver.findElements(By.tagName("a")).size());
		
		WebElement partInFooter = driver.findElement(By.className("footer-site-links"));
		System.out.println(partInFooter.findElements(By.tagName("a")).size());
		for(int i=1 ; i<partInFooter.findElements(By.tagName("a")).size(); i++)
		{
			String clickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			driver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);
		}
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it =windows.iterator();
			
		while (it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}

}
