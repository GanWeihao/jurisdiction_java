package org.item.jurisdiction.service.Impl;

import org.item.jurisdiction.mapper.UserMapper;
import org.item.jurisdiction.model.User;
import org.item.jurisdiction.service.UserService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    UserMapper userMapper = new UserMapper();


    //更改姓名
    @Override
    public int updateName(User user) {
        int i = userMapper.updateName(user);
        return i;
    }

    //解绑邮箱
    @Override
    public int delEmail(String userId) {
        int i = userMapper.delEmail(userId);
        return i;
    }

    //修改邮箱
    @Override
    public int updateEmail(String userEmail, String userId) {
        int i = userMapper.updateEmail(userEmail, userId);
        return i;
    }

    //查询所有用户
    @Override
    public List findAllUser() throws ParseException {
        return userMapper.findAllUser();
    }

    //更换头像
    @Override
    public int updateHead(User user) {
        int i = userMapper.updateHead(user);
        return i;
    }

    //登陆
    @Override
    public User userLogin(String username, String usermail, String password) throws ParseException {
        User user = userMapper.userLogin(username, usermail, password);
        return user;
    }

    //首次登录
    @Override
    public int loginFirst(String userId) {
        int i = userMapper.loginFirst(userId);
        return i;
    }

    //根据ID查询用户
    @Override
    public User findByUserId(String id) throws ParseException {
        User user = userMapper.findByUserId(id);
        return user;
    }

    //菜单
    @Override
    public List findMenuByUserId(String id) {
        List list = userMapper.findMenuByUserId(id);
        return list;
    }

    //权限
    @Override
    public List findRulesById(String userId) {
        List list = userMapper.findRulesById(userId);
        return list;
    }

    //角色
    @Override
    public List findRoleByUserId(String userId) {
        List list = userMapper.findRoleByUserId(userId);
        return list;
    }

    @Override
    public String userAdd(User user) {
        if(user.getUserTelphone() == null){
            user.setUserTelphone("");
        }
        if(user.getUserEmail() == null){
            user.setUserEmail("");
        }

        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        user.setUserError(0);
        user.setUserStatus(0);
        int i = userMapper.userAdd(user);
        return id;
    }

    @Override
    public List findByUserName(String username) {
        List list = userMapper.findByUserName(username);
        return list;
    }

    @Override
    public List findByUserEmail(String useremail) {
        List list = userMapper.findByUserEmail(useremail);
        return list;
    }

    @Override
    public List findByUserTel(String usertelphone) {
        List list = userMapper.findByUserTel(usertelphone);
        return list;
    }

    @Override
    public int deleteUser(String userId) {
        return userMapper.deleteUser(userId);
    }

    //修改用户资料
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
