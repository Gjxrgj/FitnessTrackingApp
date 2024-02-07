package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mID")
    private Long mID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "quantity")
    private int quantity = 0;

    @ManyToMany
    private List<PersonalizedIngredient> ingredients;


    public Meal(String name, String type) {
        this.name = name;
        this.type = type;

        ingredients = new ArrayList<>();
    }
    public void addIngredient(PersonalizedIngredient ingredient){
        ingredients.add(ingredient);
    }
}
