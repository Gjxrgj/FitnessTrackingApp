package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Meal;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Workout;
import org.apache.coyote.BadRequestException;

public interface DayService {
    Day getDayByDateAndUserID();
    void createDay();
    void addWorkoutToDay(Long workoutID);
    void addMealToDay(Meal meal);

    void removeWorkoutFromDay(Long dayID, Long workoutId);
    void removeMealFromDay(Long dayID, Long mealID);
}
