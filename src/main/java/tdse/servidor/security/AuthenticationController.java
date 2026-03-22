package tdse.servidor.security;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.password4j.BcryptFunction;
import com.password4j.Hash;
import com.password4j.Password;

@RestController
@RequestMapping("/security")
public class AuthenticationController {

  private User user = null;
  private BcryptFunction bcrypt = BcryptFunction.getInstance(12);

  @PostMapping("/login")
  public String userLogin(@RequestBody LoginDTO credentials) throws NullPointerException {
    if ((credentials.getUserName() == null) || (credentials.getPassword() == null)) {
      throw new NullPointerException();
    }

    UUID tokenGenerator = UUID.randomUUID();

    Hash hash = Password.hash(credentials.getPassword()).with(bcrypt);

    user = new User(credentials.getUserName(), hash.getResult(), tokenGenerator.toString());

    return tokenGenerator.toString();
  }

  @GetMapping("/pi")
  public Double userPi(@RequestHeader("Authorization") String token) {

    String newToken = token.substring(7);

    if (newToken.equals(user.getToken())) {
      return Math.PI;
    }

    throw new InvalidTokenException("The Token is not equals to the user respective");

  }

  @GetMapping("/verify")
  public Boolean verifyPassword(@RequestBody PasswordDTO password) {

    boolean verified = Password.check(password.getPassword(), user.getPassword()).with(bcrypt);

    return verified;

  }

}
