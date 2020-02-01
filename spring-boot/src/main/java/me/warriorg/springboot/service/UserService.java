package me.warriorg.springboot.service;

import me.warriorg.springboot.model.User;

/**
 * @author warrior
 */
public interface UserService {

    User getByUid(String uid);
}
