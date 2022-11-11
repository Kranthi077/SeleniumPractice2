package additionalTopics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ScrollByDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,500)"); // when scripts are run in headless mode. Actions on the elements
													// which doesn't appear on the screen without scrolling might get
													// failed
		Thread.sleep(5000);
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=200");

		List<WebElement> lastColumn = d.findElements(By.xpath("(//table[@id=\"product\"])[2]//td[4]"));

		int sum = 0;
		for (WebElement webElement : lastColumn) {
			String text = webElement.getText();
			int num = Integer.parseInt(text);
			sum = sum + num;
		}
		System.out.println(sum);

		String sum1 = d.findElement(By.cssSelector("div.totalAmount")).getText().split(" ")[3].trim();
		int actualSum = Integer.parseInt(sum1);

		Assert.assertEquals(sum, actualSum);

		d.close();
	}

}
