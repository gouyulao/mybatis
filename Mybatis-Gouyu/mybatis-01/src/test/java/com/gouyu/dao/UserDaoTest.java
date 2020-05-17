package com.gouyu.dao;

import com.gouyu.pojo.User;
import com.gouyu.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test01(){
        //获得sqlSession
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        //释放资源
        sqlSession.close();
    }


    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void test03(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=new User("张三2","zs123");
        int count=userMapper.addUser(user);
        if(count>0){
            sqlSession.commit();
            System.out.println("新增成功");
        }
        sqlSession.close();
    }

    @Test
    public void test04(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=new User(4,"张三3","zs456");
        int count=userMapper.updUser(user);
        if(count>0){
            sqlSession.commit();
            System.out.println("更新成功");
        }
        sqlSession.close();
    }

    @Test
    public void test05(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count=userMapper.delUser(4);
        if(count>0){
            sqlSession.commit();
            System.out.println("删除成功");
        }
        sqlSession.close();
    }
}
