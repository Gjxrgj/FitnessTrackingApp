package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mID")
    private Long mID;

    @ManyToOne
    @JoinColumn(name = "uID")
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToMany
    @JoinTable(
            name = "mealhasingredient",
            joinColumns = @JoinColumn(name = "mID"),
            inverseJoinColumns = @JoinColumn(name = "iID")
    )
    private List<PersonalizedIngredient> ingredients;

    public Meal(String name, String type) {
        this.name = name;
        this.type = type;

        ingredients = new ArrayList<>();
    }
    public void addIngredient(PersonalizedIngredient ingredient){
        ingredients.add(ingredient);
    }
    public int getCalories(){
        int counter = 0;
        for(PersonalizedIngredient ingredient : this.ingredients){
            counter += ingredient.getCalories();
        }
        return counter;
    }
    public int getProteins(){
        int counter = 0;
        for(PersonalizedIngredient ingredient : this.ingredients){
            counter += ingredient.getProteins();
        }
        return counter;
    }
    public int getFats(){
        int counter = 0;
        for(PersonalizedIngredient ingredient : this.ingredients){
            counter += ingredient.getFats();
        }
        return counter;
    }
    public int getCarbs(){
        int counter = 0;
        for(PersonalizedIngredient ingredient : this.ingredients){
            counter += ingredient.getCarbs();
        }
        return counter;
    }
    public int getQuantity(){
        int counter = 0;
        for(PersonalizedIngredient ingredient : this.ingredients){
            counter += ingredient.getQuantity();
        }
        return counter;
    }

}
