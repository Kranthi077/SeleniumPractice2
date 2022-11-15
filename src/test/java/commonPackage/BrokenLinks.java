package commonPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import io.opentelemetry.api.trace.StatusCode;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(5000);
		WebElement footer = d.findElement(By.id("gf-BIG"));

		SoftAssert a = new SoftAssert();
		List<WebElement> urlLinks = footer.findElements(By.tagName("a"));

		int i = 0;
		for (WebElement link : urlLinks) {
			String url = link.getAttribute("href");

			URL linkObj = new URL(url);

			HttpURLConnection connection = (HttpURLConnection) linkObj.openConnection();

			connection.setRequestMethod("HEAD");
			connection.connect();
			int StatusCode = connection.getResponseCode();
			i++;
			boolean linkStatus = true;

			if (StatusCode > 400) {

				linkStatus = false;
			}
			// Assert.assertTrue(linkStatus); //hard assert;
			// a.assertTrue(linkStatus);
			a.assertTrue(linkStatus,
					"Link is Broken " + url + "  broken because of the code " + StatusCode + " Link no.: " + i);

			//System.out.println(StatusCode + "--" + url);
		}

		d.close();

		a.assertAll();

	}

}
