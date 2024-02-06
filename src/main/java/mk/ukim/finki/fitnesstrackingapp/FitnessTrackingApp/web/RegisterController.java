package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web.auth.AuthenticationService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web.auth.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor

public class RegisterController {

    private final AuthenticationService service;

    @GetMapping
    public String getRegisterPage(){
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String name,
                           @RequestParam String password,
                           @RequestParam int age,
                           @RequestParam int height,
                           @RequestParam int weight){
        RegisterRequest request = new RegisterRequest(name, password, age, height, weight);
        service.register(request);
        return "/login";
    }

}
