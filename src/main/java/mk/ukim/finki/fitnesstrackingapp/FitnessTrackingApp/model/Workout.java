package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;

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

    @ManyToOne
    private User user;

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
