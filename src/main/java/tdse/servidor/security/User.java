package tdse.servidor.security;

public class User {

  private String userName;

  private String password;

  private String token;

  public User(String userName, String password, String token) {

    this.userName = userName;
    this.password = password;
    this.token = token;

  }

  public String getUsername() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getToken() {
    return token;
  }

  public void setUsername(String newUserName) {
    userName = newUserName;
  }

  public void setPassword(String newPassword) {
    password = newPassword;
  }

  public void setToken(String newToken) {
    token = newToken;
  }
}
