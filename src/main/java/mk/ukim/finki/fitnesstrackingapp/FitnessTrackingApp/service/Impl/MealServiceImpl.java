package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Ingredient;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Meal;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.PersonalizedIngredient;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.IngredientsRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.MealRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.PersonalizedIngredientRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.IngredientService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.MealService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.PersonalizedIngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    private final IngredientsRepository ingredientsRepository;
    private final PersonalizedIngredientService personalizedIngredientService;
    @Override
    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @Override
    public void addMeal(String name, String type) {
     mealRepository.save(new Meal(name, type));
    }
    @Override
    @Transactional
    public void AddIngredientToMeal(Long ingredientId, Long mealID, int quantity) {
        Ingredient ingredient = ingredientsRepository.findById(ingredientId).orElseThrow();
        Meal meal = mealRepository.findById(mealID).orElseThrow();
        PersonalizedIngredient personalizedIngredient = new PersonalizedIngredient(ingredient, quantity);
        personalizedIngredientService.addPersonalizedIngredient(personalizedIngredient);
        meal.addIngredient(personalizedIngredient);
        int quantForMeal = 0;
        for(PersonalizedIngredient ingr : meal.getIngredients()){
            quantForMeal += ingr.getQuantity();
        }
        meal.setQuantity(quantForMeal);
        mealRepository.save(meal);
    }
}
