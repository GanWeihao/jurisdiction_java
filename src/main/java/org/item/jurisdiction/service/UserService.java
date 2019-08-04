package org.item.jurisdiction.service;

import org.item.jurisdiction.model.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {
    //查询所有用户
    public List findAllUser() throws ParseException;

    //更换头像
    public int updateHead(User user);

    //更改姓名
    public int updateName(User user);

    //解绑邮箱
    public int delEmail(String userId);

    //更改邮箱
    public int updateEmail(String userEmail, String userId);

    //登陆
    public User userLogin(String username, String usermail, String password) throws ParseException;

    //首次登录
    public int loginFirst(String userId);

    //根据ID查询用户
    public User findByUserId(String id) throws ParseException;

    //查询菜单
    public List findMenuByUserId(String id);

    //查询权限
    public List findRulesById(String userId);

    //查询角色
    public List findRoleByUserId(String userId);

    //添加用户
    public String userAdd(User user);

    //根据用户名查用户
    public List findByUserName(String username);

    //根据邮箱查用户
    public List findByUserEmail(String useremail);

    //根据手机号查用户
    public List findByUserTel(String usertelphone);

    //删除用户
    public int deleteUser(String userId);

    //修改用户资料
    public int updateUser(User user);
}
