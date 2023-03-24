package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	public static void main (String args[]) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32_111\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String option = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(option);
		
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(dropDown);
		s.selectByVisibleText(option);
		
		driver.findElement(By.name("enter-name")).sendKeys(option);
		
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		if(alertText.contains(option)) {
			System.out.println("Success");
		}
		else {
			System.out.println("Failed");
		}
		driver.switchTo().alert().accept();
		
			
		}
	}



