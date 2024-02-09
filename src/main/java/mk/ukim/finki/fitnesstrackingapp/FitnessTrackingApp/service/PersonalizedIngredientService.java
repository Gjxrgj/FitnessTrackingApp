package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.PersonalizedIngredient;

import java.util.Optional;

public interface PersonalizedIngredientService {
    void addPersonalizedIngredient(PersonalizedIngredient ingredient);
    Optional<PersonalizedIngredient> getById(Long id);
}
