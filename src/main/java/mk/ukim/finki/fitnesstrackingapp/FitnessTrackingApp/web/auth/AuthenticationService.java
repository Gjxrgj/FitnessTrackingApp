package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.config.JwtService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.DayRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.UserRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final DayRepository dayRepository;

    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .age(request.getAge())
                .height(request.getHeight())
                .weight(request.getWeight())
                .days(new ArrayList<>())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        Day day = Day.builder()
                .date(LocalDate.now())
                .build();
        dayRepository.save(day);
        user.addDay(day);
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );
        var user = repository.findByName(request.getName()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        Cookie cookie = new Cookie("Authorization", jwtToken);
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
