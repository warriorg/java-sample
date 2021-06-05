package me.warriorg.springboot.service.impl;

import me.warriorg.springboot.model.User;
import me.warriorg.springboot.repository.UserRepository;
import me.warriorg.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepo;

    @Override
    public User getByUid(String uid) {
        return userRepo.findById(uid).orElse(null);
    }

    @Override
    public void testTransactionalEvent() {
        
    }
}
