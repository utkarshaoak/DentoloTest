package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        format = {"pretty","html:target/Destination"},
        tags = {"@test"},
        glue = {"Utils","Pages"}
)
public class Dentolo_Runner {


}
