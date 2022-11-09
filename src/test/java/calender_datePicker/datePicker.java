package calender_datePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class datePicker {

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver d = new ChromeDriver(co);
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		d.manage().window().maximize();
		d.get("https://www.redbus.in/");

		d.findElement(By.id("src")).sendKeys("hyderabad");
		d.findElement(By.xpath("//ul[contains(@class,'homeSearch')]//li[text()='Hyderabad']")).click();
		d.findElement(By.id("dest")).sendKeys("Chennai");
		d.findElement(By.xpath("//ul[contains(@class,'homeSearch')]//li[text()='Chennai']")).click();

		String currentMonth = d.findElement(By.className("monthTitle")).getText();
		// !false = true
		// !true= false
		while (!currentMonth.equalsIgnoreCase("Jun 2023")) {
			d.findElement(By.className("next")).click();
			currentMonth = d.findElement(By.className("monthTitle")).getText();
		}

		List<WebElement> days = d.findElements(By.className("day"));

		for (int i = 0; i < days.size(); i++) {
			if (days.get(i).getText().equals("23")) {
				days.get(i).click();
				break;
			}
		}

	}

}
