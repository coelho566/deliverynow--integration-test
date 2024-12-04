import io.quarkiverse.cucumber.CucumberOptions;
import io.quarkiverse.cucumber.CucumberQuarkusTest;

@CucumberOptions(
        glue = {"steps"},
        plugin = {"json:report/index.json", "html:report/index.html"},
        features = {"src/test/resources/features"}
)
public class CucumberBddTest extends CucumberQuarkusTest {

    public static void main(String[] args) {
        runMain(CucumberBddTest.class, args);
    }
}