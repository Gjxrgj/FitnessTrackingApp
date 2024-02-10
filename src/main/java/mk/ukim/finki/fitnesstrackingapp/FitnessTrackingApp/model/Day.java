package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "did")
    private Long dID;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "meals")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dayhasmeal",
            joinColumns = @JoinColumn(name = "did"),
            inverseJoinColumns = @JoinColumn(name = "mid")
    )
    private List<Meal> meals = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dayhasworkout",
            joinColumns = @JoinColumn(name = "did"),
            inverseJoinColumns = @JoinColumn(name = "wid")
    )
    private List<Workout> workouts = new ArrayList<>();

    public void addWorkoutToDay(Workout workout){
        workouts.add(workout);
    }
    public void addMealToDay(Meal meal){
        meals.add(meal);
    }
}
