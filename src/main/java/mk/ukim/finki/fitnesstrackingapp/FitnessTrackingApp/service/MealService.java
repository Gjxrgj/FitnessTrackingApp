package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Meal;

import java.util.List;

public interface MealService {
    List<Meal> getAll();
    void addMeal(String name, String type);
    void AddIngredientToMeal(Long ingredientId, Long mealID, int quantity);
    Meal getById(Long mealID);
    void removeMealFromDay(Long mealID, Long ingredientID);

    List<Meal> getAllByUserInSession();
}
