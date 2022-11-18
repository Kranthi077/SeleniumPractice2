package additionalTopics2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Additional {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		d.get("https://www.redbus.in/");
		Thread.sleep(10000);
		//d.manage().deleteAllCookies();
		//d.manage().deleteAllCookies();
	}

}
