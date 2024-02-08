package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Workout;

import java.util.List;

public interface WorkoutService {
    List<Workout> getAll();
    void addWorkout(String name);

    void addExerciseToWorkout(Long workoutID, Long exerciseID, Integer sets, Integer reps, Integer weight, Integer time);
    Workout getById(Long workoutID);
}
