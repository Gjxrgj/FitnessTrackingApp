package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "Workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wID")
    private Long wID;

    @Column(name="name")
    private String name;

    @Column(name = "duration")
    private int duration;

    @ManyToMany
    private List<PersonalizedExercise> exercises;

    public Workout() {
        this.exercises = new ArrayList<>();
    }

    public Workout(String name) {
        this.name = name;
        duration = 0;
        exercises = new ArrayList<>();
    }
    public void addExercise(PersonalizedExercise exercise){
        this.exercises.add(exercise);
    }

}
