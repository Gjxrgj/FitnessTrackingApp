package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/meals")
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;

    @GetMapping
    public String getMealPage(Model model){
        model.addAttribute("mealsList", mealService.getAll());
        return "meals";
    }
    @GetMapping("/addMeal")
    public String getAddMealPage(){
        return "addMeal";
    }
    @PostMapping("/addMeal")
    public String addMeal(@RequestParam String name,
                          @RequestParam String type){
        mealService.addMeal(name ,type);
        return "redirect:/meals";
    }

}
