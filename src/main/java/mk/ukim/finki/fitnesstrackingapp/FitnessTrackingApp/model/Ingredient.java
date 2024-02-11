package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_ingredient_seq")
    @SequenceGenerator(name = "_ingredient_seq", sequenceName = "_ingredient_seq", allocationSize = 1)
    @Column(name = "iID")
    private Long iID;

    @Getter
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "calories", nullable = false)
    private int calories;

    @Column(name = "protein", nullable = false)
    private int protein;

    @Column(name = "carbs", nullable = false)
    private int carbs;

    @Column(name = "fats", nullable = false)
    private int fats;

    public Ingredient(String name, int calories, int protein, int carbs, int fats) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }
}
