package com.bie.dao;

import java.util.List;

import com.bie.po.User;

public interface UserDao {

	 /***
     * ��ѯ���е��û���Ϣ
     * @return
     */
    public List<User> selectUser();
    
    /***
     * ���ݱ�Ų�ѯ
     * @param id
     * @return
     */
    public User selectUserId(int id);
    
    
    /***
     * ����������ѯ��Ϣ
     * @param user
     * @return
     */
    public List<User> select(String sql,List<Object> list);
}
