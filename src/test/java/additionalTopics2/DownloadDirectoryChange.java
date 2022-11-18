package additionalTopics2;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadDirectoryChange {

	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		Map<String, Object> path = new HashMap<String, Object>();
		path.put("download.default_directory", "C:\\Users\\Aishwarya Jangampeta\\Kranthi\\Selenium-Notes");
		co.setExperimentalOption("prefs", path);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(co); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();

	}

}
