package actionsClassDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// actions class object creation
		Actions a = new Actions(d);
		WebElement signIn = d.findElement(By.id("nav-link-accountList-nav-line-1"));
		WebElement searchBar = d.findElement(By.id("twotabsearchtextbox"));
		// composite actions
		// a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("mobiles").keyDown(Keys.ENTER).build().perform();
		a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("mobiles").doubleClick().keyDown(Keys.ENTER)
				.build().perform();
		Thread.sleep(5000);
		int i = 0;
		while (i < 1000) {
			a.keyDown(Keys.TAB).build().perform();
			i++;
			Thread.sleep(1000);
		}

		Thread.sleep(5000);
		a.moveToElement(signIn).contextClick().build().perform();
		Thread.sleep(5000);
		d.close();

	}

}
