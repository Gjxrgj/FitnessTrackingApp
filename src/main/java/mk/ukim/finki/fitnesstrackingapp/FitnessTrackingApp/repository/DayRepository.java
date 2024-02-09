package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

}
