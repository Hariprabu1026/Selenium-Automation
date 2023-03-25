package locators;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		System.out.println(alert.getText());
		Assert.assertEquals(alertMsg, "Hello , share this practice page and share your knowledge");
		Assert.assertTrue(true);
		alert.accept();

		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		Thread.sleep(1000);
		alert.dismiss();
		
		

	}

}
