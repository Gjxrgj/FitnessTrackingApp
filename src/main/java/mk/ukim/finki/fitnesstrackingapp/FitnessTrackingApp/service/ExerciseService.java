package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Exercise;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.ExerciseRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    List<Exercise> getAll();
    void addExercise(Exercise exercise);

    Optional<Exercise> findById(Long id);
}
