package locators;

import java.util.Arrays;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PopupBlock {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.setAcceptInsecureCerts(true);
				options.addArguments("start-maximized");
				options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
				ChromeDriver driver = new ChromeDriver(options);
				
				driver.get("https://www.webroot.com/services/popuptester1.htm");
	}

}
