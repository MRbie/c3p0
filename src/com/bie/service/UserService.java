package com.bie.service;

import java.util.List;

import com.bie.po.User;

public interface UserService {

	 /***
     * 根据条件查询用户信息
     * @param user
     * @return
     */
    public List<User> select(User user);
    
    /***
     * 添加用户信息
     * @param user
     * @return
     */
    public boolean insertUser(User user);
    
    /***
     * 修改用户的信息
     * @param user
     * @return
     */
    public boolean updateUser(User user);
    
    /***
     * 删除用户信息
     * @param id
     * @return
     */
    public boolean deleteUser(int id);
}
