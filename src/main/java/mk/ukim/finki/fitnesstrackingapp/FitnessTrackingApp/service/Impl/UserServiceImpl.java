package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.Day;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.DayRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.UserRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DayRepository dayRepository;
    @Override
    public User findByName(String name) {
        return userRepository.findByName(name).get();
    }

    @Override
    public List<User> listALl() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
