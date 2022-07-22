package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features=".//features/petstore.feature",
		glue="stepDefinitions",
		//tags="@registration",
		plugin= {"pretty","html:target/htmlreport.html"},
		monochrome=true
		
		)
public class PetStoreRunner {

}
