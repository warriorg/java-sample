package me.warriorg.mybatis.dao;

import me.warriorg.mybatis.po.UserPo;

/**
 * @author warrior
 */
public interface UserDao {

    UserPo findById(int id);
}
