package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web;

import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
@RequiredArgsConstructor

public class LogoutController {
    @GetMapping
    public String logout(){
        Cookie cookie = new Cookie("Authorization", null);
        cookie.setMaxAge(10000);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        System.out.println("COOKIE SET TO NULL - Initialization");
        return "redirect:/login";
    }

}
