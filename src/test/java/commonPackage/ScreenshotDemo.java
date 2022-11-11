package commonPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(5000);

		TakesScreenshot ts = (TakesScreenshot) d;
		/*
		 * File source = ts.getScreenshotAs(OutputType.FILE); File destination = new
		 * File("ScreenshotDemo.png"); FileUtils.copyFile(source, destination);
		 * 
		 * File destination1 = new File("ScreenshotDemo.jpg");
		 * FileUtils.copyFile(source, destination1);
		 * 
		 * File source1 =
		 * d.findElement(By.cssSelector("div.tableFixHead")).getScreenshotAs(OutputType.
		 * FILE); File destination2 = new File("Table.png"); FileUtils.copyFile(source1,
		 * destination2);
		 */

		File src = d.findElement(By.id("radio-btn-example")).getScreenshotAs(OutputType.FILE);
		File destination2 = new File("Table.png");
		FileUtils.copyFile(src, destination2);

		d.close();

	}

}
