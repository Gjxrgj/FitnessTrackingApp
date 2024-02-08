package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Meal;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Workout;

public interface DayService {
    Day getDayByDateAndUserID();
    void createDay();
    void addWorkoutToDay(Workout workout);
    void addMealToDay(Meal meal);
}
