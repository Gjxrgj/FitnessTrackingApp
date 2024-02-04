package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String password;
    private int age;
    private int height;
    private int weight;
}
