package org.item.jurisdiction.controller;

import java.util.List;

import org.item.jurisdiction.model.Role;
import org.item.jurisdiction.model.RoleRules;
import org.item.jurisdiction.model.Rules;
import org.item.jurisdiction.model.UserRole;
import org.item.jurisdiction.service.RulesService;
import org.item.jurisdiction.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class RulesController {
    private static final Logger logger = LoggerFactory.getLogger(RulesController.class);

    @Autowired
    RulesService rulesService;

    @RequestMapping({"/rules/select"})
    public JsonResult select(Role role) {

        JsonResult js;

        try {

            List list = this.rulesService.findByRole(role.getRoleId());

            js = new JsonResult("200", "查询成功", list);

        } catch (Exception e) {

            js = new JsonResult("500", "查询异常");

        }

        return js;

    }

    @RequestMapping({"/role/del"})
    public JsonResult delrole(String roleId) {

        JsonResult js;

        try {

            if (roleId == "1") {

                js = new JsonResult("400", "无法删除项目管理员");

            } else {

                int i = this.rulesService.delRole(roleId);

                js = new JsonResult("200", "删除成功");

            }

        } catch (Exception e) {

            js = new JsonResult("500", "删除异常");

        }

        return js;

    }

    @RequestMapping({"/role/insert"})
    public JsonResult roleadd(Role role) {

        JsonResult js;

        try {

            String i = this.rulesService.addRole(role);

            System.out.println(i);

            Role r = this.rulesService.findByRoleId(i);

            if (r != null) {

                js = new JsonResult("200", "添加成功", r);

            } else {

                js = new JsonResult("400", "添加失败");

            }

        } catch (Exception e) {

            js = new JsonResult("500", "添加异常");

        }

        return js;

    }

    @RequestMapping({"/role/find"})
    public JsonResult find(String userId) {

        JsonResult js;

        try {

            List list = this.rulesService.findByUserId(userId);

            js = new JsonResult("200", "查询成功", list);

        } catch (Exception e) {

            js = new JsonResult("500", "查询异常");

        }

        return js;

    }

    @RequestMapping({"/role/findall"})
    public JsonResult findall() {

        JsonResult js;

        try {

            List list = this.rulesService.findAll();

            js = new JsonResult("200", "查询成功", list);

        } catch (Exception e) {

            js = new JsonResult("500", "查询异常");

        }

        return js;

    }

    @RequestMapping({"/role/delall"})
    public JsonResult delall(String userId) {

        JsonResult js;

        try {

            int i = this.rulesService.delall(userId);

            js = new JsonResult("200", "删除成功");

        } catch (Exception e) {

            js = new JsonResult("500", "删除异常");

        }

        return js;

    }

    @RequestMapping({"/role/add"})
    public JsonResult addrole(UserRole userRole) {

        JsonResult js;

        try {

            int i = this.rulesService.addUserRole(userRole);

            js = new JsonResult("200", "添加成功");

        } catch (Exception e) {

            js = new JsonResult("500", "添加异常");

        }

        return js;

    }

    @RequestMapping({"/rules/findall"})
    public JsonResult findallrules() {
        JsonResult js;
        try {
            List list = this.rulesService.findAllRules();
            js = new JsonResult("200", "查询成功", list);
        } catch (Exception e) {
            js = new JsonResult("500", "查询异常");
        }
        return js;

    }

    @RequestMapping({"/rolerules/del"})
    public JsonResult rolerulesdel(RoleRules roleRules) {

        JsonResult js;

        try {

            int i = this.rulesService.delRoleRules(roleRules);

            js = new JsonResult("200", "设置成功");

        } catch (Exception e) {

            js = new JsonResult("500", "设置异常");

        }

        return js;

    }

    @RequestMapping({"/rolerules/insert"})
    public JsonResult rolerulesinsert(RoleRules roleRules) {
        JsonResult js;
        try {
            int i = this.rulesService.setRules(roleRules);
            js = new JsonResult("200", "设置成功");
        } catch (Exception e) {
            js = new JsonResult("500", "设置异常");
        }
        return js;
    }

    @RequestMapping({"/rules/menu/findall"})
    public JsonResult RulesWithMenu() {
        JsonResult js;
        try {
            List list = this.rulesService.findallRulesWithMenu();
            js = new JsonResult("200", "查询成功", list);
        } catch (Exception e) {
            js = new JsonResult("500", "查询异常");
        }
        return js;
    }

    @RequestMapping({"/rules/add"})
    public JsonResult rulesadd(Rules rules) {
        JsonResult js;
        try {
            int i = this.rulesService.inserrules(rules);
            js = new JsonResult("200", "添加成功");
        } catch (Exception e) {
            js = new JsonResult("500", "添加异常");
        }
        return js;
    }

    @RequestMapping({"/rules/delete"})
    public JsonResult deleteRules(String rulesId) {
        JsonResult js;
        try {
            int i = this.rulesService.deleteRules(rulesId);
            js = new JsonResult("200", "删除成功");
        } catch (Exception e) {
            js = new JsonResult("500", "删除异常");
        }
        return js;
    }

    @RequestMapping({"/role/rules/delete"})
    public JsonResult deleteRoleRules(String rulesId) {
        JsonResult js;
        try {
            int i = this.rulesService.deleteRoleRules(rulesId);
            js = new JsonResult("200", "删除成功");
        } catch (Exception e) {
            js = new JsonResult("500", "删除异常");
        }
        return js;
    }

    @RequestMapping({"/rules/update"})
    public JsonResult updaterules(Rules rules) {
        JsonResult js;
        try {
            int i = this.rulesService.updateRules(rules);
            js = new JsonResult("200", "修改成功");
        } catch (Exception e) {
            js = new JsonResult("500", "修改异常");
        }
        return js;
    }

    @RequestMapping({"/menu/findall"})
    public JsonResult findallMenu() {

        JsonResult js;

        try {

            List list = this.rulesService.findAllMenu();

            js = new JsonResult("200", "查询成功", list);

        } catch (Exception e) {

            js = new JsonResult("500", "查询异常");

        }

        return js;

    }

    @RequestMapping({"/url/selectall"})
    public JsonResult selectallurl() {
        JsonResult js;
        try {
            List list = this.rulesService.selectAllUrl();
            js = new JsonResult("200", "查询成功", list);
        } catch (Exception e) {
            js = new JsonResult("500", "查询异常");
        }
        return js;
    }
}