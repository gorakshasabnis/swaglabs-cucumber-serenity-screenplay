package roles;

public enum Users {

    STANDARD_USER("standard_user","secret_sauce"),
    LOCKED_OUT_USER("locked_out_user","secret_sauce");

    public final String username;
    public final String password;

    Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
