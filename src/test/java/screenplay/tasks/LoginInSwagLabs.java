package screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import roles.Users;
import screenplay.actions.Login;

import java.util.List;

public class LoginInSwagLabs {

    public static Performable usingValidCredentialsOf(Users user) {
        return Task.where("{0} provide credentials of "+user,
                Login.asA(user.username,user.password)
        );
    }

    public static Performable usingInvalidCredentialsOf(List<String> invalidUser) {
        return Task.where("{0} provides incorrect credentials of "+invalidUser.get(0),
                Login.asA(invalidUser.get(0),invalidUser.get(1))
        );
    }
}
