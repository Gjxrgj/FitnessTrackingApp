package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Workout;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.DayService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.MealService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.WorkoutService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/day")
@RequiredArgsConstructor
public class DayController {
    private final WorkoutService workoutService;
    private final MealService mealService;
    private final DayService dayService;
    @GetMapping("/workout/{workoutID}")
    public String addWorkoutToDay(@PathVariable Long workoutID) throws BadRequestException {
        dayService.addWorkoutToDay(workoutID);
        return "redirect:/home";
    }
    @GetMapping("/meal/{mealID}")
    public String addMealToDay(@PathVariable Long mealID){
        dayService.addMealToDay(mealService.getById(mealID));
        return "redirect:/home";
    }
    @PostMapping("/removeWorkout/{workoutID}")
    public String removeWorkoutFromDay(@PathVariable Long workoutID, @RequestParam Long dayID){
        dayService.removeWorkoutFromDay(dayID, workoutID);


        return "redirect:/home";
    }
    @PostMapping("/removeMeal/{mealID}")
    public String removeMealFromDay(@PathVariable Long mealID, @RequestParam Long dayID){
        dayService.removeMealFromDay(dayID, mealID);
        return "redirect:/home";
    }



}
