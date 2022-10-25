package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("wedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//sysntax
		WebElement currency = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select dropdown = new Select(currency);
		
		dropdown.selectByIndex(3);
		Thread.sleep(3000);
		// String selection = dropdown.getFirstSelectedOption().getText();
		String selection = dropdown.getFirstSelectedOption().getAttribute("value");
		System.out.println(selection);
		Thread.sleep(3000);
		dropdown.selectByValue("AED");
		Thread.sleep(3000);
		dropdown.selectByVisibleText("Select");
		selection = dropdown.getFirstSelectedOption().getText();
		System.out.println(selection);
		Thread.sleep(3000);
		driver.close();

	}

}
