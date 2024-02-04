package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WorkoutProgramHasWorkout")
public class WorkoutProgramHasWorkout {

    @Id
    @ManyToOne
    @JoinColumn(name = "wID")
    private Workout workout;

    @Id
    @ManyToOne
    @JoinColumn(name = "wpID")
    private WorkoutProgram workoutProgram;

}
