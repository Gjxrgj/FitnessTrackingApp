package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Meal;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Workout;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.DayRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.DayService;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.UserService;
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
    @Override
    public Day getDayByDateAndUserID() {
        return null;
    }

    @Override
    @Scheduled(cron="0 0 * * *")
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
    public void addWorkoutToDay(Workout workout) {
        User user = (User) session.getAttribute("user");
        Day day = user.getToday();
        day.addWorkoutToDay(workout);
        dayRepository.save(day);
    }

    @Override
    public void addMealToDay(Meal meal) {
        User user = (User) session.getAttribute("user");
        Day day = user.getToday();
        day.addMealToDay(meal);
        dayRepository.save(day);

    }
}
