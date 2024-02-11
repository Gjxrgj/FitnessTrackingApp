package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Exercise;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.PersonalizedExercise;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Workout;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.PersonalizedExerciseRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.WorkoutRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.ExerciseService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.PersonalizedExerciseService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.UserService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.WorkoutService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final ExerciseService exerciseService;
    private final HttpSession session;
    private final PersonalizedExerciseService personalizedExerciseService;
    private final PersonalizedExerciseRepository personalizedExerciseRepository;
    private final UserService userService;

    @Override
    public List<Workout> getAll() {
        return workoutRepository.findAll();
    }

    @Override
    public List<Workout> getAllByUserInSession() {
        User user = userService.findByName(((User) session.getAttribute("user")).getName());
        return workoutRepository.findAllByUser(user);
    }

    @Override
    @Transactional
    public void addWorkout(String name) {
        workoutRepository.save(
                Workout.builder()
                        .user((User) session.getAttribute("user"))
                        .name(name)
                        .build());
    }

    @Override
    @Transactional
    public void addExerciseToWorkout(Long workoutId, Long exerciseID, Integer sets, Integer reps, Integer weight, Integer time) {
        if (time == null) {
            time = 0;
        } else {
            sets = 0;
            reps = 0;
            weight = 0;
        }
        Exercise exercise = exerciseService.findById(exerciseID).orElseThrow();
        PersonalizedExercise personalizedExercise = new PersonalizedExercise(exercise, sets, reps, weight, time);

        personalizedExerciseService.addPersonalizedExercise(personalizedExercise);
        Workout workout = workoutRepository.findById(workoutId).orElseThrow();
        workout.addExercise(personalizedExercise);
        workoutRepository.save(workout);
    }

    @Override
    public Workout getById(Long workoutID) {
        return workoutRepository.findById(workoutID).orElseThrow();
    }

    @Override
    @Transactional
    public void removeExercise(Long workoutID, Long exerciseID) {
        Workout workout = workoutRepository.findById(workoutID).orElseThrow();
        PersonalizedExercise exercise = personalizedExerciseRepository.findById(exerciseID).orElseThrow();
        workout.getExercises().remove(exercise);
        workoutRepository.save(workout);
    }
}
