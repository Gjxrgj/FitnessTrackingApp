package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface UserService {
    User findByName(String name);
    List<User> listALl();
    void save(User user);


}
