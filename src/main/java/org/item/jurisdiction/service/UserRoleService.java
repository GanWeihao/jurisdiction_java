package org.item.jurisdiction.service;

import org.item.jurisdiction.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

public interface UserRoleService {

    int deleteUserRoleByUserId(List<String> userList) throws IOException;
}
