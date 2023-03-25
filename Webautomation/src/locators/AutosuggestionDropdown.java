package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutosuggestionDropdown {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.findElement(By.id("autosuggest")).sendKeys("In");
		Thread.sleep(3000);

		// this is a list of array which will return the options in the dropdown
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		// Scanning all the options and matching with India
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		List<WebElement> checkBoxes = driver
				.findElements(By.cssSelector("div[class='row1 padding-bottom-3 home-dis-checkboxes'] label"));

		for (WebElement checkBox : checkBoxes) {
			if (checkBox.getText().equalsIgnoreCase("Student")) {
				System.out.println(checkBox.isSelected());
				Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).isSelected());
				checkBox.click();
				System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).isSelected());
				Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).isSelected());
			}
		}

		int checkBoxCount = driver
				.findElements(By.cssSelector("div[class='row1 padding-bottom-3 home-dis-checkboxes'] input")).size();
		System.out.println(checkBoxCount);

		Actions toolTipMsg = new Actions(driver);
		toolTipMsg.moveToElement(driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"))).perform();
		String studentToolTipMsg = driver
				.findElement(
						By.xpath("//div[@id='StudentDiv'] //a/span[@class='search-offer-tooltip mobile-tooltip-left']"))
				.getText();
		System.out.println(studentToolTipMsg);
		String Expected = "Applicable for all students above the age of 12 years studying with a bonafide school/university. Limited inventory available. Valid photo ID and educational institute I-card need to be presented for verification at check-in. Bookings under this offer are refundable. Conditions apply.";
		Assert.assertEquals(studentToolTipMsg, Expected);

		driver.findElement(By.linkText("Special Assistance")).click();
		Thread.sleep(3000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(4000);

		driver.quit();
	}
}
