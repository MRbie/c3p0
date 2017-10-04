package com.bie.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bie.dao.UserDao;
import com.bie.po.User;
import com.bie.utils.BaseUtils;

public class UserDaoImpl implements UserDao{

	@Override
    public List<User> selectUser() {
        //创建QueryRunner
        //记住查询是BeanListHandler区别增删改的方法BeanHandler
        QueryRunner qr=BaseUtils.getQueryRunner();
        try {
            String sql="select * from user ";
            //这句话就相当于之前写的下面这一长串代码，这就是QueryRunner的方便之处
            /***
             *User user=new User();
               user.setId(rs.getInt("id"));
               user.setName(rs.getString("name"));
               user.setPassword(rs.getString("password"));
               user.setEmail(rs.getString("email"));
               user.setPhone(rs.getString("phone"));
             */
            return qr.query(sql, new BeanListHandler<User>(User.class));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User selectUserId(int id) {
        //创建QueryRunner
        QueryRunner qr=BaseUtils.getQueryRunner();
        String sql="select * from user where id=? ";
        try {
            //使用QueryRunner的强大之处在于此处。
            return qr.query(sql,new BeanHandler<User>(User.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<User> select(String sql,List<Object> list) {
        //创建QueryRunner
        QueryRunner qr=BaseUtils.getQueryRunner();
        try {
            //第一个参数是传来的sql，第二个是实现实体类的设置，第三个是集合转化为数组
            return qr.query(sql, new BeanListHandler<User>(User.class), list.toArray());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
