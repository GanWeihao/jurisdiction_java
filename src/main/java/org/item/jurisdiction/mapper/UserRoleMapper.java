package org.item.jurisdiction.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.item.jurisdiction.model.User;
import org.item.jurisdiction.util.SqlSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@Repository
public class UserRoleMapper {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    public int deleteUserRoleByUserId(List<String> userList) throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int j = sqlSession.delete("org.item.jurisdiction.mapper.UserRoleMapper.deleteUserRoleByUserId",userList);
        sqlSession.commit();
        sqlSession.close();
        return j;
    }
}
