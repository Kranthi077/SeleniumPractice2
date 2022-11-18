package additionalTopics;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeMultipleWindow_Tab {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(5000);

		// d.switchTo().newWindow(WindowType.TAB);
		d.switchTo().newWindow(WindowType.WINDOW);
		Set<String> tabs = d.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		d.switchTo().window(childWindowId);
		d.get("https://rahulshettyacademy.com/");
		String text = d.findElement(By.xpath("(//div[@id=\"carousel-example-generic\"]//span)[1]")).getText();
		Thread.sleep(5000);
		d.switchTo().window(parentWindowId);
		d.findElement(By.name("name")).sendKeys(text);
		Thread.sleep(5000);
		d.quit();

	}

}
