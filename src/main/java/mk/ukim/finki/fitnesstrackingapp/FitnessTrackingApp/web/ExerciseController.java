package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Exercise;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.ExerciseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exercises")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;
    @GetMapping
    public String getExercisePage(Model model){
        model.addAttribute("exerciseList", exerciseService.getAll());
        return "exercise";
    }
    @GetMapping("/addExercise")
    public String getAddExercisePage(){
        return "addExercise";
    }
    @PostMapping("/addExercise")
    public String addExercise(@RequestParam String name,
                              @RequestParam int reps,
                              @RequestParam int sets,
                              @RequestParam int weight,
                              @RequestParam int time,
                              @RequestParam String type
                              ){
        exerciseService.addExercise(new Exercise(name, reps, sets, weight, time, type));
        return "redirect:/exercises";
    }
}
