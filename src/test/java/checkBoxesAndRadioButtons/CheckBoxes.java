package checkBoxesAndRadioButtons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//isSelected is the method that selenium uses to find out the state of checked
// Assertions come from TsetNG dependency
public class CheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("wedriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(3000);
		WebElement seniorCitizen = driver
				.findElement(By.xpath("//input[@id=\"ctl00_mainContent_chk_SeniorCitizenDiscount\"]"));

		boolean checkBox = seniorCitizen.isSelected();
		
		Assert.assertFalse(checkBox); 
		System.out.println("checkbox Not selected");
		
		//System.out.println(checkBox);

		seniorCitizen.click();

		checkBox = seniorCitizen.isSelected();
		Assert.assertTrue(checkBox); 
		System.out.println("checkbox selected");
		//System.out.println(checkBox);

		List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type=\"checkbox\"]/../label"));

		
		for (int i = 1; i<checkBoxList.size();i++) {
			System.out.println(checkBoxList.get(i).getText());

		}

		driver.close();

	}

}
