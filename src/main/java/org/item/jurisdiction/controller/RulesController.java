/*     */ package org.item.jurisdiction.controller;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.item.jurisdiction.controller.RulesController;
/*     */ import org.item.jurisdiction.model.Role;
/*     */ import org.item.jurisdiction.model.RoleRules;
/*     */ import org.item.jurisdiction.model.Rules;
/*     */ import org.item.jurisdiction.model.UserRole;
/*     */ import org.item.jurisdiction.service.RulesService;
/*     */ import org.item.jurisdiction.util.JsonResult;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ @CrossOrigin
/*     */ @RestController
/*     */ public class RulesController
/*     */ {
/*     */   @Autowired
/*     */   RulesService rulesService;
/*     */   
/*     */   @RequestMapping({"/rules/select"})
/*     */   public JsonResult select(Role role) {
/*     */     JsonResult js;
/*     */     try {
/*  28 */       List list = this.rulesService.findByRole(role.getRoleId());
/*  29 */       js = new JsonResult("200", "查询成功", list);
/*     */     }
/*  31 */     catch (Exception e) {
/*  32 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/*  34 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/role/del"})
/*     */   public JsonResult delrole(String roleId) {
/*     */     JsonResult js;
/*     */     try {
/*  42 */       if (roleId == "1") {
/*  43 */         js = new JsonResult("400", "无法删除项目管理员");
/*     */       } else {
/*  45 */         int i = this.rulesService.delRole(roleId);
/*  46 */         js = new JsonResult("200", "删除成功");
/*     */       } 
/*  48 */     } catch (Exception e) {
/*  49 */       js = new JsonResult("500", "删除异常");
/*     */     } 
/*  51 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/role/insert"})
/*     */   public JsonResult roleadd(Role role) {
/*     */     JsonResult js;
/*     */     try {
/*  59 */       String i = this.rulesService.addRole(role);
/*  60 */       System.out.println(i);
/*  61 */       Role r = this.rulesService.findByRoleId(i);
/*  62 */       if (r != null) {
/*  63 */         js = new JsonResult("200", "添加成功", r);
/*     */       } else {
/*  65 */         js = new JsonResult("400", "添加失败");
/*     */       } 
/*  67 */     } catch (Exception e) {
/*  68 */       js = new JsonResult("500", "添加异常");
/*     */     } 
/*  70 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/role/find"})
/*     */   public JsonResult find(String userId) {
/*     */     JsonResult js;
/*     */     try {
/*  78 */       List list = this.rulesService.findByUserId(userId);
/*  79 */       js = new JsonResult("200", "查询成功", list);
/*  80 */     } catch (Exception e) {
/*  81 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/*  83 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/role/findall"})
/*     */   public JsonResult findall() {
/*     */     JsonResult js;
/*     */     try {
/*  91 */       List list = this.rulesService.findAll();
/*  92 */       js = new JsonResult("200", "查询成功", list);
/*  93 */     } catch (Exception e) {
/*  94 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/*  96 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/role/delall"})
/*     */   public JsonResult delall(String userId) {
/*     */     JsonResult js;
/*     */     try {
/* 104 */       int i = this.rulesService.delall(userId);
/* 105 */       js = new JsonResult("200", "删除成功");
/* 106 */     } catch (Exception e) {
/* 107 */       js = new JsonResult("500", "删除异常");
/*     */     } 
/* 109 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/role/add"})
/*     */   public JsonResult addrole(UserRole userRole) {
/*     */     JsonResult js;
/*     */     try {
/* 117 */       int i = this.rulesService.addUserRole(userRole);
/* 118 */       js = new JsonResult("200", "添加成功");
/* 119 */     } catch (Exception e) {
/* 120 */       js = new JsonResult("500", "添加异常");
/*     */     } 
/* 122 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/rules/findall"})
/*     */   public JsonResult findallrules() {
/*     */     JsonResult js;
/*     */     try {
/* 130 */       List list = this.rulesService.findAllRules();
/* 131 */       js = new JsonResult("200", "查询成功", list);
/* 132 */     } catch (Exception e) {
/* 133 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/* 135 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/rolerules/del"})
/*     */   public JsonResult rolerulesdel(RoleRules roleRules) {
/*     */     JsonResult js;
/*     */     try {
/* 143 */       int i = this.rulesService.delRoleRules(roleRules);
/* 144 */       js = new JsonResult("200", "设置成功");
/* 145 */     } catch (Exception e) {
/* 146 */       js = new JsonResult("500", "设置异常");
/*     */     } 
/* 148 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/rolerules/insert"})
/*     */   public JsonResult rolerulesinsert(RoleRules roleRules) {
/*     */     JsonResult js;
/*     */     try {
/* 156 */       int i = this.rulesService.setRules(roleRules);
/* 157 */       js = new JsonResult("200", "设置成功");
/* 158 */     } catch (Exception e) {
/* 159 */       js = new JsonResult("500", "设置异常");
/*     */     } 
/* 161 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/rules/menu/findall"})
/*     */   public JsonResult RulesWithMenu() {
/*     */     JsonResult js;
/*     */     try {
/* 169 */       List list = this.rulesService.findallRulesWithMenu();
/* 170 */       js = new JsonResult("200", "查询成功", list);
/* 171 */     } catch (Exception e) {
/* 172 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/* 174 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/rules/add"})
/*     */   public JsonResult rulesadd(Rules rules) {
/*     */     JsonResult js;
/*     */     try {
/* 182 */       int i = this.rulesService.inserrules(rules);
/* 183 */       js = new JsonResult("200", "添加成功");
/* 184 */     } catch (Exception e) {
/* 185 */       js = new JsonResult("500", "添加异常");
/*     */     } 
/* 187 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/rules/delete"})
/*     */   public JsonResult deleteRules(String rulesId) {
/*     */     JsonResult js;
/*     */     try {
/* 195 */       int i = this.rulesService.deleteRules(rulesId);
/* 196 */       js = new JsonResult("200", "删除成功");
/* 197 */     } catch (Exception e) {
/* 198 */       js = new JsonResult("500", "删除异常");
/*     */     } 
/* 200 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/role/rules/delete"})
/*     */   public JsonResult deleteRoleRules(String rulesId) {
/*     */     JsonResult js;
/*     */     try {
/* 208 */       int i = this.rulesService.deleteRoleRules(rulesId);
/* 209 */       js = new JsonResult("200", "删除成功");
/* 210 */     } catch (Exception e) {
/* 211 */       js = new JsonResult("500", "删除异常");
/*     */     } 
/* 213 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/rules/update"})
/*     */   public JsonResult updaterules(Rules rules) {
/*     */     JsonResult js;
/*     */     try {
/* 221 */       int i = this.rulesService.updateRules(rules);
/* 222 */       js = new JsonResult("200", "修改成功");
/* 223 */     } catch (Exception e) {
/* 224 */       js = new JsonResult("500", "修改异常");
/*     */     } 
/* 226 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/menu/findall"})
/*     */   public JsonResult findallMenu() {
/*     */     JsonResult js;
/*     */     try {
/* 234 */       List list = this.rulesService.findAllMenu();
/* 235 */       js = new JsonResult("200", "查询成功", list);
/* 236 */     } catch (Exception e) {
/* 237 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/* 239 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/url/selectall"})
/*     */   public JsonResult selectallurl() {
/*     */     JsonResult js;
/*     */     try {
/* 247 */       List list = this.rulesService.selectAllUrl();
/* 248 */       js = new JsonResult("200", "查询成功", list);
/* 249 */     } catch (Exception e) {
/* 250 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/* 252 */     return js;
/*     */   }
/*     */ }