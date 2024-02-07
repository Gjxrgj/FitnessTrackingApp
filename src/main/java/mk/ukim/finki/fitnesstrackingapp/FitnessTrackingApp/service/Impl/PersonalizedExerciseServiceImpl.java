package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Exercise;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.PersonalizedExercise;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.PersonalizedExerciseRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.PersonalizedExerciseService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonalizedExerciseServiceImpl implements PersonalizedExerciseService {
    private final PersonalizedExerciseRepository personalizedExerciseRepository;


    @Override
    public void addPersonalizedExercise(PersonalizedExercise personalizedExercise) {
        personalizedExerciseRepository.save(personalizedExercise);
    }
}
