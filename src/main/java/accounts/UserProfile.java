package accounts;

public class UserProfile {
    private String userName;
    private String password;
    private String email;

    public UserProfile(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.email = userName+" " + password;
    }

    public UserProfile(String userName) {
        this.userName = userName;
        this.password = userName;
        this.email = userName;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
}
