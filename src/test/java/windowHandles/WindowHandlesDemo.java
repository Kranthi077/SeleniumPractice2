package windowHandles;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlesDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/loginpagePractise/#");
		d.findElement(By.className("blinkingText")).click();
		Set<String> windows = d.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentTab = it.next();
		String childTab = it.next();
		d.switchTo().window(childTab);
		String emailString = d.findElement(By.xpath("//p[contains(@class,'im-para')][2]")).getText();
		String email = emailString.split(" ")[4].trim();
		System.out.println(email);
		d.switchTo().window(parentTab);
		d.findElement(By.name("username")).sendKeys(email);
		Thread.sleep(5000);
		d.quit();

	}

}
