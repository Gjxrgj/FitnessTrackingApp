package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WorkoutHasExercise")
public class WorkoutHasExercise {

    @Id
    @ManyToOne
    @JoinColumn(name = "eID")
    private Exercise exercise;

    @Id
    @ManyToOne
    @JoinColumn(name = "wID")
    private Workout workout;

}
