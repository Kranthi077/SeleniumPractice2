package e2eFlow;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreeKart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // sets Chromediver.exe property in system
		WebDriver d = new ChromeDriver(); // object of chromeDriver class referring to WebDriver Interface
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		// d.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		d.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] inputArray = { "Cucumber", "Brocolli", "Cauliflower", "Pears" }; // List<String> wordList =
																					// Arrays.asList(words);
		List<String> inputList = Arrays.asList(inputArray);

		GreeKart.addItemsToCart(inputList, d);

		GreeKart.verifyItemsInCart(inputList, d);

		d.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		d.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		d.findElement(By.className("promoBtn")).click();
		String promoMessage = d.findElement(By.className("promoInfo")).getText();
		Assert.assertEquals(promoMessage, "Code applied ..!");

		d.close();
	}

	public static void addItemsToCart(List<String> inputList, WebDriver d) throws InterruptedException {
		List<WebElement> itemsList = d.findElements(By.xpath("//h4[@class='product-name']"));
		List<WebElement> addToCartButtonList = d.findElements(By.xpath("//button[text()='ADD TO CART']"));
		int j = 0;
		for (int i = 0; i < itemsList.size(); i++) {
			String itemFromBrowser = itemsList.get(i).getText().split(" ")[0].trim();
			if (inputList.contains(itemFromBrowser)) {
				addToCartButtonList.get(i).click();
				j++;// 4
				if (j == 4)// true
					break;
			}
			System.out.println(itemFromBrowser);
		}

		
	}

	public static void verifyItemsInCart(List<String> inputList, WebDriver d) throws InterruptedException {
		d.findElement(By.className("cart-icon")).click();
		Thread.sleep(3000);
		String xpath = "//li[@class='cart-item']/descendant::p[@class='product-name']";
		List<WebElement> cartList = d.findElements(By.xpath(xpath));
		for (int i = 0; i < 4; i++) {
			
			Thread.sleep(3000);
			String itemFromCart = cartList.get(i).getText().split(" ")[0].trim();
			if (inputList.contains(itemFromCart)) {
				System.out.println(itemFromCart + " Item is present in cart");
			} else {
				System.out.println("Item not present - Test failed");
			}

		}
	}

}
