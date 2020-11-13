package me.warriorg.mybatisplus.crud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.warriorg.mybatisplus.crud.mapper.UserMapper;
import me.warriorg.mybatisplus.crud.model.User;
import me.warriorg.mybatisplus.crud.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
