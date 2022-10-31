package e2eFlow;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreeKart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().window().maximize();
		// d.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		d.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] inputArray = { "Cucumber", "Brocolli", "Cauliflower", "Pears" }; // List<String> wordList =
																					// Arrays.asList(words);
		List<String> inputList = Arrays.asList(inputArray);

		List<WebElement> itemsList = d.findElements(By.xpath("//h4[@class='product-name']"));
		List<WebElement> addToCartButtonList = d.findElements(By.xpath("//button[text()='ADD TO CART']"));
		int j = 0;
		for (int i = 0; i < itemsList.size(); i++) {
			String itemFromBrowser = itemsList.get(i).getText().split(" ")[0].trim();
			if (inputList.contains(itemFromBrowser)) {
				addToCartButtonList.get(i).click();
				j++;// 4
				if (j == 4)//true
					break;
			}
			System.out.println(itemFromBrowser);
		}

		Thread.sleep(3000);
		
		d.findElement(By.className("cart-icon")).click();
		
		String xpath = "//li[@class=\"cart-item\"]/descendant::p[@class=\"product-name\"]";
		List<WebElement> cartList = d.findElements(By.xpath(xpath));
		for (int i = 0; i < cartList.size()/2; i++) {
			
			// = cartList.get(i).getText(
			
		}
		
		
		
		d.close();
	}

}
