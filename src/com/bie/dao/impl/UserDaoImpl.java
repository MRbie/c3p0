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
        //����QueryRunner
        //��ס��ѯ��BeanListHandler������ɾ�ĵķ���BeanHandler
        QueryRunner qr=BaseUtils.getQueryRunner();
        try {
            String sql="select * from user ";
            //��仰���൱��֮ǰд��������һ�������룬�����QueryRunner�ķ���֮��
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
        //����QueryRunner
        QueryRunner qr=BaseUtils.getQueryRunner();
        String sql="select * from user where id=? ";
        try {
            //ʹ��QueryRunner��ǿ��֮�����ڴ˴���
            return qr.query(sql,new BeanHandler<User>(User.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<User> select(String sql,List<Object> list) {
        //����QueryRunner
        QueryRunner qr=BaseUtils.getQueryRunner();
        try {
            //��һ�������Ǵ�����sql���ڶ�����ʵ��ʵ��������ã��������Ǽ���ת��Ϊ����
            return qr.query(sql, new BeanListHandler<User>(User.class), list.toArray());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
