/*     */ package org.item.jurisdiction.service.Impl;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import org.item.jurisdiction.mapper.UserMapper;
/*     */ import org.item.jurisdiction.model.User;
/*     */ import org.item.jurisdiction.service.Impl.UserServiceImpl;
/*     */ import org.item.jurisdiction.service.UserService;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service
/*     */ public class UserServiceImpl
/*     */   implements UserService {
/*  15 */   UserMapper userMapper = new UserMapper();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  21 */   public int updateName(User user) { return this.userMapper.updateName(user); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  28 */   public int delEmail(String userId) { return this.userMapper.delEmail(userId); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   public int updateEmail(String userEmail, String userId) { return this.userMapper.updateEmail(userEmail, userId); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   public List findAllUser() throws ParseException { return this.userMapper.findAllUser(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   public int updateHead(User user) { return this.userMapper.updateHead(user); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   public User userLogin(String username, String usermail, String password) throws ParseException { return this.userMapper.userLogin(username, usermail, password); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   public int loginFirst(String userId) { return this.userMapper.loginFirst(userId); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   public User findByUserId(String id) throws ParseException { return this.userMapper.findByUserId(id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   public List findMenuByUserId(String id) { return this.userMapper.findMenuByUserId(id); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   public List findRulesById(String userId) { return this.userMapper.findRulesById(userId); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   public List findRoleByUserId(String userId) { return this.userMapper.findRoleByUserId(userId); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String userAdd(User user) {
/*  96 */     if (user.getUserTelphone() == null) {
/*  97 */       user.setUserTelphone("");
/*     */     }
/*  99 */     if (user.getUserEmail() == null) {
/* 100 */       user.setUserEmail("");
/*     */     }
/*     */     
/* 103 */     String id = UUID.randomUUID().toString();
/* 104 */     user.setUserId(id);
/* 105 */     user.setUserError(Integer.valueOf(0));
/* 106 */     user.setUserStatus(Integer.valueOf(0));
/* 107 */     int i = this.userMapper.userAdd(user);
/* 108 */     return id;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 113 */   public List findByUserName(String username) { return this.userMapper.findByUserName(username); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public List findByUserEmail(String useremail) { return this.userMapper.findByUserEmail(useremail); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 125 */   public List findByUserTel(String usertelphone) { return this.userMapper.findByUserTel(usertelphone); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 131 */   public int deleteUser(String userId) { return this.userMapper.deleteUser(userId); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   public int updateUser(User user) { return this.userMapper.updateUser(user); }
/*     */ }