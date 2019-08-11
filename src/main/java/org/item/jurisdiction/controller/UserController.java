/*     */ package org.item.jurisdiction.controller;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.mail.HtmlEmail;
/*     */ import org.item.jurisdiction.controller.UserController;
/*     */ import org.item.jurisdiction.model.User;
/*     */ import org.item.jurisdiction.service.UserService;
/*     */ import org.item.jurisdiction.util.JsonResult;
/*     */ import org.item.jurisdiction.util.StringUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.CrossOrigin;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMethod;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @CrossOrigin
/*     */ @RestController
/*     */ public class UserController
/*     */ {
/*     */   @Autowired
/*     */   UserService userService;
/*     */   
/*     */   @RequestMapping({"/user/findall"})
/*     */   public JsonResult findall() {
/*     */     JsonResult js;
/*     */     try {
/*  34 */       List list = this.userService.findAllUser();
/*  35 */       js = new JsonResult("200", "查询成功", list);
/*  36 */     } catch (Exception e) {
/*  37 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/*  39 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping(value = {"/user/login"}, method = {RequestMethod.POST})
/*     */   public JsonResult login(User user) {
/*     */     JsonResult js;
/*     */     try {
/*  47 */       String telphone = StringUtil.isnull(user.getUserTelphone()).toString();
/*  48 */       String email = StringUtil.isnull(user.getUserEmail()).toString();
/*  49 */       User u = this.userService.userLogin(telphone, email, user.getUserPassword());
/*  50 */       if (u != null) {
/*  51 */         if (u.getUserError().intValue() == 0) {
/*  52 */           js = new JsonResult("404", "首次登录需要验证邮箱", u);
/*     */         } else {
/*  54 */           this.userService.loginFirst(u.getUserId());
/*  55 */           js = new JsonResult("200", "登陆成功", u);
/*     */         } 
/*     */       } else {
/*  58 */         js = new JsonResult("500", "账号或密码错误");
/*     */       } 
/*  60 */     } catch (Exception e) {
/*  61 */       e.printStackTrace();
/*  62 */       js = new JsonResult("400", "登陆异常");
/*     */     } 
/*  64 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/firstlogin"})
/*     */   public JsonResult firstlogin(String userId, String userEmail) {
/*     */     JsonResult js;
/*     */     try {
/*  72 */       User user = this.userService.findByUserId(userId);
/*  73 */       this.userService.loginFirst(userId);
/*  74 */       HtmlEmail mail = new HtmlEmail();
/*     */       
/*  76 */       mail.setSmtpPort(25);
/*  77 */       mail.setHostName("smtp.163.com");
/*     */       
/*  79 */       mail.setAuthentication("18290605616@163.com", "gwh0921");
/*     */       
/*  81 */       mail.setFrom("18290605616@163.com", "CoCo");
/*     */       
/*  83 */       mail.addTo(userEmail);
/*     */       
/*  85 */       mail.setCharset("UTF-8");
/*     */       
/*  87 */       mail.setSubject("Welcome to join us");
/*     */       
/*  89 */       StringBuffer message = new StringBuffer();
/*  90 */       message.append("<div style='display: flex;flex-direction: column;align-items: center;'>");
/*  91 */       message.append("<div style='background-color: #409EFF; width:100%;margin:auto;color:white;font-size:50px;text-align:center;line-height:80px;'>Welcome To Join Us</div>");
/*  92 */       message.append("<p style='font-size:30px;color: #67C23A'>Hi <b style:'color: #F56C6C;font-size:35px'>" + user.getUserName() + "</b>，</p>");
/*  93 */       message.append("<p style='font-size:30px;color: #67C23A'>Thanks for signing up to LanQiao.</p>");
/*  94 */       message.append("</div>");
/*     */       
/*  96 */       mail.setContent(message.toString(), "text/html;charset=UTF-8");
/*     */       
/*  98 */       mail.setSentDate(new Date());
/*     */       
/* 100 */       mail.send();
/* 101 */       js = new JsonResult("200", "发送成功");
/* 102 */     } catch (Exception e) {
/* 103 */       js = new JsonResult("400", "发送异常");
/*     */     } 
/* 105 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/logincode"})
/*     */   public JsonResult logincode(String userEmail) {
/*     */     JsonResult js;
/*     */     try {
/* 113 */       int code = (int)((Math.random() * 9.0D + 1.0D) * 100000.0D);
/* 114 */       HtmlEmail mail = new HtmlEmail();
/*     */       
/* 116 */       mail.setSmtpPort(25);
/* 117 */       mail.setHostName("smtp.163.com");
/*     */       
/* 119 */       mail.setAuthentication("18290605616@163.com", "gwh0921");
/*     */       
/* 121 */       mail.setFrom("18290605616@163.com", "CoCo");
/*     */       
/* 123 */       mail.addTo(userEmail);
/*     */       
/* 125 */       mail.setCharset("UTF-8");
/*     */       
/* 127 */       mail.setSubject("Verification Code");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       StringBuffer message = new StringBuffer();
/* 134 */       message.append("<p style='font-size:30px;color: #67C23A'>Your Verification Code：</p>");
/* 135 */       message.append("<p style='font-size:40px;color: blue'>" + code + "</p>");
/* 136 */       mail.setContent(message.toString(), "text/html;charset=UTF-8");
/*     */       
/* 138 */       mail.setSentDate(new Date());
/*     */       
/* 140 */       mail.send();
/* 141 */       js = new JsonResult("200", "发送成功", Integer.valueOf(code));
/* 142 */     } catch (Exception e) {
/* 143 */       e.printStackTrace();
/* 144 */       js = new JsonResult("500", "发送异常");
/*     */     } 
/* 146 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/delemail"})
/*     */   public JsonResult delEmail(String userId) {
/*     */     JsonResult js;
/*     */     try {
/* 154 */       int i = this.userService.delEmail(userId);
/* 155 */       if (i != 0) {
/* 156 */         js = new JsonResult("200", "解绑成功");
/*     */       } else {
/* 158 */         js = new JsonResult("500", "解绑失败");
/*     */       } 
/* 160 */     } catch (Exception e) {
/* 161 */       js = new JsonResult("400", "解绑异常");
/*     */     } 
/* 163 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/update"})
/*     */   public JsonResult updateUser(User user) {
/*     */     JsonResult js;
/*     */     try {
/* 171 */       int i = this.userService.updateUser(user);
/* 172 */       js = new JsonResult("200", "修改成功");
/* 173 */     } catch (Exception e) {
/* 174 */       js = new JsonResult("500", "修改异常");
/*     */     } 
/* 176 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/delete"})
/*     */   public JsonResult deleteUser(String userId) {
/*     */     JsonResult js;
/*     */     try {
/* 184 */       int i = this.userService.deleteUser(userId);
/* 185 */       js = new JsonResult("200", "删除成功");
/* 186 */     } catch (Exception e) {
/* 187 */       js = new JsonResult("500", "删除异常");
/*     */     } 
/* 189 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/updateemail"})
/*     */   public JsonResult updateEmail(String userEmail, String userId) {
/*     */     JsonResult js;
/*     */     try {
/* 197 */       List list = this.userService.findByUserEmail(userEmail);
/* 198 */       if (list.size() > 0) {
/* 199 */         js = new JsonResult("500", "修改失败，该邮箱已绑定其他用户");
/*     */       } else {
/* 201 */         int i = this.userService.updateEmail(userEmail, userId);
/* 202 */         if (i != 0) {
/* 203 */           js = new JsonResult("200", "修改邮箱成功");
/*     */         } else {
/* 205 */           js = new JsonResult("500", "修改失败");
/*     */         } 
/*     */       } 
/* 208 */     } catch (Exception e) {
/* 209 */       js = new JsonResult("400", "修改异常");
/*     */     } 
/* 211 */     return js;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/changename"})
/*     */   public JsonResult updateName(User user) {
/*     */     JsonResult js;
/*     */     try {
/* 220 */       if ((user.getUserId() != null && user.getUserName() != null) || (user.getUserId() != "" && user.getUserName() != "")) {
/* 221 */         int i = this.userService.updateName(user);
/* 222 */         if (i != 0) {
/* 223 */           js = new JsonResult("200", "更换姓名成功");
/*     */         } else {
/* 225 */           js = new JsonResult("400", "更换姓名失败");
/*     */         } 
/*     */       } else {
/* 228 */         js = new JsonResult("400", "更换姓名失败");
/*     */       } 
/* 230 */     } catch (Exception e) {
/* 231 */       js = new JsonResult("500", "更换姓名异常");
/*     */     } 
/* 233 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping(value = {"/user/upHeadimg"}, method = {RequestMethod.POST})
/*     */   public JsonResult upheadimg(User user) {
/*     */     JsonResult js;
/*     */     try {
/* 241 */       if ((user.getUserId() != null && user.getUserHeadimg() != null) || (user.getUserId() != "" && user.getUserHeadimg() != "")) {
/* 242 */         int i = this.userService.updateHead(user);
/* 243 */         if (i != 0) {
/* 244 */           js = new JsonResult("200", "更换头像成功");
/*     */         } else {
/* 246 */           js = new JsonResult("400", "更换头像失败");
/*     */         } 
/*     */       } else {
/* 249 */         js = new JsonResult("400", "更换头像失败");
/*     */       } 
/* 251 */     } catch (Exception e) {
/* 252 */       js = new JsonResult("500", "更换头像异常");
/*     */     } 
/* 254 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/findById"})
/*     */   public JsonResult find(String userId) {
/*     */     JsonResult js;
/*     */     try {
/* 262 */       User user = this.userService.findByUserId(userId);
/* 263 */       js = new JsonResult("200", "查询成功", user);
/* 264 */     } catch (Exception e) {
/* 265 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/* 267 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping(value = {"/user/add"}, method = {RequestMethod.POST})
/*     */   public JsonResult add(User user) {
/*     */     JsonResult js;
/*     */     try {
/* 275 */       List l2 = this.userService.findByUserEmail(user.getUserEmail());
/* 276 */       List l3 = this.userService.findByUserTel(user.getUserTelphone());
/* 277 */       if (l2.size() > 0) {
/* 278 */         js = new JsonResult("400", "邮箱已被注册");
/* 279 */       } else if (l3.size() > 0) {
/* 280 */         js = new JsonResult("400", "手机号已被注册");
/*     */       } else {
/* 282 */         String i = this.userService.userAdd(user);
/* 283 */         User u = this.userService.findByUserId(i);
/* 284 */         if (u != null) {
/* 285 */           js = new JsonResult("200", "添加成功", u);
/*     */         } else {
/* 287 */           js = new JsonResult("400", "添加失败");
/*     */         } 
/*     */       } 
/* 290 */     } catch (Exception e1) {
/* 291 */       e1.printStackTrace();
/* 292 */       js = new JsonResult("500", "添加异常");
/*     */     } 
/* 294 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/menu"})
/*     */   public JsonResult menu(User user) {
/*     */     JsonResult js;
/*     */     try {
/* 302 */       List list = this.userService.findMenuByUserId(user.getUserId());
/* 303 */       js = new JsonResult("200", "查询成功", list);
/* 304 */     } catch (Exception e) {
/* 305 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/* 307 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/rules"})
/*     */   public JsonResult rules(String userId) {
/*     */     JsonResult js;
/*     */     try {
/* 315 */       List list = this.userService.findRulesById(userId);
/* 316 */       js = new JsonResult("200", "查询成功", list);
/* 317 */     } catch (Exception e) {
/* 318 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/* 320 */     return js;
/*     */   }
/*     */ 
/*     */   
/*     */   @RequestMapping({"/user/role"})
/*     */   public JsonResult role(String userId) {
/*     */     JsonResult js;
/*     */     try {
/* 328 */       List list = this.userService.findRoleByUserId(userId);
/* 329 */       js = new JsonResult("200", "查询成功", list);
/* 330 */     } catch (Exception e) {
/* 331 */       js = new JsonResult("500", "查询异常");
/*     */     } 
/* 333 */     return js;
/*     */   }
/*     */ }
