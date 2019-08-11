/*    */ package org.item.jurisdiction.model;
/*    */ 
/*    */ import org.item.jurisdiction.model.Role;
/*    */ 
/*    */ public class Role
/*    */ {
/*    */   private String roleId;
/*    */   private String roleName;
/*    */   private Integer roleStatus;
/*    */   
/*    */   public Role(String roleId, String roleName, Integer roleStatus) {
/* 12 */     this.roleId = roleId;
/* 13 */     this.roleName = roleName;
/* 14 */     this.roleStatus = roleStatus;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Role() {}
/*    */ 
/*    */   
/* 22 */   public String getRoleId() { return this.roleId; }
/*    */ 
/*    */ 
/*    */   
/* 26 */   public void setRoleId(String roleId) { this.roleId = (roleId == null) ? null : roleId.trim(); }
/*    */ 
/*    */ 
/*    */   
/* 30 */   public String getRoleName() { return this.roleName; }
/*    */ 
/*    */ 
/*    */   
/* 34 */   public void setRoleName(String roleName) { this.roleName = (roleName == null) ? null : roleName.trim(); }
/*    */ 
/*    */ 
/*    */   
/* 38 */   public Integer getRoleStatus() { return this.roleStatus; }
/*    */ 
/*    */ 
/*    */   
/* 42 */   public void setRoleStatus(Integer roleStatus) { this.roleStatus = roleStatus; }
/*    */ }