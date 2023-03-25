package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assignment2 {
	public static void main (String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
																							
		driver.get("https://rahulshettyacademy.com/angularpractice");
		driver.findElement(By.name("name")).sendKeys("TestPrabu");
		driver.findElement(By.name("email")).sendKeys("test0101@testmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("P@ssw0rd");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement genderDd = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select select = new Select(genderDd);
		
		List <WebElement> ddOptions = driver.findElements(By.xpath("//select/option"));
		
		for(WebElement ddOption : ddOptions)
		{
			if(ddOption.getText().equalsIgnoreCase("Female"))
			{
				ddOption.click();
				System.out.println(ddOption.getText() + " selected");
				Assert.assertTrue(ddOption.isSelected());
			}
			
		}
		driver.findElement(By.id("inlineRadio1")).click();
		Assert.assertTrue(driver.findElement(By.id("inlineRadio1")).isSelected());
		driver.findElement(By.name("bday")).sendKeys("05052023");
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		Thread.sleep(1000);
	
		System.out.println(driver.findElement(By.xpath("(//form-comp/div/div)[2]")).getText());
//		Assert.assertEquals(driver.findElement(By.xpath("(//form-comp/div/div)[2]")).getText(), "×\r\n"
//				+ "Success! The Form has been submitted successfully!.");
		
		
		driver.quit();
		
	}
	
}
