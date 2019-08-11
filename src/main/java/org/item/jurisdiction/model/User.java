/*     */ package org.item.jurisdiction.model;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.item.jurisdiction.model.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class User
/*     */ {
/*     */   private String userId;
/*     */   private String userName;
/*     */   private String userPassword;
/*     */   private String userTelphone;
/*     */   private String userEmail;
/*     */   private Date userTime;
/*     */   private Integer userStatus;
/*     */   private Integer userError;
/*     */   private String userHeadimg;
/*     */   
/*     */   public User(String userId, String userName, String userPassword, String userTelphone, String userEmail, Date userTime, Integer userStatus, Integer userError, String userHeadimg) {
/*  25 */     this.userId = userId;
/*  26 */     this.userName = userName;
/*  27 */     this.userPassword = userPassword;
/*  28 */     this.userTelphone = userTelphone;
/*  29 */     this.userEmail = userEmail;
/*  30 */     this.userTime = userTime;
/*  31 */     this.userStatus = userStatus;
/*  32 */     this.userError = userError;
/*  33 */     this.userHeadimg = userHeadimg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public User() {}
/*     */ 
/*     */   
/*  41 */   public String getUserId() { return this.userId; }
/*     */ 
/*     */ 
/*     */   
/*  45 */   public void setUserId(String userId) { this.userId = (userId == null) ? null : userId.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  49 */   public String getUserName() { return this.userName; }
/*     */ 
/*     */ 
/*     */   
/*  53 */   public void setUserName(String userName) { this.userName = (userName == null) ? null : userName.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  57 */   public String getUserPassword() { return this.userPassword; }
/*     */ 
/*     */ 
/*     */   
/*  61 */   public void setUserPassword(String userPassword) { this.userPassword = (userPassword == null) ? null : userPassword.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  65 */   public String getUserTelphone() { return this.userTelphone; }
/*     */ 
/*     */ 
/*     */   
/*  69 */   public void setUserTelphone(String userTelphone) { this.userTelphone = (userTelphone == null) ? null : userTelphone.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  73 */   public String getUserEmail() { return this.userEmail; }
/*     */ 
/*     */ 
/*     */   
/*  77 */   public void setUserEmail(String userEmail) { this.userEmail = (userEmail == null) ? null : userEmail.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  81 */   public Date getUserTime() { return this.userTime; }
/*     */ 
/*     */ 
/*     */   
/*  85 */   public void setUserTime(Date userTime) { this.userTime = userTime; }
/*     */ 
/*     */ 
/*     */   
/*  89 */   public Integer getUserStatus() { return this.userStatus; }
/*     */ 
/*     */ 
/*     */   
/*  93 */   public void setUserStatus(Integer userStatus) { this.userStatus = userStatus; }
/*     */ 
/*     */ 
/*     */   
/*  97 */   public Integer getUserError() { return this.userError; }
/*     */ 
/*     */ 
/*     */   
/* 101 */   public void setUserError(Integer userError) { this.userError = userError; }
/*     */ 
/*     */ 
/*     */   
/* 105 */   public String getUserHeadimg() { return this.userHeadimg; }
/*     */ 
/*     */ 
/*     */   
/* 109 */   public void setUserHeadimg(String userHeadimg) { this.userHeadimg = userHeadimg; }
/*     */ }