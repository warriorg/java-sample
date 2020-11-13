package me.warriorg.mybatis.dao.impl;

import me.warriorg.mybatis.dao.UserDao;
import me.warriorg.mybatis.po.UserPo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author warrior
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public UserPo findById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserPo user = sqlSession.selectOne("me.warriorg.mybatis.dao.UserDao.findById", id);
        return user;
    }

}
