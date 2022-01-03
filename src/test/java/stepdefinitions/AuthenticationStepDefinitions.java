package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.actions.navigation.NavigateTo;
import screenplay.questions.TheLoginPage;
import screenplay.questions.TheProductCatalog;
import screenplay.tasks.LoginInSwagLabs;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;
import static roles.Users.LOCKED_OUT_USER;
import static roles.Users.STANDARD_USER;

public class AuthenticationStepDefinitions {

    @Given("{actor} is on the Swag Labs login page")
    public void on_the_swag_labs_login_page(Actor actor) {
        actor.wasAbleTo(
                NavigateTo.theSamuraiReportingPage()
        );
    }

    @When("{actor} provides valid credentials")
    public void provide_valid_credentials(Actor actor) {
        actor.attemptsTo(
                LoginInSwagLabs.usingValidCredentialsOf(STANDARD_USER)
        );
    }

    @Then("{actor} should be welcomed with a Swag Labs product catalog")
    public void swag_labs_product_catalog_page(Actor actor) {
        actor.should(
                seeThat("landing page title", TheProductCatalog.title(),is("PRODUCTS"))
        );
    }

    @When("{actor} provides locked credentials")
    public void locked_Credentials(Actor actor) {
        actor.attemptsTo(
                LoginInSwagLabs.usingValidCredentialsOf(LOCKED_OUT_USER)
        );
    }

    @Then("{actor} should be presented with a message as {string}")
    public void error_Message_As(Actor actor, String errMsg) {
        actor.should(
                seeThat("login field is highlighted",TheLoginPage.usernameFieldIsHighlighted()),
                seeThat("password field is highlighted",TheLoginPage.passwordFieldIsHighlighted()),
                seeThat("error icon next to username field is displayed",TheLoginPage.errorIconIsDisplayedNextToUsername()),
                seeThat("error icon next to password field is displayed",TheLoginPage.errorIconIsDisplayedNextToPassword()),
                seeThat("error message", TheLoginPage.errorMessage(),containsString(errMsg))
        );
    }

    @When("{actor} provides invalid credentials")
    public void invalid_Credentials(Actor actor, DataTable credentials) {
        List<List<String>> loginDetails = credentials.asLists(String.class);

        loginDetails.forEach(
                cred -> actor.attemptsTo(
                        LoginInSwagLabs.usingInvalidCredentialsOf(cred)
                )
        );

    }
}
