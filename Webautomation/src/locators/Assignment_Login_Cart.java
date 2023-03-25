package locators;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_Login_Cart {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait webWait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		
		
		
		String usernamePasswordSource = driver.findElement(By.cssSelector("p.text-center.text-white")).getText();
		String[] split1 = usernamePasswordSource.split("is");
		System.out.println(split1[0]);
		System.out.println(split1[1]);
		System.out.println(split1[2]);
		
		String password = StringUtils.chop(split1[2]); //to remove the last character of a string 
		
		
		String[] split2 = split1[1].split("and");
		
		System.out.println(split2[0]);

		String finalUsername = split2[0].trim();
		String finalPassword = password.trim();
		
		System.out.println("The Actual Username is "+finalUsername);
		System.out.println("The Actual Password is "+finalPassword);
		
		driver.findElement(By.id("username")).sendKeys(finalUsername);
		driver.findElement(By.id("password")).sendKeys(finalPassword);
		
		driver.findElement(By.xpath("(//span[@class='radiotextsty'])[2]")).click();
		
		
		
		webWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-success")));
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		
		WebElement dropDown1 = driver.findElement(By.cssSelector("select.form-control"));
		
		Select dropDown = new Select(dropDown1);
		dropDown.selectByValue("consult");
		
		driver.findElement(By.xpath("//input[@name='terms']")).click();
		
		driver.findElement(By.id("signInBtn")).click();
		
		List<WebElement> addToCart = driver.findElements(By.cssSelector("button.btn.btn-info"));
		for(int i = 0 ; i<addToCart.size() ; i++) {
			driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();
		}
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		
//		List<WebElement> removeFromCart = driver.findElements(By.cssSelector("button.btn.btn-danger"));
//		for(int j=0 ; j<=removeFromCart.size() ; j++) {
//		
//			driver.findElements(By.cssSelector("button.btn.btn-danger")).get(j).click();
//			System.out.println("Items removed from cart successfully");

			}
		}
		

