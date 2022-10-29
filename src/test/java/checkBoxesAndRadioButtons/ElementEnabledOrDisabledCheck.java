package checkBoxesAndRadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementEnabledOrDisabledCheck {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("wedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(3000);

		/*
		 * // this should generally worked if "enabled or disabled" concept is used for
		 * html node
		 * System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")
		 * ).isEnabled());
		 * driver.findElement(By.xpath("(//input[@value=\"RoundTrip\"])[1]")).click();
		 * System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")
		 * ).isEnabled());
		 */

		String text = driver.findElement(By.xpath("//div[@id=\"Div1\"]")).getAttribute("style");
		elementStatusCheck(text);
		driver.findElement(By.xpath("(//input[@value=\"RoundTrip\"])[1]")).click();
		Thread.sleep(3000);
		text = driver.findElement(By.xpath("//div[@id=\"Div1\"]")).getAttribute("style");
		elementStatusCheck(text);
		driver.close();

	}

	public static void elementStatusCheck(String text) {

		if (text.contains("0.5")) {
			System.out.println("element is disabled");
		} else {
			System.out.println("element is enabled");

		}
	}

}
