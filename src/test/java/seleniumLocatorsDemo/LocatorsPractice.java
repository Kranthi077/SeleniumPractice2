package seleniumLocatorsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("wedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("inputUsername")).sendKeys("Demo");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@value='rmbrUsername']")).click();
		driver.findElement(By.className("submit")).click();
		Thread.sleep(3000); // this sleep is because selenium execution is fast but browser took some time
							// to load the element below. So code will fail if wait is not given
		String text = driver.findElement(By.xpath("//div[@class=\"login-container\"]/p")).getText();
		System.out.println(text);
		Thread.sleep(3000);
		driver.close();

	}

}
