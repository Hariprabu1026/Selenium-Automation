package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class IFrame {
	public static void main (String args[]) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32_111\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions a = new Actions(driver);
		a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		Assert.assertEquals(driver.findElement(By.id("droppable")).getText(), "Dropped!");
		System.out.println(driver.findElement(By.xpath("(//div/p)[2]")).isDisplayed());
		Assert.assertTrue(true);
		
	}

}
