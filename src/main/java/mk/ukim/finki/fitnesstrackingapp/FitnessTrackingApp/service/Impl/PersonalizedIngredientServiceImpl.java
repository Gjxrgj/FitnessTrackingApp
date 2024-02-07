package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.PersonalizedIngredient;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.PersonalizedIngredientRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.PersonalizedIngredientService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonalizedIngredientServiceImpl implements PersonalizedIngredientService {
    private final PersonalizedIngredientRepository personalizedIngredientRepository;
    @Override
    public void addPersonalizedIngredient(PersonalizedIngredient ingredient) {
        personalizedIngredientRepository.save(ingredient);
    }
}
