package MyApp.Controller;

import MyApp.Exceptions.UnauthorizedUserException;
import MyApp.Model.Account;
import MyApp.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    AuthService authService;
    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }
    @PostMapping("login")
    public Account login(@RequestBody Account account) throws UnauthorizedUserException {
        return authService.login(account);
    }
    @PostMapping("register")
    public Account register(@RequestBody Account account){
        return authService.register(account);
    }
    @ExceptionHandler(UnauthorizedUserException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "invalid login credentials!")
    public void handleUnauthorized(){

    }
}
