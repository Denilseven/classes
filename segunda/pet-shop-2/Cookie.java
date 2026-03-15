public class Cookie {
    enum LoginType {
        UNDEFINED,
        GUEST,
        USER,
        ADMIN,
    }

    LoginType loginType;

    public Cookie(LoginType loginType) {
        this.loginType = loginType;
    }

    public Cookie() {
        this.loginType = LoginType.UNDEFINED;
    }

    public void logout() {
        this.loginType = LoginType.UNDEFINED;
    }
}
