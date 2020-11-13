package me.warriorg.springboot.service.impl;

import me.warriorg.springboot.model.User;
import me.warriorg.springboot.repository.UserRepository;
import me.warriorg.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepo;

    @Override
    public User getByUid(String uid) {
        return userRepo.findById(uid).orElse(null);
    }
}
