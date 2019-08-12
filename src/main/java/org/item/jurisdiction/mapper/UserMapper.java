package org.item.jurisdiction.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.item.jurisdiction.model.User;
import org.item.jurisdiction.util.SqlUtil;
import org.item.jurisdiction.util.StringUtil;

public class UserMapper {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

    public User userLogin(String userphone, String usermail, String password) throws ParseException {

        String sql = "select * from user where USER_TELPHONE=? and USER_PASSWORD=? or USER_EMAIL=? and USER_PASSWORD=? and USER_STATUS=0";

        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, new Object[]{userphone, password, usermail, password});

        User user = null;

        if (list.size() > 0) {

            user = new User();

            user.setUserId(StringUtil.isnull(((HashMap) list.get(0)).get("USER_ID")).toString());

            user.setUserName(StringUtil.isnull(((HashMap) list.get(0)).get("USER_NAME")).toString());

            user.setUserPassword(StringUtil.isnull(((HashMap) list.get(0)).get("USER_PASSWORD")).toString());

            user.setUserTelphone(StringUtil.isnull(((HashMap) list.get(0)).get("USER_TELPHONE")).toString());

            user.setUserEmail(StringUtil.isnull(((HashMap) list.get(0)).get("USER_EMAIL")).toString());

            user.setUserTime(this.sdf.parse(StringUtil.isnull(((HashMap) list.get(0)).get("USER_TIME")).toString()));

            user.setUserStatus(Integer.valueOf(StringUtil.iszore(((HashMap) list.get(0)).get("USER_STATUS")).toString()));

            user.setUserError(Integer.valueOf(StringUtil.iszore(((HashMap) list.get(0)).get("USER_ERROR")).toString()));

            user.setUserHeadimg(StringUtil.isnull(((HashMap) list.get(0)).get("USER_HEADIMG")).toString());

        }

        return user;

    }

    public List findAllUser() throws ParseException {

        String sql = "select * from user";

        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, new Object[0]);

        List<User> li = null;

        if (list.size() > 0) {

            li = new ArrayList<User>();

            for (int i = 0; i < list.size(); i++) {

                User user = new User();

                user.setUserId(StringUtil.isnull(((HashMap) list.get(i)).get("USER_ID")).toString());

                user.setUserName(StringUtil.isnull(((HashMap) list.get(i)).get("USER_NAME")).toString());

                user.setUserPassword(StringUtil.isnull(((HashMap) list.get(i)).get("USER_PASSWORD")).toString());

                user.setUserTelphone(StringUtil.isnull(((HashMap) list.get(i)).get("USER_TELPHONE")).toString());

                user.setUserEmail(StringUtil.isnull(((HashMap) list.get(i)).get("USER_EMAIL")).toString());

                user.setUserTime(this.sdf.parse(StringUtil.isnull(((HashMap) list.get(i)).get("USER_TIME")).toString()));

                user.setUserStatus(Integer.valueOf(StringUtil.iszore(((HashMap) list.get(i)).get("USER_STATUS")).toString()));

                user.setUserError(Integer.valueOf(StringUtil.iszore(((HashMap) list.get(i)).get("USER_ERROR")).toString()));

                user.setUserHeadimg(StringUtil.isnull(((HashMap) list.get(i)).get("USER_HEADIMG")).toString());

                li.add(user);

            }

        }

        return li;

    }

    public int deleteUser(String userId) {

        String sql = "delete from user where USER_ID=?";

        String sql2 = "delete from user_role where USER_ROLE_USER_ID=?";

        int i = SqlUtil.executeUpdate(sql, new Object[]{userId});

        int j = SqlUtil.executeUpdate(sql2, new Object[]{userId});

        return i + j;

    }

    public int updateUser(User user) {

        String sql = "update user set USER_NAME=?,USER_TELPHONE=?,USER_EMAIL=? where USER_ID=?";

        return SqlUtil.executeUpdate(sql, new Object[]{user.getUserName(), user.getUserTelphone(), user.getUserEmail(), user.getUserId()});

    }

    public int loginFirst(String userId) {

        String sql = "update user set USER_ERROR=USER_ERROR+1 where USER_ID=?";

        return SqlUtil.executeUpdate(sql, new Object[]{userId});

    }

    public int updateEmail(String email, String userId) {

        String sql = "update user set USER_EMAIL=? where USER_ID=?";

        return SqlUtil.executeUpdate(sql, new Object[]{email, userId});

    }

    public int delEmail(String userId) {

        String sql = "update user set USER_EMAIL=null where USER_ID=?";

        return SqlUtil.executeUpdate(sql, new Object[]{userId});

    }

    public User findByUserId(String id) throws ParseException {

        String sql = "select * from user where USER_ID=?";

        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, new Object[]{id});

        User user = null;

        if (list.size() > 0) {

            user = new User();

            user.setUserId(StringUtil.isnull(((HashMap) list.get(0)).get("USER_ID")).toString());

            user.setUserName(StringUtil.isnull(((HashMap) list.get(0)).get("USER_NAME")).toString());

            user.setUserPassword(StringUtil.isnull(((HashMap) list.get(0)).get("USER_PASSWORD")).toString());

            user.setUserTelphone(StringUtil.isnull(((HashMap) list.get(0)).get("USER_TELPHONE")).toString());

            user.setUserEmail(StringUtil.isnull(((HashMap) list.get(0)).get("USER_EMAIL")).toString());

            user.setUserTime(this.sdf.parse(StringUtil.isnull(((HashMap) list.get(0)).get("USER_TIME")).toString()));

            user.setUserStatus(Integer.valueOf(StringUtil.iszore(((HashMap) list.get(0)).get("USER_STATUS")).toString()));

            user.setUserError(Integer.valueOf(StringUtil.iszore(((HashMap) list.get(0)).get("USER_ERROR")).toString()));

            user.setUserHeadimg(StringUtil.isnull(((HashMap) list.get(0)).get("USER_HEADIMG")).toString());

        }

        return user;

    }

    public int updateHead(User user) {

        String sql = "update user set USER_HEADIMG=? where USER_ID=?";

        return SqlUtil.executeUpdate(sql, new Object[]{user.getUserHeadimg(), user.getUserId()});

    }

    public int updateName(User user) {

        String sql = "update user set USER_NAME=? where USER_ID=?";

        return SqlUtil.executeUpdate(sql, new Object[]{user.getUserName(), user.getUserId()});

    }

    public List findByUserName(String username) {

        String sql = "select * from user where USER_NAME=?";

        return SqlUtil.executeQuery(sql, new Object[]{username});

    }

    public List findByUserEmail(String useremail) {

        String sql = "select * from user where USER_EMAIL=?";

        return SqlUtil.executeQuery(sql, new Object[]{useremail});

    }

    public List findByUserTel(String usertelphone) {

        String sql = "select * from user where USER_TELPHONE=?";

        return SqlUtil.executeQuery(sql, new Object[]{usertelphone});

    }

    public int userAdd(User user) {

        String sql = "insert into user values(?,?,?,?,?,now(),?,?,?)";

        return SqlUtil.executeUpdate(sql, new Object[]{user.getUserId(), user.getUserName(), user.getUserPassword(), user.getUserTelphone(), user.getUserEmail(), user.getUserStatus(), user.getUserError(), user.getUserHeadimg()});

    }

    public List findMenuByUserId(String id) {

        String sql = "SELECT f.MENU_ID MENU_ID, f.MENU_NAME MENU_NAME FROM user a\nLEFT JOIN user_role b ON a.USER_ID = b.USER_ROLE_USER_ID\nLEFT JOIN role c ON b.USER_ROLE_ROLE_ID = c.ROLE_ID\nLEFT JOIN role_rules d ON c.ROLE_ID = d.ROLE_RULES_ROLE_ID\nLEFT JOIN rules e ON d.ROLE_RULES_RULES_ID = e.RULES_ID\nLEFT JOIN menu f ON e.RULES_MENU_ID = f.MENU_ID\nWHERE a.USER_ID = ? \nGROUP BY MENU_ID, MENU_NAME";
        return SqlUtil.executeQuery(sql, new Object[]{id});

    }

    public List findRulesById(String userId) {

        String sql = "SELECT\nE.RULES_ID RULES_ID,\nE.RULES_NAME RULES_NAME,\nE.RULES_URL RULES_URL,\nF.MENU_ID MENU_ID,\nF.MENU_NAME MENU_NAME\nFROM\nUSER A\nLEFT JOIN user_role B ON A.USER_ID = B.USER_ROLE_USER_ID\nLEFT JOIN role C ON B.USER_ROLE_ROLE_ID = C.ROLE_ID\nLEFT JOIN role_rules D ON C.ROLE_ID = D.ROLE_RULES_ROLE_ID\nLEFT JOIN rules E ON D.ROLE_RULES_RULES_ID = E.RULES_ID\nLEFT JOIN menu F ON E.RULES_MENU_ID = F.MENU_ID \nWHERE\nA.USER_ID = ? \nGROUP BY\nRULES_ID,\nRULES_NAME,\nMENU_ID,\nMENU_NAME";
        return SqlUtil.executeQuery(sql, new Object[]{userId});

    }

    public List findRoleByUserId(String userId) {

        String sql = "SELECT C.ROLE_ID rulesid,C.ROLE_NAME rulesname FROM user A\nLEFT JOIN user_role B ON A.USER_ID = B.USER_ROLE_USER_ID\nLEFT JOIN role C ON B.USER_ROLE_ROLE_ID = C.ROLE_ID\nWHERE A.USER_ID = ?\nGROUP BY rulesid,rulesname";
        return SqlUtil.executeQuery(sql, new Object[]{userId});

    }

}