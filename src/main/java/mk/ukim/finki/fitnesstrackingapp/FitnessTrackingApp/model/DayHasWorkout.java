package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_DayHasWorkout")
public class DayHasWorkout {

    @Id
    @ManyToOne
    @JoinColumn(name = "wID")
    private Workout workout;

    @Id
    @ManyToOne
    @JoinColumn(name = "dID")
    private Day day;

}
