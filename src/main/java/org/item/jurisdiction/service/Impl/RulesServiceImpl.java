package org.item.jurisdiction.service.Impl;

import org.item.jurisdiction.bo.Rules_Menu;
import org.item.jurisdiction.mapper.RulesMapper;
import org.item.jurisdiction.model.Role;
import org.item.jurisdiction.model.RoleRules;
import org.item.jurisdiction.model.UserRole;
import org.item.jurisdiction.service.RulesService;
import org.item.jurisdiction.model.Rules;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Service
public class RulesServiceImpl implements RulesService {
    RulesMapper rulesMapper = new RulesMapper();

    @Override
    public List findByRole(String roleId) {
        List list = rulesMapper.findByRole(roleId);
        return list;
    }

    @Override
    public List findAllRules() {
        return rulesMapper.findAllRules();
    }

    @Override
    public List findByUserId(String userId) {
        return rulesMapper.findByUserId(userId);
    }

    @Override
    public List findAll() {
        return rulesMapper.findAll();
    }

    @Override
    public int delall(String userId) {
        return rulesMapper.delall(userId);
    }

    @Override
    public int addUserRole(UserRole userRole) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        userRole.setUserRoleId(id);
        return rulesMapper.addUserRole(userRole);
    }

    @Override
    public int delRole(String roleId) {
        return rulesMapper.delRole(roleId);
    }

    @Override
    public String addRole(Role role) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        Integer status = 0;
        role.setRoleId(id);
        role.setRoleStatus(status);
        rulesMapper.addRole(role);
        return id;
    }

    @Override
    public int delRoleRules(RoleRules roleRules) {
        return rulesMapper.delRoleRules(roleRules);
    }

    @Override
    public int setRules(RoleRules roleRules) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        roleRules.setRoleRulesId(id);
        int i = rulesMapper.setRules(roleRules);
        return i;
    }

    @Override
    public Role findByRoleId(String roleId) {
        return rulesMapper.findByRoleId(roleId);
    }

    @Override
    public List findallRulesWithMenu() throws ParseException {
        return rulesMapper.findallRulesWithMenu();
    }

    @Override
    public int inserrules(Rules rules) {
        String id = UUID.randomUUID().toString().replaceAll("-","");
        rules.setRulesId(id);
        rules.setRulesStatus(0);
        return rulesMapper.inserrules(rules);
    }

    @Override
    public int deleteRules(String rulesId) {
        return rulesMapper.deleteRules(rulesId);
    }

    @Override
    public int deleteRoleRules(String rulesId) {
        return rulesMapper.deleteRules(rulesId);
    }

    @Override
    public int updateRules(Rules rules) {
        return rulesMapper.updateRules(rules);
    }

    @Override
    public List findAllMenu() {
        return rulesMapper.findAllMenu();
    }
}
