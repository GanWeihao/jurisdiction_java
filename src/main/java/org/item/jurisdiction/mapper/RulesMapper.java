package org.item.jurisdiction.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.item.jurisdiction.bo.Rules_Menu;
import org.item.jurisdiction.mapper.RulesMapper;
import org.item.jurisdiction.model.Menu;
import org.item.jurisdiction.model.Role;
import org.item.jurisdiction.model.RoleRules;
import org.item.jurisdiction.model.Rules;
import org.item.jurisdiction.model.Url;
import org.item.jurisdiction.model.UserRole;
import org.item.jurisdiction.util.SqlUtil;
import org.item.jurisdiction.util.StringUtil;

public class RulesMapper {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

    public Role findByRoleId(String roleId) {
        String sql = "select * from role where ROLE_ID=?";
        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, roleId);
        Role role = null;
        if (list.size() > 0) {
            role = new Role();
            role.setRoleId(StringUtil.isnull(((HashMap) list.get(0)).get("ROLE_ID")).toString());
            role.setRoleName(StringUtil.isnull(((HashMap) list.get(0)).get("ROLE_NAME")).toString());
            role.setRoleStatus((Integer) StringUtil.iszore(((HashMap) list.get(0)).get("ROLE_STATUS")));
        }
        return role;
    }

    public List findByRole(String roleId) {
        String sql = "SELECT A.RULES_ID rulesId ,A.RULES_NAME rulesName FROM rules A\nLEFT JOIN role_rules B ON A.RULES_ID = B.ROLE_RULES_RULES_ID\nLEFT JOIN role C ON C.ROLE_ID = B.ROLE_RULES_ROLE_ID\nWHERE C.ROLE_ID = ?";
        return SqlUtil.executeQuery(sql, roleId);
    }

    public List findByUserId(String userId) {
        String sql = "select a.ROLE_ID roleId,a.ROLE_NAME roleName from role a\nleft join user_role b on a.ROLE_ID = b.USER_ROLE_ROLE_ID\nleft join user c on b.USER_ROLE_USER_ID = c.USER_ID\nwhere c.USER_ID = ?";
        return SqlUtil.executeQuery(sql, userId);
    }

    public List findAll() {
        String sql = "select * from role";
        return SqlUtil.executeQuery(sql, new Object[0]);
    }

    public int delall(String userId) {
        String sql = "delete from user_role where USER_ROLE_USER_ID = ?";
        return SqlUtil.executeUpdate(sql, userId);
    }

    public int addUserRole(UserRole userRole) {
        String sql = "insert into user_role values(?, ?, ?)";
        return SqlUtil.executeUpdate(sql, userRole.getUserRoleId(), userRole.getUserRoleUserId(), userRole.getUserRoleRoleId());
    }

    public List findAllRules() {
        String sql = "select * from rules order by RULES_ORDER";
        return SqlUtil.executeQuery(sql);
    }

    public int addRole(Role role) {
        String sql = "insert into role values(?, ?, ?)";
        return SqlUtil.executeUpdate(sql, role.getRoleId(), role.getRoleName(), role.getRoleStatus());
    }

    public int delRoleRules(RoleRules roleRules) {
        String sql1 = "delete from role_rules where ROLE_RULES_ROLE_ID=?";
        return SqlUtil.executeUpdate(sql1, roleRules.getRoleRulesRoleId());
    }

    public int setRules(RoleRules roleRules) {
        String sql2 = "insert into role_rules values (?, ?, ?)";
        return SqlUtil.executeUpdate(sql2, roleRules.getRoleRulesId(), roleRules.getRoleRulesRoleId(), roleRules.getRoleRulesRulesId());
    }

    public int delRole(String roleId) {
        String sql = "delete from role where ROLE_ID=?";
        return SqlUtil.executeUpdate(sql, roleId);
    }

    public List findallRulesWithMenu() throws ParseException {
        String sql = "SELECT\n\t*\nFROM\n\trules a\n\tLEFT JOIN menu b ON a.RULES_MENU_ID = b.MENU_ID";
        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, new Object[0]);
        List li = new ArrayList();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Rules_Menu rules_menu = new Rules_Menu();
                Menu menu = new Menu();
                rules_menu.setRulesId(StringUtil.isnull(((HashMap) list.get(i)).get("RULES_ID")).toString());
                rules_menu.setRulesMenuId(StringUtil.isnull(((HashMap) list.get(i)).get("RULES_MENU_ID")).toString());
                rules_menu.setRulesName(StringUtil.isnull(((HashMap) list.get(i)).get("RULES_NAME")).toString());
                rules_menu.setRulesTime(this.sdf.parse(StringUtil.isnull(((HashMap) list.get(i)).get("RULES_TIME")).toString()));
                rules_menu.setRulesStatus(Integer.valueOf(StringUtil.isnull(((HashMap) list.get(i)).get("RULES_STATUS")).toString()));
                rules_menu.setRulesUrl(StringUtil.isnull(((HashMap) list.get(i)).get("RULES_URL")).toString());
                menu.setMenuId(StringUtil.isnull(((HashMap) list.get(i)).get("MENU_ID")).toString());
                menu.setMenuName(StringUtil.isnull(((HashMap) list.get(i)).get("MENU_NAME")).toString());
                rules_menu.setMenu(menu);
                li.add(rules_menu);
            }
        }
        return li;
    }

    public int inserrules(Rules rules) {
        String sql = "insert into rules (RULES_ID,RULES_MENU_ID,RULES_NAME,RULES_TIME,RULES_STATUS,RULES_URL) values(?,?,?,now(),?,?)";
        return SqlUtil.executeUpdate(sql, rules.getRulesId(), rules.getRulesMenuId(), rules.getRulesName(), rules.getRulesStatus(), rules.getRulesUrl());
    }


    public int updateRules(Rules rules) {
        String sql = "update rules set RULES_MENU_ID=? , RULES_NAME=? , RULES_URL=? where RULES_ID=?";
        return SqlUtil.executeUpdate(sql, rules.getRulesMenuId(), rules.getRulesName(), rules.getRulesUrl(), rules.getRulesId());
    }


    public List findAllMenu() {
        String sql = "select * from menu";
        return SqlUtil.executeQuery(sql);
    }


    public int deleteRules(String rulesId) {
        String sql = "delete from rules where RULES_ID=?";
        String sql2 = "delete from role_rules where ROLE_RULES_RULES_ID=?";
        int i = SqlUtil.executeUpdate(sql, rulesId);
        return SqlUtil.executeUpdate(sql2, rulesId);
    }


    public int deleteRoleRules(String rulesId) {
        String sql = "delete from role_rules where ROLE_RULES_RULES_ID=?";
        return SqlUtil.executeUpdate(sql, rulesId);
    }


    public List selectAllUrl() {
        String sql = "select * from url";
        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql);
        List li = new ArrayList();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Url url = new Url();
                url.setUrlId(StringUtil.isnull(((HashMap) list.get(i)).get("URL_ID")).toString());
                url.setUrlName(StringUtil.isnull(((HashMap) list.get(i)).get("URL_NAME")).toString());
                li.add(url);
            }
        }
        return li;
    }
}