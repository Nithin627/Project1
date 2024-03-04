package PageObjets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.TestContextSetupClass;

public class LandingPage {
	public WebDriver driver;
	

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By uname = By.cssSelector("input[name='username']");
	By pass = By.cssSelector("input[name='password']");
	By submitBtn = By.cssSelector("button[type='submit']");
	
	public void enterDetails(String username, String passw) {
		driver.findElement(uname).sendKeys(username);
		driver.findElement(pass).sendKeys(passw);
	}

	public void clickOnLogin() {
		driver.findElement(submitBtn).click();
	}

}
