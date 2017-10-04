package com.bie.test;

import java.util.List;

import org.junit.Test;

import com.bie.dao.UserDao;
import com.bie.dao.impl.UserDaoImpl;
import com.bie.po.User;
import com.bie.service.UserService;
import com.bie.service.impl.UserServiceImpl;

public class QueryRunnerTest {

	private UserDao dao=new UserDaoImpl();
    private UserService service=new UserServiceImpl();
    
    //查询所有信息的测试
    @Test
    public void selectUser(){
        List<User> list=dao.selectUser();
        for(User u:list){
            System.out.println(u);
        }
    }
    
    //根绝id查询的信息
    @Test
    public void selectUserId(){
        User user=dao.selectUserId(1);
        System.out.println(user);
    }
    
    //根据条件查询信息
    @Test
    public void select(){
        User user=new User();
        user.setName("张三");
        List<User> list=service.select(user);
        for(User u:list){
            System.out.println(u);
        }
    }
    
    @Test
    public void insertUser(){
        User user=new User();
        user.setName("张三");
        user.setPassword("123456");
        user.setEmail("1748@qq.com");
        user.setPhone("11223");
        
        boolean mark=service.insertUser(user);
        if(mark){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
    }
    
    
    @Test
    public void update(){
        User user=new User();
        user.setName("李四");
        user.setId(1);
        
        boolean mark=service.updateUser(user);
        if(mark){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }
    
    @Test
    public void delete(){
        boolean mark=service.deleteUser(1);
        if(mark){
            System.out.println("用户信息删除成功");
        }else{
            System.out.println("用户信息删除失败");
        }
    }
}
