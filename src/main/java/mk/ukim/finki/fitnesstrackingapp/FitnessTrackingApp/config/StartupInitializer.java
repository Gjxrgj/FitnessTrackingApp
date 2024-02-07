package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.config;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class StartupInitializer {

    @PostConstruct
    public void initialize() {



        System.out.println("COOKIE SET TO NULL - Initialization");
    }
}
