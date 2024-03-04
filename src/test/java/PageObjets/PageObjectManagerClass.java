package PageObjets;

import org.openqa.selenium.WebDriver;

public class PageObjectManagerClass {
	public WebDriver driver;
	public LandingPage landingpage;
	
	public PageObjectManagerClass(WebDriver driver) {
		this.driver=driver;
	}
	
	public LandingPage getLandingPage() {
		landingpage=new LandingPage(driver);
		return landingpage;
	}

}
