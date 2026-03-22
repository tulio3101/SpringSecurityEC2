package tdse.servidor.security;

public class LoginDTO {

  private String userName;

  private String password;

  public LoginDTO() {

  }

  public LoginDTO(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public void setUserName(String newUserName) {
    userName = newUserName;
  }

  public void setPassword(String newPassword) {
    password = newPassword;
  }

}
