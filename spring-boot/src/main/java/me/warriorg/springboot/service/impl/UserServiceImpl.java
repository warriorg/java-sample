package me.warriorg.springboot.service.impl;

import me.warriorg.springboot.entity.UserEntity;
import me.warriorg.springboot.repository.UserRepository;
import me.warriorg.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepo;

    @Override
    public UserEntity getByUid(String uid) {
        return userRepo.findById(uid).orElse(null);
    }
}
