package com.bie.service;

import java.util.List;

import com.bie.po.User;

public interface UserService {

	 /***
     * ����������ѯ�û���Ϣ
     * @param user
     * @return
     */
    public List<User> select(User user);
    
    /***
     * ����û���Ϣ
     * @param user
     * @return
     */
    public boolean insertUser(User user);
    
    /***
     * �޸��û�����Ϣ
     * @param user
     * @return
     */
    public boolean updateUser(User user);
    
    /***
     * ɾ���û���Ϣ
     * @param id
     * @return
     */
    public boolean deleteUser(int id);
}
