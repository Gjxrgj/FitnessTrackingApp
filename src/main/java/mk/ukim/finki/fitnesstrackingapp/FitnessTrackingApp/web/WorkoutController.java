package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.WorkoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutService workoutService;
    @GetMapping
    public String getWorkoutsPage(Model model){
        model.addAttribute("workoutList", workoutService.getAll());
        return "workouts";
    }
    @GetMapping("/addWorkout")
    public String getAddWorkoutPage(){
        return "addWorkout";
    }
    @PostMapping("/addWorkout")
    public String addWorkout(@RequestParam String name){
        workoutService.addWorkout(name);
        return "redirect:/workouts";
    }

}
