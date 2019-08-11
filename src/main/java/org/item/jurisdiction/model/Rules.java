/*    */ package org.item.jurisdiction.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.item.jurisdiction.model.Rules;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Rules
/*    */ {
/*    */   private String rulesId;
/*    */   private String rulesMenuId;
/*    */   private String rulesName;
/*    */   private Date rulesTime;
/*    */   private Integer rulesStatus;
/*    */   private String rulesUrl;
/*    */   
/*    */   public Rules(String rulesId, String rulesMenuId, String rulesName, Date rulesTime, Integer rulesStatus, String rulesUrl) {
/* 20 */     this.rulesId = rulesId;
/* 21 */     this.rulesMenuId = rulesMenuId;
/* 22 */     this.rulesName = rulesName;
/* 23 */     this.rulesTime = rulesTime;
/* 24 */     this.rulesStatus = rulesStatus;
/* 25 */     this.rulesUrl = rulesUrl;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Rules() {}
/*    */ 
/*    */   
/* 33 */   public String getRulesId() { return this.rulesId; }
/*    */ 
/*    */ 
/*    */   
/* 37 */   public void setRulesId(String rulesId) { this.rulesId = (rulesId == null) ? null : rulesId.trim(); }
/*    */ 
/*    */ 
/*    */   
/* 41 */   public String getRulesMenuId() { return this.rulesMenuId; }
/*    */ 
/*    */ 
/*    */   
/* 45 */   public void setRulesMenuId(String rulesMenuId) { this.rulesMenuId = (rulesMenuId == null) ? null : rulesMenuId.trim(); }
/*    */ 
/*    */ 
/*    */   
/* 49 */   public String getRulesName() { return this.rulesName; }
/*    */ 
/*    */ 
/*    */   
/* 53 */   public void setRulesName(String rulesName) { this.rulesName = (rulesName == null) ? null : rulesName.trim(); }
/*    */ 
/*    */ 
/*    */   
/* 57 */   public Date getRulesTime() { return this.rulesTime; }
/*    */ 
/*    */ 
/*    */   
/* 61 */   public void setRulesTime(Date rulesTime) { this.rulesTime = rulesTime; }
/*    */ 
/*    */ 
/*    */   
/* 65 */   public Integer getRulesStatus() { return this.rulesStatus; }
/*    */ 
/*    */ 
/*    */   
/* 69 */   public void setRulesStatus(Integer rulesStatus) { this.rulesStatus = rulesStatus; }
/*    */ 
/*    */ 
/*    */   
/* 73 */   public String getRulesUrl() { return this.rulesUrl; }
/*    */ 
/*    */ 
/*    */   
/* 77 */   public void setRulesUrl(String rulesUrl) { this.rulesUrl = rulesUrl; }
/*    */ }