package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> getAll();
    void addExercise(Exercise exercise);
}
