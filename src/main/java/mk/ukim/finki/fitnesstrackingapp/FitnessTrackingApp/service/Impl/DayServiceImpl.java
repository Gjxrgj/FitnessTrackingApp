package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Meal;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Workout;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.DayRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.MealRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.WorkoutRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.DayService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.UserService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.WorkoutService;
import org.apache.coyote.BadRequestException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@AllArgsConstructor
public class DayServiceImpl implements DayService {
    private final DayRepository dayRepository;
    private final UserService userService;
    private final HttpSession session;
    private final WorkoutRepository workoutRepository;
    private final MealRepository mealRepository;
    private final WorkoutService workoutService;
    @Override
    public Day getDayByDateAndUserID() {
        return null;
    }

    @Override
    @Scheduled(cron="0 0 * * *")
    @Transactional
    public void createDay() {
        for(User user : userService.listALl()){
            Day day = Day.builder()
                    .date(LocalDate.now())
                    .build();
            dayRepository.save(day);
            user.addDay(day);
            userService.save(user);
        }
    }

    @Override
    @Transactional
    public void addWorkoutToDay(Long workoutID) {
        User user = userService.findByName(((User) session.getAttribute("user")).getName());
        Day day = user.getToday();
        day.addWorkoutToDay(workoutService.getById(workoutID));
        dayRepository.save(day);
    }

    @Override
    @Transactional
    public void addMealToDay(Meal meal){
        User user = userService.findByName(((User) session.getAttribute("user")).getName());
        Day day = user.getToday();
        day.addMealToDay(meal);
        dayRepository.save(day);

    }

    @Override
    @Transactional
    public void removeWorkoutFromDay(Long dayID, Long workoutId) {
        Workout workout = workoutRepository.findById(workoutId).orElseThrow();
        Day day = dayRepository.findById(dayID).orElseThrow();
        day.getWorkouts().remove(workout);
        dayRepository.save(day);
    }

    @Override
    @Transactional
    public void removeMealFromDay(Long dayID, Long mealID) {
        Meal meal = mealRepository.findById(mealID).orElseThrow();
        Day day = dayRepository.findById(dayID).orElseThrow();
        day.getMeals().remove(meal);
        dayRepository.save(day);
    }
}
