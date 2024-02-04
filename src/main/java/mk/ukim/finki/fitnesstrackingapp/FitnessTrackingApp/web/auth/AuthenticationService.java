package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web.auth;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.config.JwtService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.UserRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .age(request.getAge())
                .height(request.getHeight())
                .weight(request.getWeight())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );
        var user = repository.findByName(request.getName()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
