package nucleus.it.orianna.service.auth.data;

public class SignInData {

    private String email;
    private String password;

    public SignInData() {

    }

    public SignInData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
