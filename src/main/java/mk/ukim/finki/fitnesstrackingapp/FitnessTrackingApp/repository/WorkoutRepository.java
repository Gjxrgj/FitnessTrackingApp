package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Workout;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    @Override
    List<Workout> findAll();
}
