package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjets.PageObjectManagerClass;

public class TestContextSetupClass {
	public WebDriver driver;
	public PageObjectManagerClass pageobjectmanager;
	public TestBase testbase;
	
	public TestContextSetupClass() throws IOException {
		testbase=new TestBase();
		pageobjectmanager=new PageObjectManagerClass(testbase.webDriverManagerClass());
	}

}
