package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAll();
    void addIngredient(Ingredient ingredient);
}
