package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.web;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Ingredient;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.IngredientService;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;
    @GetMapping
    public String getIngredientsPage(Model model){
        model.addAttribute("ingredientList", ingredientService.getAll());
        return "ingredients";
    }

    @GetMapping("/addIngredient")
    public String getAddIngredientPage(){
        return "addIngredient";
    }
    @PostMapping("/addIngredient")
    public String addIngredient(@RequestParam String name,
                                @RequestParam int calories,
                                @RequestParam int quantity,
                                @RequestParam int protein,
                                @RequestParam int carbs,
                                @RequestParam int fats

                                ){
        ingredientService.addIngredient(new Ingredient(name, calories, quantity, protein, carbs, fats));
        return "redirect:/ingredients";
    }

}
