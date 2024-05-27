package brayan.demojwt.Auth;

import brayan.demojwt.Jwt.JwtService;
import brayan.demojwt.User.Role;
import brayan.demojwt.User.User;
import brayan.demojwt.User.UserRepository;
import brayan.demojwt.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jtwService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jtwService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getCorreo())
                .password(passwordEncoder.encode(request.getPassword()))
                .nombre(request.getNombre())
                .materno(request.getMaterno())
                .paterno(request.getPaterno())
                .dependencia(request.getDependenciaID())
                .matricula(request.getMatricula())
                .role(Role.USER)
                .build();
        this.userService.insertarUsuario(user);
        return AuthResponse.builder()
                .token(jtwService.getToken(user)).build();
    }
}
