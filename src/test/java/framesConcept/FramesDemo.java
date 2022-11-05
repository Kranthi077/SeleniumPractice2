package framesConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FramesDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		d.manage().window().maximize();
		d.get("https://jqueryui.com/droppable/");
		// by id
		// d.switchTo().frame(0);

		// by name or id
		// d.switchTo().frame("iframe");

		d.switchTo().frame(d.findElement(By.className("demo-frame")));
		Assert.assertTrue(d.findElement(By.id("draggable")).isDisplayed());
		Actions a = new Actions(d);
		WebElement src = d.findElement(By.id("draggable"));
		WebElement dest = d.findElement(By.id("droppable"));
		a.dragAndDrop(src, dest).build().perform();
		Thread.sleep(5000);
		d.switchTo().defaultContent();
		System.out.println(d.findElement(By.className("entry-title")).getText());
		d.close();
	}

}
