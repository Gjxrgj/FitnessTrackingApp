package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iID")
    private Long iID;

    @Getter
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "calories", nullable = false)
    private int calories;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "protein", nullable = false)
    private int protein;

    @Column(name = "carbs", nullable = false)
    private int carbs;

    @Column(name = "fats", nullable = false)
    private int fats;

}
