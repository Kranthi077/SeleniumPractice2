package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LatestDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("wedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(3000);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		for(int i=0; i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.xpath("//input[@value=\"Done\"]")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.id("divpaxinfo")).getText();
		System.out.println(text);
		
		//Hard assertions
		// execution ends - If the assertion fails. the lines of code following it will not be executed and the execution ends
		Assert.assertEquals(text, "6 Adult"); 
		
		driver.close();
		
		/*
		 * driver.findElement(By.id("hrefIncAdt")).click();
		 * driver.findElement(By.id("hrefIncAdt")).click();
		 * driver.findElement(By.id("hrefIncAdt")).click();
		 * driver.findElement(By.id("hrefIncAdt")).click();
		 * driver.findElement(By.id("hrefIncAdt")).click();
		 */
	}

}
