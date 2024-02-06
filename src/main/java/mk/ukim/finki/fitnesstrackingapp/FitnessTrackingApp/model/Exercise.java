package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eID")
    private Long eID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "reps")
    private int reps;

    @Column(name = "sets")
    private int sets;

    @Column(name = "weight")
    private int weight;

    @Column(name = "time")
    private int time;

    @Column(name = "type", nullable = false)
    private String type;

    public Exercise(String name, int reps, int sets, int weight, int time, String type) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
        this.time = time;
        this.type = type;
    }
}
