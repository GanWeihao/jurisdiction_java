package org.item.jurisdiction.controller;

import org.item.jurisdiction.model.Role;
import org.item.jurisdiction.model.RoleRules;
import org.item.jurisdiction.model.Rules;
import org.item.jurisdiction.model.UserRole;
import org.item.jurisdiction.service.RulesService;
import org.item.jurisdiction.util.Constants;
import org.item.jurisdiction.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RulesController {
    @Autowired
    RulesService rulesService;

    //查询角色拥有权限
    @RequestMapping("/rules/select")
    public JsonResult select(Role role){
        JsonResult js;
        try {
            List list = rulesService.findByRole(role.getRoleId());
            js = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);

        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "查询异常");
        }
        return js;
    }

    //删除角色
    @RequestMapping("/role/del")
    public JsonResult delrole(String roleId){
        JsonResult js;
        try{
            if(roleId=="1"){
                js = new JsonResult(Constants.STATUS_ERROR,"无法删除项目管理员");
            }else{
                int i = rulesService.delRole(roleId);
                js = new JsonResult(Constants.STATUS_SUCCESS,"删除成功");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL,"删除异常");
        }
        return js;
    }

    //添加角色
    @RequestMapping("/role/insert")
    public JsonResult roleadd(Role role){
        JsonResult js;
        try {
            String i = rulesService.addRole(role);
            System.out.println(i);
            Role r = rulesService.findByRoleId(i);
            if(r!=null){
                js = new JsonResult(Constants.STATUS_SUCCESS,"添加成功",r);
            }else{
                js = new JsonResult(Constants.STATUS_ERROR,"添加失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL,"添加异常");
        }
        return js;
    }

    //根据用户ID查询角色
    @RequestMapping("/role/find")
    public JsonResult find(String userId){
        JsonResult js;
        try{
            List list = rulesService.findByUserId(userId);
            js = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "查询异常");
        }
        return js;
    }

    //查询所有角色
    @RequestMapping("/role/findall")
    public JsonResult findall(){
        JsonResult js;
        try{
            List list = rulesService.findAll();
            js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL,"查询异常");
        }
        return js;
    }

    //删除用户所有角色
    @RequestMapping("/role/delall")
    public JsonResult delall(String userId){
        JsonResult js;
        try{
            int i = rulesService.delall(userId);
            js = new JsonResult(Constants.STATUS_SUCCESS, "删除成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL,"删除异常");
        }
        return js;
    }

    //给用户添加角色
    @RequestMapping("/role/add")
    public JsonResult addrole(UserRole userRole){
        JsonResult js;
        try{
            int i = rulesService.addUserRole(userRole);
            js = new JsonResult(Constants.STATUS_SUCCESS, "添加成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL,"添加异常");
        }
        return js;
    }

    //查询所有权限
    @RequestMapping("/rules/findall")
    public JsonResult findallrules(){
        JsonResult js;
        try{
            List list = rulesService.findAllRules();
            js = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL,"查询异常");
        }
        return js;
    }

    //删除用户所有权限
    @RequestMapping("/rolerules/del")
    public JsonResult rolerulesdel(RoleRules roleRules){
        JsonResult js;
        try {
            int i = rulesService.delRoleRules(roleRules);
            js = new JsonResult(Constants.STATUS_SUCCESS, "设置成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "设置异常");
        }
        return js;
    }

    //给角色添加权限
    @RequestMapping("/rolerules/insert")
    public JsonResult rolerulesinsert(RoleRules roleRules){
        JsonResult js;
        try {
            int i = rulesService.setRules(roleRules);
            js = new JsonResult(Constants.STATUS_SUCCESS, "设置成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "设置异常");
        }
        return js;
    }

    //查询所有权限（带上级菜单）
    @RequestMapping("/rules/menu/findall")
    public JsonResult RulesWithMenu(){
        JsonResult js;
        try{
            List list = rulesService.findallRulesWithMenu();
            js = new JsonResult(Constants.STATUS_SUCCESS,"查询成功",list);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL,"查询异常");
        }
        return js;
    }

    //新增权限
    @RequestMapping("/rules/add")
    public JsonResult rulesadd(Rules rules){
        JsonResult js;
        try{
            int i = rulesService.inserrules(rules);
            js = new JsonResult(Constants.STATUS_SUCCESS, "添加成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "添加异常");
        }
        return js;
    }

    //删除权限
    @RequestMapping("/rules/delete")
    public JsonResult deleteRules(String rulesId){
        JsonResult js;
        try{
            int i = rulesService.deleteRules(rulesId);
            js = new JsonResult(Constants.STATUS_SUCCESS, "删除成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "删除异常");
        }
        return js;
    }

    //删除权限
    @RequestMapping("/role/rules/delete")
    public JsonResult deleteRoleRules(String rulesId){
        JsonResult js;
        try{
            int i = rulesService.deleteRoleRules(rulesId);
            js = new JsonResult(Constants.STATUS_SUCCESS, "删除成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "删除异常");
        }
        return js;
    }

    //修改权限
    @RequestMapping("/rules/update")
    public JsonResult updaterules(Rules rules){
        JsonResult js;
        try{
            int i = rulesService.updateRules(rules);
            js = new JsonResult(Constants.STATUS_SUCCESS, "修改成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "修改异常");
        }
        return js;
    }

    //查询所有菜单
    @RequestMapping("/menu/findall")
    public JsonResult findallMenu(){
        JsonResult js;
        try{
            List list = rulesService.findAllMenu();
            js = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "查询异常");
        }
        return js;
    }
}
