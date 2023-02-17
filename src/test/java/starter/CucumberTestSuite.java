package starter;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Projects or @Negative or @Positive",
        plugin = {"pretty"},
        features = "classpath:features/Projects"
)
public class CucumberTestSuite {}
