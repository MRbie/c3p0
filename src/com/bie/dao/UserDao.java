package com.bie.dao;

import java.util.List;

import com.bie.po.User;

public interface UserDao {

	 /***
     * 查询所有的用户信息
     * @return
     */
    public List<User> selectUser();
    
    /***
     * 根据编号查询
     * @param id
     * @return
     */
    public User selectUserId(int id);
    
    
    /***
     * 根据条件查询信息
     * @param user
     * @return
     */
    public List<User> select(String sql,List<Object> list);
}
