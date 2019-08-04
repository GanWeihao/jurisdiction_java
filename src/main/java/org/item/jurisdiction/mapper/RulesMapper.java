package org.item.jurisdiction.mapper;

import org.item.jurisdiction.bo.Rules_Menu;
import org.item.jurisdiction.model.*;
import org.item.jurisdiction.util.SqlUtil;
import org.item.jurisdiction.util.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 权限
 */
public class RulesMapper {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
    //根据id查角色
    public Role findByRoleId(String roleId){
        String sql = "select * from role where ROLE_ID=?";
        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, roleId);
        Role role = null;
        if(list.size()>0){
            role = new Role();
            role.setRoleId(StringUtil.isnull(list.get(0).get("ROLE_ID")).toString());
            role.setRoleName(StringUtil.isnull(list.get(0).get("ROLE_NAME")).toString());
            role.setRoleStatus((Integer) StringUtil.iszore(list.get(0).get("ROLE_STATUS")));
        }
        return role;
    }

    //根据角色查询权限
    public List findByRole(String roleId){
        String sql = "SELECT A.RULES_ID rulesId ,A.RULES_NAME rulesName FROM rules A\n" +
                "LEFT JOIN role_rules B ON A.RULES_ID = B.ROLE_RULES_RULES_ID\n" +
                "LEFT JOIN role C ON C.ROLE_ID = B.ROLE_RULES_ROLE_ID\n" +
                "WHERE C.ROLE_ID = ?";
        List list = SqlUtil.executeQuery(sql, roleId);
        return list;
    }

    //查询用户角色
    public List findByUserId(String userId){
        String sql = "select a.ROLE_ID roleId,a.ROLE_NAME roleName from role a\n" +
                "left join user_role b on a.ROLE_ID = b.USER_ROLE_ROLE_ID\n" +
                "left join user c on b.USER_ROLE_USER_ID = c.USER_ID\n" +
                "where c.USER_ID = ?";
        List list = SqlUtil.executeQuery(sql, userId);
        return list;
    }

    //查询所有角色
    public List findAll(){
        String sql = "select * from role";
        List list = SqlUtil.executeQuery(sql);
        return list;
    }

    //删除用户所有角色
    public int delall(String userId){
        String sql = "delete from user_role where USER_ROLE_USER_ID = ?";
        int i = SqlUtil.executeUpdate(sql, userId);
        return i;
    }

    //给用户添加角色
    public int addUserRole(UserRole userRole){
        String sql = "insert into user_role values(?, ?, ?)";
        int i = SqlUtil.executeUpdate(sql, userRole.getUserRoleId(), userRole.getUserRoleUserId(), userRole.getUserRoleRoleId());
        return i;
    }

    //查询所有权限
    public List findAllRules(){
        String sql = "select * from rules order by RULES_ORDER";
        List list = SqlUtil.executeQuery(sql);
        return list;
    }

    //添加角色
    public int addRole(Role role){
        String sql = "insert into role values(?, ?, ?)";
        int i = SqlUtil.executeUpdate(sql,role.getRoleId(), role.getRoleName(), role.getRoleStatus());
        return i;
    }

    //删除角色所有权限
    public int delRoleRules(RoleRules roleRules){
        String sql1 = "delete from role_rules where ROLE_RULES_ROLE_ID=?";
        int i = SqlUtil.executeUpdate(sql1, roleRules.getRoleRulesRoleId());
        return i;
    }

    //给角色设置权限
    public int setRules(RoleRules roleRules){
        String sql2 = "insert into role_rules values (?, ?, ?)";
        int j = SqlUtil.executeUpdate(sql2, roleRules.getRoleRulesId(), roleRules.getRoleRulesRoleId(), roleRules.getRoleRulesRulesId());
        return j;
    }

    //删除角色
    public int delRole(String roleId){
        String sql = "delete from role where ROLE_ID=?";
        int i = SqlUtil.executeUpdate(sql, roleId);
        return i;
    }

    //查询所有权限（带上级菜单）
    public List findallRulesWithMenu() throws ParseException {
//        String sql = "SELECT\n" +
//                "\ta.RULES_ID rulesId,\n" +
//                "\ta.RULES_NAME rulesName,\n" +
//                "\ta.RULES_TIME rulesTime,\n" +
//                "\tb.MENU_ID menuId,\n" +
//                "\tb.MENU_NAME menuName \n" +
//                "FROM\n" +
//                "\trules a\n" +
//                "\tLEFT JOIN menu b ON a.RULES_MENU_ID = b.MENU_ID";

        String sql = "SELECT\n" +
                "\t*\n" +
                "FROM\n" +
                "\trules a\n" +
                "\tLEFT JOIN menu b ON a.RULES_MENU_ID = b.MENU_ID";
        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql);
        List li = new ArrayList();
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                Rules_Menu rules_menu = new Rules_Menu();
                Menu menu = new Menu();
                rules_menu.setRulesId(StringUtil.isnull(list.get(i).get("RULES_ID")).toString());
                rules_menu.setRulesMenuId(StringUtil.isnull(list.get(i).get("RULES_MENU_ID")).toString());
                rules_menu.setRulesName(StringUtil.isnull(list.get(i).get("RULES_NAME")).toString());
                rules_menu.setRulesTime(sdf.parse(StringUtil.isnull(list.get(i).get("RULES_TIME")).toString()));
                rules_menu.setRulesStatus(Integer.valueOf(StringUtil.isnull(list.get(i).get("RULES_STATUS")).toString()));

                menu.setMenuId(StringUtil.isnull(list.get(i).get("MENU_ID")).toString());
                menu.setMenuName(StringUtil.isnull(list.get(i).get("MENU_NAME")).toString());
                rules_menu.setMenu(menu);

                li.add(rules_menu);
            }
        }
        return li;
    }

    //添加权限
    public int inserrules(Rules rules){
        String sql = "insert into rules " +
                "(RULES_ID,RULES_MENU_ID,RULES_NAME,RULES_TIME,RULES_STATUS) " +
                "values(?,?,?,now(),?)";
        int i = SqlUtil.executeUpdate(sql,rules.getRulesId(),rules.getRulesMenuId(),rules.getRulesName(),rules.getRulesStatus());
        return i;
    }

    //修改权限
    public int updateRules(Rules rules){
        String sql = "update rules set RULES_MENU_ID=? , RULES_NAME=? where RULES_ID=?";
        int i = SqlUtil.executeUpdate(sql, rules.getRulesMenuId(), rules.getRulesName(), rules.getRulesId());
        return i;
    }

    //查询所有菜单
    public List findAllMenu(){
        String sql = "select * from menu";
        List list = SqlUtil.executeQuery(sql);
        return list;
    }

    //删除权限
    public int deleteRules(String rulesId){
        String sql = "delete from rules where RULES_ID=?";
        int i = SqlUtil.executeUpdate(sql, rulesId);
        return i;
    }

    //根据权限ID删除赋权表
    public int deleteRoleRules(String rulesId){
        String sql = "delete from role_rules where ROLE_RULES_RULES_ID=?";
        int i = SqlUtil.executeUpdate(sql, rulesId);
        return i;
    }
}
