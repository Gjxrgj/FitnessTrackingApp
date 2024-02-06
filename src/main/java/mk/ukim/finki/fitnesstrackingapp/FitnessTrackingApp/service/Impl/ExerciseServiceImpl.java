package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Exercise;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.ExerciseRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.ExerciseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    @Override
    public List<Exercise> getAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public void addExercise(Exercise exercise) {
        if (exercise.getType().equalsIgnoreCase("Cardio")){
            exercise.setReps(0);
            exercise.setSets(0);
            exercise.setWeight(0);
        }else{
            exercise.setTime(0);
        }
        exerciseRepository.save(exercise);
    }
}
