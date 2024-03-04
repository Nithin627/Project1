package Demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickers {

	@Test
	public void handleCalender1() {
		String month = "January 2025";
		String date = "8";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("(//li[@class='nav-item'])[2]")).click();

		driver.findElement(By.xpath("//input[@id='checkin']")).click();
		while (true) {
			String txt = driver
					.findElement(
							By.cssSelector("div[class='datepicker dropdown-menu'] div table thead tr th:nth-child(2)"))
					.getText();
			System.out.println(txt);
			if (txt.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath("(//*[@class='next'])[1]")).click();
			}
		}

		driver.findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[contains(text()," + date + ")]"))
				.click();

	}

	@Test
	public void handleCalender2() {
		String month = "January 2025";
		String date = "8";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.expedia.ca");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//button[@class='uitk-fake-input uitk-form-field-trigger'])[2]")).click();
//		driver.findElement(By.xpath("//div[@class='uitk-calendar uitk-calendar-day-selection-circle uitk-no-gridlines']/div/span[contains(text(),"+month+")]"));
		while(true) {
		String txt=driver.findElement(By.xpath("//div[@class='uitk-calendar uitk-calendar-day-selection-circle uitk-no-gridlines']/div/span")).getText();
		System.out.println(txt);
		if(txt.equals(month)) {
			break;
		}else {
			driver.findElement(By.xpath("(//button[@class='uitk-button uitk-button-medium uitk-button-only-icon uitk-button-paging'])[2]")).click();
		}
		}
		
		List<WebElement> alldates=driver.findElements(By.cssSelector("[class='uitk-month-table'] tbody tr td"));

		System.out.println(alldates);
		for(int i=0;i<alldates.size();i++) {
			String dates=alldates.get(i).getText();
			
			if(dates.equalsIgnoreCase(date)) {
				driver.findElements(By.cssSelector("[class='uitk-month-table'] tbody tr td")).get(i).click();
			}
			
		}
		driver.findElement(By.xpath("//*[@id=\"lodging_search_form\"]/div/div/div[2]/div/section/footer/div/button")).click();

	}

}
