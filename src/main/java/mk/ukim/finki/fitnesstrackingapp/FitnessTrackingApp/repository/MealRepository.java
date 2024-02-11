package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository;

import jakarta.persistence.Id;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Meal;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    @Override
    List<Meal> findAll();
    List<Meal> findAllByOrderByNameAsc();
    List<Meal> findAllByUserOrderByNameAsc(User user);
    List<Meal> findAllByUser (User user);
}
