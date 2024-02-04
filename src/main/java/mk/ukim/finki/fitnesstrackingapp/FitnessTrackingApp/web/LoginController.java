package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web.auth.AuthenticationRequest;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web.auth.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.UserService;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor

public class LoginController {

    private final UserService userService;
    private final AuthenticationService service;

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @PostMapping
    public String authenticate(
            @RequestParam String name,
            @RequestParam String password,
            HttpSession session,
            HttpServletResponse response
    ){
        AuthenticationRequest request = new AuthenticationRequest(name, password);
        String jwtToken = service.authenticate(request).getToken();



        return "redirect:/home";
    }
}
