package com.Wayne.service;

import com.Wayne.mapper.UserMapper;
import com.Wayne.pojo.User;
import com.Wayne.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     * @param userrname
     * @param password
     * @return
     */

    public User login(String userrname, String password) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取SqlSession
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 调用方法
        User user = mapper.select(userrname, password);

        //释放资源
        sqlSession.close();

        return user;
    }

    /**
     * 注册方法
     *
     * @return
     */

    public boolean register(User user) {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取SqlSession
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if(u == null) {
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u == null;
    }
}
