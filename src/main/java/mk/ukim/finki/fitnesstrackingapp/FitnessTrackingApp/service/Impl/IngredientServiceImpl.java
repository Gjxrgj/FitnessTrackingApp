package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Ingredient;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.IngredientsRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientsRepository ingredientsRepository;
    @Override
    public List<Ingredient> getAll() {
        return ingredientsRepository.findAll();
    }

    @Override
    @Transactional
    public void addIngredient(Ingredient ingredient) {
        ingredientsRepository.save(ingredient);
    }
}
