/*     */
package org.item.jurisdiction.service.Impl;
/*     */
/*     */

import java.text.ParseException;
import java.util.List;
/*     */ import java.util.UUID;
/*     */ import org.item.jurisdiction.mapper.RulesMapper;
/*     */ import org.item.jurisdiction.model.Role;
/*     */ import org.item.jurisdiction.model.RoleRules;
/*     */ import org.item.jurisdiction.model.Rules;
/*     */ import org.item.jurisdiction.model.UserRole;
/*     */ import org.item.jurisdiction.service.Impl.RulesServiceImpl;
/*     */ import org.item.jurisdiction.service.RulesService;
/*     */ import org.springframework.stereotype.Service;

/*     */
/*     */
@Service
/*     */ public class RulesServiceImpl
        /*     */ implements RulesService
        /*     */ {
    RulesMapper rulesMapper = new RulesMapper();

    public List findByRole(String roleId) {
        return this.rulesMapper.findByRole(roleId);
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*  28 */
    public List findAllRules() {
        return this.rulesMapper.findAllRules();
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*  33 */
    public List findByUserId(String userId) {
        return this.rulesMapper.findByUserId(userId);
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*  38 */
    public List findAll() {
        return this.rulesMapper.findAll();
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*  43 */
    public int delall(String userId) {
        return this.rulesMapper.delall(userId);
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public int addUserRole(UserRole userRole) {
        /*  48 */
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        /*  49 */
        userRole.setUserRoleId(id);
        /*  50 */
        return this.rulesMapper.addUserRole(userRole);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*  55 */
    public int delRole(String roleId) {
        return this.rulesMapper.delRole(roleId);
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String addRole(Role role) {
        /*  60 */
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        /*  61 */
        Integer status = Integer.valueOf(0);
        /*  62 */
        role.setRoleId(id);
        /*  63 */
        role.setRoleStatus(status);
        /*  64 */
        this.rulesMapper.addRole(role);
        /*  65 */
        return id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*  70 */
    public int delRoleRules(RoleRules roleRules) {
        return this.rulesMapper.delRoleRules(roleRules);
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public int setRules(RoleRules roleRules) {
        /*  75 */
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        /*  76 */
        roleRules.setRoleRulesId(id);
        /*  77 */
        return this.rulesMapper.setRules(roleRules);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*  83 */
    public Role findByRoleId(String roleId) {
        return this.rulesMapper.findByRoleId(roleId);
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*  88 */
    public List findallRulesWithMenu() throws ParseException {
        return rulesMapper.findallRulesWithMenu();
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public int inserrules(Rules rules) {
        /*  93 */
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        /*  94 */
        rules.setRulesId(id);
        /*  95 */
        rules.setRulesStatus(Integer.valueOf(0));
        /*  96 */
        return this.rulesMapper.inserrules(rules);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /* 101 */
    public int deleteRules(String rulesId) {
        return this.rulesMapper.deleteRules(rulesId);
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /* 106 */
    public int deleteRoleRules(String rulesId) {
        return this.rulesMapper.deleteRules(rulesId);
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /* 111 */
    public int updateRules(Rules rules) {
        return this.rulesMapper.updateRules(rules);
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /* 116 */
    public List findAllMenu() {
        return this.rulesMapper.findAllMenu();
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /* 121 */
    public List selectAllUrl() {
        return this.rulesMapper.selectAllUrl();
    }
    /*     */
}