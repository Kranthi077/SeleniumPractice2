package seleniumLocatorsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StringFunctionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("wedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		String password = getPassword(driver);
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("inputUsername")).sendKeys("Demo");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='rmbrUsername']")).click();
		driver.findElement(By.className("submit")).click();
		Thread.sleep(3000); // this sleep is because selenium execution is fast but browser took some time
							// to load the element below. So code will fail if wait is not given
		String text = driver.findElement(By.xpath("//div[@class=\"login-container\"]/p")).getText();
		System.out.println(text);

		Assert.assertEquals(text, "You are successfully logged in.");

		Thread.sleep(3000);
		driver.close();
	}

	public static String getPassword(WebDriver driver) throws InterruptedException {

		driver.findElement(By.className("forgot-pwd-container")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String passwordString = driver.findElement(By.className("infoMsg")).getText();
		System.out.println(passwordString);
		String[] passwordArray = passwordString.split("'");
		String password = passwordArray[1];
		return password;
	}

}
