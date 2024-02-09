package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web;

import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web.auth.AuthenticationRequest;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web.auth.AuthenticationService;
import org.apache.coyote.BadRequestException;
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
    public String loginPage(HttpServletResponse response) {
        Cookie cookie = new Cookie("Authorization", null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "login";
    }

    @PostMapping
    public String authenticate(
            @RequestParam String name,
            @RequestParam String password,
            HttpServletResponse response,
            HttpSession session) throws BadRequestException {
        AuthenticationRequest request = new AuthenticationRequest(name, password);
        service.authenticate(request, response).getToken();
        session.setAttribute("user", userService.findByName(name));


        return "redirect:/home";
    }
}
