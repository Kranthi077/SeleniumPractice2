package links;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class OpenLinksInNewTab {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement footer = d.findElement(By.id("gf-BIG"));
		List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
		int size1 = footerLinks.size();
		System.out.println(size1);

		for (int i = 0; i < footerLinks.size(); i++) {

			String openLinkInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			footerLinks.get(i).sendKeys(openLinkInNewTab);
			Thread.sleep(1000);
		}

		Set<String> openedTabs = d.getWindowHandles();
		Iterator<String> it = openedTabs.iterator();

		while (it.hasNext()) {

			d.switchTo().window(it.next());

			System.out.println(d.getTitle() + "--->" + d.getCurrentUrl());
		}

		d.quit();
	}

}
