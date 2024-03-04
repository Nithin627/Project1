package StepDefinition;

import java.io.IOException;

import Utils.TestContextSetupClass;
import io.cucumber.java.After;

public class Hooks {
	public TestContextSetupClass tcs;
	public Hooks(TestContextSetupClass tcs) {
		this.tcs=tcs;
	}
	
//	@After
	public void afterScenario() throws IOException {
		tcs.testbase.webDriverManagerClass().quit();
	}

}
