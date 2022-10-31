package alertsHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().window().maximize();
		// d.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		d.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		// get alert text
		String alertText = d.switchTo().alert().getText();
		System.out.println(alertText);
		// For accepting alerts
		d.switchTo().alert().accept();
		Thread.sleep(3000);
		d.findElement(By.xpath("//input[@value=\"Confirm\"]")).click();
		Thread.sleep(3000);
		// accept second type of alert
		d.switchTo().alert().accept();
		Thread.sleep(3000);
		d.findElement(By.xpath("//input[@value=\"Confirm\"]")).click();
		Thread.sleep(3000);
		//dismiss alert
		alertText = d.switchTo().alert().getText();
		System.out.println(alertText);
		d.switchTo().alert().dismiss();
		d.close();
	}

}
