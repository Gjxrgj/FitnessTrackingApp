package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Exercise;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.ExerciseRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.ExerciseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;


    @Override
    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public void addExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public Optional<Exercise> findById(Long id) {
        return exerciseRepository.findById(id);
    }
}
