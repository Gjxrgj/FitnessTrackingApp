package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    @Override
    List<Exercise> findAll();
}
