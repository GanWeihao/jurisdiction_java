/*     */ package org.item.jurisdiction.mapper;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.item.jurisdiction.mapper.UserMapper;
/*     */ import org.item.jurisdiction.model.User;
/*     */ import org.item.jurisdiction.util.SqlUtil;
/*     */ import org.item.jurisdiction.util.StringUtil;
/*     */ 
/*     */ public class UserMapper {
/*  14 */   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
/*     */ 
/*     */   
/*     */   public User userLogin(String userphone, String usermail, String password) throws ParseException {
/*  18 */     String sql = "select * from user where USER_TELPHONE=? and USER_PASSWORD=? or USER_EMAIL=? and USER_PASSWORD=? and USER_STATUS=0";
/*  19 */     List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, new Object[] { userphone, password, usermail, password });
/*  20 */     User user = null;
/*  21 */     if (list.size() > 0) {
/*  22 */       user = new User();
/*  23 */       user.setUserId(StringUtil.isnull(((HashMap)list.get(0)).get("USER_ID")).toString());
/*  24 */       user.setUserName(StringUtil.isnull(((HashMap)list.get(0)).get("USER_NAME")).toString());
/*  25 */       user.setUserPassword(StringUtil.isnull(((HashMap)list.get(0)).get("USER_PASSWORD")).toString());
/*  26 */       user.setUserTelphone(StringUtil.isnull(((HashMap)list.get(0)).get("USER_TELPHONE")).toString());
/*  27 */       user.setUserEmail(StringUtil.isnull(((HashMap)list.get(0)).get("USER_EMAIL")).toString());
/*  28 */       user.setUserTime(this.sdf.parse(StringUtil.isnull(((HashMap)list.get(0)).get("USER_TIME")).toString()));
/*  29 */       user.setUserStatus(Integer.valueOf(StringUtil.iszore(((HashMap)list.get(0)).get("USER_STATUS")).toString()));
/*  30 */       user.setUserError(Integer.valueOf(StringUtil.iszore(((HashMap)list.get(0)).get("USER_ERROR")).toString()));
/*  31 */       user.setUserHeadimg(StringUtil.isnull(((HashMap)list.get(0)).get("USER_HEADIMG")).toString());
/*     */     } 
/*  33 */     return user;
/*     */   }
/*     */ 
/*     */   
/*     */   public List findAllUser() throws ParseException {
/*  38 */     String sql = "select * from user";
/*  39 */     List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, new Object[0]);
/*  40 */     List<User> li = null;
/*  41 */     if (list.size() > 0) {
/*  42 */       li = new ArrayList<User>();
/*  43 */       for (int i = 0; i < list.size(); i++) {
/*  44 */         User user = new User();
/*  45 */         user.setUserId(StringUtil.isnull(((HashMap)list.get(i)).get("USER_ID")).toString());
/*  46 */         user.setUserName(StringUtil.isnull(((HashMap)list.get(i)).get("USER_NAME")).toString());
/*  47 */         user.setUserPassword(StringUtil.isnull(((HashMap)list.get(i)).get("USER_PASSWORD")).toString());
/*  48 */         user.setUserTelphone(StringUtil.isnull(((HashMap)list.get(i)).get("USER_TELPHONE")).toString());
/*  49 */         user.setUserEmail(StringUtil.isnull(((HashMap)list.get(i)).get("USER_EMAIL")).toString());
/*  50 */         user.setUserTime(this.sdf.parse(StringUtil.isnull(((HashMap)list.get(i)).get("USER_TIME")).toString()));
/*  51 */         user.setUserStatus(Integer.valueOf(StringUtil.iszore(((HashMap)list.get(i)).get("USER_STATUS")).toString()));
/*  52 */         user.setUserError(Integer.valueOf(StringUtil.iszore(((HashMap)list.get(i)).get("USER_ERROR")).toString()));
/*  53 */         user.setUserHeadimg(StringUtil.isnull(((HashMap)list.get(i)).get("USER_HEADIMG")).toString());
/*  54 */         li.add(user);
/*     */       } 
/*     */     } 
/*  57 */     return li;
/*     */   }
/*     */ 
/*     */   
/*     */   public int deleteUser(String userId) {
/*  62 */     String sql = "delete from user where USER_ID=?";
/*  63 */     String sql2 = "delete from user_role where USER_ROLE_USER_ID=?";
/*  64 */     int i = SqlUtil.executeUpdate(sql, new Object[] { userId });
/*  65 */     int j = SqlUtil.executeUpdate(sql2, new Object[] { userId });
/*  66 */     return i + j;
/*     */   }
/*     */ 
/*     */   
/*     */   public int updateUser(User user) {
/*  71 */     String sql = "update user set USER_NAME=?,USER_TELPHONE=?,USER_EMAIL=? where USER_ID=?";
/*  72 */     return SqlUtil.executeUpdate(sql, new Object[] { user.getUserName(), user.getUserTelphone(), user.getUserEmail(), user.getUserId() });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int loginFirst(String userId) {
/*  78 */     String sql = "update user set USER_ERROR=USER_ERROR+1 where USER_ID=?";
/*  79 */     return SqlUtil.executeUpdate(sql, new Object[] { userId });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int updateEmail(String email, String userId) {
/*  85 */     String sql = "update user set USER_EMAIL=? where USER_ID=?";
/*  86 */     return SqlUtil.executeUpdate(sql, new Object[] { email, userId });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int delEmail(String userId) {
/*  92 */     String sql = "update user set USER_EMAIL=null where USER_ID=?";
/*  93 */     return SqlUtil.executeUpdate(sql, new Object[] { userId });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public User findByUserId(String id) throws ParseException {
/*  99 */     String sql = "select * from user where USER_ID=?";
/* 100 */     List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, new Object[] { id });
/* 101 */     User user = null;
/* 102 */     if (list.size() > 0) {
/* 103 */       user = new User();
/* 104 */       user.setUserId(StringUtil.isnull(((HashMap)list.get(0)).get("USER_ID")).toString());
/* 105 */       user.setUserName(StringUtil.isnull(((HashMap)list.get(0)).get("USER_NAME")).toString());
/* 106 */       user.setUserPassword(StringUtil.isnull(((HashMap)list.get(0)).get("USER_PASSWORD")).toString());
/* 107 */       user.setUserTelphone(StringUtil.isnull(((HashMap)list.get(0)).get("USER_TELPHONE")).toString());
/* 108 */       user.setUserEmail(StringUtil.isnull(((HashMap)list.get(0)).get("USER_EMAIL")).toString());
/* 109 */       user.setUserTime(this.sdf.parse(StringUtil.isnull(((HashMap)list.get(0)).get("USER_TIME")).toString()));
/* 110 */       user.setUserStatus(Integer.valueOf(StringUtil.iszore(((HashMap)list.get(0)).get("USER_STATUS")).toString()));
/* 111 */       user.setUserError(Integer.valueOf(StringUtil.iszore(((HashMap)list.get(0)).get("USER_ERROR")).toString()));
/* 112 */       user.setUserHeadimg(StringUtil.isnull(((HashMap)list.get(0)).get("USER_HEADIMG")).toString());
/*     */     } 
/* 114 */     return user;
/*     */   }
/*     */ 
/*     */   
/*     */   public int updateHead(User user) {
/* 119 */     String sql = "update user set USER_HEADIMG=? where USER_ID=?";
/* 120 */     return SqlUtil.executeUpdate(sql, new Object[] { user.getUserHeadimg(), user.getUserId() });
/*     */   }
/*     */ 
/*     */   
/*     */   public int updateName(User user) {
/* 125 */     String sql = "update user set USER_NAME=? where USER_ID=?";
/* 126 */     return SqlUtil.executeUpdate(sql, new Object[] { user.getUserName(), user.getUserId() });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List findByUserName(String username) {
/* 132 */     String sql = "select * from user where USER_NAME=?";
/* 133 */     return SqlUtil.executeQuery(sql, new Object[] { username });
/*     */   }
/*     */ 
/*     */   
/*     */   public List findByUserEmail(String useremail) {
/* 138 */     String sql = "select * from user where USER_EMAIL=?";
/* 139 */     return SqlUtil.executeQuery(sql, new Object[] { useremail });
/*     */   }
/*     */ 
/*     */   
/*     */   public List findByUserTel(String usertelphone) {
/* 144 */     String sql = "select * from user where USER_TELPHONE=?";
/* 145 */     return SqlUtil.executeQuery(sql, new Object[] { usertelphone });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int userAdd(User user) {
/* 151 */     String sql = "insert into user values(?,?,?,?,?,now(),?,?,?)";
/* 152 */     return SqlUtil.executeUpdate(sql, new Object[] { user.getUserId(), user
/* 153 */           .getUserName(), user
/* 154 */           .getUserPassword(), user
/* 155 */           .getUserTelphone(), user
/* 156 */           .getUserEmail(), user
/* 157 */           .getUserStatus(), user
/* 158 */           .getUserError(), user
/* 159 */           .getUserHeadimg() });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List findMenuByUserId(String id) {
/* 165 */     String sql = "SELECT f.MENU_ID MENU_ID, f.MENU_NAME MENU_NAME FROM user a\nLEFT JOIN user_role b ON a.USER_ID = b.USER_ROLE_USER_ID\nLEFT JOIN role c ON b.USER_ROLE_ROLE_ID = c.ROLE_ID\nLEFT JOIN role_rules d ON c.ROLE_ID = d.ROLE_RULES_ROLE_ID\nLEFT JOIN rules e ON d.ROLE_RULES_RULES_ID = e.RULES_ID\nLEFT JOIN menu f ON e.RULES_MENU_ID = f.MENU_ID\nWHERE a.USER_ID = ? \nGROUP BY MENU_ID, MENU_NAME";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     return SqlUtil.executeQuery(sql, new Object[] { id });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List findRulesById(String userId) {
/* 181 */     String sql = "SELECT\nE.RULES_ID RULES_ID,\nE.RULES_NAME RULES_NAME,\nE.RULES_URL RULES_URL,\nF.MENU_ID MENU_ID,\nF.MENU_NAME MENU_NAME\nFROM\nUSER A\nLEFT JOIN user_role B ON A.USER_ID = B.USER_ROLE_USER_ID\nLEFT JOIN role C ON B.USER_ROLE_ROLE_ID = C.ROLE_ID\nLEFT JOIN role_rules D ON C.ROLE_ID = D.ROLE_RULES_ROLE_ID\nLEFT JOIN rules E ON D.ROLE_RULES_RULES_ID = E.RULES_ID\nLEFT JOIN menu F ON E.RULES_MENU_ID = F.MENU_ID \nWHERE\nA.USER_ID = ? \nGROUP BY\nRULES_ID,\nRULES_NAME,\nMENU_ID,\nMENU_NAME";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     return SqlUtil.executeQuery(sql, new Object[] { userId });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List findRoleByUserId(String userId) {
/* 208 */     String sql = "SELECT C.ROLE_ID rulesid,C.ROLE_NAME rulesname FROM user A\nLEFT JOIN user_role B ON A.USER_ID = B.USER_ROLE_USER_ID\nLEFT JOIN role C ON B.USER_ROLE_ROLE_ID = C.ROLE_ID\nWHERE A.USER_ID = ?\nGROUP BY rulesid,rulesname";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     return SqlUtil.executeQuery(sql, new Object[] { userId });
/*     */   }
/*     */ }