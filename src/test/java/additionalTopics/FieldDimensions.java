package additionalTopics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FieldDimensions {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(5000);
		WebElement name = d.findElement(By.name("name"));
		Thread.sleep(5000);
		int width = name.getRect().getDimension().getWidth();
		int height = name.getRect().getDimension().getHeight();
		System.out.println(width);
		System.out.println(height);
		d.close();
	}

}
