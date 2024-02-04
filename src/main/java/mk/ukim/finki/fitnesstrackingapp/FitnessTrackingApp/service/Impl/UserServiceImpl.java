package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.Impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.repository.UserRepository;
import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User findByName(String name) {
        return userRepository.findByName(name).get();
    }
}
