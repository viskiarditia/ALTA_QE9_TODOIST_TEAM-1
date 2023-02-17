package starter;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Task",
        plugin = {"pretty"},
        features = "classpath:features",
        glue = "starter/feature/steps"
)
public class CucumberTestSuite {}
