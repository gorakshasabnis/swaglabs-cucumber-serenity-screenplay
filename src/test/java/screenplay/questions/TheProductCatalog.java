package screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TheProductCatalog {

    private static final Target catalogPageTitle = Target.the("catalog page title").locatedBy(".title");

    public static Question<String> title() {
        return Text.of(catalogPageTitle).asAString();
    }
}
