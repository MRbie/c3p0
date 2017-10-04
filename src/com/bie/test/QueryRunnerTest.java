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
    
    //��ѯ������Ϣ�Ĳ���
    @Test
    public void selectUser(){
        List<User> list=dao.selectUser();
        for(User u:list){
            System.out.println(u);
        }
    }
    
    //����id��ѯ����Ϣ
    @Test
    public void selectUserId(){
        User user=dao.selectUserId(1);
        System.out.println(user);
    }
    
    //����������ѯ��Ϣ
    @Test
    public void select(){
        User user=new User();
        user.setName("����");
        List<User> list=service.select(user);
        for(User u:list){
            System.out.println(u);
        }
    }
    
    @Test
    public void insertUser(){
        User user=new User();
        user.setName("����");
        user.setPassword("123456");
        user.setEmail("1748@qq.com");
        user.setPhone("11223");
        
        boolean mark=service.insertUser(user);
        if(mark){
            System.out.println("����ɹ�");
        }else{
            System.out.println("����ʧ��");
        }
    }
    
    
    @Test
    public void update(){
        User user=new User();
        user.setName("����");
        user.setId(1);
        
        boolean mark=service.updateUser(user);
        if(mark){
            System.out.println("�޸ĳɹ�");
        }else{
            System.out.println("�޸�ʧ��");
        }
    }
    
    @Test
    public void delete(){
        boolean mark=service.deleteUser(1);
        if(mark){
            System.out.println("�û���Ϣɾ���ɹ�");
        }else{
            System.out.println("�û���Ϣɾ��ʧ��");
        }
    }
}
