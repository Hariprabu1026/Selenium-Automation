package locators;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class OpenConnection_BrokenLinkCheck {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
			
			System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			//options.setAcceptInsecureCerts(true);
			options.addArguments("start-maximized");
			//options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			ChromeDriver driver = new ChromeDriver(options);
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			
			List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li'] /a"));
						
			for(WebElement link : links) {
				String linkText = link.getAttribute("href");
				String textLink = link.getText();
				HttpURLConnection conn = (HttpURLConnection)new URL(linkText).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int repCode = conn.getResponseCode();
				System.out.println(textLink + repCode);
				if(repCode > 400)
				{
					
				}
			}

	}

}
