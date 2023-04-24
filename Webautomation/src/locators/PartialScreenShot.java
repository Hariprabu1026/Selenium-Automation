package locators;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class PartialScreenShot {
	@Test
	public void screenshot() throws IOException
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32_111\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("start-maximized");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameBox = driver.findElement(By.cssSelector("[name='name']"));
		nameBox.sendKeys("Automation Course");
		
		File file = nameBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("namebox.png"));
		
		System.out.println(nameBox.getRect().getDimension().getHeight());
		System.out.println(nameBox.getRect().getDimension().getWidth());
		
		
	}

}
