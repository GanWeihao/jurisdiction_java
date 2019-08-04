package org.item.jurisdiction.mapper;

import org.item.jurisdiction.model.User;
import org.item.jurisdiction.util.SqlUtil;
import org.item.jurisdiction.util.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserMapper {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

    //登陆
    public User userLogin(String userphone, String usermail, String password) throws ParseException {
        String sql = "select * from user where USER_TELPHONE=? and USER_PASSWORD=? or USER_EMAIL=? and USER_PASSWORD=? and USER_STATUS=0";
        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, userphone, password, usermail, password);
        User user = null;
        if (list.size() > 0) {
            user = new User();
            user.setUserId(StringUtil.isnull(list.get(0).get("USER_ID")).toString());
            user.setUserName(StringUtil.isnull(list.get(0).get("USER_NAME")).toString());
            user.setUserPassword(StringUtil.isnull(list.get(0).get("USER_PASSWORD")).toString());
            user.setUserTelphone(StringUtil.isnull(list.get(0).get("USER_TELPHONE")).toString());
            user.setUserEmail(StringUtil.isnull(list.get(0).get("USER_EMAIL")).toString());
            user.setUserTime(sdf.parse(StringUtil.isnull(list.get(0).get("USER_TIME")).toString()));
            user.setUserStatus(Integer.valueOf(StringUtil.iszore(list.get(0).get("USER_STATUS")).toString()));
            user.setUserError(Integer.valueOf(StringUtil.iszore(list.get(0).get("USER_ERROR")).toString()));
            user.setUserHeadimg(StringUtil.isnull(list.get(0).get("USER_HEADIMG")).toString());
        }
        return user;
    }

    //查询所有用户
    public List findAllUser() throws ParseException {
        String sql = "select * from user";
        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql);
        List<User> li = null;
        if(list.size()>0){
            li = new ArrayList();
            for(int i=0;i<list.size();i++){
                User user = new User();
                user.setUserId(StringUtil.isnull(list.get(i).get("USER_ID")).toString());
                user.setUserName(StringUtil.isnull(list.get(i).get("USER_NAME")).toString());
                user.setUserPassword(StringUtil.isnull(list.get(i).get("USER_PASSWORD")).toString());
                user.setUserTelphone(StringUtil.isnull(list.get(i).get("USER_TELPHONE")).toString());
                user.setUserEmail(StringUtil.isnull(list.get(i).get("USER_EMAIL")).toString());
                user.setUserTime(sdf.parse(StringUtil.isnull(list.get(i).get("USER_TIME")).toString()));
                user.setUserStatus(Integer.valueOf(StringUtil.iszore(list.get(i).get("USER_STATUS")).toString()));
                user.setUserError(Integer.valueOf(StringUtil.iszore(list.get(i).get("USER_ERROR")).toString()));
                user.setUserHeadimg(StringUtil.isnull(list.get(i).get("USER_HEADIMG")).toString());
                li.add(user);
            }
        }
        return li;
    }

    //删除用户
    public int deleteUser(String userId){
        String sql = "delete from user where USER_ID=?";
        String sql2 = "delete from user_role where USER_ROLE_USER_ID=?";
        int i = SqlUtil.executeUpdate(sql, userId);
        int j = SqlUtil.executeUpdate(sql2, userId);
        return i+j;
    }

    //修改用户资料
    public int updateUser(User user){
        String sql = "update user set USER_NAME=?,USER_TELPHONE=?,USER_EMAIL=? where USER_ID=?";
        int i = SqlUtil.executeUpdate(sql, user.getUserName(), user.getUserTelphone(), user.getUserEmail(), user.getUserId());
        return i;
    }

    //登陆次数+1
    public int loginFirst(String userId){
        String sql = "update user set USER_ERROR=USER_ERROR+1 where USER_ID=?";
        int i = SqlUtil.executeUpdate(sql, userId);
        return i;
    }

    //更改邮箱
    public int updateEmail(String email, String userId){
        String sql = "update user set USER_EMAIL=? where USER_ID=?";
        int i = SqlUtil.executeUpdate(sql, email, userId);
        return i;
    }

    //解绑邮箱
    public int delEmail(String userId){
        String sql = "update user set USER_EMAIL=null where USER_ID=?";
        int i = SqlUtil.executeUpdate(sql, userId);
        return i;
    }

    //根据ID查询用户
    public User findByUserId(String id) throws ParseException {
        String sql = "select * from user where USER_ID=?";
        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, id);
        User user = null;
        if(list.size()>0){
            user = new User();
            user.setUserId(StringUtil.isnull(list.get(0).get("USER_ID")).toString());
            user.setUserName(StringUtil.isnull(list.get(0).get("USER_NAME")).toString());
            user.setUserPassword(StringUtil.isnull(list.get(0).get("USER_PASSWORD")).toString());
            user.setUserTelphone(StringUtil.isnull(list.get(0).get("USER_TELPHONE")).toString());
            user.setUserEmail(StringUtil.isnull(list.get(0).get("USER_EMAIL")).toString());
            user.setUserTime(sdf.parse(StringUtil.isnull(list.get(0).get("USER_TIME")).toString()));
            user.setUserStatus(Integer.valueOf(StringUtil.iszore(list.get(0).get("USER_STATUS")).toString()));
            user.setUserError(Integer.valueOf(StringUtil.iszore(list.get(0).get("USER_ERROR")).toString()));
            user.setUserHeadimg(StringUtil.isnull(list.get(0).get("USER_HEADIMG")).toString());
        }
        return user;
    }

    //更换头像
    public int updateHead(User user){
        String sql = "update user set USER_HEADIMG=? where USER_ID=?";
        int i = SqlUtil.executeUpdate(sql , user.getUserHeadimg(), user.getUserId());
        return i;
    }
    //更改姓名
    public int updateName(User user){
        String sql = "update user set USER_NAME=? where USER_ID=?";
        int i = SqlUtil.executeUpdate(sql , user.getUserName(), user.getUserId());
        return i;
    }

    //根据username查询用户
    public List findByUserName(String username){
        String sql = "select * from user where USER_NAME=?";
        List list = SqlUtil.executeQuery(sql, username);
        return list;
    }
    //根据useremail查询用户
    public List findByUserEmail(String useremail){
        String sql = "select * from user where USER_EMAIL=?";
        List list = SqlUtil.executeQuery(sql, useremail);
        return list;
    }
    //根据usertelphone查询用户
    public List findByUserTel(String usertelphone){
        String sql = "select * from user where USER_TELPHONE=?";
        List list = SqlUtil.executeQuery(sql, usertelphone);
        return list;
    }

    //添加用户
    public int userAdd(User user){
        String sql = "insert into user values(?,?,?,?,?,now(),?,?,?)";
        int i = SqlUtil.executeUpdate(sql, user.getUserId(),
                user.getUserName(),
                user.getUserPassword(),
                user.getUserTelphone(),
                user.getUserEmail(),
                user.getUserStatus(),
                user.getUserError(),
                user.getUserHeadimg());
        return i;
    }

    //查询菜单
    public List findMenuByUserId(String id) {
        String sql = "SELECT f.MENU_ID MENU_ID, f.MENU_NAME MENU_NAME FROM user a\n" +
                "LEFT JOIN user_role b ON a.USER_ID = b.USER_ROLE_USER_ID\n" +
                "LEFT JOIN role c ON b.USER_ROLE_ROLE_ID = c.ROLE_ID\n" +
                "LEFT JOIN role_rules d ON c.ROLE_ID = d.ROLE_RULES_ROLE_ID\n" +
                "LEFT JOIN rules e ON d.ROLE_RULES_RULES_ID = e.RULES_ID\n" +
                "LEFT JOIN menu f ON e.RULES_MENU_ID = f.MENU_ID\n" +
                "WHERE a.USER_ID = ? \n" +
                "GROUP BY MENU_ID, MENU_NAME";

        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, id);

        return list;
    }

    //查询权限
    public List findRulesById(String userId) {
        String sql = "SELECT\n" +
                "E.RULES_ID RULES_ID,\n" +
                "E.RULES_NAME RULES_NAME,\n" +
                "F.MENU_ID MENU_ID,\n" +
                "F.MENU_NAME MENU_NAME\n" +
                "FROM\n" +
                "USER A\n" +
                "LEFT JOIN user_role B ON A.USER_ID = B.USER_ROLE_USER_ID\n" +
                "LEFT JOIN role C ON B.USER_ROLE_ROLE_ID = C.ROLE_ID\n" +
                "LEFT JOIN role_rules D ON C.ROLE_ID = D.ROLE_RULES_ROLE_ID\n" +
                "LEFT JOIN rules E ON D.ROLE_RULES_RULES_ID = E.RULES_ID\n" +
                "LEFT JOIN menu F ON E.RULES_MENU_ID = F.MENU_ID \n" +
                "WHERE\n" +
                "A.USER_ID = ? \n" +
                "GROUP BY\n" +
                "RULES_ID,\n" +
                "RULES_NAME,\n" +
                "MENU_ID,\n" +
                "MENU_NAME";

        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, userId);
        return list;
    }

    //查询角色
    public List findRoleByUserId(String userId) {
        String sql = "SELECT C.ROLE_ID rulesid,C.ROLE_NAME rulesname FROM user A\n" +
                "LEFT JOIN user_role B ON A.USER_ID = B.USER_ROLE_USER_ID\n" +
                "LEFT JOIN role C ON B.USER_ROLE_ROLE_ID = C.ROLE_ID\n" +
                "WHERE A.USER_ID = ?\n" +
                "GROUP BY rulesid,rulesname";
        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, userId);
        return list;
    }
}
