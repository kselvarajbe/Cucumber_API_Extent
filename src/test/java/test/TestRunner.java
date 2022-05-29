package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty:target/cucumber/cucumber.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				//"html:target/cucumber/report",
				"json:target/cucumber/cucumber.json",
				"com.api.utils.MyTestListener"
		}
		,features= {"src/test/resources/features/CreateStudent.feature",
		            "src/test/resources/features/ViewStudentDetails.feature",
		            "src/test/resources/features/UpdateStudent.feature",
		            "src/test/resources/features/DeleteStudent.feature"
                   }
		,glue = {"com.api.stepdefinition"}
		//,dryRun = true
		,monochrome = true
		,snippets = SnippetType.CAMELCASE
		,tags = ""
		//,publish = true
		)
public class TestRunner {

}