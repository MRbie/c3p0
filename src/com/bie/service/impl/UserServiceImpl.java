package com.bie.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bie.dao.UserDao;
import com.bie.dao.impl.UserDaoImpl;
import com.bie.po.User;
import com.bie.service.UserService;
import com.bie.utils.BaseUtils;

public class UserServiceImpl implements UserService{

	 private UserDao dao=new UserDaoImpl();
	    
    @Override
    public List<User> select(User user) {
        StringBuilder sql=new StringBuilder("select * from user where 1=1 ");
        List<Object> list=new ArrayList<Object>();
        if(user!=null){
            //根据编号查询
            if(user.getId()!=0 && !"".equals(user.getId())){
                sql.append(" and id = ? ");
                list.add(user.getId());
            }
            
            //根据名称模糊查询,模糊查询"" %% "" ++
            if(user.getName()!=null && !"".equals(user.getName())){
                sql.append(" and name like ? ");
                list.add("%"+user.getName()+"%");
            }
        }
        
        return dao.select(sql.toString(), list);
    }

    @Override
    public boolean insertUser(User user) {
        String sql="insert into user values(0,?,?,?,?)";
        List<Object> list=new ArrayList<>();
        if(user!=null){
            list.add(user.getName());
            list.add(user.getPassword());
            list.add(user.getEmail());
            list.add(user.getPhone());
        }
        try {
            return BaseUtils.addUpdateDelete(sql, list.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        String sql="update user set name=?,password=?,email=?,phone=? where id=? ";
        List<Object> list=new ArrayList<>();
        if(user!=null){
            list.add(user.getName());
            list.add(user.getPassword());
            list.add(user.getEmail());
            list.add(user.getPhone());
            
            //根据编号修改信息
            list.add(user.getId());
        }
        
        try {
            return BaseUtils.addUpdateDelete(sql, list.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        String sql="delete from user where id=? ";
        List<Object> list=new ArrayList<>();
        if(id!=0){
            //根据编号修改信息
            list.add(id);
        }
        
        try {
            return BaseUtils.addUpdateDelete(sql, list.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
