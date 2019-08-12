package org.item.jurisdiction.service.Impl;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import org.item.jurisdiction.mapper.RulesMapper;
import org.item.jurisdiction.model.Role;
import org.item.jurisdiction.model.RoleRules;
import org.item.jurisdiction.model.Rules;
import org.item.jurisdiction.model.UserRole;
import org.item.jurisdiction.service.RulesService;
import org.springframework.stereotype.Service;


@Service
public class RulesServiceImpl implements RulesService {
    RulesMapper rulesMapper = new RulesMapper();

    public List findByRole(String roleId) {
        return this.rulesMapper.findByRole(roleId);
    }

    public List findAllRules() {
        return this.rulesMapper.findAllRules();
    }

    public List findByUserId(String userId) {
        return this.rulesMapper.findByUserId(userId);
    }

    public List findAll() {
        return this.rulesMapper.findAll();
    }

    public int delall(String userId) {
        return this.rulesMapper.delall(userId);
    }

    public int addUserRole(UserRole userRole) {

        String id = UUID.randomUUID().toString().replaceAll("-", "");

        userRole.setUserRoleId(id);

        return this.rulesMapper.addUserRole(userRole);

    }

    public int delRole(String roleId) {
        return this.rulesMapper.delRole(roleId);
    }

    public String addRole(Role role) {

        String id = UUID.randomUUID().toString().replaceAll("-", "");

        Integer status = Integer.valueOf(0);

        role.setRoleId(id);

        role.setRoleStatus(status);

        this.rulesMapper.addRole(role);

        return id;

    }

    public int delRoleRules(RoleRules roleRules) {
        return this.rulesMapper.delRoleRules(roleRules);
    }

    public int setRules(RoleRules roleRules) {

        String id = UUID.randomUUID().toString().replaceAll("-", "");

        roleRules.setRoleRulesId(id);

        return this.rulesMapper.setRules(roleRules);

    }

    public Role findByRoleId(String roleId) {
        return this.rulesMapper.findByRoleId(roleId);
    }

    public List findallRulesWithMenu() throws ParseException {
        return rulesMapper.findallRulesWithMenu();
    }

    public int inserrules(Rules rules) {

        String id = UUID.randomUUID().toString().replaceAll("-", "");

        rules.setRulesId(id);

        rules.setRulesStatus(Integer.valueOf(0));

        return this.rulesMapper.inserrules(rules);

    }

    public int deleteRules(String rulesId) {
        return this.rulesMapper.deleteRules(rulesId);
    }

    public int deleteRoleRules(String rulesId) {
        return this.rulesMapper.deleteRules(rulesId);
    }

    public int updateRules(Rules rules) {
        return this.rulesMapper.updateRules(rules);
    }

    public List findAllMenu() {
        return this.rulesMapper.findAllMenu();
    }

    public List selectAllUrl() {
        return this.rulesMapper.selectAllUrl();
    }

}