package mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.service;

import mk.ukim.finki.fitnesstrackingapp.FitnessTrackingApp.model.user.User;

public interface UserService {
    public User findByName(String name);
}
