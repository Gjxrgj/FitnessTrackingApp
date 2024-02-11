package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_exercise_seq")
    @SequenceGenerator(name = "_exercise_seq", sequenceName = "_exercise_seq", allocationSize = 1)
    @Column(name = "eID")
    private Long eID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    public Exercise(String name, String type) {
        this.name = name;

        this.type = type;
    }
}
