package screenplay.actions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class Login {

    private static final Target userNameField = Target.the("username field").locatedBy("#user-name");
    private static final Target passwordField = Target.the("password field").locatedBy("#password");
    private static final Target loginBtn = Target.the("login button").locatedBy("#login-button");

    public static Performable asA(String username, String password) {
        return Interaction.where("{0} tries to login as "+username,
                Enter.theValue(username).into(userNameField),
                Enter.theValue(password).into(passwordField),
                Click.on(loginBtn)
        );
    }
}
