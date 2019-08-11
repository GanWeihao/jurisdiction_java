/*    */ package org.item.jurisdiction.bo;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.item.jurisdiction.bo.Rules_Menu;
/*    */ import org.item.jurisdiction.model.Menu;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Rules_Menu
/*    */ {
/*    */   private String rulesId;
/*    */   private String rulesMenuId;
/*    */   private String rulesName;
/*    */   private Date rulesTime;
/*    */   private Integer rulesStatus;
/*    */   private String rulesUrl;
/*    */   private Menu menu;
/*    */   
/*    */   public Rules_Menu(String rulesId, String rulesMenuId, String rulesName, Date rulesTime, Integer rulesStatus, Menu menu, String rulesUrl) {
/* 23 */     this.rulesId = rulesId;
/* 24 */     this.rulesMenuId = rulesMenuId;
/* 25 */     this.rulesName = rulesName;
/* 26 */     this.rulesTime = rulesTime;
/* 27 */     this.rulesStatus = rulesStatus;
/* 28 */     this.menu = menu;
/* 29 */     this.rulesUrl = rulesUrl;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Rules_Menu() {}
/*    */ 
/*    */   
/* 37 */   public String getRulesId() { return this.rulesId; }
/*    */ 
/*    */ 
/*    */   
/* 41 */   public void setRulesId(String rulesId) { this.rulesId = rulesId; }
/*    */ 
/*    */ 
/*    */   
/* 45 */   public String getRulesMenuId() { return this.rulesMenuId; }
/*    */ 
/*    */ 
/*    */   
/* 49 */   public void setRulesMenuId(String rulesMenuId) { this.rulesMenuId = rulesMenuId; }
/*    */ 
/*    */ 
/*    */   
/* 53 */   public String getRulesName() { return this.rulesName; }
/*    */ 
/*    */ 
/*    */   
/* 57 */   public void setRulesName(String rulesName) { this.rulesName = rulesName; }
/*    */ 
/*    */ 
/*    */   
/* 61 */   public Date getRulesTime() { return this.rulesTime; }
/*    */ 
/*    */ 
/*    */   
/* 65 */   public void setRulesTime(Date rulesTime) { this.rulesTime = rulesTime; }
/*    */ 
/*    */ 
/*    */   
/* 69 */   public Integer getRulesStatus() { return this.rulesStatus; }
/*    */ 
/*    */ 
/*    */   
/* 73 */   public void setRulesStatus(Integer rulesStatus) { this.rulesStatus = rulesStatus; }
/*    */ 
/*    */ 
/*    */   
/* 77 */   public String getRulesUrl() { return this.rulesUrl; }
/*    */ 
/*    */ 
/*    */   
/* 81 */   public void setRulesUrl(String rulesUrl) { this.rulesUrl = rulesUrl; }
/*    */ 
/*    */ 
/*    */   
/* 85 */   public Menu getMenu() { return this.menu; }
/*    */ 
/*    */ 
/*    */   
/* 89 */   public void setMenu(Menu menu) { this.menu = menu; }
/*    */ }
