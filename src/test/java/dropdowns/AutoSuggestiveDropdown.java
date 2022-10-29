package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("wedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Thread.sleep(3000);
		WebElement autoSuggestiveDD = driver.findElement(By.id("autosuggest"));
		autoSuggestiveDD.sendKeys("In");
		Thread.sleep(3000);
		List<WebElement> ddList = driver.findElements(By.className("ui-menu-item"));

		/*
		 * System.out.println(ddList.size());
		 * System.out.println(ddList.get(0).getText());
		 * System.out.println(ddList.get(1).getText());
		 * System.out.println(ddList.get(2).getText());
		 */

		/*
		 * for (int i = 0; i < ddList.size(); i++) {
		 * System.out.println(ddList.get(i).getText()); }
		 */
		for (WebElement option : ddList) {
			System.out.println(option.getText());
			
			if(option.getText().equalsIgnoreCase("inDiA")) {
				option.click();
				break;
			}
		}
		Thread.sleep(5000);

			driver.close();

	}

}
