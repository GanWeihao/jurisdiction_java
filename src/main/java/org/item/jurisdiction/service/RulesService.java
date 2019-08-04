package org.item.jurisdiction.service;

import org.item.jurisdiction.bo.Rules_Menu;
import org.item.jurisdiction.model.Role;
import org.item.jurisdiction.model.RoleRules;
import org.item.jurisdiction.model.UserRole;
import org.item.jurisdiction.model.Rules;

import java.text.ParseException;
import java.util.List;

public interface RulesService {
    //根据角色查询权限
    public List findByRole(String roleId);

    //查询所有权限
    public List findAllRules();

    //查询用户角色
    public List findByUserId(String userId);

    //查询所有角色
    public List findAll();

    //删除用户所有角色
    public int delall(String userId);

    //给用户添加角色
    public int addUserRole(UserRole userRole);

    //删除角色
    public int delRole(String roleId);

    //添加角色
    public String addRole(Role role);

    //删除角色所有权限
    public int delRoleRules(RoleRules roleRules);

    //给角色设置权限
    public int setRules(RoleRules roleRules);

    //根据角色ID查角色
    public Role findByRoleId(String roleId);

    //查询所有权限（带上级菜单）
    public List findallRulesWithMenu() throws ParseException;

    //新增权限
    public int inserrules(Rules rules);

    //删除权限
    public int deleteRules(String rulesId);

    //根据权限ID删除赋权表
    public int deleteRoleRules(String rulesId);

    //修改权限
    public int updateRules(Rules rules);

    //查询所有菜单
    public List findAllMenu();
}
