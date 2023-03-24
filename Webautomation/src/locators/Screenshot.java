package locators;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Screenshot {
	public static void main (String args[]) throws IOException {
		
	System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	//options.setAcceptInsecureCerts(true);
	options.addArguments("start-maximized");
	//options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
	ChromeDriver driver = new ChromeDriver(options);
	//test
	driver.get("https://www.google.com/");
	
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("D://screenshot.png"));
	
	
	//Test
	}
}
