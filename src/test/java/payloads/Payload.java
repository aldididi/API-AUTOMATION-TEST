package payloads;

public class Payload {
    public static String userValidLogin(String email, String password) {
        return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
    }
}
