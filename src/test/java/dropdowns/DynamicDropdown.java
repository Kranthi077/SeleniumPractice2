package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("wedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); /// from dropdown
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='GOI']")).click(); // select goa from options
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click(); // using indexes
		
		//below xpath is written using parent child relationship
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value='HYD']")).click();
		
		

	}

}
