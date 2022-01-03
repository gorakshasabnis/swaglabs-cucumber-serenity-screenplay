package screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class TheLoginPage {

    private static final Target usernameError = Target.the("username error highlighted").locatedBy("#user-name.form_input.error");
    private static final Target usernameErrorIcon = Target.the("username error icon").locatedBy("#user-name+[data-icon='times-circle']");
    private static final Target passwordError = Target.the("password error highlighted").locatedBy("#password.form_input.error");
    private static final Target passwordErrorIcon = Target.the("password error icon").locatedBy("#password+[data-icon='times-circle']");
    private static final Target errorMsg = Target.the("login error message").locatedBy("[data-test='error']");

    public static Question<String> errorMessage() {
        return Text.of(errorMsg).asAString();
    }

    public static Question<Boolean> usernameFieldIsHighlighted() {
        return Visibility.of(usernameError).asABoolean();
    }

    public static Question<Boolean> passwordFieldIsHighlighted() {
        return Visibility.of(passwordError).asABoolean();
    }

    public static Question<Boolean> errorIconIsDisplayedNextToUsername() {
        return Visibility.of(usernameErrorIcon).asABoolean();
    }

    public static Question<Boolean> errorIconIsDisplayedNextToPassword() {
        return Visibility.of(passwordErrorIcon).asABoolean();
    }
}
