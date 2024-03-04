package Demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoClass {
	@Test
	public void LoginTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String uname = driver.findElement(By.xpath("//div[contains(@class,'oxd-sheet')]/p[1]")).getText().split(":")[1]
				.trim();
		String pass = driver.findElement(By.xpath("//div[contains(@class,'oxd-sheet')]/p[2]")).getText().split(":")[1]
				.trim();
//		System.out.println(uname);
//		System.out.println(pass);

		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(uname);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(pass);

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		driver.findElement(By.xpath("(//span[contains(@class,'oxd-text')])[6]")).click();

////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='firstName']")));
//		Thread.sleep(2000);
////		driver.findElements(By.xpath("//input[contains(@class,'oxd-input')]")).clear();
//		
//		driver.findElement(By.cssSelector("input[name='firstName']")).clear();
//		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Nithin");
//		
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input[name='lastName']")).clear();
//		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Puttur");
//		
//		driver.findElement(By.xpath("(//input[contains(@class,'oxd-input')])[6]")).clear();
//		driver.findElement(By.xpath("(//input[contains(@class,'oxd-input')])[6]")).sendKeys("12345");

//		driver.findElement(By.xpath("(//input[contains(@class,'oxd-input')])[8]")).sendKeys("12345");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//i[contains(@class,'oxd-date-input-icon')])[1]")));
		driver.findElement(By.xpath("(//i[contains(@class,'oxd-date-input-icon')])[1]")).click();

		while (!driver.findElement(By.cssSelector(".oxd-calendar-selector-month div p")).getText().contains("April")) {
			driver.findElement(By.xpath("(//button[@class='oxd-icon-button'])[3]")).click();
		}

		int dates = driver.findElements(By.cssSelector("div[class='oxd-calendar-date']")).size();
		for (int i = 0; i < dates; i++) {
			String date = driver.findElements(By.cssSelector("div[class='oxd-calendar-date']")).get(i).getText();
			if (date.equalsIgnoreCase("23")) {
				driver.findElements(By.cssSelector("div[class='oxd-calendar-date']")).get(i).click();
				break;
			}
		}

		driver.findElement(By.xpath("(//i[contains(@class,'oxd-select-text--arrow')])[1]")).click();
		int countries = driver.findElements(By.cssSelector("div[role='listbox'] div")).size();

		for (int j = 0; j < countries; j++) {
			String country = driver.findElements(By.cssSelector("div[role='listbox'] div")).get(j).getText();
			if (country.equalsIgnoreCase("Indian")) {
				driver.findElements(By.cssSelector("div[role='listbox'] div")).get(j).click();
				break;
			}

		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[contains(@class,'oxd-select-text--arrow')])[2]")).click();
		int Meritals = driver.findElements(By.cssSelector("div[class='oxd-select-dropdown --positon-bottom'] div"))
				.size();

		for (int k = 0; k < Meritals; k++) {
			String merital = driver
					.findElements(By.cssSelector("div[class='oxd-select-dropdown --positon-bottom'] div")).get(k)
					.getText();
			if (merital.equalsIgnoreCase("Single")) {
				driver.findElements(By.cssSelector("div[class='oxd-select-dropdown --positon-bottom'] div")).get(k)
						.click();
				break;
			}
		}

//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//i[contains(@class,'oxd-select-text--arrow')])[3]")).click();
//		driver.findElement(By.xpath("(//input[@placeholder='yyyy-mm-dd'])[2]")).click();
//		
//		while (!driver.findElement(By.cssSelector(".oxd-calendar-selector-month div p")).getText().contains("April") && driver.findElement(By.cssSelector(".oxd-calendar-selector-year")).getText().contains("2000")) {
//			driver.findElement(By.xpath("(//button[@class='oxd-icon-button'])[3]")).click();
//		}

		driver.findElement(By.xpath("(//i[contains(@class,' oxd-date-input-icon')])[2]")).click();

		driver.findElement(By.cssSelector("li[class='oxd-calendar-selector-month']")).click();
		int count = driver.findElements(By.cssSelector("ul[class='oxd-calendar-selector'] li ul")).size();

		for (int n = 0; n < count; n++) {
			String months = driver.findElements(By.cssSelector("ul[class='oxd-calendar-selector'] li ul")).get(n)
					.getText();
			if (months.contains("April")) {
				driver.findElements(By.cssSelector("ul[class='oxd-calendar-selector'] li ul")).get(n).click();
			}

		}
//
//		driver.findElement(By.cssSelector("li[class='--active oxd-calendar-selector-year']")).click();
//		int years = driver.findElements(By.cssSelector("li[class='--active oxd-calendar-selector-year'] ul li")).size();
//		for (int m = 0; m < years; m++) {
//			String year = driver.findElements(By.cssSelector("li[class='--active oxd-calendar-selector-year'] ul li"))
//					.get(m).getText();
//
//			if (year.equalsIgnoreCase("2000")) {
//				driver.findElements(By.cssSelector("li[class='--active oxd-calendar-selector-year'] ul li")).get(m)
//						.click();
//			}
//		}

//		driver.findElement(By.xpath("(//i[contains(@class,' oxd-date-input-icon')])[2]")).click();
//
//		String txt = driver.findElement(By.cssSelector("(//p[@class='oxd-text oxd-text--p'])[1]")).getText();
//		String txt2 = driver.findElement(By.cssSelector("(//p[@class='oxd-text oxd-text--p'])[2]")).getText();
//		if (txt != "April" && txt2 != "2000") {
//			driver.findElement(By.xpath("//i[@class='oxd-icon bi-chevron-right']")).click();
//
//		}

	}

}
