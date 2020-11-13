package me.warriorg.mybatis;

import me.warriorg.mybatis.dao.UserDao;
import me.warriorg.mybatis.dao.impl.UserDaoImpl;
import me.warriorg.mybatis.po.UserPo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {


    public static void main(String[] args) throws IOException {
        // 加载劝酒配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        UserDao dao = new UserDaoImpl(sqlSessionFactory);
        UserPo user = dao.findById(1);
        System.out.println(user);
    }

}
