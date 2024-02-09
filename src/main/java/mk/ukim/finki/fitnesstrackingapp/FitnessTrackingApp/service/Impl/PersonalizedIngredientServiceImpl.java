package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.PersonalizedIngredient;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.PersonalizedIngredientRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.PersonalizedIngredientService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonalizedIngredientServiceImpl implements PersonalizedIngredientService {
    private final PersonalizedIngredientRepository personalizedIngredientRepository;
    @Override
    @Transactional
    public void addPersonalizedIngredient(PersonalizedIngredient ingredient) {
        personalizedIngredientRepository.save(ingredient);
    }

    @Override
    public Optional<PersonalizedIngredient> getById(Long id) {
        return personalizedIngredientRepository.findById(id);
    }
}
