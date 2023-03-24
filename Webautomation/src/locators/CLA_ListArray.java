package locators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CLA_ListArray {
	public static void main (String args[]) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		driver.get("https://cla-cooperqa.loanhd.com/");
		driver.findElement(By.cssSelector("a.show-popup-link.pull-right")).click();
		driver.findElement(By.id("txtUserName_I")).sendKeys("HariCooperInvestor");
		driver.findElement(By.id("txtPassword_I")).sendKeys("P@ssw0rd");
		driver.findElement(By.xpath("(//span[@class='dx-vam'])[1]")).click();
		System.out.println(driver.findElement(By.id("MainContent_lblTextblock")).getText());
		
		driver.findElement(By.cssSelector("i.navIconicon-expand")).click();
		driver.findElement(By.xpath("//a[@data-original-title='Register / Lock Loan']")).click();
		driver.findElement(By.id("MainContent_PageControlLoan_cboBidTapeSeller_I")).click();
		String selectName = "HariCooperSellerQA";
		
		//Array
		List<WebElement> sellerDropDown =  driver.findElements(By.id("MainContent_PageControlLoan_cboBidTapeSeller_DDD_L_LBT"));
		for (int i=0; i<sellerDropDown.size(); i++) {
			String sellerNames = sellerDropDown.get(i).getText();
			System.out.println(sellerNames);
			if(sellerNames.equalsIgnoreCase(selectName)) {
				driver.findElements(By.id("MainContent_PageControlLoan_cboBidTapeSeller_DDD_L_LBT")).get(i).click();
				break;
			}
		}
		
		
	}

}
