package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Ingredient;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Meal;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.PersonalizedIngredient;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.IngredientsRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.MealRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.PersonalizedIngredientRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.UserRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.IngredientService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.MealService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.PersonalizedIngredientService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    private final IngredientsRepository ingredientsRepository;
    private final PersonalizedIngredientService personalizedIngredientService;
    private final PersonalizedIngredientRepository personalizedIngredientRepository;
    private final UserService userService;
    private final HttpSession session;
    @Override
    public List<Meal> getAll() {
        List<Meal> meals = mealRepository.findAllByUserOrderByNameAsc((User)session.getAttribute("user"));
        return meals;
    }

    @Override
    @Transactional
    public void addMeal(String name, String type) {

     mealRepository.save(Meal.builder()
                     .user((User)session.getAttribute("user"))
                     .name(name)
                     .type(type)
             .build());
    }
    @Override
    @Transactional
    public void AddIngredientToMeal(Long ingredientId, Long mealID, int quantity) {
        Ingredient ingredient = ingredientsRepository.findById(ingredientId).orElseThrow();
        Meal meal = mealRepository.findById(mealID).orElseThrow();
        PersonalizedIngredient personalizedIngredient = new PersonalizedIngredient();
        personalizedIngredient.setIngredient(ingredient);
        personalizedIngredient.setQuantity(quantity);
        personalizedIngredientService.addPersonalizedIngredient(personalizedIngredient);
        meal.addIngredient(personalizedIngredient);
        mealRepository.save(meal);
    }

    @Override
    public Meal getById(Long mealID) {
        return mealRepository.findById(mealID).orElseThrow();
    }

    @Override
    @Transactional
    public void removeMealFromDay(Long mealID, Long ingredientID) {
        PersonalizedIngredient ingredient = personalizedIngredientService.getById(ingredientID).orElseThrow();
        Meal meal = mealRepository.findById(mealID).orElseThrow();
        meal.getIngredients().remove(ingredient);
        personalizedIngredientRepository.delete(ingredient);
        mealRepository.save(meal);
    }

    @Override
    public List<Meal> getAllByUserInSession() {
        User user = userService.findByName(((User) session.getAttribute("user")).getName());
        return mealRepository.findAllByUser(user);
    }
}
