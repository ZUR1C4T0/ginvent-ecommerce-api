package ginvent.backend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ginvent.backend.auth.entities.AuthResponse;
import ginvent.backend.auth.entities.LoginRequest;
import ginvent.backend.auth.entities.RegisterRequest;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest body) {
        AuthResponse res = authService.login(body);
        if (res == null) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
        return ResponseEntity.ok(res);
    }

    @PostMapping("register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest body) {
        AuthResponse res = authService.register(body);
        if (res == null) {
            return ResponseEntity.badRequest().body("User already exists");
        }
        return ResponseEntity.ok(res);
    }

}
