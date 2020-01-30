package me.warriorg.springboot.service;

import me.warriorg.springboot.entity.UserEntity;

/**
 * @author warrior
 */
public interface UserService {

    UserEntity getByUid(String uid);
}
