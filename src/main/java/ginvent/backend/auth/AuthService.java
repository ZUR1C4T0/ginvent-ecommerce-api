package ginvent.backend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ginvent.backend.auth.entities.AuthResponse;
import ginvent.backend.auth.entities.JwtService;
import ginvent.backend.auth.entities.LoginRequest;
import ginvent.backend.auth.entities.RegisterRequest;
import ginvent.backend.users.entities.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthResponse login(LoginRequest body) {
        User user = userRepository.findByEmail(body.getEmail()).orElse(null);
        if (user == null) {
            return null;
        }
        if (!bCryptPasswordEncoder.matches(body.getPassword(), user.getPassword())) {
            return null;
        }
        return new AuthResponse(jwtService.createToken(user));
    }

    public AuthResponse register(RegisterRequest body) {
        final boolean exists = userRepository.existsByEmail(body.getEmail())
                || userRepository.existsByUsername(body.getUsername());

        if (exists) {
            return null;
        }

        User newUser = User.builder()
                .username(body.getUsername())
                .email(body.getEmail())
                .password(bCryptPasswordEncoder.encode(body.getPassword()))
                .role(Role.CLIENT)
                .build();

        userRepository.save(newUser);
        return new AuthResponse(jwtService.createToken(newUser));
    }

}
