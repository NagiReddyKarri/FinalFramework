package RunnerClass;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.CommonLibraries;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = { "src/test/resources/Features/Newtours.feature" },
		glue = { "StepDefinition","Utilities", "RunnerClass"},
		 tags = "@Test11",//"@TestSceanrio", //
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	/**
	 **********************************************************************
	 * @MethodName : createReporterfolder()
	 * @Description : This function is used to set report path
	 ***********************************************************************
	 */
	@BeforeTest
	public void createReporterfolder()
	{
	CommonLibraries.createReport();
	}

//	@Test
//	public void x()
//	{}
	

}
