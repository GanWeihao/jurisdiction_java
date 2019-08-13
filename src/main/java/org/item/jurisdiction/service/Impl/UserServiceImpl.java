package org.item.jurisdiction.service.Impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import org.item.jurisdiction.mapper.UserMapper;
import org.item.jurisdiction.model.User;
import org.item.jurisdiction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public int updateName(User user) {
        return this.userMapper.updateName(user);
    }

    public int delEmail(String userId) {
        return this.userMapper.delEmail(userId);
    }

    public int updateEmail(String userEmail, String userId) {
        return this.userMapper.updateEmail(userEmail, userId);
    }

    public List findAllUser() throws ParseException {
        return this.userMapper.findAllUser();
    }

    public int updateHead(User user) {
        return this.userMapper.updateHead(user);
    }

    public User userLogin(String username, String usermail, String password) throws ParseException {
        return this.userMapper.userLogin(username, usermail, password);
    }

    public int loginFirst(String userId) {
        return this.userMapper.loginFirst(userId);
    }

    public User findByUserId(String id) throws ParseException {
        return this.userMapper.findByUserId(id);
    }

    public List findMenuByUserId(String id) {
        return this.userMapper.findMenuByUserId(id);
    }

    public List findRulesById(String userId) {
        return this.userMapper.findRulesById(userId);
    }

    public List findRoleByUserId(String userId) {
        return this.userMapper.findRoleByUserId(userId);
    }

    public String userAdd(User user) {
        if (user.getUserTelphone() == null) {
            user.setUserTelphone("");
        }
        if (user.getUserEmail() == null) {
            user.setUserEmail("");
        }
        String id = UUID.randomUUID().toString().replaceAll("-","");
        user.setUserId(id);
        user.setUserError(Integer.valueOf(0));
        user.setUserStatus(Integer.valueOf(0));
        int i = this.userMapper.userAdd(user);
        return id;
    }

    public List findByUserName(String username) {
        return this.userMapper.findByUserName(username);
    }

    public List findByUserEmail(String useremail) {
        return this.userMapper.findByUserEmail(useremail);
    }

    public List findByUserTel(String usertelphone) {
        return this.userMapper.findByUserTel(usertelphone);
    }

    public int deleteUser(String userId) {
        return this.userMapper.deleteUser(userId);
    }

    public int updateUser(User user) {
        return this.userMapper.updateUser(user);
    }

    @Override
    public int deleteUserByPrimaryKey(List<String> userList) throws IOException {
        return userMapper.deleteUserByPrimaryKey(userList);
    }
}