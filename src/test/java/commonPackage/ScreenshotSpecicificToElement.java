package commonPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotSpecicificToElement {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		d.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(5000);

		WebElement name = d.findElement(By.xpath("//div[@class='form-group']/input[@name='name']"));

		name.sendKeys("sample Text");

		File src = name.getScreenshotAs(OutputType.FILE);
		File dest = new File("sampleScreenShot.png");
		FileUtils.copyFile(src, dest);

		Thread.sleep(5000);

		WebElement name1 = d.findElement(By.xpath("(//div[@class='form-group'])[1]"));
		File src1 = name1.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("sampleScreenShot1.png");
		FileUtils.copyFile(src1, dest1);
		d.close();

	}

}
