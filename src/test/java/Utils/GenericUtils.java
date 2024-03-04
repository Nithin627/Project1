package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchWindows() {
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> itr=s1.iterator();
//		String ParentWindow=itr.next();
//		String ChildWindow=itr.next();
//		driver.switchTo().window(ChildWindow);
		
		while(itr.hasNext()){
			driver.switchTo().window(itr.next());
		}
	}

}
