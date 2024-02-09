package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personalizedingredient")
public class PersonalizedIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "piID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iID")
    private Ingredient ingredient;

    @Column(name = "quantity")
    private int quantity;

    public PersonalizedIngredient(Ingredient ingredient, int quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }
    public double getCoef(){
        return this.quantity/100.0;
    }
    public int getCalories(){
        return (int) (ingredient.getCalories() * getCoef());
    }
    public int getProteins(){
        return (int) (ingredient.getProtein() * getCoef());

    }
    public int getFats(){
        return (int) (ingredient.getFats() * getCoef());

    }
    public int getCarbs(){
        return (int) (ingredient.getCarbs() * getCoef());
    }

}
