package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wID")
    private Long wID;

    @Column(name = "duration")
    private int duration;

}
