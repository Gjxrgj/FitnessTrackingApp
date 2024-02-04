package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MealHasIngredient")
public class MealHasIngredient {

    @Id
    @ManyToOne
    @JoinColumn(name = "mID")
    private Meal meal;

    @Id
    @ManyToOne
    @JoinColumn(name = "iID")
    private Ingredient ingredient;

}
