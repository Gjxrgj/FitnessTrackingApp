package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.config;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Component;



@Component
public class StartupInitializer {

    @PostConstruct
    public void initialize() {

        Cookie cookie = new Cookie("Authorization", null);
        cookie.setMaxAge(10000); // Set max age to 0 to expire the cookie immediately
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        System.out.println("COOKIE SET TO NULL - Initialization");
    }
}
