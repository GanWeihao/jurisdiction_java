/*    */ package org.item.jurisdiction.model;
/*    */ 
/*    */ import org.item.jurisdiction.model.UserRole;
/*    */ 
/*    */ public class UserRole
/*    */ {
/*    */   private String userRoleId;
/*    */   private String userRoleUserId;
/*    */   private String userRoleRoleId;
/*    */   
/*    */   public UserRole(String userRoleId, String userRoleUserId, String userRoleRoleId) {
/* 12 */     this.userRoleId = userRoleId;
/* 13 */     this.userRoleUserId = userRoleUserId;
/* 14 */     this.userRoleRoleId = userRoleRoleId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public UserRole() {}
/*    */ 
/*    */   
/* 22 */   public String getUserRoleId() { return this.userRoleId; }
/*    */ 
/*    */ 
/*    */   
/* 26 */   public void setUserRoleId(String userRoleId) { this.userRoleId = (userRoleId == null) ? null : userRoleId.trim(); }
/*    */ 
/*    */ 
/*    */   
/* 30 */   public String getUserRoleUserId() { return this.userRoleUserId; }
/*    */ 
/*    */ 
/*    */   
/* 34 */   public void setUserRoleUserId(String userRoleUserId) { this.userRoleUserId = (userRoleUserId == null) ? null : userRoleUserId.trim(); }
/*    */ 
/*    */ 
/*    */   
/* 38 */   public String getUserRoleRoleId() { return this.userRoleRoleId; }
/*    */ 
/*    */ 
/*    */   
/* 42 */   public void setUserRoleRoleId(String userRoleRoleId) { this.userRoleRoleId = (userRoleRoleId == null) ? null : userRoleRoleId.trim(); }
/*    */ }
