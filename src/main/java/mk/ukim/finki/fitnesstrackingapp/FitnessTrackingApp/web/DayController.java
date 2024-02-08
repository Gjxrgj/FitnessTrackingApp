package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.DayService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.MealService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.WorkoutService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/day")
@RequiredArgsConstructor
public class DayController {
    private final WorkoutService workoutService;
    private final MealService mealService;
    private final DayService dayService;
    @GetMapping("/workout/{workoutID}")
    public String addWorkoutToDay(@PathVariable Long workoutID){
        dayService.addWorkoutToDay(workoutService.getById(workoutID));
        return "redirect:/home";
    }
    @GetMapping("/meal/{mealID}")
    public String addMealToDay(@PathVariable Long mealID){
        dayService.addMealToDay(mealService.getById(mealID));
        return "redirect:/home";
    }
}
