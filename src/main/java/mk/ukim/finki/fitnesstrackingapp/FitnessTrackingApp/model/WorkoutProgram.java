package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workoutprogram")
public class WorkoutProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wpID")
    private Long wpID;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "workoutprogramhasworkout",
            joinColumns = @JoinColumn(name = "wpID"),
            inverseJoinColumns = @JoinColumn(name = "wID")
    )
    private List<Workout> workouts;

}
