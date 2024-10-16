package Runner;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/feature", glue = "StepDefinations", monochrome = true, plugin = {"html:target/cucumber-reports/report.html"})
public class Runner_Class extends AbstractTestNGCucumberTests {

}





