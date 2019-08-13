package org.item.jurisdiction.service.Impl;

import org.item.jurisdiction.mapper.UserRoleMapper;
import org.item.jurisdiction.model.User;
import org.item.jurisdiction.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public int deleteUserRoleByUserId(List<String> userList) throws IOException {
        return userRoleMapper.deleteUserRoleByUserId(userList);
    }
}
