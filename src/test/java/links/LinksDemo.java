package links;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> links = d.findElements(By.tagName("a"));
		int size = links.size();
		System.out.println(size);
		/*
		 * for (WebElement webElement : links) {
		 * System.out.println(webElement.getAttribute("href")); }
		 */

		WebElement footer = d.findElement(By.id("gf-BIG"));

		List<WebElement> footerLinks = footer.findElements(By.tagName("a"));

		int size1 = footerLinks.size();
		System.out.println(size1);

		for (WebElement webElement : footerLinks) {
			System.out.println(webElement.getAttribute("href"));
		}

	}

}
