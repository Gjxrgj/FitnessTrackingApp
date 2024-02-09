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
@Entity
@Table(name = "_day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dID")
    private Long dID;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "meals")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dayhasmeal",
            joinColumns = @JoinColumn(name = "dID"),
            inverseJoinColumns = @JoinColumn(name = "mID")
    )
    private List<Meal> meals;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dayhasworkout",
            joinColumns = @JoinColumn(name = "dID"),
            inverseJoinColumns = @JoinColumn(name = "wID")
    )
    private List<Workout> workouts;

    public Day() {
        workouts = new ArrayList<>();
    }

    public void addWorkoutToDay(Workout workout){
        workouts.add(workout);
    }
    public void addMealToDay(Meal meal){
        meals.add(meal);
    }
}
