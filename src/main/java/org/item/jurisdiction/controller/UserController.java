package org.item.jurisdiction.controller;

/**
 * 用户 Controller
 */

import org.apache.commons.mail.HtmlEmail;
import org.item.jurisdiction.model.User;
import org.item.jurisdiction.service.UserService;
import org.item.jurisdiction.util.Constants;
import org.item.jurisdiction.util.JsonResult;
import org.item.jurisdiction.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    //查询所有用户
    @RequestMapping("/user/findall")
    public JsonResult findall(){
        JsonResult js;
        try {
           List list = userService.findAllUser();
           js = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "查询异常");
        }
        return js;
    }

    //登陆
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public JsonResult login(User user) {
        JsonResult js;
        try {
            String telphone = StringUtil.isnull(user.getUserTelphone()).toString();
            String email = StringUtil.isnull(user.getUserEmail()).toString();
            User u = userService.userLogin(telphone, email, user.getUserPassword());
            if (u != null) {
                if(u.getUserError()==0){
                    js = new JsonResult(Constants.STATUS_NOT_FOUND, "首次登录需要验证邮箱", u);
                }else{
                    userService.loginFirst(u.getUserId());
                    js = new JsonResult(Constants.STATUS_SUCCESS, "登陆成功", u);
                }
            } else {
                js = new JsonResult(Constants.STATUS_FAIL, "账号或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            js = new JsonResult(Constants.STATUS_ERROR, "登陆异常");
        }
        return js;
    }

    //首次登录成功
    @RequestMapping("/user/firstlogin")
    public JsonResult firstlogin(String userId, String userEmail){
        JsonResult js;
        try {
            User user = userService.findByUserId(userId);
            userService.loginFirst(userId);
            HtmlEmail mail = new HtmlEmail();
            // 设置邮箱服务器信息
            mail.setSmtpPort(25);
            mail.setHostName("smtp.163.com");
            // 设置密码验证器
            mail.setAuthentication("18290605616@163.com", "gwh0921");
            // 设置邮件发送者
            mail.setFrom("18290605616@163.com","CoCo");
            // 设置邮件接收者
            mail.addTo(userEmail);
            // 设置邮件编码
            mail.setCharset("UTF-8");
            // 设置邮件主题
            mail.setSubject("Welcome to join us");
            // 设置邮件内容
            StringBuffer message  =  new StringBuffer();
            message.append("<div style='display: flex;flex-direction: column;align-items: center;'>");
            message.append("<div style='background-color: #409EFF; width:100%;margin:auto;color:white;font-size:50px;text-align:center;line-height:80px;'>Welcome To Join Us</div>");
            message.append("<p style='font-size:30px;color: #67C23A'>Hi <b style:'color: #F56C6C;font-size:35px'>"+user.getUserName()+"</b>，</p>");
            message.append("<p style='font-size:30px;color: #67C23A'>Thanks for signing up to LanQiao.</p>");
            message.append("</div>");

            mail.setContent(message.toString(),"text/html;charset=UTF-8");
            // 设置邮件发送时间
            mail.setSentDate(new Date());
            // 发送邮件
            mail.send();
            js = new JsonResult(Constants.STATUS_SUCCESS, "发送成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR, "发送异常");
        }
        return js;
    }

    //发送登录验证码
    @RequestMapping("/user/logincode")
    public JsonResult logincode(String userEmail){
        JsonResult js;
        try{
            int code = (int)((Math.random()*9+1)*100000);
            HtmlEmail mail = new HtmlEmail();
            // 设置邮箱服务器信息
            mail.setSmtpPort(25);
            mail.setHostName("smtp.163.com");
            // 设置密码验证器
            mail.setAuthentication("18290605616@163.com", "gwh0921");
            // 设置邮件发送者
            mail.setFrom("18290605616@163.com","CoCo");
            // 设置邮件接收者
            mail.addTo(userEmail);
            // 设置邮件编码
            mail.setCharset("UTF-8");
            // 设置邮件主题
            mail.setSubject("Verification Code");
            // 设置邮件内容
//                    StringBuffer messageText=new StringBuffer();//内容以html格式发送,防止被当成垃圾邮件
//                    messageText.append("<span>Hi，您好:</span></br>");
//                    messageText.append("<span>你的验证码是:"+code+"</span></br>");
//                    messageText.append("<span>出于安全原因，该验证码将于10分钟后失效。请勿将验证码透露给他人。</span></br>");
            StringBuffer message  =  new StringBuffer();
            message.append("<p style='font-size:30px;color: #67C23A'>Your Verification Code：</p>");
            message.append("<p style='font-size:40px;color: blue'>"+code+"</p>");
            mail.setContent(message.toString(),"text/html;charset=UTF-8");
            // 设置邮件发送时间
            mail.setSentDate(new Date());
            // 发送邮件
            mail.send();
            js= new JsonResult(Constants.STATUS_SUCCESS,"发送成功",code);
        }catch (Exception e){
            e.printStackTrace();
            js= new JsonResult(Constants.STATUS_FAIL,"发送异常");
        }
        return js;
    }

    //解绑邮箱
    @RequestMapping("/user/delemail")
    public JsonResult delEmail(String userId){
        JsonResult js;
        try{
            int i = userService.delEmail(userId);
            if(i != 0){
                js = new JsonResult(Constants.STATUS_SUCCESS, "解绑成功");
            }else {
                js = new JsonResult(Constants.STATUS_FAIL, "解绑失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR, "解绑异常");
        }
        return js;
    }

    //修改用户资料
    @RequestMapping("/user/update")
    public JsonResult updateUser(User user){
        JsonResult js;
        try{
            int i = userService.updateUser(user);
            js = new JsonResult(Constants.STATUS_SUCCESS, "修改成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL,"修改异常");
        }
        return js;
    }

    //删除用户
    @RequestMapping("/user/delete")
    public JsonResult deleteUser(String userId){
        JsonResult js;
        try{
            int i = userService.deleteUser(userId);
            js = new JsonResult(Constants.STATUS_SUCCESS, "删除成功");
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL,"删除异常");
        }
        return js;
    }

    //更换邮箱
    @RequestMapping("/user/updateemail")
    public JsonResult updateEmail(String userEmail, String userId){
        JsonResult js;
        try {
            List list = userService.findByUserEmail(userEmail);
            if(list.size()>0){
                js = new JsonResult(Constants.STATUS_FAIL, "修改失败，该邮箱已绑定其他用户");
            }else{
                int i = userService.updateEmail(userEmail, userId);
                if(i != 0){
                    js = new JsonResult(Constants.STATUS_SUCCESS, "修改邮箱成功");
                }else{
                    js = new JsonResult(Constants.STATUS_FAIL,"修改失败");
                }
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_ERROR,"修改异常");
        }
        return js;
    }

    //更改姓名
    @RequestMapping("/user/changename")
    public JsonResult updateName(User user){
        JsonResult js;
        try {

            if(user.getUserId()!=null && user.getUserName()!=null || user.getUserId()!="" && user.getUserName()!=""){
                int i = userService.updateName(user);
                if(i != 0){
                    js = new JsonResult(Constants.STATUS_SUCCESS, "更换姓名成功");
                }else{
                    js = new JsonResult(Constants.STATUS_ERROR, "更换姓名失败");
                }
            }else{
                js = new JsonResult(Constants.STATUS_ERROR, "更换姓名失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "更换姓名异常");
        }
        return js;
    }

    //更换头像
    @RequestMapping(value = "/user/upHeadimg", method = RequestMethod.POST)
    public JsonResult upheadimg(User user){
        JsonResult js;
        try {
            if(user.getUserId()!=null && user.getUserHeadimg()!=null || user.getUserId()!="" && user.getUserHeadimg()!=""){
                int i = userService.updateHead(user);
                if(i != 0){
                    js = new JsonResult(Constants.STATUS_SUCCESS, "更换头像成功");
                }else{
                    js = new JsonResult(Constants.STATUS_ERROR, "更换头像失败");
                }
            }else{
                js = new JsonResult(Constants.STATUS_ERROR, "更换头像失败");
            }
        }catch (Exception e){
            js = new JsonResult(Constants.STATUS_FAIL, "更换头像异常");
        }
        return js;
    }

    //根据ID查询用户
    @RequestMapping("/user/findById")
    public JsonResult find(String userId) {
        JsonResult js;
        try {
            User user = userService.findByUserId(userId);
            js = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", user);
        } catch (Exception e) {
            js = new JsonResult(Constants.STATUS_FAIL, "查询异常");
        }
        return js;
    }

    //添加用户
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public JsonResult add(User user) throws Exception {
        JsonResult js;
        try {
            List l2 = userService.findByUserEmail(user.getUserEmail());
            List l3 = userService.findByUserTel(user.getUserTelphone());
            if (l2.size() > 0) {
                js = new JsonResult(Constants.STATUS_ERROR, "邮箱已被注册");
            } else if (l3.size() > 0) {
                js = new JsonResult(Constants.STATUS_ERROR, "手机号已被注册");
            } else {
                String i = userService.userAdd(user);
                User u = userService.findByUserId(i);
                if (u != null) {
                    js = new JsonResult(Constants.STATUS_SUCCESS, "添加成功", u);
                } else {
                    js = new JsonResult(Constants.STATUS_ERROR, "添加失败");
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            js = new JsonResult(Constants.STATUS_FAIL, "添加异常");
        }
        return js;
    }

    //查询菜单
    @RequestMapping("/user/menu")
    public JsonResult menu(User user) {
        JsonResult js;
        try {
            List list = userService.findMenuByUserId(user.getUserId());
            js = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);
        } catch (Exception e) {
            js = new JsonResult(Constants.STATUS_FAIL, "查询异常");
        }
        return js;
    }

    //查询用户权限
    @RequestMapping("/user/rules")
    public JsonResult rules(String userId) {
        JsonResult js;
        try {
            List list = userService.findRulesById(userId);
            js = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);
        } catch (Exception e) {
            js = new JsonResult(Constants.STATUS_FAIL, "查询异常");
        }
        return js;
    }

    //查询用户角色
    @RequestMapping("/user/role")
    public JsonResult role(String userId) {
        JsonResult js;
        try {
            List list = userService.findRoleByUserId(userId);
            js = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);
        } catch (Exception e) {
            js = new JsonResult(Constants.STATUS_FAIL, "查询异常");
        }
        return js;
    }
}
