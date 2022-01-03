package screenplay.actions.navigation;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import screenplay.page.LoginPage;

public class NavigateTo {
    public static Performable theSamuraiReportingPage() {
        return Interaction.where("{0} is on the Swag Labs Login page",
                Open.browserOn().the(LoginPage.class)
        );
    }
}
