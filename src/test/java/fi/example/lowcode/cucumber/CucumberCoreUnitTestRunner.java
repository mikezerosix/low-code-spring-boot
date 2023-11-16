package fi.example.lowcode.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
    plugin = {"pretty", "json:target/cucumber-reports.json", "html:target/cucumber.html", "junit:target/surefire-reports/cucumber.xml"})
public class CucumberCoreUnitTestRunner {
    private static final Logger log = LoggerFactory.getLogger(CucumberCoreUnitTestRunner.class);

    public static void noOp() {
        log.debug("No-op Cucumber test");
    }

}