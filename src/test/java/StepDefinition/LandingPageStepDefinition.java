package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjets.LandingPage;
import PageObjets.PageObjectManagerClass;
import Utils.TestContextSetupClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public LandingPage landingpage;
	public PageObjectManagerClass pageobjectmanager;
	public TestContextSetupClass tcs;

	public LandingPageStepDefinition(TestContextSetupClass tcs) {
		this.tcs = tcs;
		this.landingpage = tcs.pageobjectmanager.getLandingPage();
	}

	@Given("User on the Orange HRM login page")
	public void User_on_the_Orange_HRM_login_page() throws IOException {
//		Assert.assertEquals(tcs.testbase.webDriverManagerClass().getTitle(), "OrangeHRM");

	}

	@When("^User Enter the (.+) and (.+)$")
	public void User_Enter_the_username_and_password(String username, String password) {

		landingpage.enterDetails(username, password);

	}

	@Then("User clicks on the login button")
	public void User_clicks_on_the_login_button() {

		landingpage.clickOnLogin();

	}

	@Then("User validate the Orange HRM home page")
	public void User_validate_the_Orange_HRM_home_page() throws IOException {
		String title = tcs.testbase.webDriverManagerClass().getTitle();
		Assert.assertTrue(title.equalsIgnoreCase("OrangeHRM"));
		System.out.println(title);
	}

}
