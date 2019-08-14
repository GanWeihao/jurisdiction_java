package org.item.jurisdiction.controller;

import java.util.ArrayList;
import java.util.Date;
/*     */ import java.util.List;
/*     */ import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.mail.HtmlEmail;
/*     */ import org.item.jurisdiction.controller.UserController;
/*     */ import org.item.jurisdiction.model.User;
/*     */ import org.item.jurisdiction.service.UserRoleService;
import org.item.jurisdiction.service.UserService;
/*     */ import org.item.jurisdiction.util.Constants;
import org.item.jurisdiction.util.JsonResult;
/*     */ import org.item.jurisdiction.util.StringUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.*;
/*     */
/*     */
/*     */

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping({"/user/findall"})
    public JsonResult findall(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "8")Integer pageSize) {
        JsonResult js;
        try {
            System.out.println(pageSize);
            PageHelper.startPage(pageNum, pageSize);
            List list = this.userService.findAllUser();
            PageInfo pageInfo = new PageInfo(list);
            js = new JsonResult("200", "查询成功", pageInfo);
        } catch (Exception e) {
            js = new JsonResult("500", "查询异常");
        }
        return js;
    }

    @RequestMapping(value = {"/user/login"}, method = {RequestMethod.POST})
    public JsonResult login(User user) {
        JsonResult js;
        try {
            String telphone = StringUtil.isnull(user.getUserTelphone()).toString();
            String email = StringUtil.isnull(user.getUserEmail()).toString();
            User u = this.userService.userLogin(telphone, email, user.getUserPassword());
            if (u != null) {
                if (u.getUserError().intValue() == 0) {
                    js = new JsonResult("404", "首次登录需要验证邮箱", u);
                } else {
                    this.userService.loginFirst(u.getUserId());
                    js = new JsonResult("200", "登陆成功", u);
                }
            } else {
                js = new JsonResult("500", "账号或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            js = new JsonResult("400", "登陆异常");
        }
        return js;
    }

    @RequestMapping({"/user/firstlogin"})
    public JsonResult firstlogin(String userId, String userEmail) {
        JsonResult js;
        try {
            User user = this.userService.findByUserId(userId);
            this.userService.loginFirst(userId);
            HtmlEmail mail = new HtmlEmail();
            mail.setSmtpPort(25);
            mail.setHostName("smtp.163.com");
            mail.setAuthentication("18290605616@163.com", "gwh0921");
            mail.setFrom("18290605616@163.com", "CoCo");
            mail.addTo(userEmail);
            mail.setCharset("UTF-8");
            mail.setSubject("Welcome to join us");
            StringBuffer message = new StringBuffer();
            message.append("<div style='display: flex;flex-direction: column;align-items: center;'>");
            message.append("<div style='background-color: #409EFF; width:100%;margin:auto;color:white;font-size:50px;text-align:center;line-height:80px;'>Welcome To Join Us</div>");
            message.append("<p style='font-size:30px;color: #67C23A'>Hi <b style:'color: #F56C6C;font-size:35px'>" + user.getUserName() + "</b>，</p>");
            message.append("<p style='font-size:30px;color: #67C23A'>Thanks for signing up to LanQiao.</p>");
            message.append("</div>");
            mail.setContent(message.toString(), "text/html;charset=UTF-8");
            mail.setSentDate(new Date());
            mail.send();
            js = new JsonResult("200", "发送成功");
        } catch (Exception e) {
            js = new JsonResult("400", "发送异常");
        }
        return js;
    }

    @RequestMapping({"/user/logincode"})
    public JsonResult logincode(String userEmail) {
        JsonResult js;
        try {
            int code = (int) ((Math.random() * 9.0D + 1.0D) * 100000.0D);
            HtmlEmail mail = new HtmlEmail();
            mail.setSmtpPort(25);
            mail.setHostName("smtp.163.com");
            mail.setAuthentication("18290605616@163.com", "gwh0921");
            mail.setFrom("18290605616@163.com", "CoCo");
            mail.addTo(userEmail);
            mail.setCharset("UTF-8");
            mail.setSubject("Verification Code");
            StringBuffer message = new StringBuffer();
            message.append("<p style='font-size:30px;color: #67C23A'>Your Verification Code：</p>");
            message.append("<p style='font-size:40px;color: blue'>" + code + "</p>");
            mail.setContent(message.toString(), "text/html;charset=UTF-8");
            mail.setSentDate(new Date());
            mail.send();
            js = new JsonResult("200", "发送成功", Integer.valueOf(code));
        } catch (Exception e) {
            /* 143 */
            e.printStackTrace();
            /* 144 */
            js = new JsonResult("500", "发送异常");
            /*     */
        }
        /* 146 */
        return js;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    @RequestMapping({"/user/delemail"})
    /*     */ public JsonResult delEmail(String userId) {
        /*     */
        JsonResult js;
        /*     */
        try {
            /* 154 */
            int i = this.userService.delEmail(userId);
            /* 155 */
            if (i != 0) {
                /* 156 */
                js = new JsonResult("200", "解绑成功");
                /*     */
            } else {
                /* 158 */
                js = new JsonResult("500", "解绑失败");
                /*     */
            }
            /* 160 */
        } catch (Exception e) {
            /* 161 */
            js = new JsonResult("400", "解绑异常");
            /*     */
        }
        /* 163 */
        return js;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    @RequestMapping({"/user/update"})
    /*     */ public JsonResult updateUser(User user) {
        JsonResult js;
        try {
            int i = this.userService.updateUser(user);
            js = new JsonResult("200", "修改成功");
        } catch (Exception e) {
            js = new JsonResult("500", "修改异常");
        }
        return js;
    }

    @RequestMapping({"/user/delete"})
    /*     */ public JsonResult deleteUser(String userId) {
        /*     */
        JsonResult js;
        /*     */
        try {
            /* 184 */
            int i = this.userService.deleteUser(userId);
            /* 185 */
            js = new JsonResult("200", "删除成功");
            /* 186 */
        } catch (Exception e) {
            /* 187 */
            js = new JsonResult("500", "删除异常");
            /*     */
        }
        /* 189 */
        return js;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    @RequestMapping({"/user/updateemail"})
    /*     */ public JsonResult updateEmail(String userEmail, String userId) {
        /*     */
        JsonResult js;
        /*     */
        try {
            /* 197 */
            List list = this.userService.findByUserEmail(userEmail);
            /* 198 */
            if (list.size() > 0) {
                /* 199 */
                js = new JsonResult("500", "修改失败，该邮箱已绑定其他用户");
                /*     */
            } else {
                /* 201 */
                int i = this.userService.updateEmail(userEmail, userId);
                /* 202 */
                if (i != 0) {
                    /* 203 */
                    js = new JsonResult("200", "修改邮箱成功");
                    /*     */
                } else {
                    /* 205 */
                    js = new JsonResult("500", "修改失败");
                    /*     */
                }
                /*     */
            }
            /* 208 */
        } catch (Exception e) {
            /* 209 */
            js = new JsonResult("400", "修改异常");
            /*     */
        }
        /* 211 */
        return js;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    @RequestMapping({"/user/changename"})
    /*     */ public JsonResult updateName(User user) {
        /*     */
        JsonResult js;
        /*     */
        try {
            /* 220 */
            if ((user.getUserId() != null && user.getUserName() != null) || (user.getUserId() != "" && user.getUserName() != "")) {
                /* 221 */
                int i = this.userService.updateName(user);
                /* 222 */
                if (i != 0) {
                    /* 223 */
                    js = new JsonResult("200", "更换姓名成功");
                    /*     */
                } else {
                    /* 225 */
                    js = new JsonResult("400", "更换姓名失败");
                    /*     */
                }
                /*     */
            } else {
                /* 228 */
                js = new JsonResult("400", "更换姓名失败");
                /*     */
            }
            /* 230 */
        } catch (Exception e) {
            /* 231 */
            js = new JsonResult("500", "更换姓名异常");
            /*     */
        }
        /* 233 */
        return js;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    @RequestMapping(value = {"/user/upHeadimg"}, method = {RequestMethod.POST})
    /*     */ public JsonResult upheadimg(User user) {
        /*     */
        JsonResult js;
        /*     */
        try {
            /* 241 */
            if ((user.getUserId() != null && user.getUserHeadimg() != null) || (user.getUserId() != "" && user.getUserHeadimg() != "")) {
                /* 242 */
                int i = this.userService.updateHead(user);
                /* 243 */
                if (i != 0) {
                    /* 244 */
                    js = new JsonResult("200", "更换头像成功");
                    /*     */
                } else {
                    /* 246 */
                    js = new JsonResult("400", "更换头像失败");
                    /*     */
                }
                /*     */
            } else {
                /* 249 */
                js = new JsonResult("400", "更换头像失败");
                /*     */
            }
            /* 251 */
        } catch (Exception e) {
            /* 252 */
            js = new JsonResult("500", "更换头像异常");
            /*     */
        }
        /* 254 */
        return js;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    @RequestMapping({"/user/findById"})
    /*     */ public JsonResult find(String userId) {
        /*     */
        JsonResult js;
        /*     */
        try {
            /* 262 */
            User user = this.userService.findByUserId(userId);
            /* 263 */
            js = new JsonResult("200", "查询成功", user);
            /* 264 */
        } catch (Exception e) {
            /* 265 */
            js = new JsonResult("500", "查询异常");
            /*     */
        }
        /* 267 */
        return js;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    @RequestMapping(value = {"/user/add"}, method = {RequestMethod.POST})
    /*     */ public JsonResult add(User user) {
        /*     */
        JsonResult js;
        /*     */
        try {
            /* 275 */
            List l2 = this.userService.findByUserEmail(user.getUserEmail());
            /* 276 */
            List l3 = this.userService.findByUserTel(user.getUserTelphone());
            /* 277 */
            if (l2.size() > 0) {
                /* 278 */
                js = new JsonResult("400", "邮箱已被注册");
                /* 279 */
            } else if (l3.size() > 0) {
                /* 280 */
                js = new JsonResult("400", "手机号已被注册");
                /*     */
            } else {
                /* 282 */
                String i = this.userService.userAdd(user);
                /* 283 */
                User u = this.userService.findByUserId(i);
                /* 284 */
                if (u != null) {
                    /* 285 */
                    js = new JsonResult("200", "添加成功", u);
                    /*     */
                } else {
                    /* 287 */
                    js = new JsonResult("400", "添加失败");
                    /*     */
                }
                /*     */
            }
            /* 290 */
        } catch (Exception e1) {
            /* 291 */
            e1.printStackTrace();
            /* 292 */
            js = new JsonResult("500", "添加异常");
            /*     */
        }
        /* 294 */
        return js;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    @RequestMapping({"/user/menu"})
    /*     */ public JsonResult menu(User user) {
        /*     */
        JsonResult js;
        /*     */
        try {
            /* 302 */
            List list = this.userService.findMenuByUserId(user.getUserId());
            /* 303 */
            js = new JsonResult("200", "查询成功", list);
            /* 304 */
        } catch (Exception e) {
            /* 305 */
            js = new JsonResult("500", "查询异常");
            /*     */
        }
        /* 307 */
        return js;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    @RequestMapping({"/user/rules"})
    /*     */ public JsonResult rules(String userId) {
        /*     */
        JsonResult js;
        /*     */
        try {
            /* 315 */
            List list = this.userService.findRulesById(userId);
            /* 316 */
            js = new JsonResult("200", "查询成功", list);
            /* 317 */
        } catch (Exception e) {
            /* 318 */
            js = new JsonResult("500", "查询异常");
            /*     */
        }
        /* 320 */
        return js;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    @RequestMapping({"/user/role"})
    public JsonResult role(String userId) {
        JsonResult js;
        try {
            List list = this.userService.findRoleByUserId(userId);
            js = new JsonResult("200", "查询成功", list);
        } catch (Exception e) {
            js = new JsonResult("500", "查询异常");
        }
        return js;
    }

    @RequestMapping(value = "/user/deleteoptions", method = RequestMethod.GET)
    public JsonResult deleteoptions(@RequestParam("user") List<String> users){
        List<String> userList = new ArrayList<>();
        for(String u : users){
            String u1 = u.replaceAll("\\[","");
            String u2 = u1.replaceAll("\\]","");
            String u3 = u2.replaceAll("\"","");
            userList.add(u3);
        }
        JsonResult js;
        try {
            int i = userService.deleteUserByPrimaryKey(userList);
            if(i!=0){
                int j = userRoleService.deleteUserRoleByUserId(userList);
                if(j!=0){
                    js = new JsonResult(Constants.STATUS_SUCCESS,"删除成功",j);
                }else{
                    js = new JsonResult(Constants.STATUS_SUCCESS,"删除用户成功，删除权限失败",i);
                }
            }else{
                js = new JsonResult(Constants.STATUS_FAIL,"删除失败",i);
            }
        }catch (Exception e){
            e.printStackTrace();
            js = new JsonResult(Constants.STATUS_FAIL,"删除异常");
        }
        return js;
    }
}
