package goibibo;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(glue={"goibibo","commonMethods"}, features = "src/test/java/goibibo", plugin = { "pretty", "html:target/site/cucumber-pretty",
        "json:target/cucumber.json" })
public class runner {
}
