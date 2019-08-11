/*    */ package org.item.jurisdiction.model;
/*    */ 
/*    */ import org.item.jurisdiction.model.RoleRules;
/*    */ 
/*    */ public class RoleRules
/*    */ {
/*    */   private String roleRulesId;
/*    */   private String roleRulesRoleId;
/*    */   private String roleRulesRulesId;
/*    */   
/*    */   public RoleRules(String roleRulesId, String roleRulesRoleId, String roleRulesRulesId) {
/* 12 */     this.roleRulesId = roleRulesId;
/* 13 */     this.roleRulesRoleId = roleRulesRoleId;
/* 14 */     this.roleRulesRulesId = roleRulesRulesId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RoleRules() {}
/*    */ 
/*    */   
/* 22 */   public String getRoleRulesId() { return this.roleRulesId; }
/*    */ 
/*    */ 
/*    */   
/* 26 */   public void setRoleRulesId(String roleRulesId) { this.roleRulesId = (roleRulesId == null) ? null : roleRulesId.trim(); }
/*    */ 
/*    */ 
/*    */   
/* 30 */   public String getRoleRulesRoleId() { return this.roleRulesRoleId; }
/*    */ 
/*    */ 
/*    */   
/* 34 */   public void setRoleRulesRoleId(String roleRulesRoleId) { this.roleRulesRoleId = (roleRulesRoleId == null) ? null : roleRulesRoleId.trim(); }
/*    */ 
/*    */ 
/*    */   
/* 38 */   public String getRoleRulesRulesId() { return this.roleRulesRulesId; }
/*    */ 
/*    */ 
/*    */   
/* 42 */   public void setRoleRulesRulesId(String roleRulesRulesId) { this.roleRulesRulesId = (roleRulesRulesId == null) ? null : roleRulesRulesId.trim(); }
/*    */ }