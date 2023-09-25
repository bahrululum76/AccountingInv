package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features/General Journal","src/test/resources/features/Good and Service","src/test/resources/features/contact","src/test/resources/features/System","src/test/resources/features/Cash and Bank"}, 
glue={"steps"},
monochrome = true,


plugin = {"pretty"},
 tags = "@add_taxes"
)

public class TestRunnerAccounting {

}
