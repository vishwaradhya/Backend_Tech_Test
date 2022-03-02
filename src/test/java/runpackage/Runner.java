package runpackage;

import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@ExtendedCucumberOptions(jsonReport = "target/cucumber.json", retryCount = 0, detailedReport = true, detailedAggregatedReport = true, overviewReport = true,
		jsonUsageReport = "target/cucumber-usage.json", usageReport = true, toPDF = true, excludeCoverageTags = {
				"@flaky" }, includeCoverageTags = { "@passed" }, outputFolder = "target/results")

@CucumberOptions(plugin = { "html:target/cucumberHtmlReport", "json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json" },
		features = "classpath:features", glue = { "com.rest.stepdefinitions" }, tags = {
				"@jp" })

public class Runner {
	
	

}
