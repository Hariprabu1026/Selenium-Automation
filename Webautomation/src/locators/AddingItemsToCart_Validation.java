package locators;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingItemsToCart_Validation {
	public static void main (String args[])
	{
			System.setProperty("webdriver.chrome.driver",
					"D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			
			String[] itemsNeeded = {"Cucumber","Brocolli"};
			int j=0;
			
			List<WebElement> vegItems = driver.findElements(By.xpath("//h4[@class='product-name']"));
			for(int i=0; i<vegItems.size(); i++)
			{
				String[] name = vegItems.get(i).getText().split("-");
				String actualName = name[0].trim();
				
//				System.out.println(name);
				
				List itemsNeededList = Arrays.asList(itemsNeeded);
				
				if(itemsNeededList.contains(actualName))
				{
					j++;
					driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
					if(j==3)
					{
						break;
					}
				}
			}
	}

}
